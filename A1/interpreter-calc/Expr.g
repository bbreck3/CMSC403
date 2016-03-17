/**
	Robert Breckenridge 
	CMSC403 
	A1: antlr interpreter

	This solution only works as single varibale calculator.

	Things that doe not work:

	1) Multiple Varibale Declaration: eg: var int x,y
	2) String variable declration: eg: var string x....

	Both issues will print out error messages if the type or signiture is detected.

	According to doctor Arrodz via email correspondance, if I was having issues, and given limited time to focus on a subset of the problem

	Ether string or integers
	Only utilize singel variable declaration rather than more complex solutions that handle mutltiple varibale declarations

	Output error messages and use error detection.


	I read the reference book twice and and looked things up online. This is my best attempt for A1.

	Hopefully things will go better in A2.



*/




grammar Expr;

@header{
	import java.util.*;
}

@parser::members{
	Map<String, Integer> memory = new HashMap<String, Integer>(); //HashMap to store the variables and to simulate memory
	
	/*Function to evaluate to left and right sub child  of the tree alonf with a particular operatio type:
		ADD --> +
		SUB: --> -
		DIV --> /
		MULT --> *

		etc...

		Thus function only works for Integer data types. An overloaded eval function shown below to handle String types
	*/
	int eval(int left, int op, int right){
		switch( op ){
	case MUL : return left * right;
	case DIV : if(right==0){  //Case that handles division by zero of integer data types...which is illegal
					error("Division by zero is not allowed!");
				} else {
						return left / right;
				}
	return left / right;
	case ADD : return left + right;
	case SUB : return left - right;
		}
	 return 0;
	}

	/**
		Overloaded eval function to handle multiple variable declaration 

		****NOTE: I was unsuccessfully in this attempt***** 

	*/

	int eval(int left, int op, int right, int nextNum){  /**  My attempt at getting multiple varibles to work...yeah */
		switch( op ){
	case MUL : return left * right * nextNum;
	case DIV : if(nextNum==0){  //Case that handles division by zero of integer data types...which is illegal
					error("Division by zero is not allowed!");
				} else {
						return left / right / nextNum;
				}
			
	case ADD : return left + right + nextNum;
	case SUB : return left - right - nextNum;
		}
	 return 0;
	}

	/**
		Overloaded eval function to handle String data types

		****NOTE: I was unsuccessfully in this attempt***** 

	*/
	String eval(String str1, String str2){
	return str1;
	}

	/**
		Becuase  I was unable to get both data types and single variable declaration to work:
		As per suggested by email exchange by Dr.Arodz:
		Focus on a subset of the language.

		Therefore, if the interpreter detects string types or multiple varibale declarations:

		It throws an error: and prints out respectively;

		"Error: String types not allowed"
		"Error: Multiple varibales declarations are not allowed"

	*/


	void error(){ //Message to handle String types
		System.err.println("Error: String types not allowed!");
		System.exit(0);
	}
	void error(String msg){ //Generic message to handle the message passed in as parameter. See error() function below for details.
			System.out.println(msg);
			System.exit(0);
	}
}

prog: stat+; //Start or entry point of the program. Every program must have at least one statement


/**

	statemenst (stat) are broken up into tokens for parsing based on specific definitions and defined signitures
	
	1) VAR --> keyword to identify with 'var' : defined at bottom of page
	2) INTEGER --> keyword to recongnize 'int'
	3) '=' the assignment operator
	4) e for expr --> looks for sequences of letters and digits to parse for manipulation

*/
stat: e NEWLINE  {System.out.println($e.v);} 
|	VAR  INTEGER ID '=' e NEWLINE {memory.put($ID.text, $e.v);} //Handles single variable declarations
|	VAR  INTEGER ID ',' ID '=' e NEWLINE {   /**  My attempt at getting multiple varibles to work...yeah */
					memory.put($ID.text, $e.v); //Multiple varibale declarations are not supported so it throws an error
					 error("Multiple varibale declarations not allowed!");
					 } 
| 	VAR STRING ID '=' e NEWLINE {error("Error: String types not allowed!");} //String signiture types are not allowed and thus throws an error
| 	'print' e NEWLINE {System.out.println($e.v);} //print the value of e, either from assignment or after arithmetic operations
|	NEWLINE //newline token
;


e returns [int v] // actions event for e--> takes the left and right children and passes it to methods at the top of the page for evaluation
:	a=e op=('*' | '/') b=e {$v = eval($a.v, $op.type, $b.v);} //Multiplication and Division test cases
|	a=e op=('+' | '-') b=e {$v = eval($a.v, $op.type, $b.v);} //Addition and Subtraction test cases
|	a=e op=('*' | '/') b=e c=e {$v = eval($a.v, $op.type, $b.v, $c.v);} /**  My attempt at getting multiple varibles to work...yeah */
|	a=e op=('+' | '-') b=e c=e{$v = eval($a.v, $op.type, $b.v, $c.v);} /**  My attempt at getting multiple varibles to work...yeah */
|	INT		{$v = $INT.int;}
|	ID {
	String id = $ID.text;
		$v = memory.containsKey(id) ? memory.get(id) : 0;
	}
| '(' e ')'  {$v =$e.v;}
;



/**
		Attempting these two for strings--> Neither worked and could not figure out why.....
		Solution: Interpreter that will will only work for A subset of the language:: Integers only.
		Print out an error if a string type is detected....

*/



/**  Method One: Error: error(147): Calc.g:57:0: left recursive rule e2 must contain an alternative which is not left recursive

	Can not figure out why: after reading the book, stackoverflow and internet searching......



e2 returns [String v]
:	a=e2 {$v = eval($a.v, $op.type, $b.v);}
;

*/




/**


 	Method Two: Error:: Various Java files:: 1) Required Reference: found int
 											 2) int cannot be converted to String

 							Note: I am aware of the what the issues mean and have an idea of what it could be
 								BUT this antlr thing is just not computing with me.....yeah......

e3 returns [Object v]
:	a=e op=('*' | '/') b=e { //Mutliplication and Division test cases
		if ($a.v instanceof Integer && $b.v instanceof Integer){
			$v = eval((Integer)$a.v, $op.type, (Integer)$b.v);
		}
	}
|	a=e op=('+' | '-') b=e { //Addition and Subtraction test cases
		if ($a.v instanceof Integer && $b.v instanceof Integer){
			$v = eval((Integer)$a.v, $op.type, (Integer)$b.v);
		}
	}
|	a=e b=e{ //Case to handle Strings --> this did not work...
			if($a.v instanceof String && $b.v instanceof String){
				$v = eval((String)$a.v, (String)$b.v);
			}
		}
|	INT		{$v = $INT.int;}
|	ID {
	String id = $ID.text;
		$v = memory.containsKey(id);
	}
| '(' e ')'  {$v =$e.v;}
;

*/




/**
	Definitions:

*/

VAR : 'var'; //keyword var
INTEGER : 'int'; //keyword int
STRING : 'string';   // ...
TEST : 'hello';    // ...
ID  :   ('a'..'z'|'A'..'Z')+ ; //regular expresion to handle and type of identifier for either case, must have at least one
STRID : '"' ('a'..'z'| 'A'..'Z')* '"';// My attempt to handle string after assignment ... '='
INT :   '0'..'9'+ ; //regular expression to handle any integer num
NEWLINE:'\r'? '\n' ; //Newline
WS  :   (' '|'\t')+ {skip();} ; // take out / ignore whitespace

//Is what it says....
MUL : '*';
DIV : '/';
SUB : '-';
ADD : '+';


