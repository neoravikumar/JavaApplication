package com.intermediate.hashing;

import java.util.HashMap;

/*Change Date Format
Given a date string in the format Day Month Year, where:

Day is in the set {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", ..., "29th", "30th", "31th"}.
Month is in the set {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}.
Year is in the inclusive range [1900, 3000].

Convert the date string to the format YYYY-MM-DD, where:

YYYY denotes the 4 digit year.
MM denotes the 2 digit month.
DD denotes the 2 digit day.
For example:

1st Mar 1984 → 1984-03-01
2nd Feb 2013 → 2013-02-02 4th Apr 1900 → 1900-04-04



Input Format

The only argument given is a String, a date in the above-mentioned format.
Output Format

Return a String, i.e date in YYYY-MM-DD format.
Constraints

The values of Day, Month, and Year are restricted to the value ranges specified above.
The given dates are guaranteed to be valid, so no error handling is necessary.
Sample Test 1

Input:
    A = "16th Mar 2068"
Output:
    2068-03-16
Sample Test 2

Input:
    A = "6th Jun 1933"
Output:
    1933-06-06*/
public class ChangeDateFormat {

	public String solve(String A) {

		HashMap<String, String> days = new HashMap<>();
		HashMap<String, String> months = new HashMap<>();
		days.put("1st", "01");
		days.put("2nd", "02");
		days.put("3rd", "03");
		for (int i = 4; i <= 31; i++) {

			if (i < 10) {
				String d = "0" + i;
				days.put(i + "th", d);
			} else {
				days.put(i + "th", "" + i);
			}

		}
		months.put("Jan", "01");
		months.put("Feb", "02");
		months.put("Mar", "03");
		months.put("Apr", "04");
		months.put("May", "05");
		months.put("Jun", "06");
		months.put("Jul", "07");
		months.put("Aug", "08");
		months.put("Sep", "09");
		months.put("Oct", "10");
		months.put("Nov", "11");
		months.put("Dec", "12");

		String[] dString = A.split(" ");
		String day = dString[0];
		String month = dString[1];
		String year = dString[2];

		String resultString = "";
		
		resultString = year + "-" + months.get(month) + "-" + days.get(day);

		/*
		 * if (Integer.valueOf(year) >= 1900 && Integer.valueOf(year) <= 3000) {
		 * resultString = year + "-" + months.get(month) + "-" + days.get(day); }
		 */

		return resultString;
	}

	public static void main(String[] args) {
		ChangeDateFormat changeDateFormat = new ChangeDateFormat();

		String abc = "3rd Jul 3532";

		System.out.println(changeDateFormat.solve(abc));

	}

}
