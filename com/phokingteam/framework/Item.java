/*
 * Created By Jordan Kale 
 */

package com.phokingteam.framework;

import java.util.ArrayList;

//holds an item
public abstract class Item
{
	protected String 	  name;
	protected float  	  price;
	protected Ingredients ingredients;
	
	abstract void setPrice (float  f);
	abstract void setName  (String name);
	
	public String getName()
	{
		return name;
	}
	public float getPrice()
	{
		return price;
	}
	public Ingredients getIngredients()
	{
		return ingredients;
	}

    public ArrayList<Ingredient> getIngredientList()
    {
        return ingredients.getIngredientList();
    }
	
	
}

