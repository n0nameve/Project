package hashmap_practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

class CharCount1 implements Comparable<CharCount1> {
	String ch;
	int count;

	public CharCount1(String ch, int count) {
		this.ch=ch;
		this.count=count;
	}

	@Override
	public int compareTo(CharCount1 other) {
		if(other.count==this.count) {
			return this.ch.compareToIgnoreCase(other.ch);
		}else {
			return other.count-this.count;
		}	
	}
}

public class MostFrequentStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("請輸入字串:");
		String num = sc.nextLine();
		HashMap<String, Integer> list = new HashMap<>();
		
		int max = 0;
		for (int i = 0; i < num.length(); i++) {
			String data = String.valueOf(num.toLowerCase().charAt(i));
			int count = list.getOrDefault(data, 0) + 1;
			list.put(data, count);
			
			if (count > max) {
				max = count;
			}
		}
		
		ArrayList<CharCount1> list1=new ArrayList<>();
		for (Entry<String, Integer> entry : list.entrySet()) {
			list1.add(new CharCount1(entry.getKey(), entry.getValue()));
		}
		
		Collections.sort(list1);
		
		System.out.println("排序後的字元出現次數：");
		for(CharCount1 l:list1) {
			System.out.print(l.ch+":"+l.count+" ");
			
		}
		System.out.println();
		System.out.println("出現最多次的字元：");
		for (Entry<String, Integer> entry : list.entrySet()) {
			if (entry.getValue() == max) {
				System.out.println(entry.getKey() + ":" + max);
			}

		}

	}

}
