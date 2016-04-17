/**
	@auther Robert Breckenridge
	V00637965
	CMSC403: A2: Code Injection

	Solution: Scan the input file line by line and detect if the line contains # symbol;
	If the line does contain that symbol, then evaluate it further for key components and build a return string 
	based on the parsed information.

	To handle outlying String cases: 
		Example: #outList0=MAP[inCollection,String,s,Integer,len,{len=s.length();}]
		Example: String z="#outList=MAP[inCollection,String,s,Integer,len,{len=s.length();}]"; <-- do not parse that as this is a valid string

		I did not use the Island strategy: I figured out a way to distinguies between the two cases by detecting if the line that has a # symbol 
		aslso contians a " symbol as this is an actual String and should not be parsed.

		if the line only contains a # and not "  then it should be parsed.

		Example in sudo code:

		if(line has #) //line needs to contains a # to be further examined
			if(!line has ") // if that line further does not have a " then continue else if it does halt and return the line
					parse(line)



To run the program:
1) --> antlr4 expr.g
2) -->  javac *.java
3) --> cat input.java | grun expr prog > output.java // (prog is the entry point to the grammer)

antlr4 and grun are alias set according to:
http://www.antlr.org/

 export CLASSPATH=".:/usr/local/lib/antlr-4.5.2-complete.jar:$CLASSPATH"
 alias antlr4='java -jar /usr/local/lib/antlr-4.5.2-complete.jar'
 alias grun='java org.antlr.v4.gui.TestRig'



*/







grammar expr;
@header{
	import java.io.*;
	import java.util.*;
}
@parser::members{
	
	String token ="";// --> empty string for the return token
	String parse(String str){ // --> method that takes a string as input
	Scanner scan = new Scanner(str);
	String line=scan.nextLine(); // if the line contains a # symbol, take a closer look at that line
								// Example: #outList0=MAP[inCollection,String,s,Integer,len,{len=s.length();}]
	if(line.contains("#")){
		System.out.println("//" + line);
		
		if(!(line.contains("\""))){ //verifies that a line that contians a # symbol does not contains quotes ' " '
									//example: String z="#outList=MAP[inCollection,String,s,Integer,len,{len=s.length();}]"; <-- do not parse that as //this is a valid string
									//if the line fits the criterion, further examine it
		token = extract(line);
		}
	} else { token = line;} // if the line does not contain # then do nothing, it is of no concern so simply return it
	return token;
	
		
	}
	
	String extract(String str){ //--> //method the extract the contents of the line that contianed a #
				
				//find the index of various key components
				int hashTagIdx= str.indexOf('#');
				int equalIdx = str.indexOf('=');
				int leftBrak = str.indexOf('[');
				int rightBrak = str.indexOf(']');
				int leftCurly = str.indexOf('{');
				int rightCurly = str.indexOf('}'); 
				
				int commaPos=0; // --> records whether or not the current character is a , and increments by one if it is....for an array purposes
				int commaCounter=0; // --> //keep count of the number of commas--> in order to find out how many tokens are inside the [  ] 
				String trgToken=""; // --> if the currently parsed token in the [  ] is  then assign the value of that string to this
				String arr[]; // --> array to hold all the tokens inside the  [    ]
				String function="";// ---> stting to hold the funtion eg : MAP, FILTER or FOLD
				String retTok=""; // String hold the final result if that will return that correct output of the parsed string

				//interate through the string that contains the # symbol
				for(int i=0; i<str.length()-1; i++){
			
				if(str.charAt(i)=='#'){ // detect the #
				
				
				String contents = str.substring(leftBrak+1, rightBrak); // --> grab contents between [  ]
				String listName = str.substring(hashTagIdx+1, equalIdx); // --> grabs the listName
				String extractFunc=str.substring(equalIdx+1,leftBrak); // --> grabs the fucntion name: MAP, FILTER, FOLD
				String betweenCurly = str.substring(leftCurly+1, rightCurly);// --> grabs the info between {   }
				switch(extractFunc){ // evaluate the function and assign the correct one
					case "MAP": function="MAP";
						
					break;
				
					case "FILTER": function="FILTER";
						
					break;

					case "FOLD": function="FOLD";
						
					break;
					default: System.out.println("No Such Case");
					
				}

				for(int j=0; j<contents.length(); j++){ // --> Iterate through the contect in order to count the number of commas
					
					if(contents.charAt(j)==','){
						
							commaCounter++;
					}
				}
				
				arr = new String[commaCounter]; // --> initialize an array with the number of found commas

				for(int j=0;j<contents.length();j++){ // iterate through the contents again looking for commmans, 
														// while you do not find one, build a string 
														// with all the non , chars that you do find, once a , is found, add that string to the array and // reset the string...repeat
						if(!(contents.charAt(j)==',')){
								trgToken+=contents.charAt(j);
						} else{ arr[commaPos]=trgToken; commaPos++; trgToken="";}
				}

				
					//filter the return token by function and built the string by each function case
					if(function=="MAP"){
					retTok+="List<"+ arr[1] + "> outListInternal=new LinkedList<" + arr[1] +">();\n";
					retTok+="for( " + arr[1] + " " + arr[2] + " : " + arr[0] + " )\n";
					retTok+="{ \n";
					retTok+=arr[3] + " " + arr[4] +";\n";
					retTok+=betweenCurly +"\n";
					retTok+="outListInternal.add(" +arr[4] + ");\n";
					retTok+="} \n";
					retTok+=listName + "=outListInternal;";


					} else if(function=="FILTER"){
					retTok+="List<"+ arr[1] + "> outListInternal=new LinkedList<" + arr[1] +">();\n";
					retTok+="for( " + arr[1] + " " + arr[2] + " : " + arr[0] + " )\n";
					retTok+="{ \n";
					retTok+="if(" + betweenCurly+")\n";
					retTok+="{ \n";
					retTok+="outListInternal.add(" +arr[2] + ");\n";
					retTok+="} \n";
					retTok+="} \n";
					retTok+=listName + "=outListInternal;\n";

					} else if(function=="FOLD"){
					retTok+="List<"+ arr[1] + "> outListInternal=new LinkedList<" + arr[1] +">();\n";
					retTok+="for( " + arr[1] + " " + arr[2] + " : " + arr[0] + " )\n";
					retTok+="{ \n";
					retTok+=betweenCurly+"\n";
					retTok+="} \n";
					}
				} 	
			}return retTok;
	}

}

//entry point int0 the program
prog: stat+; //every program must have at least one statement


stat: e NEWLINE {System.out.println($e.v);}  //every statement must have at least one e(short for expression)
;


e returns [String v] //action for e that returns a String
 : a = STRING { // each token must be a string...parse each string line by line
 	String s = $a.text; // grab the value of the token
	$v = parse(s); // parse the value
	}
;


STRING:  ~[\r\n]+; //A string is anything that is not a newline or a return


NEWLINE:'\r'? '\n' ; //Newline
WS  :   (' '|'\t')+ {skip();} ; //Whitespace