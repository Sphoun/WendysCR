/*
 * Created By Jordan Kale 
 */

package com.phokingteam.framework;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


//gets the current date based off
//your systems calendar
public class CurrentDateTime
{
		
		public String toString()
		{
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		   //get current date time with Calendar()
		   Calendar cal = Calendar.getInstance();
		   
		   return dateFormat.format(cal.getTime());
		}
		
		public String getDate()
		{
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Calendar cal = Calendar.getInstance();
			return dateFormat.format(cal.getTime());
		}

        public String getDate(String format)
        {
            DateFormat dateFormat = new SimpleDateFormat(format);
            Calendar cal = Calendar.getInstance();
            return dateFormat.format(cal.getTime());
        }
}
