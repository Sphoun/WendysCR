/*
 * Created By Jordan Kale 
 */

package com.phokingteam.framework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


//Takes a bill and writes it into the
//bills directory
//"bills/date/ordernumber"


//file of he form:
//order number
//order
//subtotal
//tax
//total

public class BillFile
{

	private Bill	bill;
	private String	path;

	public BillFile(Bill bill)
	{
		this.bill = bill;
		new MakeDir(new CurrentDateTime().getDate());
		path = MakeDir.todaysDir + "/" + this.bill.getOrderNumber();

		try
		{
			writeFile();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private void writeFile() throws IOException
	{
		File bill = new File(path + ".txt");

		BufferedWriter writer = new BufferedWriter(new FileWriter(bill));

		writer.write(this.bill.getOrderNumber() + System.getProperty("line.separator"));

		for (Item i : this.bill.getCurrentOrder().getItemList())
		{
			writer.write(i.getName() + System.getProperty("line.separator"));
			
			for (Ingredient ingredient : i.getIngredients().getIngredientList())
			{
				if (ingredient.getModifier() != Ingredient.Modifier.DEFAULT)
				{
					switch (ingredient.getModifier())
					{
						case EXTRA:
						{
							writer.write("  Extra " + ingredient.getName() + System.getProperty("line.separator"));
							break;
						}
						case LIGHT:
						{
							writer.write("  Light " + ingredient.getName() + System.getProperty("line.separator"));
							break;
						}
						case NO:
						{
							writer.write("  No " + ingredient.getName() + System.getProperty("line.separator"));
							break;
						}
						default:
							break;
							
					}// end switch
				}// end if
			}// end inner for
		}// end outer for

		writer.write(this.bill.getSubTotal() + System.getProperty("line.separator"));
		writer.write(this.bill.getTax()      + System.getProperty("line.separator"));
		writer.write(this.bill.getTotal()    + System.getProperty("line.separator"));

		writer.close();
	}
	
	public Bill loadBill()
	{
		Bill bill = new Bill();
		return bill;
	}

}
