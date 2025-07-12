package hashmap_practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

class Score implements Comparable<Score>{
	
	String name;
	int score;
	
	public Score(String name,int score) {
		this.name=name;
		this.score=score;
	}

	@Override
	public int compareTo(Score other) {
		if(other.score==this.score) {
			return this.name.compareToIgnoreCase(other.name);
		}else {
			return other.score-this.score;
		}
	}
	
	public String toString() {
		return name+":"+score;
		
	}
	
}

public class TopScorer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] names = {"John", "Mary", "Tom"};
		int[] scores = {85, 92, 78};
		
		HashMap<String, Integer> score =new HashMap<>();
		for(int i=0;i<names.length;i++) {
			score.put(names[i], scores[i]);
		}
		
		ArrayList<Score> list=new ArrayList<>();
		for(Entry<String, Integer> entry:score.entrySet()) {
			list.add(new Score(entry.getKey(), entry.getValue()));
		}
		
		Collections.sort(list);
		
		for(int i=0;i<list.size();i++) {
			System.out.println("#"+(i+1)+" "+list.get(i));
		}
		
	}

}
