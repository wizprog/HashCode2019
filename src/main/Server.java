package main;

import java.io.File;
import java.util.Scanner;

public class Server {
	
	public static void main(String[] args) {
		
		File file = null;
		Scanner scanner = null;
		
		int row;
		int column;
		int numOfVeh;
		int numOfRides;
		int bonus;
		int numOfSteps;
		
		int x, y , x1, y1 , startTime, endTime;
		
		try {
			file = new File("example.in");
			scanner = new Scanner(file);
			
			row = scanner.nextInt();
			column = scanner.nextInt();
			
			numOfVeh = scanner.nextInt();
			numOfRides = scanner.nextInt();
			bonus = scanner.nextInt();
			numOfSteps = scanner.nextInt();
			
//			Ride[] arrayOfRides = new Ride[numOfRides];
			
			
			for (int i=0; i<numOfRides; i++) {
				x = scanner.nextInt();
				y = scanner.nextInt();
				x1 = scanner.nextInt();
				y1 = scanner.nextInt();
				startTime = scanner.nextInt();
				endTime = scanner.nextInt();
				
//				arrayOfRides[i] = new Ride(x , y , x1, y1, startTime, endTime);
				
			}
			
			
			
			
//			for (int i=0; i<numOfRides; i++) System.out.println( arrayOfRides[i]);
		
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
