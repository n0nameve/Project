package hashmap_practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

class CharCountCompare implements Comparable<CharCountCompare>{
	char c;
	int count;
	
	public CharCountCompare(char c,int count) {
		this.c=c;
		this.count=count;
	}
	
	public int compareTo(CharCountCompare other){
		return Character.compare(this.c,other.c);
		
	}
}

public class CharCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("請輸入字串：");
		String str=sc.nextLine();
		
		
		HashMap<Character, Integer> charCount=new HashMap<>();
		for(int i=0;i<str.length();i++) {
			char c=str.charAt(i);
			charCount.put(c, charCount.getOrDefault(c, 0)+1);
			
		}
		ArrayList<CharCountCompare> list=new ArrayList<>();
		for(Entry<Character, Integer> entry:charCount.entrySet()) {
			list.add(new CharCountCompare(entry.getKey(), entry.getValue()));
		}
		Collections.sort(list);
		
		for(CharCountCompare cc:list) {
			System.out.println(cc.c+":"+cc.count);
		}
		
	}

}
