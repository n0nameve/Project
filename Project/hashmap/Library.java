package hashmap_practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Library {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<String, String> bookMap=new HashMap<>();
		HashMap<String, String> userMap=new HashMap<>();
		HashMap<String, ArrayList<String>> borrowMap=new HashMap<>();
		Scanner sc=new Scanner(System.in);
		
		String bid,bname,id,name;
		
		
		
		while(true) {
			System.out.println("1.新增書籍 2.新增會員 3.借書 4.還書 5.查詢會員借了哪些書 6.查詢某書被哪些會員借走 7.離開系統");
			System.out.print("請輸入選項：");
			int num=sc.nextInt();
			sc.nextLine();
			switch(num) {
				case 1:
					System.out.println("輸入書籍編號：");
					bid=sc.nextLine();
					System.out.println("輸入書名：");
					bname=sc.nextLine();
					bookMap.put(bid, bname);
					System.out.println("新增成功");
				break;
				
				case 2:
					System.out.println("輸入會員ID：");
					id=sc.nextLine();
					System.out.println("輸入姓名：");
					name=sc.nextLine();
					userMap.put(id, name);
					System.out.println("新增成功");
				break;
				
				case 3:
					System.out.println("輸入員ID：");
					id=sc.nextLine();
					System.out.println("輸入書籍編號：");
					bid=sc.nextLine();
					if(userMap.containsKey(id)&&bookMap.containsKey(bid)) {
						if(!borrowMap.containsKey(id)) {
							borrowMap.put(id, new ArrayList<>());
						}
						if(!borrowMap.get(id).contains(bid)) {
							borrowMap.get(id).add(bid);
							System.out.println("借閱成功");
						}else {
							System.out.println("已借閱"+bookMap.get(bid)+"("+bid+")");
						}
						
					}else {
						System.out.println("請輸入正確的會員ID、書籍編號");
					}
				break;
				
				case 4:
					System.out.println("輸入會員ID：");
					id=sc.nextLine();
					System.out.println("輸入書籍編號：");
					bid=sc.nextLine();
					if(borrowMap.containsKey(id)&&borrowMap.get(id).contains(bid)) {
						borrowMap.get(id).remove(bid);
						System.out.println("還書成功");
					}else {
						System.out.println("請輸入正確的會員ID、書籍編號");
					}
				break;
				
				case 5:
					System.out.println("輸入會員ID：");
					id=sc.nextLine();
					if(userMap.containsKey(id)) {
						System.out.println("會員"+userMap.get(id)+"借閱的書籍：");
						if(borrowMap.containsKey(id)) {
							ArrayList<String> books=borrowMap.get(id);
							for(String b:books) {
								System.out.println("書名："+bookMap.get(b)+"("+b+")");
							}
							
						}else {
							System.out.println("此會員無借閱書籍");
						}

					}else {
						System.out.println("請輸入正確的會員ID");
					}
				break;
				
				case 6:
					System.out.println("輸入書籍編號：");
					bid=sc.nextLine();
					if(bookMap.containsKey(bid)) {
						System.out.println("有借閱"+bookMap.get(bid)+"("+bid+")"+"的會員：");
						boolean isborrowed=false;
						for(String key:borrowMap.keySet()) {
							ArrayList<String> member=borrowMap.get(key);
							if(member.contains(bid)) {
								System.out.println("姓名："+userMap.get(key)+"("+key+")");
								isborrowed=true;
							}
						}
						
						if(!isborrowed) {
							System.out.println("無人借閱此書");
						}
					}else {
						System.out.println("請輸入正確的書籍編號");
					}
				break;
				
				case 7:
					return;
				default:
					System.out.println("請輸入正確的選項");
					break;

					
					
			}
		}
		
	}

}
