/**
 * Created by Dyon Ng on 2014-10-31.
 **/

package com.phokingteam.gui;

import com.phokingteam.framework.CurrentDateTime;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class InfoPanel extends JPanel
{
    private BufferedImage image;
    private Dimension size;

    private final String dark = "./assets/background/Info_bg.png";
    private final String lite = "./assets/background/Info_bg_lite.png";

    private Color orderColor    = new Color(23, 157, 216);
    private Color dateColor     = new Color(78, 206, 151);
    private Color timeColor     = new Color(238, 58, 67);

    public InfoPanel()
    {
        super();

        if (MainPanel.useLite)  loadImage(lite);
        else                    loadImage(dark);
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

    private void loadImage(String url)
    {
        try
        {
            image = ImageIO.read(new File(url));
            size = new Dimension(image.getWidth(), image.getHeight());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    // Paints the image
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g2d.setColor(orderColor);
        g2d.drawString("Order Number #" + MainPanel.currentBill.orderNumber, 15, 19);

        g2d.setColor(dateColor);
        g2d.drawString(new CurrentDateTime().getDate(), 980, 19);

        g2d.setColor(timeColor);
        g2d.drawString(new CurrentDateTime().getDate("h:mm:ss a"), 1085, 19);
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