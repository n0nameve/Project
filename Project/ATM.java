package practice;

import java.util.Scanner;

class Account{
	String username;
	String password;
	double balance;
	
	public Account(String username, String password, double balance) {
		this.username=username;
		this.password=password;
		this.balance=balance;	
	}
	
	public void deposit(double amount) {
		balance+=amount;
	}
	
	public void withdraw(double amount) {
		if(balance>=amount) {
			balance-=amount;
		}else {
			System.out.println("Insufficient funds");
		}
	}
	
	public void showBalance() {
		System.out.println(balance);
	}
}

public class ATM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account x=new Account("user", "123456", 1000);
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("enter account：");
		String name=scanner.nextLine();
		System.out.println("enter password");
		String password=scanner.nextLine();
		
		if(name.equals(x.username) && password.equals(x.password)) {
			int num;
			while(true) {
				System.out.println("1.存款");
				System.out.println("2.提款");
				System.out.println("3.查詢餘額");
				System.out.println("4.登出");
				
				System.out.printf("請輸入選項：");
				num=scanner.nextInt();
				scanner.nextLine();
				switch(num) {
					case 1:
						System.out.println("金額：");
						double deposit=scanner.nextInt();
						scanner.nextLine();
						x.deposit(deposit);
						break;
					case 2:
						System.out.println("金額：");
						double withdraw=scanner.nextInt();
						scanner.nextLine();
						x.withdraw(withdraw);
						break;
					case 3:
						System.out.println("查詢餘額：");
						x.showBalance();
						System.out.print("請按 Enter 鍵繼續...");
						scanner.nextLine(); // ← 讓畫面暫停，直到你按下 Enter
						break;
					case 4:
						System.out.println("已登出！");
						return;
					default:
			            System.out.println("無效選項，請重新輸入！");
			            return;
				
				}
			}
			
		}else {
			System.out.println("account or password wrong");
			scanner.close();
		}
		
	}

}
