#all subclasses inherit sample and calculate the data from the list created in sample in a specific way
#inherits sample
#Euclidean measure the EuclideanDistance of all the elements
#EuclideanNorm is the the sqrt(summation(i^2))) or the square root of all summatino each ith term squared 
import math;
from sample import sample;
class ManhattanSample(sample):
	def _init_(self,list):
		super(ManhattanSample,self)._init_(list);
		
		#Eucliudean Distance
	def distance(self,sample,list2):
		list1=sample.getList();
		list3=range(4);
		for num in range(0,len(list2)):
 			
 			list3[num] = list1[num]-list2[num];
 		ED = abs(list3[0]+list3[1]+list3[2]+list3[3]);
 		#print(list1);
 		
		return ED;
		print(12);
		#super(EuclideanSample,self).distance(list1,list2);

		
	def getList(self):
 		return self.list;

 	#Inherited getList Method
	#def getList(self):
		#return super(EuclideanSample, self).getList();


	#def _init_(self,list):
		#self.list = list;
	#def getList(self):
		#return self.list;
	#def setList(self, list):
		#this.list = list;
	

##################################
###    Initialize the Lists    ###
##################################

#initialize a sample list and a list from the Euclidean list
#list = [1,2,3,4];
a= sample();
b= ManhattanSample();
b._init_([1,2,3,4]);
a._init_([5,6,7,8]);




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
print(b.distance(a, b.getList()));


#print(z);
#print(x);
#print(b.distance(a.getList(),b.getList()));



