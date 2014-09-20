package org.shashwat;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TempMain {
	public static void main(String[] args) {
		while (true) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter the date :");
				OddDay obj = new OddDay(br.readLine(), "/");
				//OddDay obj = new OddDay(15, 8, 1947);
				//OddDay obj = new OddDay(4, 1, 2010);
				System.out.println(obj.getWeekDay() + " and odd days are " + obj.getOddDays());
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
}
