/*
 * Created By Jordan Kale 
 */

package com.phokingteam.framework;


import java.util.ArrayList;

//This class holds the entire menu
//Items holds everything like burgers, chicken, salads
//ingredients holds every possible condiment
public class Menu
{
	public static Ingredients ingredients = new Ingredients();
	public static Items		  items  	  = new Items();
	
	//Ingredients must be read first because
	//items use it to add ingredients
	public static IngredientFile ingredientFile = new IngredientFile();
	public static ItemFile       itemFile		= new ItemFile();

    public static ArrayList<Item> sortItemsByType(String type)
    {
        ArrayList<Item> itemList = new ArrayList<Item>();

        for (Item i : items.getItemList())
        {
            if (i.getClass().getName().equals("com.phokingteam.framework." + type))
            {
                itemList.add(i);
            }
        }
        return itemList;
    }
}
