/**
 * Created by Dyon Ng on 2014-11-01.
 **/

package com.phokingteam.gui.MouseListeners;

import com.phokingteam.gui.CustomButton;
import com.phokingteam.gui.InfoPanel;
import com.phokingteam.gui.MainPanel;
import com.phokingteam.gui.MenuPanel;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuListener implements MouseListener
{
    private CustomButton button;
    private String type;
    private MainPanel mainPanel;

    public MenuListener(CustomButton cb, String type, MainPanel mp)
    {
        this.button     = cb;
        this.type       = type;
        this.mainPanel  = mp;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        mainPanel.setCurrentPane(MainPanel.MENU_PANE);
        MainPanel.menuPane.setMenu(type);
        MainPanel.menuPane.repaint();
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
        button.setHover(true);
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        button.setHover(false);
    }
}