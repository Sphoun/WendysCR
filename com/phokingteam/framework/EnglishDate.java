/*
 * Schott Phounpadith
 */

package com.phokingteam.framework;

//writes the date in the form
//MonthName day, year
public class EnglishDate extends MyDate
{
	public EnglishDate(String inputString)
	{
		super(inputString);
	}


	@Override
	public String toStringEnglish()
	{
		String monthNames[] =
		{
				"January", 
				"February", 
				"March", 
				"April", 
				"May",
				"June", 
				"July", 
				"August", 
				"September",
				"October", 
				"November",
				"December"
		};

		return (monthNames[ month - 1 ] + " " + day + ", " + year);
	}

	@Override
	public String toStringFrench()
	{
		return null;
	}

}