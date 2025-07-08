package Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Item {
	String name;
	String author;
	boolean isBorrowed;

}

class Book extends Item {
	public Book() {
		isBorrowed = false;
	}

	public Book(String name, String author) {
		this.name = name;
		this.author = author;
	}

	public void borrow() {
		isBorrowed = true;
	}

	public void returnback() {
		isBorrowed = false;
	}

	public String toString() {
		if (isBorrowed == true) {
			return name + "-" + author + "：已借出";
		} else {
			return name + "-" + author + "：可借閱";
		}

	}
}

public class LibrarySystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		List<Book> books = new ArrayList<>();

		books.add(new Book("Java 初學者入門", "王大明"));
		books.add(new Book("深入理解物件導向", "林慧君"));
		books.add(new Book("資料結構與演算法圖解", "陳威廷"));
		books.add(new Book("程式設計邏輯思維", "張曉涵"));
		books.add(new Book("從 0 開始學會 Spring Boot", "李宗霖"));
		books.add(new Book("系統設計圖解實戰", "黃筱芸"));
		books.add(new Book("資料庫入門：MySQL 快速上手", "吳建勳"));
		books.add(new Book("軟體工程實務與開發流程", "陳怡君"));
		books.add(new Book("Git 版本控制從入門到進階", "賴志強"));
		for (int i = 0; i < books.size(); i++) {
			System.out.println("[" + (i + 1) + "] " + books.get(i));
		}

		while (true) {

			System.out.println("-------------------------------------");
			System.out.println("請輸入：1.借書 2.還書 3.查詢狀態 0.離開");
			int num = scanner.nextInt();
			scanner.nextLine();

			switch (num) {

			case 1:
				System.out.println("輸入編號：");
				int b = scanner.nextInt();
				books.get(b - 1).borrow();
				System.out.println("["+b+"] "+books.get(b-1));
				break;
			case 2:
				System.out.println("輸入編號：");
				int b1 = scanner.nextInt();
				books.get(b1 - 1).returnback();
				System.out.println("["+b1+"] "+books.get(b1-1));
				break;
			case 3:
				for (int i = 0; i < books.size(); i++) {
				    System.out.println("[" + (i + 1) + "] " + books.get(i));
				}
				break;
			case 0:
				return;
			default:
				System.out.println("請輸入正確號碼");
			}

		}

	}

}
