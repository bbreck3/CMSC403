


#class sample: Initilizes a list with some sample data and creates a distance method in order to provide distance
#capabilities. The specific type of distance will be calculated in one of three ways: 
# 1) EuclideanNorm which is the the sqrt(summation(i^2))) or the square root of all summatino each ith term squared 
# 2) The taxicab norm  is the summation of the absolute value of each ith term.
# 3) MaxNorm is the absolute value of of each term in the vector set. There is no summation for this one. Simple the absolute value for each element
class sample:
	list;
	def _init_(self,list):
		self.list = list;
 	def distance(list):
 		print(list);


#test = sample([1,2,3,4]);
#print(list.distance());




#all subclasses inherit sample and calculate the data from the list created in sample in a specific way

#inherits sample
#Euclidean measure the EuclideanDistance of all the elements
#EuclideanNorm is the the sqrt(summation(i^2))) or the square root of all summatino each ith term squared 
#class EuclideanSample:

#inherits sample
#Taxicab measure the TaxicabNorm of all the elements
#The taxicab norm  is the summation of the absolute value of each ith term.
#class TaxicabSample:

#inhertis sample
#MaxiMumNorm measure the MaximumNorm of all the elements
#MaxNorm is the absolute value of of each term in the vector set. There is no summation for this one. Simple the absolute value for each element
#class MaxNormSample:

