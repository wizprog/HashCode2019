package main;

import java.util.ArrayList;

public class Picture {
	
	private int  position;
	private int tagSize;
	
	private ArrayList<String> tags = new ArrayList<>();

	public Picture(int position, ArrayList<String> tags) {
		super();
		this.position = position;
		this.tags = tags;
		tagSize = tags.size();
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

	public int getTagSize() {
		return tagSize;
	}

	public void setTagSize(int tagSize) {
		this.tagSize = tagSize;
	}

	public ArrayList<String> getTags() {
		return tags;
	}

	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}
	
	
	
}
