/*
 * Created By Jordan Kale 
 */

package com.phokingteam.framework;


//holds an entree item
public class Entree extends Item
{
	
	public Entree()
	{
		name 		= new String();
		price 		= 0.00f;
		ingredients = new Ingredients();
	}
	public Entree(String name, float price, Ingredients ingredients)
	{
		this.name		 = name;
		this.price 		 = price;
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
