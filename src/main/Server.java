package main;

import java.io.File;
import java.util.*;
public class Server {
	
	private static int lastID = 0;
	
	public static void main(String[] args) {
		
		ArrayList<Picture> HPictures = new ArrayList<>();
		ArrayList<Picture> VPictures = new ArrayList<>();
		
		File file = null;
		Scanner scanner = null;

		long N;
		
		int tempNum;
		char tempPosition;
		ArrayList<String> tempTags;
	
		
		
		
		int x, y , x1, y1 , startTime, endTime;
		
		try {
			file = new File("a_example.txt");
			scanner = new Scanner(file);
			
			N = scanner.nextInt();
			
			for (long i=0; i<N; i++) {
				tempPosition = scanner.next().charAt(0);	
				tempNum = scanner.nextInt();
				tempTags = new ArrayList<>();
				
				for(int j =0;j<tempNum;j++) {
					tempTags.add(scanner.next());
				}
				
				if(tempPosition=='H') {
					HPictures.add(new Picture(1,tempTags,lastID++,0));
				}
				else {
					VPictures.add(new Picture(0,tempTags,lastID++,0));
				}
				
			}
			
			for (int i=0; i<HPictures.size(); i++) System.out.println(HPictures.get(i).toString());
			for (int i=0; i<VPictures.size(); i++) System.out.println(VPictures.get(i).toString());
			
			System.out.println("///////////////////////////////////////////////////////");

			Collections.sort(VPictures,Picture.tagComparator);
			
			VPictures = Picture.mergePictures(VPictures);
			
			HPictures.addAll(VPictures);
			
			for (int i=0; i<HPictures.size(); i++) System.out.println(HPictures.get(i).toString());
			
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// file.close();
			try {

				scanner.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
