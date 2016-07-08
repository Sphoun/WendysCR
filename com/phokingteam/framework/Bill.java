/*
 * Created By Jordan Kale 
 */

package com.phokingteam.framework;

import java.util.ArrayList;

/*
 * This Class is used to hold the current 
 * bill
 */
public class Bill
{
		public static enum Type
		{
			DINE_IN,
			TAKE_OUT
		}
		
		//current tax on all items in canada
		private final float TAX = 0.13f;

		//total of the combined items without tax
		private float subTotal;
		
		//used to identify what order we are on
		//adds one everytime a new Bill object
		//is created
		public static int orderNumber = 0;


		//Either Dine In or Take Out
		private Type 	orderType;
		
		//holds the current order.
		private Items currentOrder;
		
		//holds todays date
		private CurrentDateTime date;

        private float discount;

        public int curOrderNumber;
		
		public Bill()
		{
			subTotal 		= 0.00f;
            discount        = 0.00f;
			currentOrder 	= new Items();

			orderType = Type.TAKE_OUT;
			++orderNumber;

            curOrderNumber = orderNumber;

            date = new CurrentDateTime();
		}

        public int getCurOrderNumber()
        {
            return curOrderNumber;
        }

		public int getOrderNumber()
		{
			return orderNumber;
		}


        public void setDiscount(float discount)
        {
            if      (discount < 0) discount = 0;
            else if (discount > 1) discount = 1;

            this.discount = discount;
        }
        public float getDiscount()
        {
            return discount;
        }

		public void setOrderType(Bill.Type type)
		{
			orderType = type;
		}

        public Bill.Type getOrderType()
		{
			return orderType;
		}
		
		//////////////////////////////////////////////////////////////////////////////////////////////
		//                              Order Totals
		/////////////////////////////////////////////////////////////////////////////////////////////
		public float getSubTotal()
		{
			subTotal = 0.00f;
			for (Item i : currentOrder.getItemList())
			{
				subTotal += i.getPrice();
			}
			return subTotal;
		}	
		
		//return the added cost of tax on the current order
		public float getTax()
		{
			return getSubTotal() *  TAX;
		}
		
		//returns the total including tax
		public float getTotal()
		{
            float total = getSubTotal() + getTax();
			return total - (total * discount);
		}
		//////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		//returns the current order
		public Items getCurrentOrder()
		{
			return currentOrder;
		}

    public boolean add(Item i)
        {
            return currentOrder.getItemList().add(i);
        }

    public ArrayList<Item> getItemList()
    {
        return currentOrder.getItemList();
    }

    public void printBill()
    {
        System.out.println("\n===============================");
        System.out.println("     =     WENDYS      =");
        System.out.println("===============================\n");


        System.out.println("Date:\t" 		+  date.toString());
        System.out.println("\nOrder #: "    +  orderNumber);
        System.out.println("............................ ");

        //loops through every item in the order
        for (Item i : currentOrder.getItemList())
        {
            System.out.println(i.getName());

            //loops through the ingredients of every item in
            //the current order and writes the modified ones
            for (Ingredient ingredient : i.getIngredients().getIngredientList())
            {
                if (ingredient.getModifier() != Ingredient.Modifier.DEFAULT)
                {
                    switch (ingredient.getModifier())
                    {
                        case EXTRA:
                        {
                            System.out.println("  Extra " + ingredient.getName());
                            break;
                        }
                        case LIGHT:
                        {
                            System.out.println("  Light " + ingredient.getName());
                            break;
                        }
                        case NO:
                        {
                            System.out.println("  No " + ingredient.getName());
                            break;
                        }
                        default:
                            break;
                    }//end switch
                }//end if
            }//end for
        }

        System.out.println("\nSub-Total:\t$" 	    + String.format("%.2f", getSubTotal()));
        System.out.println("Tax:\t\t$"       		+ String.format("%.2f", getTax()));

        if (discount != 0)
        {
            System.out.println("Discount:\t" + (int) (discount * 100) + "%");
        }

        System.out.println("Total:\t\t$" 			+ String.format("%.2f", getTotal()));
    }
}