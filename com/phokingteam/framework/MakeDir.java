/*
 * Created By Jordan Kale 
 */

package com.phokingteam.framework;
import java.io.File;

//Makes teh directory bill if it does not exist
//creates a directory named todays date
public class MakeDir
{

	private 	  EnglishDate  date;
	private final String       s = "bills/";
	
	public static String todaysDir  = "bills/" + (new EnglishDate(new CurrentDateTime().getDate()).toStringEnglish());
	
	public MakeDir(String curDate)
	{
		if (!pathExists("bills")) makePath("bills");
		
		date = new EnglishDate(curDate);
		
		if (pathExists(s + date.toStringEnglish()))
		{
			System.out.println("Path \"" + s + date.toStringEnglish() + "\" already exists");
		}
		else
		{
			makePath(s + date.toStringEnglish());
			System.out.println("Path \"" + s +date.toStringEnglish() + "\" created");
		}
	}
	
	//checks if a path is foreal
	public static boolean pathExists(String date)
	{
		File   f = new File(date);
		return f.exists();
	}
	
	//attempts to makea path foreal
	public static boolean makePath(String date)
	{
		File f = new File(date);
		return f.mkdir();
	}
}
