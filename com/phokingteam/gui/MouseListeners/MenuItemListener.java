/**
 * Created by Dyon Ng on 2014-11-01.
 **/

package com.phokingteam.gui.MouseListeners;

import com.phokingteam.framework.Bill;
import com.phokingteam.framework.Item;
import com.phokingteam.gui.CustomButton;
import com.phokingteam.gui.MainPanel;
import com.phokingteam.gui.OrderPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuItemListener implements MouseListener
{
    private CustomButton cb;
    private Item item;

    public MenuItemListener(Item i, CustomButton cb)
    {
        this.cb = cb;
        this.item = i;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        MainPanel.currentBill.add(item);
        MainPanel.orderPane.updateOrder();
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
        cb.setHover(true);
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        cb.setHover(false);
    }
}