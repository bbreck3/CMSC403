
import java.util.*;
class test{
	
	public static void main(String args[]){
			Scanner scan = new Scanner(System.in);
			int counter = 0;
			while(scan.hasNext()){
				String next = scan.nextLine();
				System.out.println("Next Line: " +next);
				counter++;
			}
			System.out.println(counter);
	}
}