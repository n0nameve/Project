package practice;

import java.util.LinkedList;
import java.util.Scanner;

class music{
	LinkedList<String> PlayList = new LinkedList<>();
	Scanner sc = new Scanner(System.in);
	String name;
	int i=0;
	public void addsong() {
		System.out.print("輸入歌曲：");
		name = sc.nextLine();
		PlayList.add(name);
		System.out.println("新增成功");
	}
	
	public void playsong() {
		if (PlayList.isEmpty()) {
			System.out.println("播放清單為空！");
			return;
		}
		System.out.println(PlayList.getFirst() + " 播放中");
		i = PlayList.indexOf(PlayList.getFirst());
	}
	
	public void nextsong() {
		if (PlayList.isEmpty()) {
			System.out.println("播放清單為空！");
			return;
		}
		i = (i + 1) % PlayList.size();
		System.out.println(PlayList.get(i) + " 播放中");
	}
	
	public void previousSong() {
		if (PlayList.isEmpty()) {
			System.out.println("播放清單為空！");
			return;
		}
		i = ((i - 1) + PlayList.size()) % PlayList.size();
		System.out.println(PlayList.get(i) + " 播放中");
	}
	
	public void show() {
		for (int j = 0; j < PlayList.size(); j++) {
			if (j == i) {
				System.out.println("▶ " + PlayList.get(j));
			} else {
				System.out.println("  " + PlayList.get(j));
			}
		}
	}
	
	public void shuffleSong() {
		if (PlayList.isEmpty()) {
			System.out.println("播放清單為空！");
			return;
		}
		i = (int) (Math.random() * PlayList.size());
		System.out.println(PlayList.get(i) + " 播放中");
	}
}


public class MusicPlayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		music m=new music();
		int num;
		
		while (true) {
			System.out.println("1.加入歌曲 2.播放 3.下一首 4.上一首 5.播放清單 6.隨機播放 0.離開");
			System.out.print("輸入選項：");
			num = sc.nextInt();
			sc.nextLine();
			switch (num) {
			case 1:
				m.addsong();
				break;
			case 2:
				m.playsong();
				break;
			case 3:
				m.nextsong();
				break;
			case 4:
				m.previousSong();
				break;
			case 5:
				m.show();
				break;
			case 6:
				m.shuffleSong();
				break;
			case 0:
				System.out.println("再見！");
				return;
			default:
				System.out.println("請輸入正確選項");
				break;

			}

		}

	}

}
