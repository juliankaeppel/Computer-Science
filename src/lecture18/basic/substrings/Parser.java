package lecture18.basic.substrings;

import java.util.HashMap;
import java.util.Map;

public class Parser {

	private int substringLength;
	
	private String input;
	private HashMap<String, Integer> map = new HashMap<String, Integer>();
	
	public Parser(String input, int substringLength) {
		this.input = input;
		this.substringLength = substringLength;
		map();
	}
	
	private void map() {
		for (int i = 0; i < input.length() - substringLength + 1; i++) {
			String substring = input.substring(i, i + substringLength);
			if (!map.containsKey(substring))
				map.put(substring, 1);
			else
				map.put(substring, map.get(substring) + 1);
		}
	}
	
	public int substringCount() {
		return map.size();
	}
	
	public Map.Entry<String, Integer>[] occurrenceCount() {
		@SuppressWarnings("unchecked")
		Map.Entry<String, Integer>[] entry = (Map.Entry<String, Integer>[]) new Map.Entry[map.size()];
		
		int i = 0;
		for (Map.Entry<String, Integer> e : map.entrySet())
			entry[i++] = e;
		
		for (i = 1; i < entry.length; i++) {
			if (entry[i].getValue() > entry[i - 1].getValue()) {
				
				Map.Entry<String, Integer> temp = entry[i];
				int j;
				
				for (j = i; j > 0 && entry[j - 1].getValue() < temp.getValue(); j--)
					entry[j] = entry[j - 1];
				
				entry[j] = temp;
			}
		}
		
		return entry;
	}
}
