/*
 * Created By Scott Phounpadith
 */

package com.phokingteam.framework;

//does the same thing as EnglishDate
//except it returns the month in french
public class FrenchDate extends MyDate
{
	public FrenchDate(String inputString)
	{
		super(inputString);
	}

	public String toStringFrench()
	{
		String monthNames[] = 
		{
				"Janvier", 
				"Fevrier", 
				"Mars",
				"Avril",
				"Mai",
				"Juin", 
				"Juillet",
				"Aout", 
				"Septembre", 
				"Octobre", 
				"Novembre",
				"Decembre" 
		};
		
		return (day + " " + monthNames[ month - 1 ] + ", " + year);

	}

	@Override
	public String toStringEnglish()
	{
		return null;
	}

}