package gtt;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Bookshop {
	
	public static void main(String [] args) {
		
		//ArrayList allows new books to be added or removed at anytime
		ArrayList<Books> bookshop = new ArrayList<Books>();
		
		bookshop.add(new Books("Moby Dick",new BigDecimal("18.5"),1851));
		bookshop.add(new Books("The Terrible Privacy of Maxwell Sim",new BigDecimal("13.14"),2010));
		bookshop.add(new Books("Still Life With Woodpecker",new BigDecimal("11.05"),1980));
		bookshop.add(new Books("Sleeping Murder",new BigDecimal("10.24"),1976));
		bookshop.add(new Books("Three Men in a Boat",new BigDecimal("12.87"),1889));
		bookshop.add(new Books("The Time Machine",new BigDecimal("10.43"),1895));
		bookshop.add(new Books("The Caves of Steel",new BigDecimal("8.12"),1954));
		bookshop.add(new Books("Idle Thoughts of an Idle Fellow",new BigDecimal("7.32"),1886));
		bookshop.add(new Books("A Christmas Carol",new BigDecimal("4.23"),1843));
		bookshop.add(new Books("A Tale of Two Cities",new BigDecimal("6.32"),1859));
		bookshop.add(new Books("Great Expectations",new BigDecimal("13.21"),1861));
		
		
		ShoppingBasket sb = new ShoppingBasket();
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		boolean purchasing = true;
		boolean checkingOut = true;
		
		int answer = JOptionPane.showConfirmDialog(null, 
					 "Would you like to purchase a book?",null, JOptionPane.YES_NO_OPTION);
		if(answer == JOptionPane.YES_OPTION) {
		
		while(purchasing) {	
			
			//Case-sensitive
			String title = JOptionPane.showInputDialog(null,"Please enter the name of the book you wish to purchase?");
			
			for(int i = 0; i < bookshop.size();i++) {
				if(title.equals(bookshop.get(i).getTitle())){
					sb.addBook(title,bookshop);
					
					int continuing = JOptionPane.showConfirmDialog(null,"Please select 'Yes' if you would like to checkout or 'No' if you would like to "
										+ "purchase another book? Or Cancel to exit.");
					if(continuing == JOptionPane.CANCEL_OPTION) {
						System.exit(0);
					}
					if(continuing == JOptionPane.YES_OPTION) {
						purchasing = false;
					}
					break;
				}
				if(i==bookshop.size()-1) {
					JOptionPane.showMessageDialog(null,"The book you would like to purchase is not in stock please select another book.");
				}
			}
		}
			
		
			int checkoutBooks = JOptionPane.showConfirmDialog(null,"Are there any books you would like to remove before checkout? Or "
								+ " Cancel to exit.");
			if(checkoutBooks == JOptionPane.CANCEL_OPTION) {
				System.exit(0);
			}
						
			BigDecimal totalCost= new BigDecimal("0.00");
			if(checkoutBooks == JOptionPane.YES_OPTION) {
			while(checkingOut) {		
				
				String remove = JOptionPane.showInputDialog(null,"Please enter the name of the book you wish to remove?");	
				
				for(int i = 0; i < bookshop.size();i++) {
					if(remove.equals(bookshop.get(i).getTitle())){
						sb.removeBook(remove,bookshop);
					
						int removeCheckout = JOptionPane.showConfirmDialog(null,"Please select 'Yes' if you would like to continue checking out"
												+ " or 'No' if you would like to remove another book?",null,JOptionPane.YES_NO_OPTION);
						if(removeCheckout == JOptionPane.YES_OPTION) {
							checkingOut = false;
						}
						break;
					}
				if(i==bookshop.size()-1) {
					JOptionPane.showMessageDialog(null,"The book you would like to remove is not in the basket, please select another book.");
				}
				}
			}
				
					for(int i =0; i<sb.getShoppingBasket().size();i++) {
						boolean apply = sb.checkDiscount2000(sb.getShoppingBasket().get(i).getYear());
						totalCost = totalCost.add(sb.applyDiscount2000(apply, sb.getShoppingBasket().get(i).getPrice()));
	
					}
				

			}
			if(checkoutBooks == JOptionPane.NO_OPTION) {
			
				
					for(int i =0; i<sb.getShoppingBasket().size();i++) {
						boolean apply = sb.checkDiscount2000(sb.getShoppingBasket().get(i).getYear());
						totalCost = totalCost.add(sb.applyDiscount2000(apply, sb.getShoppingBasket().get(i).getPrice()));
						
					}
				}
			
	
			boolean applicable = sb.checkDiscount30(totalCost);	
			totalCost = sb.applyDiscount30(applicable, totalCost);
			
			JOptionPane.showMessageDialog(null, "The total cost of the books is: " + nf.format(totalCost) +".");
			
			
		}else {
			System.exit(0);
		}
		
		
	}

}
