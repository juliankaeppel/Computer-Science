package lecture18.basic.matching;

import java.util.Deque;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

	String sequence;
	
	public Parser(String sequence) {
		this.sequence = sequence;
	}
	
	public boolean isValid() {
		Pattern p = Pattern.compile("<(\\/?\\w+)>");
		Matcher m = p.matcher(sequence);
		Deque<String> q = new LinkedList<String>();
		
		while (m.find()) {
			String tag = m.group(1);
			
			if (tag.charAt(0) == '/') {
				if (q.isEmpty() || !q.pop().equals(tag.substring(1)))
					return false;
			} else
				q.push(tag);
				
		}
		
		return q.isEmpty();
	}
}
