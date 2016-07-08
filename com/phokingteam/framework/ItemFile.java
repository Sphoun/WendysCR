/*
 * Created By Jordan Kale 
 */

package com.phokingteam.framework;

import java.io.*;
import java.util.Scanner;

//used to read and write to
//the file that holds all of the
//possible items

//items.txt is of the form
//name,price,type,ingredientName ... \n
public class ItemFile
{
	private File file;
	
	public ItemFile()
	{
		file = new File("config/items.txt");
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
				
				Menu.items.add(makeItem(temp));
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private Item makeItem(String item)
	{
		String delim    = "[,]";
		String tokens[] = item.split(delim);
		
		switch (tokens[2])
		{
			case "ENTREE":
			{
				Entree entree = new Entree();
				
				entree.setName  (tokens[0]);
				entree.setPrice (Float.parseFloat(tokens[1]));
				
				for (int i = 3; i < tokens.length; ++i)
				{
					if (!entree.getIngredients().add(tokens[i]))
					{
						System.out.println("Ingredient \"" + tokens[i] + "\" does not exist.");
					}
				}
				return entree;
			}
			case "SIDE":
			{
				Side side = new Side();
				
				side.setName  (tokens[0]);
				side.setPrice (Float.parseFloat(tokens[1]));
				
				for (int i = 3; i < tokens.length; ++i)
				{
					if (!side.getIngredients().add(tokens[i]))
					{
						System.out.println("Ingredient \"" + tokens[i] + "\" does not exist.");
					}
				}	
				return side;
			}
			case "DRINK":
			{
				Drink  drink = new Drink(tokens[0], Float.parseFloat(tokens[1]));
				return drink;
			}
		}
		return null;
	}
		//deletes an item permanantly from the item file
		public boolean delete(Item item) throws IOException 
		{
			File temp = new File("config/itemTempFile");
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
			BufferedWriter writer = new BufferedWriter(new FileWriter(temp));
			
			String currentLine;
			String tempCurrentLine;;
			
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
			
			file.delete();
			return temp.renameTo(file);
		}

		//adds an item to the items.txt
		public boolean Add(Item item)
		{
			try
			{
				FileWriter out = new FileWriter(file, true);
				
				String toAdd = System.getProperty("line.separator");
				
				toAdd += item.getName()  + ",";
				toAdd += item.getPrice() + ",";
				
				switch(item.getClass().getName())
				{
					case "Entree":
					{
						toAdd += "ENTREE,";
						for (Ingredient i : item.getIngredients().getIngredientList())
						{
							toAdd += i.getName() + ",";
						}
						break;
					}
					case "Side":
					{
						toAdd += "SIDE,";
						for (Ingredient i : item.getIngredients().getIngredientList())
						{
							toAdd += i.getName() + ",";
						}
						
						break;
					}
					case "Drink":
					{
						toAdd += "DRINK,";
						break;
					}
				}
				toAdd = toAdd.substring(0, toAdd.length() - 1);
				out.write(toAdd);
				
				out.close();
				return true;
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//out.write(arg0)
			return false;
		}
}
