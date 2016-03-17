

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
	/*File file = new File(test.java);
	Scanner scan = new Scanner(System.in);
	String line;
	String parse(String str){

	while(scan.hasNext()){
		String  test = scan.next();
		if(test=="#"){
		line = scan.nextLine();
		System.out.println(line);
		}
	} return line;  */
	/**

		Currently works, but is not reading in the input correctly...should be from scanner, not using a method

	*/
	String parse(String str){
	if(str.charAt(0)=='#'){
		String temp = eval(str);
		return temp;
	} else {
		str="Invalid";
	}
	return str;
	}

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




