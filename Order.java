// Developed by: Igor Inácio de Carvalho Silva

//imports
import java.lang.*; // to use substring method
import java.util.ArrayList; // to use arrayList

public class Order
{
	//atributes
	private String timeOfDay;
	private ArrayList <Integer> orders = new ArrayList <Integer>();

	/****************************************** constructors ***************************************/
	Order(String orderString)
	{
		orderString = removeSpaces(orderString);
		//index of first occurency of comma
		//substring delimit string until next occurrence of comma
		for (int i=0, idx=0;;i++)
		{
			//index of comma in order string
			idx = orderString.indexOf(',');
			try
			{
				//catch the period
				if (i==0)
					this.timeOfDay = orderString.substring(0,idx);
				//catch items order	
				else
					this.orders.add(Integer.parseInt(orderString.substring(0,idx)));
				//replace the order string
				orderString = orderString.substring(idx+1,orderString.length());

			}
			
			catch(Exception ex)
			{
				try
				{
					//add the last order number
					this.orders.add(Integer.parseInt(orderString));
				}
				//when the order doesn't have a item
				catch(Exception ex2)
				{
					System.out.println("Necessary to order correctly: Example of a valid order: morning, 1, 2, 3, 4");
					System.exit(0);
				}
				break;
			}	
			//increment the index var
			idx++;
		}
	}

	/****************************** public methods - accessible for all classes ********************/
	
	// method to remove spaces from string
	public String removeSpaces(String orderString)
	{
		//new string
		String stringReplaced = "";

		//walks the order string
		for (int i=0; i<orderString.length();i++)
		{
			//verify if is a space
			if (orderString.charAt(i) != ' ')
				//remove the space
				stringReplaced = stringReplaced.concat(""+orderString.charAt(i));	
		}
		return stringReplaced;
	}

	//show method
	public void show()
	{
		//order the arraylist with quicksort algo
		//call the algo, passing by parameters first and last positions
		quickSort(0, this.orders.size()-1);
		try
		{
			//convert string to lower case
			String timeOfDay = this.timeOfDay.toLowerCase();
			//switch the period
			switch(timeOfDay)
			{
				case "morning":		
					//call the method which verify if is a valid order
					if(!verifyOrder())
						System.out.println("multiple order is possible only for drinks");					
				break;

				case "night":
					//call the method which verify if is a valid order
					if(!verifyOrder())
						System.out.println("multiple order is possible only for potatoes");	
				break;
				//non valid period
				default:
					System.out.println("Wrong option. Choose 'morning' or 'night'");
				break;
			}
		}
		//any error occurrence
		catch(Exception ex)
		{
			System.out.println("Error to show order");
		}
	}

	/**************************** private methods - accessible only for this class *****************/
	
	//verify if is a valid order
	private boolean verifyOrder ()
	{
		//final order
		String order="";
		//counters of items in a order
		int entree=0;
		int side =0;
		int drink=0;
		int dessert =0;
		int other =0;	

		//morning
		if(this.timeOfDay.equals("morning"))
		{
			
			//walks the arraylist
			for (int i=0; i<this.orders.size();i++)
			{
				//sum in counter is an occurence
				if (this.orders.get(i) == 1)
					entree++;

				else if (this.orders.get(i) == 2)
					side++;

				else if (this.orders.get(i) == 3)
					drink++;

				else if (this.orders.get(i) >3 || this.orders.get(i) <1)
					dessert++;

				//verify if the order is possible
				if (entree>1 || side>1 || dessert>1)
					return false;
			}

			//verify if exists a entree
			if(entree>0)
				order = order.concat("eggs");

			//verify if exists a side
			if(side>0)
			{
				//if have a entree 
				if (!order.equals(""))
					order = order.concat(", toast");
				//if doesn't have a entree
				else
					order = order.concat("toast");		
			}

			//verify if exists a drink
			if(drink>0)
			{
				//more than one drink
				if (drink >1)
				{
					//if have a entree or side
					if (!order.equals(""))
						order = order.concat(", coffee("+drink+"x)");
					// if doesn't have a entree or side
					else
						order = order.concat("coffee (" + drink + ")");
				}
				//just one drink
				else
				{
					//if have a entree or side
					if (!order.equals(""))
						order = order.concat(", coffee");
					//if doesn't have a entree or side
					else
						order = order.concat("coffee");
				}	
			}

			//verify if exists a dessert
			if(dessert>0)
			{
				//if have a entree,side or drink
				if (!order.equals(""))
					order = order.concat(", error");
				//if doesn't have a entree,side or drink
				else
					order = order.concat("error");
			}

			//show order
			System.out.println(order);

			return true;
		}

		//nigth
		else
		{	
			//walks the arraylist
			for (int i=0; i<this.orders.size();i++)
			{
				//sum in counter is an occurence
				if (this.orders.get(i) == 1)
					entree++;

				else if (this.orders.get(i) == 2)
					side++;

				else if (this.orders.get(i) == 3)
					drink++;

				else if (this.orders.get(i) == 4)
					dessert++;

				else if (this.orders.get(i) > 4 || this.orders.get(i) < 1)
					other++;

				//verify if the order is possible 
				if (entree>1 || drink>1 || dessert>1 || other>1)
					return false;
			}
			
			//verify if exists a entree
			if(entree>0)
				order = order.concat("steak");

			//verify if exists a side
			if(side>0)
			{
				//more than one side
				if (side >1)
				{
					//if have a entree
					if (!order.equals(""))
						order = order.concat(", potato("+side+"x)");
					//if doesn't have a entree
					else
						order = order.concat("potato(" + side + ")");
				}
				//only one side
				else
				{
					//if have a entree
					if (!order.equals(""))
						order = order.concat(", potato");
					//if doesn't have a entree
					else
						order = order.concat("potato");
				}	
			}

			//verify if exists a drink
			if(drink>0)
			{
				//if have a entree or side
				if (!order.equals(""))
					order = order.concat(", wine");
				//if doesn't have a entree or side
				else
					order = order.concat("wine");		
			}

			//verify if exists a dessert
			if(dessert>0)
			{
				//if have a entree, side or drink
				if (!order.equals(""))
					order = order.concat(", cake");
				//if doesn't have a entree, side or drink
				else
					order = order.concat("cake");
			}

			//verify if exists other order
			if(other>0)
			{
				//if have a entree, side, drink or dessert
				if (!order.equals(""))
					order = order.concat(", error");
				//if doesn't have a entree, side, drink or dessert
				else
					order = order.concat("error");
			}

			//show order
			System.out.println(order);

			return true;
		}
	}

	//sort algorithm - the best for worst case
	//adapted from http://www.java2novice.com/java-sorting-algorithms/quick-sort/
	private void quickSort(int begin, int end)
	{
        int i = begin;
        int j = end;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = this.orders.get(begin+(end-begin)/2);
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which 
             * is greater then the pivot value, and also we will identify a number 
             * from right side which is less then the pivot value. Once the search 
             * is done, then we exchange both numbers.
             */
            while (this.orders.get(i) < pivot)
                i++;
            while (this.orders.get(j) > pivot)
                j--;
            if (i <= j)
            {
                swap(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (begin < j)
            quickSort(begin, j);
        if (i < end)
            quickSort(i, end);
    }
 	
 	//swap values between two positions of arraylist
    private void swap(int i, int j)
    {
        int temp = this.orders.get(i);
        this.orders.set(i, this.orders.get(j));
        this.orders.set(j, temp);
    }
}