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

public class DiscountListener implements MouseListener
{
    private CustomButton cb;

    public DiscountListener(CustomButton cb)
    {
        this.cb = cb;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
       if (MainPanel.currentBill.getDiscount() == 0)         MainPanel.currentBill.setDiscount(cb.getBtnLabel().equals("Manager Discount") ? 1f: 0.5f);
       else if (MainPanel.currentBill.getDiscount() == 0.5f) MainPanel.currentBill.setDiscount(cb.getBtnLabel().equals("Manager Discount") ? 1f: 0f);
       else if (MainPanel.currentBill.getDiscount() == 1f)   MainPanel.currentBill.setDiscount(cb.getBtnLabel().equals("Employee Discount") ? 0.5f: 0f);
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