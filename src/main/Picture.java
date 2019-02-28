package main;

import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Picture {
	
	private int  position;
	
	private ArrayList<String> tags = new ArrayList<>();

	public Picture(int position, ArrayList<String> tags) {
		super();
		this.position = position;
		this.tags = tags;
	}
	
	public Picture() {
		super();
		this.position = 0;
		this.tags = null;
	}
	
	@Override
	public String toString() {
		StringBuilder sb= new StringBuilder(position==1?"H":"V");
		for(int i =0;i<tags.size();i++) {
			sb.append(" "+tags.get(i));
		}
		return sb.toString();
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public ArrayList<String> getTags() {
		return tags;
	}

	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}
	
	public static Picture merge(Picture p1 , Picture p2) {
		Picture p = new Picture();
		
		 Set<String> set = new LinkedHashSet<>(p1.getTags());
	        set.addAll(p2.getTags());
	        ArrayList<String> combinedList = new ArrayList<>(set);
	        
		p.setPosition(1);
		p.setTags(combinedList);
		return p;
	}
	
}
