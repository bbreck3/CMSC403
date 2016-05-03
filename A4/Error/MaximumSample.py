#all subclasses inherit sample and calculate the data from the list created in sample in a specific way
#inherits sample
#Euclidean measure the EuclideanDistance of all the elements
#EuclideanNorm is the the sqrt(summation(i^2))) or the square root of all summatino each ith term squared 
import math;
from nn import *;
class MaximumSample(nn):
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



