import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.ArrayList;


public class GroceryList extends JPanel implements KeyListener {
	
	private ArrayList<String> groceryList;

	GroceryList() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);

		groceryList = new ArrayList<String>();
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.dispose();
	}

	ArrayList<String> getGroceryList() {
		return groceryList;
	}
 
	public void setGroceryList(ArrayList<String> groceryList) {
		this.groceryList = groceryList;
	}

	/**
	 * Add item to GroceryList, if it's not already existing
	 */
	void addGroceryItem(String item) {

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

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}
