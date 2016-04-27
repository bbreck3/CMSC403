#all subclasses inherit sample and calculate the data from the list created in sample in a specific way
#inherits sample
#Euclidean measure the EuclideanDistance of all the elements
#EuclideanNorm is the the sqrt(summation(i^2))) or the square root of all summatino each ith term squared 
from sample import sample;
class EuclideanSample(sample):
	def _init_(self,list):
		super(EuclideanSample,self)._init_(list);
	def distance(self,list1,list2):
		super(EuclideanSample,self).distance(list1,list2);
		print(list1);
		print(list2);
	def getList():
		return super().getList();


	#def _init_(self,list):
		#self.list = list;
	#def getList(self):
		#return self.list;
	#def setList(self, list):
		#this.list = list;
	


a = sample();
b = EuclideanSample();
a._init_([1,2,3,4]);
b._init_([11,22,33,44]);
print(b.getList());
x= a.getList();
#print(z);
#print(x);
#print(b.distance(a.getList(),b.getList()));



