/**
 * Created by Lucas Kaiser on 2014-11-01.
 **/

package com.phokingteam.gui;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BillPanel extends JPanel
{
    private BufferedImage background;
    private Dimension     size;

    private final String dark = "./assets/background/Order_bg.png";
    private final String lite = "./assets/background/Order_bg_lite.png";

    public BillPanel()
    {
        super();
        if (MainPanel.useLite)  loadImage(lite);
        else                    loadImage(dark);
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