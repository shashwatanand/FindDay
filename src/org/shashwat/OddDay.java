package org.shashwat;

@ClassPreamble(
	author = "Shashwat",
	date = "12/20/2009",
	currentRevision = 2,
	lastModified = "12/20/2009",
	lastModifiedBy = "Shashwat",
	reviewers = {"Shashwat"}
)
public class OddDay {
	private int mDay;
	private int mMonth;
	private int mYear;
	
	private String[] mArrOddDays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	private int[] mArrNoOfDaysInMonthInOrdYear = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private int[] mArrNoOfDaysInMonthInLeapYear = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public OddDay(int pDay, int pMonth, int pYear) {
		this.mDay = pDay;
		this.mMonth = pMonth;
		this.mYear = pYear;
	}
	
	public OddDay(String pDateString, String pDelimiter) {
		try {
			String[] lArrDayString = Helper.parseDateString(pDateString, pDelimiter);
			this.mDay = Integer.parseInt(lArrDayString[0]);
			this.mMonth = Integer.parseInt(lArrDayString[1]);
			this.mYear = Integer.parseInt(lArrDayString[2]);
		} catch (Exception ex) {
			System.out.println("Given enter string is not in proper format dd/mm/yyyy : " + ex.getMessage());
		}
	}
	
	private int findOddDay() {
		if (this == null) {
			return 0;
		}
		int lOneYearLess = this.mYear - 1;
		int lTotalOddDays = 0;
		
		int lNoOfYears = lOneYearLess % 100;
		int lCentury = lOneYearLess - lNoOfYears;
		int lNoOfHundredYears = 0;
		int lOddDaysForHundredYears = 0;
		while (lCentury % 400 != 0) {
			lCentury -= 100;
			lNoOfHundredYears += 100;
		}
		switch (lNoOfHundredYears) {
			case 100 :
				lOddDaysForHundredYears = 5;
				break;
			case 200 :
				lOddDaysForHundredYears = 3;
				break;
			case 300 :
				lOddDaysForHundredYears = 1;
				break;
			case 400 :
				lOddDaysForHundredYears = 0;
				break;
		}
		int lNoOfLeapYears = lNoOfYears / 4;
		int lNoOfDaysForOneLessYear = (lNoOfLeapYears * 2) + (lNoOfYears - lNoOfLeapYears);
		int lOddDaysForOneLessYear = lNoOfDaysForOneLessYear % 7;
		
		lTotalOddDays = (lOddDaysForHundredYears + lOddDaysForOneLessYear) % 7;
		int lNoOfDaysInYear = 0;
		if (this.mYear % 4 == 0){
			for (int index = 0; index < this.mMonth - 1; index ++) {
				lNoOfDaysInYear += mArrNoOfDaysInMonthInLeapYear[index];
			}
		} else {
			for (int index = 0; index < this.mMonth - 1; index ++) {
				lNoOfDaysInYear += mArrNoOfDaysInMonthInOrdYear[index];
			}
		}
		lNoOfDaysInYear += this.mDay;
		int lOddDaysInYear = lNoOfDaysInYear % 7;
		lTotalOddDays += lOddDaysInYear;
		
		return lTotalOddDays % 7;
	}
	
	public int getOddDays() {
		return this.findOddDay();
	}
	
	public String getWeekDay() {
		return mArrOddDays[this.findOddDay()];
	}
}
