grammar test1;

@parser::members{
	String parse(String str){
	if(str.charAt(0)=='#'){
		return str;
	} else {
		str="Invalid";
	}
	return str;
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




