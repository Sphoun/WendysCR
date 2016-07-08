/*
 * Created By Jordan Kale 
 */

package com.phokingteam.framework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


//used to read and write to
//the file that holds all of the
//possible ingredients

//ingredients.txt is of the form
//name,price,type\n
public class IngredientFile
{

	private File file;
	
	public IngredientFile()
	{
		file = new File("config/ingredients.txt");
		read();
	}
	
	private void read()
	{
		try (Scanner scanner = new Scanner(file))
		{
			while (scanner.hasNextLine())
			{
				String temp = scanner.nextLine();
				
				if (temp.length() < 3)  continue;
				
				Menu.ingredients.add(makeIngredient(temp));
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	//takes a string of the form
	//name,price,type
	private Ingredient makeIngredient(String line)
	{
		String delim    = "[,]";
		String tokens[] = line.split(delim);
		
		Ingredient ingredient = new Ingredient();
		ingredient.setName(tokens[0]);
		ingredient.setPrice(Float.parseFloat(tokens[1]));
		
		switch(tokens[2])
		{
			case "TOPPING":
			{
				ingredient.setType(Ingredient.Type.TOPPING);
				return ingredient;
			}
			case "SAUCE":
			{
				ingredient.setType(Ingredient.Type.SAUCE);
				return ingredient;
			}
		}
		
		return null;
	}

	//removes an ingredient from the menu forever
	//returns true if the addition was successful
	public boolean delete(Item item) throws IOException
	{
		File temp = new File("config/ingredientTempFile");
		
		BufferedReader reader = new BufferedReader(new FileReader(file));
		BufferedWriter writer = new BufferedWriter(new FileWriter(temp));
		
		String currentLine, tempCurrentLine;
		
		while ((currentLine = reader.readLine()) != null && currentLine.length() > 3)
		{
			tempCurrentLine = currentLine.substring(0, currentLine.indexOf(","));
			
			if (tempCurrentLine.equals(item.getName()))
			{
				continue;
			}
			writer.write(currentLine + System.getProperty("line.separator"));
		}
		
		writer.close();
		reader.close();
		
		//THIS IS A REALLY BAD WAY TO DO THIS BUT
		//IM TOO DUMB TO MAKE IT RIGHT
		//note: can get smart and fix but currently too lazy
		file.delete();
		return temp.renameTo(file);
	}
	
	//adds an ingredient to the menu;
	//returns true on success
	public boolean Add(Ingredient ingredient)
	{
		try
		{
			FileWriter out = new FileWriter(file, true);
			
			String toAdd = System.getProperty("line.separator");
			
			toAdd += ingredient.getName()  + ",";
			toAdd += ingredient.getPrice() + ",";
			toAdd += ingredient.getType() == Ingredient.Type.SAUCE ? "SAUCE" : "TOPPING";
			
			
			out.write(toAdd);
			
			out.close();
			return true;
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


}

