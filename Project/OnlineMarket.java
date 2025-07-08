package AdvancedClass;

import java.util.Scanner;

class Product1 {
	int num;
	String name;
	int price;

	public Product1(int num, String name, int price) {
		this.num = num;
		this.name = name;
		this.price = price;
	}

	public void printInfo() {
		System.out.println(num + "." + name + "：" + price);

	}
}

public class OnlineMarket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product1 a = new Product1(1, "apple", 15);
		Product1 b = new Product1(2, "banana", 20);
		Product1 c = new Product1(3, "pineapple", 50);
		Product1 d = new Product1(4, "mango", 70);

		
		int tol = 0;
		while (true) {
			
			a.printInfo();
			b.printInfo();
			c.printInfo();
			d.printInfo();

			Scanner scanner = new Scanner(System.in);
			System.out.println("輸入商品編號(0 結帳)：");
			int x = scanner.nextInt();
			if(x==0) {
				break;
			}
			System.out.println("輸入購買數量：");
			int y = scanner.nextInt();
			
			int sum=0;
			switch (x) {

			case 1:
				sum += y * a.price;
				break;
			case 2:
				sum += y * b.price;
				break;
			case 3:
				sum += y * c.price;
				break;
			case 4:
				sum += y * d.price;
				break;
			default:
				System.out.println("查無此商品");
			}
			System.out.println("小記："+sum);
			tol += sum;
			System.out.println("累積金額："+tol);
		}
		
		System.out.println("總金額："+tol);
		
	}

}
