


#class sample: Initilizes a list with some sample data and creates a distance method in order to provide distance
#capabilities. The specific type of distance will be calculated in one of three ways: 
# 1) EuclideanNorm which is the the sqrt(summation(i^2))) or the square root of all summatino each ith term squared 
# 2) The taxicab norm  is the summation of the absolute value of each ith term.
# 3) MaxNorm is the absolute value of of each term in the vector set. There is no summation for this one. Simple the absolute value for each element

class nn(object):

###$############
#### Working ###
################

	#list; #= [1,2,3,4];
	#def _init_(self,list):
		#self.list = list;
	#def getList(self):
			#return self.list;
	#def setList(self, list):
		#self.list = list;
 	#def distance(self,sample, list2):
 	#	list1 = sample.getList();
 	#	list3 = range(4);
 	#	for num in range(0,len(list1)):
 			
 	#		list3[num] = list1[num]-list2[num];
 	#		return list3;
 		
 #########################
 ## Testing ##############
 #########################

	def __init__(self,list, tag=None):
			if tag is None:
				self.list =list;
			else: self.list =list; self.tag = tag; #print(tag);
	def getList(self):
			return self.list;

	def getTag(self,*tag):
		return self.tag;
		self.list = list;
 	def distance(self,sample, list2):
 		list1 = sample.getList();
 		list3 = range(4);

 		for num in range(0,len(list1)):
 			
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