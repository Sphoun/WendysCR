/*
 * Created By Jordan Kale 
 */

package com.phokingteam.framework;

import java.util.ArrayList;

//holds a list of items
public class Items
{
	private ArrayList<Item> items;
	
	public Items()
	{
		items = new ArrayList<Item>();
	}
	
	//adds an item to the list
	public boolean add(Item item)
	{
		return items.add(item);
	}
	//removes an item iff it exists
	public boolean remove(Item i)
	{
		return items.remove(i);
	}
	
	public ArrayList<Item> getItemList()
	{
		return items;
	}
}
