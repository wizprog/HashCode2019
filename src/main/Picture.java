package main;

import java.util.*;

public class Picture {
	
	private int  position;
	private long ID1;
	private long ID2;

	private ArrayList<String> tags = new ArrayList<>();

	public Picture(int position, ArrayList<String> tags,int ID1,int ID2) {
		super();
		this.position = position;
		this.tags = tags;
		this.ID1 = ID1;
		this.ID2= ID2;
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
	
	public String finalOutput() {
		StringBuilder sb = new StringBuilder(String.valueOf(ID1));
		if(ID2!=-1) sb.append(" "+String.valueOf(ID2));
		sb.append("\n");
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
	
	public long getID1() {
		return ID1;
	}

	public void setID1(long iD1) {
		ID1 = iD1;
	}
	
	
	public long getID2() {
		return ID2;
	}

	public void setID2(long iD2) {
		ID2 = iD2;
	}

	public static Picture merge(Picture p1 , Picture p2) {
		Picture p = new Picture();
		
		 Set<String> set = new LinkedHashSet<>(p1.getTags());
	        set.addAll(p2.getTags());
	        ArrayList<String> combinedList = new ArrayList<>(set);
	        
		p.setPosition(1);
		p.setTags(combinedList);
		
		p.setID1(p1.getID1());
		p.setID2(p2.getID1());
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
		 int last = list.size()%2==0?list.size()/2:(list.size()-1)/2;
		 ArrayList<Picture> newList = new ArrayList<>();
		
		 
		 for(int i = 0;i<last;i++) {
			 Picture newPic = Picture.merge(list.get(i), list.get(list.size()-1-i));
			 newList.add(newPic);
		 }
		 
		 
		 if(list.size()%2!=0) {
			 list.get(last).setPosition(1);
			 newList.add(list.get(last));
		 }
		 
		 return newList;
	 }
	
}
