package HashMap_practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

class Student implements Comparable<Student>{
	String name;
	int score;
	
	public Student(String name,int score) {
		this.name=name;
		this.score=score;
	}
	
	public int compareTo(Student other) {
		return other.score-this.score;
	}
	
	public String toString() {
		 return "姓名：" + name + " 成績：" + score;
	}
}

public class studentScore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<String, Student> studentMap = new HashMap<>();
		
		Scanner sc = new Scanner(System.in);
		String id,name;
		int score;
		while (true) {
			System.out.println("1.新增  2.查詢  3.移除  4.顯示  5.成績排名 6.分數門檻  0.離開");
			System.out.print("請輸入選項：");
			int num=sc.nextInt();
			sc.nextLine();
			switch(num) {
				case 1:
					System.out.print("輸入學號：");
					id=sc.nextLine();
					System.out.print("輸入姓名：");
					name=sc.nextLine();
					System.out.print("輸入成績：");
					score=sc.nextInt();
					studentMap.put(id,new Student(name,score));
					System.out.println("新增成功");
					break;
				case 2:
					System.out.print("輸入學號：");
					id=sc.nextLine();
					if(studentMap.containsKey(id)) {
						Student Data=studentMap.get(id);
						System.out.println(Data);
					}else {
						System.out.println("查無此學號");
					}
					break;
				case 3:
					System.out.print("輸入學號：");
					id=sc.nextLine();
					if(studentMap.containsKey(id)) {
						studentMap.remove(id);
						System.out.println("已移除");
					}else {
						System.out.println("查無此學號");
					}
					break;
				case 4:
					for(String key:studentMap.keySet()) {
						Student Data=studentMap.get(key);
						System.out.println("學號："+key+" "+Data);
					}
					break;
				case 5:
					ArrayList<Student> students=new ArrayList<>(studentMap.values());
					Collections.sort(students);
					System.out.println("成績排序：");
					int sum=0; double avg;
					for(int i=0;i<students.size();i++) {
						System.out.println("#"+(i+1)+" "+students.get(i));
						sum+=students.get(i).score;
					}
					System.out.println("最高分=>"+students.get(0));
					System.out.println("最低分=>"+students.reversed().get(0));
					avg=sum/students.size();
					System.out.println("平均分數："+avg);
					break;
				case 6:
					System.out.println("請輸入分數門檻：");
					int a=sc.nextInt();
					boolean find=false;
					for(String key:studentMap.keySet()) {
						Student Data=studentMap.get(key);
						if(Data.score>=a) {
							System.out.println("學號："+key+" "+Data);
							find=true;
						}
					}
					if(!find) {
						System.out.println("查無符合條件的學生");
					}
					break;
					
				case 0:
					System.out.println("感謝使用");
					return;
				default:
					System.out.println("請輸入正確的選項");
					break;

			}
		}

	}

}