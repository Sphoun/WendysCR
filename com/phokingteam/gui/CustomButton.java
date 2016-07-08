/**
 * Created by Dyon Ng on 2014-10-30.
 **/

package com.phokingteam.gui;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class CustomButton extends JComponent
{
    private Dimension size;

    private Color       idleColour;
    private Color       hoverColour;
    private Color       textColour;
    private Font        textFont;
    private String      btnLabel;
    private boolean     hover;
    private JLabel      textLabel;

    // Constructor
    public CustomButton(Color idle, Color hover, String label, Dimension size, int fontSize)
    {
        super();

        this.size           = size;
        this.idleColour     = idle;
        this.hoverColour    = hover;
        this.btnLabel       = label;
        this.hover          = false;
        this.textColour     = Color.WHITE;
        this.textFont       = new Font("Arial", Font.BOLD, fontSize);
        this.textLabel      = new JLabel(btnLabel, SwingConstants.CENTER);

        add(textLabel);
        textLabel.setText("<html><div style='text-align: center;'>" + btnLabel + "</html>");
        textLabel.setBounds(10, 10, size.width - 20, size.height - 20);
    }

    // Draws the Button
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        // Draw Button
        if (!hover)
        {
            g.setColor(idleColour);
            setCursor (new Cursor(Cursor.DEFAULT_CURSOR));
        }
        else
        {
            g.setColor(hoverColour);
            setCursor (new Cursor(Cursor.HAND_CURSOR));
        }

        g.fillRect(0, 0, getWidth(), getHeight());

        // Draw Text
        textLabel.setFont(textFont);
        textLabel.setForeground(textColour);
        textLabel.repaint();
    }

    // Getters and Setters

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

    public Color getIdleColour()
    {
        return idleColour;
    }

    public void setIdleColour(Color idleColour)
    {
        this.idleColour = idleColour;
        repaint();
    }

    public Color getHoverColour()
    {
        return hoverColour;
    }

    public void setHoverColour(Color hoverColour)
    {
        this.hoverColour = hoverColour;
        repaint();
    }

    public Color getTextColour()
    {
        return textColour;
    }

    public void setTextColour(Color textColour)
    {
        this.textColour = textColour;
        repaint();
    }

    public Font getTextFont()
    {
        return textFont;
    }

    public void setTextFont(Font textFont)
    {
        this.textFont = textFont;
        repaint();
    }

    public String getBtnLabel()
    {
        return btnLabel;
    }

    public void setBtnLabel(String btnLabel)
    {
        this.btnLabel = btnLabel;
        textLabel.setText("<html><div style='text-align: center;'>" + btnLabel + "</html>");
        repaint();
    }

    public boolean isHover()
    {
        return hover;
    }

    public void setHover(boolean hover)
    {
        this.hover = hover;
        repaint();
    }

    @Override
    public Dimension getSize()
    {
        return size;
    }

    @Override
    public void setSize(Dimension size)
    {
        this.size = size;
        repaint();
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