package com.Epsondoms.javaLibrary;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This Class Provided Reusuable Method To Perform Java-Related Actions
 * By Calling Inbuilt Methods
 * 
 * 
 @author rehana23*/
public class JavaUtility {
	public  static void pause(long time) {
		try {
			Thread.sleep(time);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	public int generateRandomNum(int limit)
	{
		Random random=new  Random();
		return random.nextInt(limit);
	}
	public String getCurrentTime()
	{
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		return sdf.format(date);
	}

}
