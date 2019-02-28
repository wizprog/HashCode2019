package main;

import java.util.Set;
import java.util.stream.Collectors;

public class Pair {

	int score;
	int equals;
	int onlyS1;
	int onlyS2;
	int globalScore;
	int selectedTag;
	
	Picture p1;
	Picture p2;
	Picture help;
	
	public Pair(Picture p1) {
		super();
		this.p1 = p1;
		selectedTag = 1;
		globalScore = -1;
		this.help = null;
	}
	
	public Pair(Picture p1, Picture p2) {
		super();
		this.p1 = p1;
		this.p2 = p2;
		intersection();
	}
	
	public int calculateScore(Picture p) {
		Set<String> result = p1.getTags().stream()
				  .distinct()
				  .filter(p.getTags()::contains)
				  .collect(Collectors.toSet());
		
		this.equals = result.size();
		
		this.onlyS1 = p1.getTags().size() - equals;
		this.onlyS2 = p.getTags().size() - equals;
		
		return Math.min(onlyS1, Math.min(onlyS2, equals));
	}
	
	public void compair(Picture p, int x) {
		int sc = calculateScore(p);
		if (sc > globalScore) {
			this.help = p;
			globalScore = sc;
			selectedTag = x;
		}
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
	
	public int getSelectedTag() {
		return selectedTag;
	}

	public void setSelectedTag(int selectedTag) {
		this.selectedTag = selectedTag;
	}

	public Picture getHelp() {
		return help;
	}

	public void setHelp(Picture help) {
		this.help = help;
	}

	int score() {
		return Math.min(onlyS1, onlyS2 > equals ? equals : onlyS2);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getEquals() {
		return equals;
	}

	public void setEquals(int equals) {
		this.equals = equals;
	}

	public int getOnlyS1() {
		return onlyS1;
	}

	public void setOnlyS1(int onlyS1) {
		this.onlyS1 = onlyS1;
	}

	public int getOnlyS2() {
		return onlyS2;
	}

	public void setOnlyS2(int onlyS2) {
		this.onlyS2 = onlyS2;
	}

	public Picture getP1() {
		return p1;
	}

	public void setP1(Picture p1) {
		this.p1 = p1;
	}

	public Picture getP2() {
		return p2;
	}

	public void setP2(Picture p2) {
		this.p2 = p2;
	}

	public String write() {
		 StringBuilder s = new StringBuilder();
//		 if (p1 != null) s.append(p1.finalOutput());
//		 if (help != null) s.append(help.finalOutput());
		 return p1.finalOutput() + help.finalOutput(); //s.toString();
	}
	
	public String writeNew() {
		return p1.finalOutput() + p2.finalOutput();
	}
	
	
	
	
	
}
