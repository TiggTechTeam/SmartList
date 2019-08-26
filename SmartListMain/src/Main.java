import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
 
	private static Scanner scanner = new Scanner(System.in);
	private static GroceryList groceryList = new GroceryList();
	
	
	public static void main(String[] args) {
		Screen screen = new Screen("Grocery List");
		screen.setVisible(true);

		try {
			Connection database = DriverManager.getConnection("jdbc:mysql://localhost:3306/grocery_list?serverTimezone=Europe/Vienna", "root", "root");
			Statement queries = database.createStatement();
			ResultSet rs = queries.executeQuery("select * from items;");
			while (rs.next()) {
				screen.insertItem(rs.getString("item"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}





		/* screen settings
		JFrame screen = new JFrame("Grocery List");

		screen.setVisible(true);
		screen.setResizable(false);
		screen.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Screen fr = new Screen();
		fr.setVisible(true);
		screen.add(fr);*/


		boolean quit = false;
		int choice = 0;
		printInstructions();
		
		while(!quit) {
			System.out.println("  Enter Your Choice");
			choice = scanner.nextInt();
			scanner.nextLine();
			
			
			switch (choice) {
			case 0:
				printInstructions();
				break;
				
			case 1:
				groceryList.printGroceryList();
				
				break;
				
			case 2:
				addItem();
				break;
				
			case 3 :
				modifyItem();
				break;
				
			case 4:
				removeItem();
				break;
				
			case 5:
				searchForItem();
				break;
				
			case 6:
				processArrayList();
				break;
				
			case 7:
				quit= true;
				break;
			}
		}
	
		
		System.out.println("*********************************************************\r");
		
		ArrayList<String> myToDoList = new ArrayList<String>();
		
		myToDoList.add("Write an articel");
		myToDoList.add("Make a Youtube Video");
		myToDoList.add("Make a salad for dinner");
		
		System.out.println(myToDoList.size());
		
		myToDoList.set(0, "Dont forget things");
		myToDoList.set(1, "Buy milk and orange juice");
		
		myToDoList.remove(0);
		
		
		for(int i = 0; i < myToDoList.size(); i++) {
			System.out.println("Item No " + (i) + " - "+ myToDoList.get(i));
		}
		
	}
 
	public static void printInstructions() {
		System.out.println("\nPress");
		System.out.println("\t 0 - To Print The Instructions ");
		System.out.println("\t 1 - To Print GroceryList ");
		System.out.println("\t 2 - To Add Item ");
		System.out.println("\t 3 - To Modify item ");
		System.out.println("\t 4 - To Remove Item ");
		System.out.println("\t 5 - To Search for an Item ");
		System.out.println("\t 6 - To Process Array List. ");
		System.out.println("\t 7 - To Not Continue");
	}
	
	public static void addItem() {
		System.out.print("Add : Please enter the grocery Item : ");
		String tmp = scanner.nextLine();
		System.out.println(tmp);
		groceryList.addGroceryItem(tmp);
	}
	
	public static void modifyItem() {
		System.out.print("Modify : Enter the Item: ");
		String curItem = scanner.nextLine();		
		
		System.out.print("Modify : Enter the Replacement Item");
		String newItem = scanner.nextLine();
		
		groceryList.modifyGroceryItem(curItem, newItem);
	}
	
	public static void removeItem() {
		System.out.print("Remove : Enter the Item: ");
		String itemNo = scanner.nextLine();
		groceryList.removeItem(itemNo);
		System.out.print("msg: The Item has been removed");
		groceryList.printGroceryList();
	}
	
	 public static void searchForItem() {
	        System.out.print("Item to search for: ");
	        String searchItem = scanner.nextLine();
	        if(groceryList.onFile(searchItem)) {
	        	System.out.println("Item " + searchItem + " is on the list");
	        }else{
	        	System.out.println(searchItem + " is not in the list");
	        }
	    }
	 
	 public static void processArrayList() {
		 
		 ArrayList<String> newArrayList = new ArrayList<String>();
		 newArrayList.addAll(groceryList.getGroceryList());
		 
		 
		 ArrayList<String> anotherArrayList = new ArrayList<>(groceryList.getGroceryList());
		 
		 String[] myArray = new String[groceryList.getGroceryList().size()];
		 myArray = groceryList.getGroceryList().toArray(myArray);
	 }
	
	}
