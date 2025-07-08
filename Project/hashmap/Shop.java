package hashmap_practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Shop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<String, String> productMap = new HashMap<>();
		HashMap<String, String> memberMap = new HashMap<>();
		HashMap<String, ArrayList<String>> purchaseMap = new HashMap<>();

		String pid, pname, id, name;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("1.新增商品 2.新增會員 3.購買商品 4.查詢會員購買紀錄 5.查詢某商品被哪些會員購買 6.離開系統");
			System.out.print("請輸入選項：");
			int num = sc.nextInt();
			sc.nextLine();

			switch (num) {
			case 1:
				System.out.print("輸入商品代號：");
				pid = sc.nextLine();
				System.out.print("輸入商品名稱：");
				pname = sc.nextLine();
				productMap.put(pid, pname);
				System.out.println("新增成功");
				break;
			case 2:
				System.out.print("輸入會員ID：");
				id = sc.nextLine();
				System.out.print("輸入姓名：");
				name = sc.nextLine();
				memberMap.put(id, name);
				System.out.println("新增成功");
				break;
			case 3:
				System.out.print("輸入會員ID：");
				id = sc.nextLine();
				System.out.print("輸入商品代號：");
				pid = sc.nextLine();
				if (memberMap.containsKey(id) && productMap.containsKey(pid)) {
					if (!purchaseMap.containsKey(id)) {
						purchaseMap.put(id, new ArrayList<String>());
					}
					purchaseMap.get(id).add(pid);
					System.out.println("購買成功");
				} else {
					System.out.println("請輸入正確的會員ID、商品代號");
				}
				break;
			case 4:
				System.out.print("輸入會員ID：");
				id = sc.nextLine();
				if (memberMap.containsKey(id)) {
					System.out.println("會員：" + memberMap.get(id) + "(" + id + ") 購買紀錄：");
					if (purchaseMap.containsKey(id) && !purchaseMap.get(id).isEmpty()) {
						ArrayList<String> products = purchaseMap.get(id);
						for (String p : products) {
							System.out.println("商品：" + productMap.get(p) + "(" + p + ")");
						}
					} else {
						System.out.println("此會員無購買任何商品");
					}
				} else {
					System.out.println("請輸入正確的會員ID");
				}
				break;
			case 5:
				System.out.print("輸入商品代號：");
				pid = sc.nextLine();
				if (productMap.containsKey(pid)) {
					System.out.println("購買商品：" + productMap.get(pid) + "(" + pid + ") 的會員：");
					boolean isbought=false;
					for (String key : purchaseMap.keySet()) {
						ArrayList<String> product = purchaseMap.get(key);
						if (product.contains(pid)) {
							System.out.println("姓名：" + memberMap.get(key) + "(" + key + ")");
							isbought=true;
						}
					}
					if(!isbought) {
						System.out.println("無會員購買此商品");
					}
				} else {
					System.out.println("請輸入正確的商品代號");
				}
				break;
			case 6:
				System.out.println("感謝使用");
				return;

			}
		}
	}

}
