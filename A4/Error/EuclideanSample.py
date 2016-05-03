#all subclasses inherit sample and calculate the data from the list created in sample in a specific way
#inherits sample
#Euclidean measure the EuclideanDistance of all the elements
#EuclideanNorm is the the sqrt(summation(i^2))) or the square root of all summatino each ith term squared 
import math;
from nn import nn;
class EuclideanSample(nn):
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



