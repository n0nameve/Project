package hashmap_practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class selectCourses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<String, String> studentMap=new HashMap<>();
		HashMap<String, String> courseMap=new HashMap<>();
		HashMap<String, ArrayList<String>> enrollMap= new HashMap<>();
		
		
		Scanner sc = new Scanner(System.in);
		String id,name,cid,cname;
		
		while (true) {
			System.out.println("1.新增學生  2.新增課程  3.選課  4.查詢學生的所有課程  5.查詢課程下有哪些學生 6.課程退選 7.離開");
			System.out.print("請輸入選項：");
			int num=sc.nextInt();
			sc.nextLine();
			switch(num) {
				case 1:
					System.out.print("輸入學號：");
					id=sc.nextLine();
					System.out.print("輸入姓名：");
					name=sc.nextLine();
					studentMap.put(id,name);
					System.out.println("新增成功");
					break;
				case 2:
					System.out.print("輸入課程代號：");
					cid=sc.nextLine();
					System.out.print("輸入課程名稱：");
					cname=sc.nextLine();
					courseMap.put(cid,cname);
					System.out.println("新增成功");
					break;
				case 3:
					System.out.print("輸入學號：");
					id=sc.nextLine();
					System.out.print("輸入課程代號：");
					cid=sc.nextLine();
					if(!enrollMap.containsKey(id)) {
						enrollMap.put(id, new ArrayList<>());

					}
					enrollMap.get(id).add(cid);
					System.out.println("選課成功");
					break;
				case 4:
					for(String key:enrollMap.keySet()) {
						System.out.print("學號："+key+ " 姓名："+studentMap.get(key));
						ArrayList<String> courses=enrollMap.get(key);
						for(String c:courses) {
							System.out.print(" 課程："+c+"("+courseMap.get(c)+")");
						}
						System.out.println();
					}
					break;
				case 5:
					System.out.print("輸入課程代號：");
					cid = sc.nextLine();
					if (courseMap.containsKey(cid)) {
						System.out.println("有選修 " + courseMap.get(cid) + " (" + cid + ") 課程的學生：");
						boolean found = false;
						for (String key : enrollMap.keySet()) {
							ArrayList<String> courses1 = enrollMap.get(key);
							if (courses1.contains(cid)) {
								System.out.println("學號：" + key + ", 姓名：" + studentMap.get(key));
								found = true;
							}
						}
						if (!found) {
							System.out.println("目前無學生選修此課程");
						}
					} else {
						System.out.println("查無此課程");
					}
					break;
				case 6:
					System.out.print("輸入學號：");
					id=sc.nextLine();
					System.out.print("輸入課程代號：");
					cid = sc.nextLine();
					if(studentMap.containsKey(id)&&courseMap.containsKey(cid)) {
						if(enrollMap.containsKey(id)&&enrollMap.get(id).contains(cid)) {
							enrollMap.get(id).remove(cid);
							System.out.println("退選成功");
						}else {
							System.out.println("該學生沒有選這門課");
						}
					}else {
						System.out.println("請輸入正確的學號、課程代號");
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
