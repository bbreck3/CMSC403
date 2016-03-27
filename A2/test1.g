

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
	
	if(line.contains("#")){

		if(!(line.contains("\""))){
		
		token = extract(line); //"Target-->" +line;
		}
	} else { token = line;}
	return token;



	/*for(int i=0; i<line.length(); i++){	
		if(line.charAt(i)=='#'){

		String next = line.substring(10,12);
		
			return token;	
	} else return "Invalid Input";
	}*/ 
	
		
	}

	String extract(String str){
				
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
				String function="";

				
			for(int i=0; i<str.length()-1; i++){
			
				if(str.charAt(i)=='#'){
				
				
				String contents = str.substring(leftBrak+1, rightBrak);
				System.out.println("Debug--> contents");
				String listName = str.substring(hashTagIdx+1, equalIdx);
				System.out.println("Debug--> listName");
				String extractFunc=str.substring(equalIdx+1,leftBrak);
				String betweenCurly = str.substring(leftCurly+1, rightCurly);
				switch(extractFunc){
					case "MAP": function="MAP";
						
					break;
				
					case "FILTER": function="FILTER";
						
					break;

					case "FOLD": function="FOLD";
						
					break;
					default: System.out.println("No Such Case");
					
				}
				for(int j=0; j<contents.length(); j++){
					
					if(contents.charAt(j)==','){
						
							commaCounter++;
					}
				}
				
				arr = new String[commaCounter];
				for(int j=0;j<contents.length();j++){
						
						if(!(contents.charAt(j)==',')){
								trgToken+=contents.charAt(j);
						} else{ arr[commaPos]=trgToken; commaPos++; trgToken="";}
				}

				System.out.println("List-->" + listName);
				System.out.println("Function-->" + function);
				System.out.println("Between Curly-->" + betweenCurly);
				System.out.println("Elems: (By Case Below)");
				
					if(function=="MAP"){
					System.out.println("List<"+ arr[1] + "> outListInternal=new LinkedList<" + arr[1] +">();");
					System.out.println("for( " + arr[1] + " " + arr[2] + " : " + arr[0] + " )");
					System.out.println("{ \n");
					System.out.println(arr[3] + " " + arr[4]);
					System.out.println(betweenCurly);
					System.out.println("outListInternal.add(" +arr[4] + ")" );
					System.out.println("} \n");
					System.out.println(listName + "=outListInternal");


					} else if(function=="FILTER"){
					System.out.println("List<"+ arr[1] + "> outListInternal=new LinkedList<" + arr[1] +">();");
					System.out.println("for( " + arr[1] + " " + arr[2] + " : " + arr[0] + " )");
					System.out.println("{ \n");
					System.out.println("if(" + betweenCurly+")");
					System.out.println("{ \n");
					System.out.println("outListInternal.add(" +arr[2] + ");" );
					System.out.println("} \n");
					System.out.println(listName + "=outListInternal");

					} else if(function=="FOLD"){
					System.out.println("List<"+ arr[1] + "> outListInternal=new LinkedList<" + arr[1] +">();");
					System.out.println("for( " + arr[1] + " " + arr[2] + " : " + arr[0] + " )");
					System.out.println("{ \n");
					System.out.println(betweenCurly);
					System.out.println("} \n");
					}
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

stat: e NEWLINE {System.out.println($e.v);} 
;

e returns [String v]
 : a = STRING {
 	String s = $a.text;
	$v = parse(s);
	}
;


STRING:  ~[\r\n]+;

NEWLINE:'\r'? '\n' ; //Newline
WS  :   (' '|'\t')+ {skip();} ;