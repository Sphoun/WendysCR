/**
 * Created by Lucas Kaiser on 2014-11-01.
 **/

package com.phokingteam.gui.MouseListeners;

import com.phokingteam.gui.CustomButton;
import com.phokingteam.gui.MainPanel;
import com.phokingteam.gui.OrderPanel;
import com.phokingteam.framework.Bill;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InOutListener implements MouseListener
{
    private CustomButton cb;

    public InOutListener(CustomButton cb)
    {
        this.cb   = cb;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        MainPanel.currentBill.setOrderType(cb.getBtnLabel().equals("Dine In") ? Bill.Type.DINE_IN : Bill.Type.TAKE_OUT);
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