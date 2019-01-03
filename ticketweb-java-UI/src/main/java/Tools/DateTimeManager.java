package Tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTimeManager {
	public static String CurrentDate() {
		String outDate = null;
		Date now = new Date();

		String pattern = "EEE MMM d, Y";
		SimpleDateFormat format = new SimpleDateFormat(pattern, Locale.ENGLISH);

		outDate = format.format(now);
		System.out.println("CurrentDate "+outDate);

		return outDate;

	}
	public static String AddDateByDates(int Dates) {
		String outDate = null;
		Date now = new Date();
		Date tomorrow = new Date(now.getTime() - (1000 * 60 * 60 * 24 * Dates));

		String pattern = "EEE MMM d, Y";
		SimpleDateFormat format = new SimpleDateFormat(pattern, Locale.ENGLISH);

		outDate = format.format(tomorrow);
//		System.out.println("AddDateByDates "+outDate);

		return outDate;

	}
	public static String MinusDateByDates(int Dates) {
		String outDate = null;
		Date now = new Date();
		Date before = new Date(now.getTime() + (1000 * 60 * 60 * 24 * Dates));

		String pattern = "EEE MMM d, Y";
		SimpleDateFormat format = new SimpleDateFormat(pattern, Locale.ENGLISH);

		outDate = format.format(before);
//		System.out.println("MinusDateByDates "+outDate);

		return outDate;

	}
	public static String CurrentTime() {
		String outTime = null;
		Date now = new Date();

		String pattern = "h:m aa";
		SimpleDateFormat format = new SimpleDateFormat(pattern, Locale.ENGLISH);

		outTime = format.format(now);
//		System.out.println(outTime);

		return outTime;

	}
	public static String AddTimeByTimes(int Times) {
		String outDate = null;
		Date now = new Date();
		Date tomorrow = new Date(now.getTime() + (1000 * 60 * 60 * 24 * Times));

		String pattern = "h:m aa";
		SimpleDateFormat format = new SimpleDateFormat(pattern, Locale.ENGLISH);

		outDate = format.format(tomorrow);
//		System.out.println(outDate);

		return outDate;

	}
	
	public static void WaitSecond(int Seconds) {
		int time = Seconds * 1000;
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
//		CurrentDate();
//		AddDateByDates(30);
//		CurrentTime();
//		MinusDateByDates(30);
		CurrentTime();
		WaitSecond(5);
		CurrentTime();
	}

}
