package part2;

import java.util.Calendar;

public class Time {
	
	private int hours = 0, minutes = 0, seconds = 0, milliseconds = 0;
	private int year = 2015;
	private int month = 1, day = 1;
	
	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		if(hours >= 0 && hours < 23)
			this.hours = hours;
		else throw new IllegalArgumentException();
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		if(minutes >= 0 && minutes < 60)
			this.minutes = minutes;
		else throw new IllegalArgumentException();
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		if(seconds >= 0 && seconds < 60)
			this.seconds = seconds;
		else throw new IllegalArgumentException();
	}

	public int getMilliseconds() {
		return milliseconds;
	}

	public void setMilliseconds(int milliseconds) {
		if(milliseconds >= 0 && milliseconds < 1000)
			this.milliseconds = milliseconds;
		else throw new IllegalArgumentException();
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if(month >= 1 && month <= 12)
			this.month = month;
		else throw new IllegalArgumentException();
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		if((day >= 0) && (day <= daysInMonth[this.month-1] || (isLeapYear(this.year) && this.month == 1 && day == 29))) //handling Feb on leap years...
			this.day = day;
		else throw new IllegalArgumentException();
	}
	
	public boolean isLeapYear(int year){
		if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
			return true;
		return false;
	}
	
	public Time now(){
		Time time = new Time();
		Calendar calendar = Calendar.getInstance();
		time.year = calendar.get(Calendar.YEAR);
		time.month = calendar.get(Calendar.MONTH) + 1;
		time.day = calendar.get(Calendar.DAY_OF_MONTH);
		time.hours = calendar.get(Calendar.HOUR_OF_DAY);
		time.minutes = calendar.get(Calendar.MINUTE);
		time.seconds = calendar.get(Calendar.SECOND);
		time.milliseconds = calendar.get(Calendar.MILLISECOND);
		
		return time;
	}
	
	public String toString(){
		String result = this.hours + ":" + this.minutes + ":" + this.seconds + " " + this.day + "." + this.month + "." + this.year;
		return result;
	}

	public Time(){
	}
	
	public Time(Time t){
		this.year = t.year;
		this.month = t.month;
		this.day = t.day;
		this.hours = t.hours;
		this.minutes = t.minutes;
		this.seconds = t.seconds;
		this.milliseconds = t.milliseconds;
	}
}
