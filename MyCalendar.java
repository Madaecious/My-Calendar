///////////////////////////////////////////////////////////////////////////////////////////////////
//	Name:			Mark Barros																	 //
//	Course:			CS1400 - Intro to Programming and Problem Solving							 //
//	Description:	This program outputs a monthly calendar for a given month and year.			 //
///////////////////////////////////////////////////////////////////////////////////////////////////

// These are necessary imports. --------------------------------------------------------------------
import java.util.Calendar;
import java.util.Scanner;

// This is the MyCalendar class, which contains main(). -------------------------------------------
public class MyCalendar
{
	public static void main(String[] args)
	{
		int selected_month = 0,
		    selected_year = 0,
		    column_number = 7,
		    day_of_month = 1,
		    days_in_month = 0,
		    blank_days = 0;
		boolean finished = false;

		Scanner keyboard = new Scanner(System.in);
		Calendar calendar = Calendar.getInstance();

		System.out.print("Mark's My Calendar\n\n");
		System.out.print("Enter month year? ");

		selected_month = keyboard.nextInt() - 1;
		selected_year = keyboard.nextInt();

		calendar.set(selected_year, selected_month, 1);
		days_in_month = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		blank_days = calendar.get(Calendar.DAY_OF_WEEK) - 1;

		System.out.print("\n" + (selected_month + 1) + "/" + selected_year + "\n");
		System.out.println("Sun  Mon  Tue  Wed  Thu  Fri  Sat");
		System.out.println("---------------------------------");

		if(blank_days > 0)
		{
			while(blank_days > 0)
			{
				System.out.print("     ");
				column_number--;
				blank_days--;
			}
		}
		while(day_of_month <=  days_in_month)
		{
			while((column_number >= 1) && (finished == false))
			{
				System.out.printf("%3d  ", day_of_month);
				if(day_of_month == days_in_month) finished = true;
				day_of_month++;
				column_number--;
			}
			System.out.println();
			column_number = 7;
		}
	}
} // End of class. --------------------------------------------------------------------------------