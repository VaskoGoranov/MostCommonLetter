package MostEncChar;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public class CompByEntry implements Comparator<Map.Entry<Character, Integer>>{

	@Override
	public int compare(Entry<Character, Integer> arg0, Entry<Character, Integer> arg1) {
		
		return arg1.getValue() - arg0.getValue();
	}

	

}
