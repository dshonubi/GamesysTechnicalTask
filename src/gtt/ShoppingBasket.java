package gtt;


import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * 
 * @author Dayo Shonubi
 * 
 * This class controls the movement of books when making a purchase.
 * It also controls the discount features.
 * Methods considering longevity were added to the application. However, some methods cannot be implemented due to the manner of the application made.
 * If I used a website in which I could separate admin and user rules then I would have implemented them but, in this application
 * I couldn't do it without leaving user access to apply made-up discounts open, as an example.
 * 
 * The methods that would be used for longevity in a different type of application are commented as unused.
 * Others are simply not added as they would not be set up in this type of class. E.g. discounts would be done in a jsp 
 * where the amount could be entered and the conditions also.
 * 
 */

public class ShoppingBasket{

	private BigDecimal totalCost = new BigDecimal("0.00");
	
	//Only need to change these values for discount percentage and 
	//where it occurs to be changed everywhere else
	private BigDecimal discount30 = new BigDecimal("0.05");
	private BigDecimal discount30Applies = new BigDecimal("30.00");
	private int discount2000Applies = 2000;
	private BigDecimal discount2000 = new BigDecimal("0.1");
	private ArrayList <Books> basket = new ArrayList<Books>();
	
	
	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
		
	}
	
	//method checks whether the 5% discount can be applied if the total cost is over £30
	public boolean checkDiscount30(BigDecimal totalCost) {
		if(totalCost.compareTo(discount30Applies)>= 0) {
			return true;
		}else {
			return false;
		}
	}
	
	//method checks whether 10% discount can be applied for books published after 2000
	public boolean checkDiscount2000(int year) {
		if(year>=discount2000Applies) {
			return true;
		}else {
			return false;
		}
	}
	
	public BigDecimal applyDiscount30(boolean check,BigDecimal totalCost) {
		if(check == false)
			return totalCost;
		
		 BigDecimal val = totalCost.multiply(discount30);
		 return totalCost.subtract(val);
	}

	public BigDecimal applyDiscount2000(boolean check,BigDecimal price) {
		if(check == false)
			return price;
		
		 BigDecimal val = price.multiply(discount2000);
		 return price.subtract(val);
	}
	
	public ArrayList<Books> getShoppingBasket(){
		return basket;
	}
	
	//books could have the same name if question didn't specify title,price and year would
	//use author to solve issue of adding books and removing them 
	public void removeBook(String title, ArrayList<Books> bookshop){
		
		for(int i =0; i<basket.size();i++) {
			if(basket.get(i).getTitle().equals(title)) {
				basket.remove(i);
				break;
			}
			if(i== basket.size()-1) {
				JOptionPane.showMessageDialog(null,"Basket does not contain this book.");
			}
		}

	}
	
	public void addBook(String title,ArrayList<Books> bookshop){
		
		for(int i =0; i<bookshop.size();i++) {
			if(bookshop.get(i).getTitle().equals(title)) {
				basket.add(bookshop.get(i));
				break;
			}
		}
	}
	
	//unused for admin
	public void addBookToBookshop(ArrayList<Books> bookshop,Books book) {
		bookshop.add(book);
	}
	
	//unused for admin
	public void removeBookFromBookshop(ArrayList<Books> bookshop,String title) {
		for(int i=0; i<bookshop.size();i++) {
			if(bookshop.get(i).getTitle().equals(title)){
				bookshop.remove(bookshop.get(i));
			}
		}
	}
	
	//unused for admin
	public void editBookPriceInBookshop(ArrayList<Books> bookshop,String title, BigDecimal price) {
		for(int i=0; i<bookshop.size();i++) {
			if(bookshop.get(i).getTitle().equals(title)){
				bookshop.get(i).setPrice(price);
			}
		}
	}
	
	//unused for admin
	public void editBookTitleInBookshop(ArrayList<Books> bookshop,String OriginalTitle, String NewTitle) {
		for(int i=0; i<bookshop.size();i++) {
			if(bookshop.get(i).getTitle().equals(OriginalTitle)){
				bookshop.get(i).setTitle(NewTitle);
			}
		}
	}
	
	//unused for admin
	public void editBookYearInBookshop(ArrayList<Books> bookshop,String title, int year) {
		for(int i=0; i<bookshop.size();i++) {
			if(bookshop.get(i).getTitle().equals(title)){
				bookshop.get(i).setYear(year);
			}
		
		}
	}
	
}
