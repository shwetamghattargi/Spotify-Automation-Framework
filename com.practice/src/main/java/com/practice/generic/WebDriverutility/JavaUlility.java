package com.practice.generic.WebDriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUlility {
	public int getRandomNumber()
	{
		Random random=new Random();
		int randomnumner=random.nextInt(5000);
		return randomnumner;
	}
	public String getSystemDatayyyyDDMM() {
		Date dateobj= new Date();
		SimpleDateFormat sim= new SimpleDateFormat("yyyy-MM-dd");

		String date=sim.format(dateobj);
		return date;}
	public String getRequriedDateYYYYDDMM(int days)
	{
		SimpleDateFormat sim= new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate=sim.format(cal.getTime());
		return reqDate;

	}

}
