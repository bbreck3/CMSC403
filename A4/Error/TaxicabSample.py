#all subclasses inherit sample and calculate the data from the list created in sample in a specific way
#inherits sample
#Euclidean measure the EuclideanDistance of all the elements
#EuclideanNorm is the the sqrt(summation(i^2))) or the square root of all summatino each ith term squared 
import math;
from nn import *;
class TaxicabSample(nn):
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



