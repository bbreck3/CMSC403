

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
	String token = "";
	String parse(String str){
	Scanner scan = new Scanner(str);
	String line=scan.next();
	if(line.charAt(0)=='#'){

		String next = line.substring(10,12);
		switch(next){
		case "MA": token="MAP";
					return token;
				
		case "FI": token="FILTER";
					return token;
				
		case "FO": token="FOLD";
					return token;
					
		}
		
		return next;
	} else return "Invalid Input";
		
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




