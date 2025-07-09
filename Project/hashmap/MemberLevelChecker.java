package HashMapandHashSet;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class MemberLevelChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<String, String> members=new HashMap<>();
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			System.out.println("1.新增會員 2.查詢 3.顯示所有會員");
			System.out.print("請選擇：");
			int num=sc.nextInt();
			sc.nextLine();
			switch(num) {
			case 1:
				System.out.print("請輸入帳號：");
				String name=sc.nextLine();
				System.out.println("等級： 1.一般會員 2.VIP");
				System.out.print("請選擇：");
				int num1=sc.nextInt();
				switch(num1) {
				case 1:
					members.put(name, "一般會員");
					break;
				case 2:
					members.put(name, "VIP");
					break;
				default:
					System.out.println("請輸入正確選項");
					continue;
				}
				break;
			case 2:
				System.out.print("請輸入帳號：");
				name=sc.nextLine();
				if(members.containsKey(name)) {
					System.out.println(name+":"+members.get(name));
				}else {
					System.out.println("查無此帳號");
				}
				
				break;
			case 3:
				for(Entry<String, String> entry:members.entrySet()) {
					System.out.println(entry.getKey()+":"+entry.getValue());
				}
				break;
			default:
				System.out.println("請輸入正確選項");
				continue;
			}
		}
		
	}

}
