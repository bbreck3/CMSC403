

grammar test1;



@header{
	import java.io.*;
	import java.util.*;
}
@parser::members{
	/**

		Debugging: Input should be read from system.in using a scanner
		Currently: Doesnt work
	*/
	//File file = new File(test.java);
	//String trgToken ="";
	String token ="";
	String parse(String str){
	Scanner scan = new Scanner(str);

	String line=scan.nextLine();
	if(line.contains("#") || !(line.indexOf("String") > 0))
	{
		System.out.println("Debug");
		token = extract(line); //"Target-->" +line;
		//if(!(line.indexOf("String") > 0)){
		//token = extract(line); //"Target-->" +line;
		//}
	} else { token = line;}
	return token;



	/*for(int i=0; i<line.length(); i++){	
		if(line.charAt(i)=='#'){

		String next = line.substring(10,12);
		switch(next){
		case "MA": token="MAP";
						Sytsem.out.println("Debug --> MAP");
					break;
				
		case "FI": token="FILTER";
					Sytsem.out.println("Debug-->Filter");
					break;

		case "FO": token="FOLD";
					Sytsem.out.println("Debug --> FOLD");
					break;
		default: return 
					
		}
			return token;	
	} else return "Invalid Input";
	}*/ 
	
		
	}

	String extract(String str){
				//System.out.println("Debug-->" + str);
				int hashTagIdx= str.indexOf('#');
				int equalIdx = str.indexOf('=');
				int leftBrak = str.indexOf('[');
				int rightBrak = str.indexOf(']');
				int leftCurly = str.indexOf('{');
				int rightCurly = str.indexOf('}');
				int commaPos=0;
				int commaCounter=0;
				String trgToken="";
				String arr[];
			for(int i=0; i<str.length()-1; i++){
			//System.out.println(i);
				if(str.charAt(i)=='#'){
				
				String contents = str.substring(leftBrak+1, rightBrak);
				//System.out.println("Debug: contents::-->" + contents);
				//System.out.println("Hash-->" + hashTagIdx + ", equal-->" + equalIdx);
				String listName = str.substring(hashTagIdx+1, equalIdx);
				token = listName;
				for(int j=0; j<contents.length(); j++){
					//System.out.println(contents.charAt(j));
					if(contents.charAt(j)==','){
						
							commaCounter++;
					}
				}
				//System.out.println("Debug--> " + commaCounter);
				arr = new String[commaCounter];
				for(int j=0;j<contents.length();j++){
						
						if(!(contents.charAt(j)==',')){
								trgToken+=contents.charAt(j);
						} else{ arr[commaPos]=trgToken; commaPos++; trgToken="";}
				}
				for(int j=0; j<arr.length; j++){
					System.out.println(arr[j] + "\n");
				}
				
				
						
						/*switch(next){
						case "MA": token="MAP";
									return token;
					
						case "FI": token="FILTER";
									return token;

						case "FO": token="FOLD";
									return token;
						} */

				} 	
			}return token;
	}



	/**

		Currently works, but is not reading in the input correctly...should be from scanner, not using a method

	*/
	/*String parse(String str){
	if(str.charAt(0)=='#'){
		String temp = eval(str);
		return temp;
	} else {
		str="Invalid";
	}
	return str;
	}*/

	String eval(String str){
	//for debugging
	char trash = str.charAt(0);
	System.out.println("Trash: --> " +trash);
	String rest = str.substring(1,str.length());
	System.out.println("Debug -->" +rest);
	//end debugging
	return  rest;

	}

}

prog: stat+;

stat: e NEWLINE  {System.out.println($e.v);} 
;

e returns [String v]
 : a = STRING {
 	String s = $a.text;
	$v = parse(s);
	}
;


STRING:  ~[\r\n]+;

NEWLINE:'\r'? '\n' ; //Newline
WS  :   (' '|'\t')+ {skip();} ; // take out / ignore whitespace