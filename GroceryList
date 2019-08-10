import java.util.ArrayList;
 
public class GroceryList {
	
	private ArrayList<String> groceryList = new ArrayList<String>();
	
	
	
	public ArrayList<String> getGroceryList() {
		return groceryList;
	}
 
	public void setGroceryList(ArrayList<String> groceryList) {
		this.groceryList = groceryList;
	}
 
	public void addGroceryItem(String item) {
		groceryList.add(item);
	}
	
	public void printGroceryList() {
		System.out.println("You Have "+ groceryList.size() + " item in your grocery list");
		for(int i = 0; i < groceryList.size(); i ++) {
			System.out.println((i+1) +" . "+groceryList.get(i));
		}
	}
	
	public void modifyGroceryItem(String currentItem, String newItem) {
		int position = findItem(currentItem);
		if(position >= 0) {
			modifyGroceryItem(position , newItem);
		}
	}
	
	private void modifyGroceryItem(int position , String item) {
		groceryList.set(position, item);
		System.out.println("Grocery Item " + (item) + " has been modified");
	}
	
	public void removeItem(String item) {
		int position = findItem(item);
		if(position >= 0) {
			removeItem(position);
		}
	}
	
	private void removeItem(int position) {
		groceryList.remove(position);
	}
	 
	private int findItem(String searchItem) {
		
		return groceryList.indexOf(searchItem);
		
  }
	
	public boolean onFile(String item) {
		int position = findItem(item);
		if(position >= 0) {
			return true;
		}
		return false;
	}
 
}
