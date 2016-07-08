/**
 * Created by Dyon Ng on 2014-10-31.
 **/

package com.phokingteam.gui;

import com.phokingteam.framework.Item;
import com.phokingteam.framework.Menu;
import com.phokingteam.gui.MouseListeners.MenuItemListener;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MenuPanel extends JPanel
{
    private BufferedImage background;
    private Dimension     size;

    private final String dark = "./assets/background/Menu_bg.png";
    private final String lite = "./assets/background/Menu_bg_lite.png";

    private Color idleColour    = new Color(244, 224, 100, 200);   // 200 Alpha
    private Color hoverColour   = new Color(244, 224, 100);        // 255 Alpha

    private ArrayList<Item> itemList;
    private ArrayList<CustomButton> buttonList = new ArrayList<CustomButton>();
    private String menuType = null;

    public MenuPanel()
    {
        super();

        if (MainPanel.useLite)  loadImage(lite);
        else                    loadImage(dark);
    }

    public void clearMenu()
    {
        for (CustomButton i : buttonList) remove(i);
        buttonList.clear();
        menuType = null;
        revalidate();
        repaint();
    }

    public void setMenu(String type)
    {
        if (type == menuType) return;

        if (menuType != null)
        {
            for (CustomButton i : buttonList) remove(i);
            buttonList.clear();
        }

        menuType = type;

        itemList = Menu.sortItemsByType(type);
        for (int x = 0; x < itemList.size(); ++x)
        {
            buttonList.add(new CustomButton(idleColour, hoverColour, itemList.get(x).getName(), new Dimension(150, 70), 14));
            add(buttonList.get(x));
            buttonList.get(x).addMouseListener(new MenuItemListener(itemList.get(x), buttonList.get(x)));
            buttonList.get(x).setTextColour(Color.BLACK);
        }

        for (int col = 0, index = 0; col < Math.ceil(itemList.size() / 4); col++)
        {
            for (int row = 0; row < 4; ++row)
            {
                CustomButton cb = buttonList.get(index);
                cb.setBounds((5 * (row + 1)) + (row * cb.getWidth()), (5 * (col + 1)) + (col * cb.getHeight()), cb.getWidth(), cb.getHeight());
                ++index;
                if (index == buttonList.size()) break;
            }
        }

        revalidate();
        repaint();
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
