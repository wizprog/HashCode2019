package main;

import java.util.Set;
import java.util.stream.Collectors;

public class Par {

	int score;
	int equals;
	int onlyS1;
	int onlyS2;
	
	Picture p1;
	Picture p2;
	
	public Par(Picture p1, Picture p2) {
		super();
		this.p1 = p1;
		this.p2 = p2;
	}
	
	int intersection() {
		Set<String> result = p1.getTags().stream()
				  .distinct()
				  .filter(p2.getTags()::contains)
				  .collect(Collectors.toSet());
		
		return result.size();
	}
	
}
