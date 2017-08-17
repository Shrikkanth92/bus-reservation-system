package com.polaris.teamd.bean;

public class CWeekDays {

	private CBusService busService ;
	private boolean monday, tuesday, wednesday, thursday, friday, saturday,
			sunday;
	private boolean[] weekdays=new boolean[7];
	{
		weekdays[0] = monday;
		weekdays[1] = tuesday;
		weekdays[2] = wednesday;
		weekdays[3] = thursday;
		weekdays[4] = friday;
		weekdays[5] = saturday;
		weekdays[6] = sunday;
	}

	public CWeekDays() {
		super();
	}

	public CWeekDays( boolean monday, boolean tuesday,
			boolean wednesday, boolean thursday, boolean friday,
			boolean saturday, boolean sunday) {
		super();
		
		this.monday = monday;
		this.tuesday = tuesday;
		this.wednesday = wednesday;
		this.thursday = thursday;
		this.friday = friday;
		this.saturday = saturday;
		this.sunday = sunday;
	}

	public CBusService getBusService() {
		return busService;
	}

	public void setBusService(CBusService busService) {
		this.busService = busService;
	}

	public boolean[] getWeekdays() {
		return weekdays;
	}

	public void setWeekdays(boolean[] weekdays) {
		this.weekdays = weekdays;
	}

	public boolean isMonday() {
		return monday;
	}

	public void setMonday(boolean monday) {
		this.monday = monday;
	}

	public boolean isTuesday() {
		return tuesday;
	}

	public void setTuesday(boolean tuesday) {
		this.tuesday = tuesday;
	}

	public boolean isWednesday() {
		return wednesday;
	}

	public void setWednesday(boolean wednesday) {
		this.wednesday = wednesday;
	}

	public boolean isThursday() {
		return thursday;
	}

	public void setThursday(boolean thursday) {
		this.thursday = thursday;
	}

	public boolean isFriday() {
		return friday;
	}

	public void setFriday(boolean friday) {
		this.friday = friday;
	}

	public boolean isSaturday() {
		return saturday;
	}

	public void setSaturday(boolean saturday) {
		this.saturday = saturday;
	}

	public boolean isSunday() {
		return sunday;
	}

	public void setSunday(boolean sunday) {
		this.sunday = sunday;
	}

	public boolean getWeekdays(int index) {
		return weekdays[index];
	}

	public void setWeekdays(int index, boolean weekday) {
		this.weekdays[index] = weekday;
	}

}
