/*
 * Created By Jordan Kale 
 */

package com.phokingteam.framework;

//holds a side item
public class Side extends Item
{
	private Ingredients ingredients;
	
	public Side()
	{
		name		= null;
		price 		= 0.00f;
		ingredients = new Ingredients();
	}
	
	public Side(String name, float price, Ingredients ingredients)
	{
		this.name 			= name;
		this.price	 		= price;
		this.ingredients = ingredients;
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

	public Ingredients getIngredients()
	{
		return ingredients;
	}
}
