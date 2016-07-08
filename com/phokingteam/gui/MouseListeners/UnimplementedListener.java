/**
 * Created by Dyon Ng on 2014-11-02.
 **/

package com.phokingteam.gui.MouseListeners;

import com.phokingteam.gui.CustomButton;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UnimplementedListener implements MouseListener
{
    private CustomButton customButton;

    public UnimplementedListener(CustomButton customButton)
    {
        this.customButton = customButton;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        System.out.println("You just activated my trap card!");
        System.out.println(customButton.getBtnLabel() + " is unimplemented!\nHAHAHAHAHAHAHAHAHA!\n");
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
        this.customButton.setHover(true);
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        this.customButton.setHover(false);
    }
}
