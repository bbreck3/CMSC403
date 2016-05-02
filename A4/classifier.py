from sample import sample;
from EuclideanSample import EuclideanSample;
class classifier(object):
	global list9;
	list9= [];
	global list10;
	list10=[];
	#def __init__(self, list):
	#	self.list=list;

	def addSample(self,sample):
		list1 = sample.getList();
		tag = sample.getTag();

		list9.append(list1);
		list10.append(tag);
		
		
		#print(list9);
		#print(list10);
	def predictLabel(self, sample):
		#testList = sample.getList();
		minList = [];

		#print(sample);
		for i in range(0,len(list9)):
			#print(i);
			tempCMPList = list9[i];
			#print(tempCMPList); 
			
			x= EuclideanSample.distance(sample, tempCMPList);
			minList.append(x);
			#print(x);
		#	print(minList)
		y =min(minList);
		#print(y);
		w = minList.index(y);
		#print(w);
		i=list10.index(w);
		#print(p);
		f=list10[i];
		#print(f);
		#print(minList.index(y));
		#print(q);
		return f;

	def getList(self):
		return self.list;


		




cl=classifier()
cl.addSample(sample([2, 2, 2],-1));
cl.addSample(sample([0, 0, 0],1))

p=cl.predictLabel(EuclideanSample([-1, -1, -1]));
print(p) #should print 1