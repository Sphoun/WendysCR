/*
 * Created By Scott Phounpadith
 */

package com.phokingteam.framework;

import java.util.StringTokenizer;

public abstract class MyDate
{
	protected int	day;
	protected int	month;
	protected int	year;

	public MyDate(String inputString)
	{
		StringTokenizer tokenizeDate = new StringTokenizer(inputString, "/");
		
		
		this.day	= Integer.parseInt(tokenizeDate.nextToken());
		this.month 	= Integer.parseInt(tokenizeDate.nextToken());
		this.year 	= Integer.parseInt(tokenizeDate.nextToken());
	}

	/*
	 * Method toString return a string describing the date in the following
	 * format: a) the month name, a space, followed by b) the date, a space, a
	 * quote, followed by c) the last two digits of the year
	 */

	public abstract String toStringEnglish();

	public abstract String toStringFrench();
}