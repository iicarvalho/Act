// Developed by: Igor Inácio de Carvalho Silva

//To compile the project : javac projectName
//To execute the project: java projectName
//Example of a valid input: morning, 1, 2, 3, 4

//imports
import java.util.Scanner; // Scanner

//principal class
public class ActTest
{
	public static void main(String[] args)
	{
		//instance of object scanner
    	Scanner ler = new Scanner(System.in);
    	//instance of string and read keybord until press enter key
    	String orderString = ler.nextLine();
		//instance
		Order order = new Order(orderString); 	
  		//order exibition	
		order.show();	
	}
}