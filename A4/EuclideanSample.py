#all subclasses inherit sample and calculate the data from the list created in sample in a specific way
#inherits sample
#Euclidean measure the EuclideanDistance of all the elements
#EuclideanNorm is the the sqrt(summation(i^2))) or the square root of all summatino each ith term squared 
from sample import sample;
class EuclideanSample(sample):
	def _init_(self):
		list = [1,2,3,4];
		super(sample)._init_(list);
		super(sample).distance(list);

	#print(list);

	