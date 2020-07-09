package gtt;

import java.math.BigDecimal;

/**
 * 
 * @author Dayo Shonubi
 * 
 * This class allows details for each book to be set, edited and called.
 *
 */

public class Books {
	
	private String title;
	private BigDecimal price;
	private int year;
	
	public Books(String title, BigDecimal price, int year) {
		this.title = title;
		this.price = (BigDecimal) price;
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
