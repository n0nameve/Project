package practice;

import java.util.ArrayList;
import java.util.Scanner;

class CBook {
	String title;
	int price;

	public CBook(String t, int p) {
		title = t;
		price = p;
	}

	@Override
	public String toString() {
		return "Title: " + title + ", Price: " + price;
	}
	
	public int getDiscountPrice(int discount) {
	    return price * discount / 100;
	}
}

public class BookList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		ArrayList<CBook> bookList = new ArrayList<>();
		while(true) {
			System.out.println("請輸入書名(輸入end結束)：");
			String bookName=scanner.nextLine();
			
			if(bookName.equals("end")) {
				break;
			}
			System.out.println("請輸入價格：");
			int bookPrice=Integer.parseInt(scanner.nextLine());
			
			bookList.add(new CBook(bookName, bookPrice));
		}
		System.out.println("你輸入的書籍有：");
		for (CBook book : bookList) {
			System.out.println(book); 
		}
		
		System.out.println("各書籍 8 折後價格如下：");
		for (CBook book : bookList) {
			int dp=book.getDiscountPrice(80);
			System.out.println(book.title+":"+dp); 
		}
		
		System.out.println("價格最高的書是：");
		int max=0;
		CBook mostExpensiveBook = null;
		for (CBook book : bookList) {
			if(book.price>max) {
				max=book.price;
				mostExpensiveBook=book;
			}

		}
		System.out.println(mostExpensiveBook);
	}

}
