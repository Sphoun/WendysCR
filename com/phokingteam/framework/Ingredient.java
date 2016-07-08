/*
 * Created By Jordan Kale 
 */

package com.phokingteam.framework;

//holds an ingredient that can be
//on an entree or side
public class Ingredient extends Item
{
	public static enum Type
	{
		TOPPING,
		SAUCE;
	}
	
	public static enum Modifier
	{
		DEFAULT,
		NO,
		LIGHT,
		EXTRA,
	}
	
	private Type 	 type;
	private Modifier modifier;
	
	public Ingredient()
	{
		name 	 = null;
		price 	 = 0.00f;
		type 	 = null;
		modifier = Modifier.DEFAULT;
	}
	public Ingredient(String name, float price, Type type)
	{
		this.name 	= name;
		this.price	= price;
		this.type 	= type;
		modifier 	= Modifier.DEFAULT;
	}
	
	public void setModifier(Modifier m)
	{
		modifier = m;
	}
	public Modifier getModifier()
	{
		return modifier;
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
	
	void setType(Type type)
	{
		this.type = type;
	}
	Type getType()
	{
		return type;
	}

}
