package main;

import java.util.*;

public class Picture {
	
	private int  position;
	private long ID;

	private ArrayList<String> tags = new ArrayList<>();

	public Picture(int position, ArrayList<String> tags,int ID) {
		super();
		this.position = position;
		this.tags = tags;
		this.ID = ID;
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
	
	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
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
	
	
	 public static Comparator<Picture> tagComparator = new Comparator<Picture>() {

			public int compare(Picture p1, Picture p2) {
			  return p1.getTags().size()>p2.getTags().size()?1:0;
		    }
	 };
	 
	 
	 public static ArrayList<Picture> mergePictures(ArrayList<Picture> list){
		 if(list.isEmpty()) {
			 return null;
		 }
		 
		 long first = 0;
		 long last = list.size()%2==0?list.size()/2:(list.size()-1)/2;
		 ArrayList<Picture> newList = new ArrayList<>();
		
		 
		 for(long i = first;i<last;i++) {
			 Picture newPic = Picture.merge(list.get(i), list.get(list.size()-i));
		 }
		 
		 
		 return null;
	 }
	
}
