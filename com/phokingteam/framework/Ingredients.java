/*
 * Created By Jordan Kale 
 */

package com.phokingteam.framework;
import java.util.ArrayList;

//Holds a list of ingredients
public class Ingredients
{
	private ArrayList<Ingredient> ingredients;
	
	public Ingredients()
	{
		ingredients = new ArrayList<Ingredient>();
	}
	
	//adds an ingredient to the list
	public boolean add(Ingredient ingredient)
	{
		return ingredients.add(ingredient);	
	}
	
	//adds a ingredient based on its name
	//iff it exists
	public boolean add(String s)
	{
		for (Ingredient i : Menu.ingredients.getIngredientList())
		{
			if (s.equals(i.getName()))
			{
				ingredients.add(i);
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Ingredient> getIngredientList()
	{
		return ingredients;
	}
	
	//removes a ingredient iff it exists
	public boolean remove(Ingredient toRemove)
	{
		return ingredients.remove(toRemove);
	}
}

