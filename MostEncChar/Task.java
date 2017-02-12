package MostEncChar;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Task {

	public static void main(String[] args) {
		
		int counter = 0;
		TreeMap<Character, Integer> map = new TreeMap<>();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter some text:");
		String text = sc.nextLine();
		text = text.toUpperCase();
		for (int i = 0; i < text.length(); i++) {
			char letter = text.charAt(i);
			if (letter == ' ' || !(letter>'A' && letter<'Z')) {
				continue;
			}
			for (int j = 0; j < text.length(); j++) {
				if (letter == text.charAt(j)) {
					counter ++;
				}
			}
			map.put(letter, counter);
			counter = 0;
		}
		ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
		
		Collections.sort(list, new CompByEntry());
		
		LinkedHashMap<Character, Integer> sort = new LinkedHashMap ();
		for (int i = 0; i<list.size(); i++) {
			sort.put(list.get(i).getKey(), list.get(i).getValue());
		}
		
		LinkedHashMap<Map.Entry<Character, Integer>, StringBuilder> graph = new LinkedHashMap<>();
		
		for (Entry<Character, Integer> e : sort.entrySet()) {
			StringBuilder chars = new StringBuilder();
			for (int i = 0; i < e.getValue(); i++) {
				chars.append("####");
			}
			
			graph.put(e, chars);
		}
		
		for (Entry<Map.Entry<Character, Integer>, StringBuilder> e : graph.entrySet()) {
			System.out.println(e.getKey().getKey() + " : " + e.getKey().getValue() + " " + e.getValue() );
			
		}
		
		
	}
		
}
