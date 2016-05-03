from nn import nn;
from EuclideanSample import EuclideanSample;
from TaxicabSample import TaxicabSample;
from MaximumSample import MaximumSample;
class Classifier(object):
	global sampleList;
	sampleList= [];
	global tagList;
	tagList =[];
	global baseLen;
	baseLen =[];
	global listLenDif;
	listLenDif=[0];
	
	# method to add a sample to the pool
	def addSample(self,Sample):
		baseLen.append(len(Sample.getList()));
		maxLen = baseLen[0];

		tempSampleList = Sample.getList(); # tempory list to the value of the incomming list
		tag = Sample.getTag(); # tag list that stores a an optional tag associated with each incomming list

		sampleList.append(tempSampleList); # larget list to append each sample list as it comes it...essential make
											# larger list where each ith element in the list is a list itself that is a sample
		tagList.append(tag); # list of all the tags that come in with each list
		

		if len(sampleList)>1: # that point of this check is to use the first incomming list as a base for each subsequent list
								# the length of each subsequent list is then compared to the length of the first list for equality
								# if unequal, the 0 are appended to the list to account for the differing lengths
			base = sampleList[0];
			baseLength =len(base);
			for i in range(1,len(sampleList)):
				temp = sampleList[i];
				if len(temp) < len(base):
						diff = len(base) - len(temp);
						for j in range(0,diff-1):
							temp.append(0);
				sampleList[i]=temp;



###################################################################################################################################################################
####	predictLabel Algorithm:																																	 ##
####	1) check the type of object in order to determing the correct distance algorithm to use																	 ##
####	2) iterates over the larger list and grabs each sample sublist located at each ith position in the larger list and calculates the distance				 ##
####		3) calculate the distance according to the currently set distance algorithm from the sample distance 												 ##
####		4) add this returned distance to a list 																											 ##
####	5) find the smallest element in the previous minList  																									 ##
####	6) grab the index of the minimal element from the previous step in the list of all minimum elements 													 ##
####	7) grab the element located at the index of the previous minimal element minElemIndex																	 ##	
####	----------------------------------------------------------------------------------------------------													 ##
####	step 6 and 7 only work if you assume that the the list and tag of the list have the same index and are store in two different list and have insertion	 ##
####	in order of addSample method call;																														 ## 
####	-----------------------------------------------------------------------------------------------------													 ##
####	In other words: step 6 and 7 only work by each time addSample is called: you grab the list conntects and the tag of that list and store these elements	 ##
####	in a different list in order of insetion...the must be inserted at the same time and the same index of the two list..self.  							 ##	
####	EX: list[1,2,3,4],-1:																																	 ##
####		the elements are 1,2,3,4 and will be stored at index 0 or the listElemlist																			 ##
####		the tag is -1 and will be stored at index 0 or tagList																								 ##
####		Therefore each element is stored in a seperate list but by doing so simultanously inorder the both have the same index so accessing both of the them ##
####		in two different list within a loop is thus trivial																									 ##
###################################################################################################################################################################


	def predictLabel(self, Sample): # first check the type of the object in order to calculate the correct sample algorythm to run
		if(isinstance(Sample,EuclideanSample)): # the object type
			minList = [];
			for i in range(0,len(sampleList)): # iterate over the list to grab the sublist
				tempCMPList = sampleList[i];
				distance= EuclideanSample.distance(Sample, tempCMPList); # clacualte the distance
				minList.append(distance); # add the previous distance to  a list
			minElem =min(minList); # grab the minimum element from the list (least distance)
			minElemIndex = minList.index(minElem); # grab the index of the minimum element in the minlist
			indexMinElemList=sampleList[minElemIndex]; # grab the element at the index of the previous element
			return indexMinElemList; # return that elemeent
		if(isinstance(Sample,TaxicabSample)):	# check the type of object
			minList = [];
			for i in range(0,len(sampleList)): # iterate over the list to grab the sublist
				tempCMPList = sampleList[i];
				distance =TaxicabSample.distance(Sample,tempCMPList); # clacualte the distance
				minList.append(distance); # add the previous distance to  a list
			minElem =min(minList); # grab the minimum element from the list (least distance)
			minElemIndex = minList.index(minElem); # grab the index of the minimum element in the minlist
			indexMinElemList=sampleList[minElemIndex]; # grab the element at the index of the previous element
			return indexMinElemList;
		if(isinstance(Sample,MaximumSample)): # check the type of object
			minList = [];
			for i in range(0,len(sampleList)): # iterate over the list to grab the sublist
				tempCMPList = sampleList[i];
				distance = MaximumSample.distance(Sample,tempCMPList); # clacualte the distance
				minList.append(distance); # add the previous distance to  a list
			minElem =min(minList); # grab the minimum element from the list (least distance)
			minElemIndex = minList.index(minElem); # grab the index of the minimum element in the minlist
			indexMinElemList=sampleList[minElemIndex]; # grab the element at the index of the previous element
			return indexMinElemList;

	#getter ...
	def getList(self):
		return self.list;



#####################################################
#######			Sample Run                     ######
#######		All the test ran correctly 	   	   ######
#######		NOTE: For whatever reason, 	       ######
#######		you have to run the test   	       ######
#######		individually for each sample case  ######
#######		For EX:							   ###### 	
#######			Run Sample 1 then			   ######	
#######				Sample 2 then 			   ######
#######				Sample 3				   ######
#######			If you run all 3 simultanously,###### 
#######			it will break				   ######
#####################################################




########################################################################
####  Sample 1:  Works Correctly occording to the ourputs below   ######
########################################################################

cl=Classifier()
cl.addSample(Sample([2, 2, 2, 2, 2],-1))
cl.addSample(Sample([0, 0, 0],1))
cl.addSample(Sample([0, 0, 0, 0],-1))
p=cl.predictLabel(EuclideanSample([-1, -1, -1, -1 ,-1]))
print(p)  #should print 1





########################################################################
####  Sample 2:  Works Correctly occording to the ourputs below   ######
########################################################################

#cl2=classifier()
#cl2.addSample(sample([0, 0,0,0],["list","number",1]))
#cl2.addSample(sample([2.1, 5.2],["list","number",2]))
#p=cl2.predictLabel(EuclideanSample([0, 3.3,0,0]))
#print(p)  #should print ['list', 'number', 2]
#p=cl2.predictLabel(ManhattanSample([0, 3.3,0,0]))
#print(p)  #should print ['list', 'number', 1]



########################################################################
####  Sample 3:  Works Correctly occording to the ourputs below   ######
########################################################################


#cl3=classifier()
#cl3.addSample(sample([3, 1, 1,0,0],"a"))
#cl3.addSample(sample([2, 2, 2],"b"))
#cl3.addSample(sample([4, 0, 0],"c"))
#p=cl3.predictLabel(EuclideanSample([0, 0, 0,0,0]))
#print(p)  #should print a
#p=cl3.predictLabel(ManhattanSample([0, 0, 0,0,0]))
#print(p)  #should print c
#p=cl3.predictLabel(MaxSample([0, 0, 0,0,0]))
#print(p)  #should print b
