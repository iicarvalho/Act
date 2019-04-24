// Developed by: Igor Inácio de Carvalho Silva

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
		//instance of object order
		Order order = new Order(orderString); 	
  		//order exibition	
		order.show();	
	}
}
