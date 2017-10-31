package au.edu.qut.simpleCalendar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class SimpleCalendar 
{
	public static void main(String[] args) 
	{
		System.out.println("请输入日期（按照格式：2017-3-18）");
		Scanner scanner = new Scanner(System.in);
		String temp=scanner.nextLine();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = format.parse(temp);
			Calendar calendar = new  GregorianCalendar();
			calendar.setTime(date);
			
			int currentDay = calendar.get(Calendar.DATE);
			
			calendar.set(Calendar.DATE, 1);
			//System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
			int maxDate=calendar.getActualMaximum(Calendar.DATE);
			
			System.out.println("日\t一\t二\t三\t四\t五\t六");
			
			for(int i=1;i<calendar.get(Calendar.DAY_OF_WEEK);i++)
			{
				System.out.print('\t');
			}
			

			for(int i=1;i<=maxDate;i++)
			{
			
				
				if (i==currentDay)
				{
					System.out.print(i+"*\t");
				}
				else
				{
					System.out.print(i+"\t");
				}
				if(calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY)
				{
					System.out.print('\n');
				}
				calendar.add(Calendar.DATE, 1);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
