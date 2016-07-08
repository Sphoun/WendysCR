/**
 * Created by Dyon Ng on 2014-10-30.
 **/

package com.phokingteam.gui;

import javax.swing.JFrame;
import java.awt.*;

public class PhoKingFrame extends JFrame
{
    private MainPanel panel = new MainPanel();

    public PhoKingFrame()
    {
        this("PhoKing Cash Register");
    }

    public PhoKingFrame(String frameTitle)
    {
        super(frameTitle);
        setSize(1206, 929);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocation((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2) - (getWidth()/2), (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2) - (getHeight()/2));
        getContentPane().setBackground(Color.WHITE);
        add(panel);
    }
}