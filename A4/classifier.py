from sample import sample;
from EuclideanSample import EuclideanSample;
from ManhattanSample import ManhattanSample;
from MaxSample import MaxSample;
class classifier(object):
	global list9;
	list9= [];
	global list10;
	list10 =[];
	global baseLen;
	baseLen =[];
	global listLenDif;
	listLenDif=[0];
	#def __init__(self, list):
	#	self.list=list;

	def addSample(self,sample):
		baseLen.append(len(sample.getList()));
		maxLen = baseLen[0];
		#print(listLenDif);

		#if(len(sample.getList()) < maxLen):
			#listLenDif[0]=1;
		#if(listLenDif[0]==1):
			#print("asdf");
			#lenDif = maxLen - len(sample.getList());
			#list1 = sample.getList();
			#for i in range(0,lenDif):
		#		list1.append(0);


		list1 = sample.getList();
		tag = sample.getTag();

		list9.append(list1);
		list10.append(tag);
		
		
		#print(list9);
		#print(list10);
	def predictLabel(self, sample):
		if(isinstance(sample,EuclideanSample)):
			
			#testList = sample.getList();
			minList = [];

			#print(sample);
			for i in range(0,len(list9)):
				#print(i);
				tempCMPList = list9[i];
				#print(tempCMPList); 
			
				x= EuclideanSample.distance(sample, tempCMPList);
				#x = ManhattanSample.distance(sample,tempCMPList);
				#x = MaxSample.distance(sample,tempCMPList);
				minList.append(x);
				#print(x);
				#print(minList)
			y =min(minList);
			#print(y);
			w = minList.index(y);
			#print(w);
			i=list10[w];
			#print(i);
			#f=list10[i];
			#print(f);
			#print(minList.index(y));
			#print(q);
			return i;
		if(isinstance(sample,ManhattanSample)):
				
				
			minList = [];

			#print(sample);
			for i in range(0,len(list9)):
				#print(i);
				tempCMPList = list9[i];
				#print(tempCMPList); 
			
				#x= EuclideanSample.distance(sample, tempCMPList);
				x = ManhattanSample.distance(sample,tempCMPList);
				#x = MaxSample.distance(sample,tempCMPList);
				minList.append(x);
				#print(x);
				#print(minList)
			y =min(minList);
			#print(y);
			w = minList.index(y);
			#print(w);
			i=list10[w];
			#print(i);
			#f=list10[i];
			#print(f);
			#print(minList.index(y));
			#print(q);
			return i;
		if(isinstance(sample,MaxSample)):
				#testList = sample.getList();
			minList = [];
			

			#print(sample);
			for i in range(0,len(list9)):
				#print(i);
				tempCMPList = list9[i];
				#print(tempCMPList); 
			
				#x= EuclideanSample.distance(sample, tempCMPList);
				#x = ManhattanSample.distance(sample,tempCMPList);
				x = MaxSample.distance(sample,tempCMPList);
				minList.append(x);
				#print(x);
				#print(minList)
			y =min(minList);
			#print(y);
			w = minList.index(y);
			#print(w);
			i=list10[w];
			#print(i);
			#f=list10[i];
			#print(f);
			#print(minList.index(y));
			#print(q);
			return i;

	def getList(self):
		return self.list;


		




####Sample 1: #### Works if the list are the same;

#cl=classifier()
#cl.addSample(sample([2, 2, 2, 2],-1))
#cl.addSample(sample([0, 0, 0,0],1))
#cl.addSample(sample([0, 0, 0, 0],-1))
#p=cl.predictLabel(EuclideanSample([-1, -1, -1, -1]))
#print(p)  #should print 1




##    Sample 2    ##### WORKS!!
#cl2=classifier()
#cl2.addSample(sample([0, 0],["list","number",1]))
#cl2.addSample(sample([2.1, 5.2],["list","number",2]))
#p=cl2.predictLabel(EuclideanSample([0, 3.3]))
#print(p)  #should print ['list', 'number', 2]
#p=cl2.predictLabel(ManhattanSample([0, 3.3]))
#print(p)  #should print ['list', 'number', 1]
  



### Sample 3: #### WORKS!!!

cl3=classifier()
cl3.addSample(sample([3, 1, 1],"a"))
cl3.addSample(sample([2, 2, 2],"b"))
cl3.addSample(sample([4, 0, 0],"c"))
p=cl3.predictLabel(EuclideanSample([0, 0, 0]))
print(p)  #should print a
p=cl3.predictLabel(ManhattanSample([0, 0, 0]))
print(p)  #should print c
p=cl3.predictLabel(MaxSample([0, 0, 0]))
print(p)  #should print b
