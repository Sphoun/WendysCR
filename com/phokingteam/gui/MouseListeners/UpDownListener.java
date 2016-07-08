/**
 * Created by Dyon Ng on 2014-11-02.
 **/

package com.phokingteam.gui.MouseListeners;

import com.phokingteam.gui.CustomButton;
import com.phokingteam.gui.MainPanel;
import com.phokingteam.gui.OrderPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UpDownListener implements MouseListener
{
    private boolean goUp;
    private CustomButton customButton;

    public UpDownListener(boolean goUp, CustomButton customButton)
    {
        this.goUp = goUp;
        this.customButton = customButton;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        MainPanel.orderPane.moveSelectionIndex(goUp);
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
