package com.java_example_clock.app;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Entry point for application.
 *
 */
public class App extends JFrame implements MouseWheelListener {
    private TimerLabel timeLabel = new TimerLabel();

    public App() {
        JPanel contentPanel = new JPanel();

        addMouseWheelListener(this);

        contentPanel.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        contentPanel.add(timeLabel, constraints);

        add(contentPanel);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new App();
    }

    public void mouseWheelMoved(MouseWheelEvent e) {
        int notches = e.getWheelRotation();

        if (notches > 0) {
            timeLabel.decrementFontSize();
        } else {
            timeLabel.incrementFontSize();
        }

        if (getExtendedState() != MAXIMIZED_BOTH) {
            pack();
        }
    }
}
