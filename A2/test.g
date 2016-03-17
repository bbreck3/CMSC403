grammar test;

@parser::members{
	String str;
	/*String parse(String str){
		switch(str){
			case: '#': return str;

		}
		return 0;
	}*/
	//Scanner scan = new Scanner(System.in);
	//String input = scan.nextLine();
	//while(input!=null)
}
file: row+ {System.out.printf("%f,%f\n", str);};

row: a= field '\r'? '\n'
{
	str+=$a.start.getText();
	parse($str);

}
;

e returns [Object v]
    : a=e op=( MUL | DIV ) b=e  
        {   
            if ($a.v instanceof Integer && $b.v instanceof Integer){
                $v = eval((Integer)$a.v, $op.type, (Integer)$b.v);
            } else if ($a.v instanceof String && $b.v instanceof Integer){
                $v = eval((String)$a.v, $op.type, (Integer)$b.v);
            } else if ($a.v instanceof Integer && $b.v instanceof String){
                $v = eval((String)$b.v, $op.type, (Integer)$a.v);
            } else {
                error();
            }
        }

field
: TEXT
;

e return [String s]
: a=e {$v = parse($a.v);}
TEXT: ~[.]+;
