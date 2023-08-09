package main;
import java.util.ArrayList;
import java.util.LinkedList;

public class test {
	  public static void main(String[] args) { 
	    LinkedList<String> cars = new LinkedList<String>();
	    ArrayList<String> cars2 = new ArrayList<String>();
	    cars.add("Volvo");
	    cars.add("BMW");
	    cars.add("Ford");
	    cars.add("Mazda");
	    cars2.add("Volvo");
	    cars2.add("BMW");
	    cars2.add("Ford");
	    cars2.add("Mazda");
	    System.out.println(cars);
	    System.out.println(cars.getFirst());
	    System.out.println(cars.getLast());
	    System.out.println(cars2.get(0));
	    System.out.println(cars2.get(cars2.size()-1));
	    
	  } 
}
