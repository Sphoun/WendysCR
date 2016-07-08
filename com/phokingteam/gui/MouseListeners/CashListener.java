/**
 * Created by Dyon Ng on 2014-11-16.
 **/

package com.phokingteam.gui.MouseListeners;

import com.phokingteam.gui.CustomButton;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CashListener implements MouseListener
{
    CustomButton customButton;
    int amount;

    public CashListener(CustomButton cb, int amount)
    {
        this.customButton = cb;
        this.amount = amount;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        System.out.println("This button will add " + amount + " to the amount the customer is paying.");
    }

    @Override
    public void mousePressed(MouseEvent e)
    {

    }

    @Override
    public void mouseReleased(MouseEvent e)
    {

    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        customButton.setHover(true);
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        customButton.setHover(false);
    }
}
