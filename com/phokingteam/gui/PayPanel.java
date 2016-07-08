/**
 * Created by Dyon on 2014-11-10.
 **/

package com.phokingteam.gui;

import com.phokingteam.gui.MouseListeners.CashListener;
import com.phokingteam.gui.MouseListeners.UnimplementedListener;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PayPanel extends JPanel
{
    private BufferedImage background;
    private Dimension size;

    private final String dark = "./assets/background/Menu_bg.png";
    private final String lite = "./assets/background/Menu_bg_lite.png";

    private Color idleColour    = new Color(244, 224, 100, 200);   // 200 Alpha
    private Color hoverColour   = new Color(244, 224, 100);        // 255 Alpha

    private CustomButton[] topButtons   = { new CustomButton(idleColour, hoverColour, "Reset" , new Dimension(150, 70), 16),
                                            new CustomButton(idleColour, hoverColour, "Debit<br>Credit", new Dimension(150, 70), 16),
                                            new CustomButton(idleColour, hoverColour, "Custom Amount", new Dimension(305, 70), 16) };

    private CustomButton[] cashButtons  = { new CustomButton(idleColour, hoverColour, "$5" , new Dimension(150, 70), 16),
                                            new CustomButton(idleColour, hoverColour, "$10", new Dimension(150, 70), 16),
                                            new CustomButton(idleColour, hoverColour, "$20", new Dimension(150, 70), 16),
                                            new CustomButton(idleColour, hoverColour, "$50", new Dimension(150, 70), 16) };

    private int amounts[] = { 5, 10, 20, 50 };

    public PayPanel()
    {
        super();
        setLayout(null);

        if (MainPanel.useLite)  loadImage(lite);
        else                    loadImage(dark);

        for (int i = 0; i < 3; ++i)
        {
            topButtons[i].setTextColour(Color.BLACK);
            topButtons[i].setBounds(5 * (i + 1) + (i * topButtons[0].getWidth()), 5, topButtons[i].getWidth(), topButtons[i].getHeight());
        }

        topButtons[0].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("This button will reset the amount the customer is paying.");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                topButtons[0].setHover(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                topButtons[0].setHover(false);
            }
        });

        topButtons[1].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("This button will assume the customer is paying the exact total due with debit/credit.");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                topButtons[1].setHover(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                topButtons[1].setHover(false);
            }
        });

        topButtons[2].addMouseListener(new UnimplementedListener(topButtons[2]));

        for (int i = 0; i < 4; ++i)
        {
            cashButtons[i].setTextColour(Color.BLACK);
            cashButtons[i].setBounds(5 * ( i + 1) + (i * cashButtons[i].getWidth()), 80, cashButtons[i].getWidth(), cashButtons[i].getHeight());
            cashButtons[i].addMouseListener(new CashListener(cashButtons[i], amounts[i]));
        }
    }

    public void hideButtons()
    {
        for (int i = 0; i < 3; ++i) remove(topButtons[i]);
        for (int i = 0; i < 4; ++i) remove(cashButtons[i]);

        revalidate();
        repaint();
    }

    public void showButtons()
    {
        for (int i = 0; i < 3; ++i) add(topButtons[i] );
        for (int i = 0; i < 4; ++i) add(cashButtons[i]);

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
