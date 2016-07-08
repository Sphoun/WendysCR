/*
 * Created By Jordan Kale 
 */

package com.phokingteam.framework;

//contains a drink like coke
public class Drink extends Item
{
	public Drink()
	{
		price 		= 0.00f;
		name 		= new String();
		ingredients = new Ingredients();
	}
	
	public Drink(String name, float price)
	{
		this.name 	= name;
		this.price 	= price;
		ingredients = new Ingredients();
	}
	
	@Override
	void setPrice(float price)
	{
		this.price = price;
	}

	@Override
	void setName(String name)
	{
		this.name = name;
	}
	
}
