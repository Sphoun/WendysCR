/**
 * Created by Lucas Kaiser on 2014-10-30.
 **/

package com.phokingteam.gui;

import com.phokingteam.framework.Bill;
import com.phokingteam.framework.BillFile;
import com.phokingteam.gui.MouseListeners.DiscountListener;
import com.phokingteam.gui.MouseListeners.InOutListener;
import com.phokingteam.gui.MouseListeners.MenuListener;
import com.phokingteam.gui.MouseListeners.RepeatListener;
import com.phokingteam.gui.MouseListeners.UnimplementedListener;
import com.phokingteam.gui.MouseListeners.UpDownListener;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainPanel extends JPanel
{
    public static boolean useLite = true;

    public static final int MENU_PANE     = 0;
    public static final int PAY_PANE      = 1;
    public static final int DETAIL_PANE   = 2;

    public static int currentPane = 0;

    String menus    [] = {"Combos", "Kids Meals", "Burgers", "Chicken &<br>Fish", "Salads &<br>Chili", "Fries &<br>Potatoes", "Sides &<br>Misc", "Drinks"};
    String controls [] = {"Up", "Down", "Repeat", "Next Tray", "Multi-Order", "Up", "Down", "Prev-Order"};
    String inout    [] = {"Dine In", "Take Out"};
    String discounts[] = {"Manager<br>Discount", "Employee<br>Discount", "Coupons"};
    String tabs     [] = {"Order", "Pay", "Other"};

    CustomButton menuButtons    [] = new CustomButton[8];
    CustomButton controlButtons [] = new CustomButton[8];
    CustomButton inoutButtons   [] = new CustomButton[2];
    CustomButton discountButtons[] = new CustomButton[3];
    CustomButton tabButtons     [] = new CustomButton[3];

    Dimension menuSize     = new Dimension(120, 84);
    Dimension discountSize = new Dimension(101, 70);
    Dimension controlSize  = new Dimension(108, 72);
    Dimension inoutSize    = new Dimension(260, 112);
    Dimension tabSize      = new Dimension(248, 72);

    //Blue
    Color bIdle  = new Color(23, 157, 216);
    Color bHover = new Color(15, 121, 202);

    //Green
    Color gIdle  = new Color(78, 206, 151);
    Color gHover = new Color(50, 188, 113);

    //Red
    Color rIdle  = new Color(238, 58, 67);
    Color rHover = new Color(232, 37, 43);

    //Orange
    Color oIdle  = new Color(244, 123, 100);
    Color oHover = new Color(240, 78, 64);

    public static Bill currentBill = new Bill();

    public static MenuPanel     menuPane    = new MenuPanel();
    public static InfoPanel     infoPane    = new InfoPanel();
    public static OrderPanel    orderPane   = new OrderPanel();
    public static BillPanel     billPane    = new BillPanel();
    public static PayPanel      payPane     = new PayPanel();

    Timer timer;

    public MainPanel()
    {
        setLayout(null);
        if (useLite) setBackground(Color.WHITE);
        else         setBackground(new Color(35, 35, 35));


        //InfoPanel
        add(infoPane);
        infoPane.setBounds(3, 3, infoPane.getWidth(), infoPane.getHeight());
        timer = new Timer(100, new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                orderPane.repaint();
                infoPane.repaint();
                timer.restart();
            }
        });
        timer.start();

        //OrderPanel
        add(orderPane);
        orderPane.setBounds(113, 37, orderPane.getWidth(), orderPane.getHeight());

        //BillPanel
        add(billPane);
        billPane.setBounds(113, 900 - billPane.getHeight() - 3, billPane.getWidth(), billPane.getHeight());

        //MenuPanel
        add(menuPane);
        menuPane.setBounds(450, 111, menuPane.getWidth(), menuPane.getHeight());

        //PayPanel
        payPane.setBounds(450, 111, payPane.getWidth(), payPane.getHeight());

        //Control Buttons
        int count = 0;
        for (int i = 0; i < controls.length; ++i)
        {
            controlButtons[i] = new CustomButton(rIdle, rHover, controls[i], controlSize, 14);
            //Top Bill Controls
            if (i < 5) controlButtons[i].setBounds(3, 37 + (controlSize.height * i) + i, controlSize.width, controlSize.height);

            //Bottom Bill Controls
            else if (i >= 5 && i < 8)
            {
                controlButtons[i].setBounds(3, 468 + (controlSize.height * count) + count, controlSize.width, controlSize.height);
                count++;
            }

            //Serve Button
            else controlButtons[i].setBounds(3, 900 - controlSize.height - 3, controlSize.width, controlSize.height);

            add(controlButtons[i]);

            if      (i == 0)    controlButtons[i].addMouseListener(new UpDownListener(true, controlButtons[i]));
            else if (i == 1)    controlButtons[i].addMouseListener(new UpDownListener(false, controlButtons[i]));
            else if (i == 2)    controlButtons[i].addMouseListener(new RepeatListener(controlButtons[i]));
            else                controlButtons[i].addMouseListener(new UnimplementedListener(controlButtons[i]));
        }

        //Menu Buttons
        for (int i = 0; i < menus.length; ++i)
        {
            menuButtons[i] = new CustomButton(bIdle, bHover, menus[i], menuSize, 14);
            menuButtons[i].setBounds(1077, 111 + (menuSize.height * i) + i, menuSize.width, menuSize.height);
            add(menuButtons[i]);
            if      (i < 6)  menuButtons[i].addMouseListener(new MenuListener(menuButtons[i], "Entree", this));
            else if (i == 6) menuButtons[i].addMouseListener(new MenuListener(menuButtons[i], "Side", this));
            else             menuButtons[i].addMouseListener(new MenuListener(menuButtons[i], "Drink", this));
        }

        //Tab Buttons
        for (int i = 0; i < tabs.length; ++i)
        {
            tabButtons[i] = new CustomButton(gIdle, gHover, tabs[i], tabSize, 18);
            tabButtons[i].setBounds(450 + (tabSize.width * i) + i, 37, tabSize.width, tabSize.height);
            add(tabButtons[i]);
            if (i == 1) tabButtons[i].addMouseListener(new MouseListener()
            {
                @Override
                public void mouseClicked(MouseEvent e)
                {
                    setCurrentPane(PAY_PANE);
                    payPane.showButtons();
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
                    tabButtons[1].setHover(true);
                }

                @Override
                public void mouseExited(MouseEvent e)
                {
                    tabButtons[1].setHover(false);
                }
            });
            else tabButtons[i].addMouseListener(new UnimplementedListener(tabButtons[i]));
        }

        //Dine In/Take Out Buttons
        for (int i = 0; i < inout.length; ++i)
        {
            inoutButtons[i] = new CustomButton(gIdle, gHover, inout[i], inoutSize, 24);
            inoutButtons[i].setBounds(496 + (inoutSize.width * i) + i, 668, inoutSize.width, inoutSize.height);
            add(inoutButtons[i]);
            inoutButtons[i].addMouseListener(new InOutListener(inoutButtons[i]));
        }

        //Discount Buttons
        for (int i = 0; i < discounts.length; ++i)
        {
            discountButtons[i] = new CustomButton(oIdle, oHover, discounts[i], discountSize, 14);
            discountButtons[i].setBounds(603 + (discountSize.width * i) + i, 900 - discountSize.height - 19, discountSize.width, discountSize.height);
            add(discountButtons[i]);
            if (i == 2) discountButtons[i].addMouseListener(new UnimplementedListener(discountButtons[i]));
            else        discountButtons[i].addMouseListener(new DiscountListener(discountButtons[i]));
        }
    }

    public static void createNewBill()
    {
        new BillFile(currentBill);
        currentBill = new Bill();
        orderPane.resetBill();
        menuPane.clearMenu();
        payPane.hideButtons();
    }

    public void setCurrentPane(int PANE_NAME)
    {
        if (currentPane == PANE_NAME || PANE_NAME > 2 || PANE_NAME < 0) return;

        switch(currentPane)
        {
            case MENU_PANE:
                menuPane.clearMenu();
                remove(menuPane);
                break;

            case PAY_PANE:
                payPane.hideButtons();
                remove(payPane);
                break;

            case DETAIL_PANE:
                break;

            default:
                break;
        }

        switch(PANE_NAME)
        {
            case MENU_PANE:
                add(menuPane);
                break;

            case PAY_PANE:
                add(payPane);
                break;

            case DETAIL_PANE:
                break;

            default:
                break;
        }

        currentPane = PANE_NAME;
    }
}
