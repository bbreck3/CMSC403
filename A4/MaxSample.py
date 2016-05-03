#all subclasses inherit sample and calculate the data from the list created in sample in a specific way
#inherits sample
#Euclidean measure the EuclideanDistance of all the elements
#EuclideanNorm is the the sqrt(summation(i^2))) or the square root of all summatino each ith term squared 
import math;
from sample import sample;
class MaxSample(sample):
	def __init__(self,list,*tag):
		super(MaxSample,self).__init__(list,*tag);
		
		#Eucliudean Distance
	def distance(sample,list2):
		list1 = sample.getList();
		list3=range(len(sample.getList()));
		list2.append(0);
		#print(list2);
 		#print(list1);
 		#print(list3);
		for num in range(0,len(list3)):
 			list3[num] = abs(abs(list2[num])-abs(list1[num]));

 		#Max using the math max value built in to the math class
 		#print(list3);
 		ED = max(list3);
 		#print(ED);


 		#Max Using an algorythm
 		#ED=0;
 		#max = list[0];
 		#for num in range(0,len(list2)-1):
 		 #		if list3[num] < list3[num+1]:
 		 #			max=list3[num+1];
 		 #		else: 
 		 			#max=list3[num];
 		#ED=max;
 		return ED;






 		 #+list3[1]+list3[2]+list3[3]);
 		
		#return ED;
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



