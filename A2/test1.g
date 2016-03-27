

grammar test1;



@header{
	import java.io.*;
	import java.util.*;
}
@parser::members{
	
	String token ="";
	String parse(String str){
	Scanner scan = new Scanner(str);

	String line=scan.nextLine();
	
	if(line.contains("#")){
		System.out.println("//" + line);
		if(!(line.contains("\""))){
		
		token = extract(line); //"Target-->" +line;
		//System.out.println("Token returned--> " + "[ " + token + " ]");
		//System.out.println("Debug Line after token returned");
		}
	} else { token = line;}
	return token;
	
		
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
				String retTok="";

				
			for(int i=0; i<str.length()-1; i++){
			
				if(str.charAt(i)=='#'){
				
				
				String contents = str.substring(leftBrak+1, rightBrak);
				//System.out.println("Debug--> contents");
				String listName = str.substring(hashTagIdx+1, equalIdx);
				//System.out.println("Debug--> listName");
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

				//System.out.println("List-->" + listName);
				//System.out.println("Function-->" + function);
				//System.out.println("Between Curly-->" + betweenCurly);
				//System.out.println("Elems: (By Case Below)");
				
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