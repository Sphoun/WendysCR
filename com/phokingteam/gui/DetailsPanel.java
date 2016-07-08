/**
 * Created by Dyon Ng on 2014-10-31.
 **/

package com.phokingteam.gui;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DetailsPanel extends JPanel
{
    private BufferedImage image;
    private Dimension size;

    private String lite = "./assets/background/Menu_bg_lite.png";
    private String dark = "./assets/background/Menu_bg.png";

    public DetailsPanel()
    {
        super();

        if (MainPanel.useLite)  loadImage(lite);
        else                    loadImage(dark);
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

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.drawImage(image, 0, 0, null);
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
