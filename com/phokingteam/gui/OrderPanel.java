/**
 * Created by Lucas Kaiser on 2014-11-01.
 **/

package com.phokingteam.gui;

import com.phokingteam.framework.Bill;
import com.phokingteam.framework.Item;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

public class OrderPanel extends JPanel
{
    private BufferedImage background;
    private Dimension     size;
    private JList         order;
    private JScrollPane   scrollPane;

    private final String dark = "./assets/background/Order_bg.png";
    private final String lite = "./assets/background/Order_bg_lite.png";

    public OrderPanel()
    {
        super();

        this.order = new JList();
        this.scrollPane =  new JScrollPane();

        if (MainPanel.useLite)  loadImage(lite);
        else                    loadImage(dark);

        setLayout(null);
        setBounds(0, 0, size.width, size.height);

        add(scrollPane);

        initList();
        initScrollPane();
        updateOrder();
    }

    private void loadImage(String url)
    {
        try
        {
            background = ImageIO.read(new File(url));
            size = new Dimension(background.getWidth(), background.getHeight());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    private void initList()
    {
        if (MainPanel.useLite)
        {
            order.setBackground(Color.WHITE);
            order.setForeground(Color.BLACK);
        }
        else
        {
            order.setBackground(new Color(35, 35, 35));
            order.setForeground(Color.WHITE);
        }

        order.setFixedCellHeight(30);
        order.setFixedCellWidth(333);
        order.setFont(new Font("Consolas", Font.BOLD, 12));
    }

    private void initScrollPane()
    {
        scrollPane.setBounds(1, 31, size.width-2, 300);
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        scrollPane.setWheelScrollingEnabled(true);
        scrollPane.setViewportView(order);
    }

    public void resetBill()
    {
        order.removeAll();
        updateOrder();
    }

    public String[] getOrder()
    {
        String items[] = new String[MainPanel.currentBill.getCurrentOrder().getItemList().size()];
        int count = 0;

        for (Item i : MainPanel.currentBill.getCurrentOrder().getItemList())
        {
            double length = (335 - (i.getName().length() * 7)) / 7 - String.format("%.2f", i.getPrice()).length() - 2;

            items[count] = " " + i.getName();
            for (int j = 0; j < length; ++j) items[count] += " ";
            items[count] += String.format("%.2f", i.getPrice());

            count++;
        }

        return items;
    }

    public void updateOrder()
    {
        order.setListData(getOrder());

        order.setSelectedIndex(order.getModel().getSize() - 1);
        order.ensureIndexIsVisible(order.getModel().getSize() - 1);

        order.revalidate();
        order.repaint();
    }

    public void moveSelectionIndex(boolean goUp)
    {
        if (order == null) return;

        if (goUp && order.getSelectedIndex() != 0 && order.getModel().getSize() != 0)
        {
            order.setSelectedIndex(order.getSelectedIndex() - 1);
        }

        if (!goUp && (order.getSelectedIndex() != order.getModel().getSize()-1))
        {
            order.setSelectedIndex(order.getSelectedIndex() + 1);
        }

        order.ensureIndexIsVisible(order.getSelectedIndex());
    }

    public void repeatSelectedItem()
    {
        if (order == null) return;
        if (order.getModel().getSize() != 0) MainPanel.currentBill.add(MainPanel.currentBill.getItemList().get(order.getSelectedIndex()));
        updateOrder();
    }

    @Override
    public int getWidth()
    {
        return size.width;
    }

    @Override
    public int getHeight()
    {
        return size.height;
    }

    // Paints the image
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        int totalLine;

        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(new Font("Consolas", Font.BOLD, 12));
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        if (MainPanel.useLite)  g2d.setColor(Color.BLACK);
        else                    g2d.setColor(Color.WHITE);

        //Draws Order # and separator
        g2d.drawString("Order #" + MainPanel.currentBill.orderNumber, 8, 20);
        g2d.drawString(MainPanel.currentBill.getOrderType() == Bill.Type.TAKE_OUT ? "TAKE OUT":"DINE IN" , size.width - (MainPanel.currentBill.getOrderType() == Bill.Type.TAKE_OUT ? "TAKE OUT".length()*7: "DINE IN".length()*7) - 12, 20);
        g2d.drawLine(7, 25, size.width - 7, 25);

        //Draws separator, sub-total, tax, and discount
        g2d.drawLine(7, 340, size.width-7, 340);
        g2d.drawString("Sub-Total:", 8, size.height - 70);
        g2d.drawString(String.format("%.2f", MainPanel.currentBill.getSubTotal()), (size.width - (String.format("%.2f", MainPanel.currentBill.getSubTotal()).length()*7) - 12), size.height - 70);
        g2d.drawString("HST Tax:", 8, size.height - 50);
        g2d.drawString(String.format("%.2f", MainPanel.currentBill.getTax()), (size.width - (String.format("%.2f", MainPanel.currentBill.getTax()).length()*7) - 12), size.height - 50);

        if (MainPanel.currentBill.getDiscount() != 0)
        {
            g2d.drawString("Discount:", 8, size.height - 30);
            g2d.drawString(String.format("%.0f", MainPanel.currentBill.getDiscount() * 100) + "%", (size.width - (String.format("%.0f",MainPanel.currentBill.getDiscount() * 100).length()*7) - 19), size.height - 30);

            totalLine = 405;
        }
        else totalLine = 385;

        //Draws separator and total
        g2d.drawLine(7, totalLine, size.width-7, totalLine);
        g2d.drawString("Total:", 8, MainPanel.currentBill.getDiscount() != 0 ? size.height - 10: size.height - 30);
        g2d.drawString(String.format("%.2f", MainPanel.currentBill.getTotal()), (size.width - (String.format("%.2f", MainPanel.currentBill.getTotal()).length()*7) - 12), MainPanel.currentBill.getDiscount() != 0 ? size.height - 10: size.height - 30);

    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(getWidth(), getHeight());
    }

    @Override
    public Dimension getMinimumSize()
    {
        return getPreferredSize();
    }

    @Override
    public Dimension getMaximumSize()
    {
        return getPreferredSize();
    }
}