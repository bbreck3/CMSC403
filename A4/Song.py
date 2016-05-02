class Song(object):

    def __init__(self, list):
        self.list = list;

    def sing_me_a_song(self):
        for num in self.list:
            print num;

happy_bday = Song([1,2,3,4]);
                   #"I don't want to get sued",
                   #"So I'll stop right there"])

bulls_on_parade = Song([2,4,6,8]);
                        

happy_bday.sing_me_a_song()

bulls_on_parade.sing_me_a_song()