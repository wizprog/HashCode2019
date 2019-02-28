package main;

import java.util.ArrayList;

public class Picture {
	
	private int  position;
	
	private ArrayList<String> tags = new ArrayList<>();

	public Picture(int position, ArrayList<String> tags) {
		super();
		this.position = position;
		this.tags = tags;
	}
	
	@Override
	public String toString() {
		StringBuilder sb= new StringBuilder(position==1?"H":"V");
		for(int i =0;i<tags.size();i++) {
			sb.append(" "+tags.get(i));
		}
		return sb.toString();
	}
	
}
