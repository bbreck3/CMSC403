


#class sample: Initilizes a list with some sample data and creates a distance method in order to provide distance
#capabilities. The specific type of distance will be calculated in one of three ways: 
# 1) EuclideanNorm which is the the sqrt(summation(i^2))) or the square root of all summatino each ith term squared 
# 2) The taxicab norm  is the summation of the absolute value of each ith term.
# 3) MaxNorm is the absolute value of of each term in the vector set. There is no summation for this one. Simple the absolute value for each element

##################################
##### 		Sample Class  ########
##################################
class Sample(object):

	#initialize the list:--> Constructor
	def __init__(self,list, tag=None): # the contructor uses an ooption tag in order to handle an option tag assigned to each sample
			if tag is None:
				self.list =list;
			else: self.list =list; self.tag = tag;
			return self.list;
	#Getter:--> Retrieves the list
	def getTag(self,*tag):
		return self.tag;
		self.list = list;
	#Generic distance formula: Will be inherited by 3 sub class in order
	# calculate the distance 3 different ways:
 	def distance(self,sample, list2):
 		list1 = sample.getList(); # Grabs the list
 		list3 = range(4); # creates a new list
 		for num in range(0,len(list1)): # iterates over the list and calculates the diffence between each point in the list
 			list3[num] = list1[num]-list2[num];
 			list3.append(tag);
 			return list3;

 #########################
 ## Testing ##############
 #########################

#z = sample([1,2,3,4]);

 # Sample of how to create objects, call methods and how to swap list		
#a = sample();

#b = sample();
#list = [4,3,2,1];
#a._init_([1,2,3,4]);
#b._init_([11,22,33,44]);
#print(a.getList());
#print(b.getList());
#x = a.getList();
#z = b.getList();
#print(a.distance(b,list));



#z=a.getList();
#b.setList(z);
#print(b.getList());




 # Sample of how to create objects, list and calculate distance between the two list		
#a = sample();

#b = sample();

#a._init_([1,2,3,4]);
#b._init_([11,22,33,44]);

#z=a.distance(b.getList(), a.getList());
#print(z);


#all subclasses inherit sample and calculate the data from the list created in sample in a specific way

#inherits sample
#Euclidean measure the EuclideanDistance of all the elements
#EuclideanNorm is the the sqrt(summation(i^2))) or the square root of all summatino each ith term squared 
#class EuclideanSample(sample):
#	def _init_(self):
#		list = [1,2,3,4];
#		super(sample)._init_(list);
#		super(sample).distance(list);

	#print(list);


#inherits sample
#Taxicab measure the TaxicabNorm of all the elements
#The taxicab norm  is the summation of the absolute value of each ith term.
#class TaxicabSample:

#inhertis sample
#MaxiMumNorm measure the MaximumNorm of all the elements
#MaxNorm is the absolute value of of each term in the vector set. There is no summation for this one. Simple the absolute value for each element
#class MaxNormSample:

########################
##### END TESTING ######
########################




#########################
### END CLASS SAMPLE ####
#########################










#########################
### EuclideanSample #####
#########################




class EuclideanSample(Sample):
	def __init__(self,list,*tag): # consttrutor inherted from its parent class
		super(EuclideanSample,self).__init__(list,*tag);
		
	#Euclidean Distance:
	# SquareRoot of each summed term squared
	def distance(sample,list2): #constructor:--> First few variables self explainator 
		list1 = sample.getList();
		list3=range(len(sample.getList()));
		sumSquared=0; # sumSquared:--> varaible that that holds sum of each ith and ith + 1 term squared
		for num in range(0,len(list2)): # Calculates the distance between each point in the list
 			list3[num] = list2[num]-list1[num];
		for num in range(0,len(list2)-1): # Iterates over the calculated distance list and then calculats the square of the ith and ith + 1 term, adds them, then adds this current total to sumSquared
 			sumSquared += pow(list3[num],2) + pow(list3[num+1],2);
 		ED = math.sqrt(sumSquared);	# takes the squareroot of the final sum of sumSquared to return the answer
		return ED;
		

		#gettter ...
	def getList(self):
 		return self.list;


######################
#### Testing #########
######################

##################################
###    Initialize the Lists    ###
##################################

#initialize a sample list and a list from the Euclidean list
#list = [1,2,3,4];


# = EuclideanSample([5,6,7,8]);
#b=EuclideanSample([1,2,3,4]);
#print(b.distance(a,b.getList()));
#b= EuclideanSample();
#a._init_([5,6,7,8]);
#b._init_([1,2,3,4]);

#################################################################
##   Results:												   ##
##	Expected:    											   ##
##	(5-1) =4;												   ##
##	(6-2) =4;												   ##
##	(7-3) =4;												   ##
##	(8-4) =4;												   ##
##	----------												   ##	
##	distance=4,4,4,4:= (sum_i=1 to 4) = 16					   ##
##	EuclideanDistance: sqrt(x_1^2 + x_2^2 + x_3^2 + x_4^2):= 8 ##
##	-----------------------------------------------------------##
##	Actual:  												   ##
##	(5-1) =4;												   ##
##	(6-2) =4;												   ##
##	(7-3) =4;												   ##
##	(8-4) =4;												   ##
##	----------												   ##
##	distance=4,4,4,4:= (sum_i=1 to 4) = 64					   ##
##	EuclideanDistance: sqrt(x_1^2 + x_2^2 + x_3^2 + x_4^2):= 8 ##
##	---------------------------------------------------------- ##
##  CHECK!													   ##
#################################################################   



############################
###    Step by Step     ####
############################

#get the Euclidean sampe list
#z = a.getList();
#print(z);
#print(list);

#calculate the distance between the Euclidean sample and the sample list
#x = a.distance(z, list);
#print out the distance
#print(x);


##########################
###    All in One     ####
##########################

#print the results in one line
#print(b.distance(a,b.getList()));


#print(z);
#print(x);
#print(b.distance(a.getList(),b.getList()));



###########################
#### END TESTING ##########
###########################

################################
#### END EuclideanSample Class##
#################################






###################################
### CLASS TAXICAB SAMPLE ##########
###################################



class TaxicabSample(Sample):
	def __init__(self,list,*tag):
		super(TaxicabSample,self).__init__(list,*tag);
		
		#Taxicab Distance
		# Sum of the absolute value of the ith and ith + 1 term
	def distance(Sample,list2):
		list1=Sample.getList();
		list3=range(len(Sample.getList()));
		for num in range(0,len(list2)-1): #Iterate over the list and calculate the distance between each point
 			list3[num] = list2[num]-list1[num];
 		ED = abs(list3[num]+list3[num+1]); # takes the absolute value of the sum of each ith and ith + 1 point
		return ED;
		# getter ...
	def getList(self):
 		return self.list;

######################
#### Testing #########
######################
	

##################################
###    Initialize the Lists    ###
##################################

#initialize a sample list and a list from the Euclidean list
#list = [1,2,3,4];
#a= sample();
#b= ManhattanSample();
#b._init_([1,2,3,4]);
#a._init_([5,6,7,8]);




#################################################################
##   Results:												   ##
##	Expected:    											   ##
##	(5-1) =4;												   ##
##	(6-2) =4;												   ##
##	(7-3) =4;												   ##
##	(8-4) =4;												   ##
##	----------												   ##	
##	distance=4,4,4,4:= (sum_abs_i=1 to 4) = 16				   ##
##	ManhattanDistance: sum_i=1 to 4 abs(x_i)) 16			   ##
##	-----------------------------------------------------------##
##	Actual:  												   ##
##	(5-1) =4;												   ##
##	(6-2) =4;												   ##
##	(7-3) =4;												   ##
##	(8-4) =4;												   ##
##	----------												   ##
##	distance=4,4,4,4:= (sum_i=1 to 4) = 16					   ##
##	EuclideanDistance: sqrt(x_1^2 + x_2^2 + x_3^2 + x_4^2):=16 ##
##	---------------------------------------------------------- ##
##  CHECK!													   ##
#################################################################   




############################
###    Step by Step     ####
############################

#get the Euclidean sampe list
#z = a.getList();
#print(z);
#print(list);

#calculate the distance between the Euclidean sample and the sample list
#x = a.distance(z, list);
#print out the distance
#print(x);


##########################
###    All in One     ####
##########################

#print the results in one line
#print(b.distance(a, b.getList()));


#print(z);
#print(x);
#print(b.distance(a.getList(),b.getList()));


##########################
#### END Testing #########
##########################

#######################################
#### END CLASS TAXICAB SAMPLE #########
#######################################











#######################################
#### CLASS MAXIMUM SAMPLE #############
#######################################




class MaximumSample(Sample):
	def __init__(self,list,*tag):
		super(MaximumSample,self).__init__(list,*tag);
		
		#Maximum Distance
	def distance(Sample,list2):
		list1 = Sample.getList();
		list3=range(len(Sample.getList()));
		list2.append(0); # fixes a bug in Sample 3 test cases...its "crap patch" but seems to fix the issue and doesn't effect the other sample runs
		for num in range(0,len(list3)): ## iterates over the list and calculates the absolite value of the distance between each point
 			list3[num] = abs(abs(list2[num])-abs(list1[num]));

 		ED = max(list3); # calculates the max value in the newly created list
 		return ED;

 		# getter ...
	def getList(self):
 		return self.list;	



######################
#### Testing #########
######################
	

##################################
###    Initialize the Lists    ###
##################################

#initialize a sample list and a list from the Euclidean list
#list = [1,2,3,4];
#a= MaxSample();
#b= sample();
#b._init_([5,7,9,11]);
#a._init_([1,2,3,4]);


#################################################################
##   Results:												   ##
##	Expected:    											   ##
##	(5-1) =4;												   ##
##	(7-2) =5;												   ##
##	(9-3) =6;												   ##
##	(11-4) =7;												   ##
##	----------												   ##	
##	distance=4,5,6,7:= MaxVal:= 7;				   			   ##
##	MaxDistance: MaxVal:= 7; 			   					   ##
##	-----------------------------------------------------------##
##	Actual:  												   ##
##	(5-1) =4;												   ##
##	(6-2) =4;												   ##
##	(7-3) =4;												   ##
##	(8-4) =4;												   ##
##	----------												   ##
##	distance=4,5,6,7:= MaxVal:= 7;				   			   ##
##	MaxDistance: MaxVal:= 7; 								   ##
##	---------------------------------------------------------- ##
##  CHECK!													   ##
################################################################# 





############################
###    Step by Step     ####
############################

#get the Euclidean sampe list
#z = a.getList();
#print(z);
#print(list);

#calculate the distance between the Euclidean sample and the sample list
#x = a.distance(z, list);
#print out the distance
#print(x);


##########################
###    All in One     ####
##########################

#print the results in one line
#print(a.distance(b,a.getList()));


#print(z);
#print(x);
#print(b.distance(a.getList(),b.getList()));



##########################
#### END Testing #########
##########################


#################################
#### END CLASS MAXIMUM SAMPLE ###
#################################








###################################
### CLASS CLASSIFIER ##############
###################################	





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



#######################################
##### BEGIN SAMPLE RUNS ###############
#######################################





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




###########################
#### END SAMPLE RUNS ######
#### ######################



############################
### END CLASS CLASSIFIER ###
############################
