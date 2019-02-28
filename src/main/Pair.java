package main;

import java.util.Set;
import java.util.stream.Collectors;

public class Pair {

	int score;
	int equals;
	int onlyS1;
	int onlyS2;
	
	Picture p1;
	Picture p2;
	
	public Pair(Picture p1, Picture p2) {
		super();
		this.p1 = p1;
		this.p2 = p2;
	}
	
	void intersection() {
		Set<String> result = p1.getTags().stream()
				  .distinct()
				  .filter(p2.getTags()::contains)
				  .collect(Collectors.toSet());
		
		this.equals = result.size();
		
		this.onlyS1 = p1.getTags().size() - equals;
		this.onlyS2 = p2.getTags().size() - equals;
		
	}

	
	int score() {
		return Math.min(onlyS1, onlyS2 > equals ? equals : onlyS2);
	}
	
}
