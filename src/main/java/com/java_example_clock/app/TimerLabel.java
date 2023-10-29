package com.java_example_clock.app;

import java.awt.Font;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class TimerLabel extends JLabel implements ActionListener {
    private int textSize = 21;

    private static Font fontForSize(int size) {
        return new Font("Serif", Font.PLAIN, size);
    }

    public TimerLabel() {
        super();

        setTime(new Date());
        setFont(fontForSize(textSize));

        Timer timer = new Timer(1000, this);

        timer.setInitialDelay(1);
        timer.start();
    }

    public void incrementFontSize() {
        textSize = Math.min(textSize + 4, 201);
        setFont(fontForSize(textSize));
    }

    public void decrementFontSize() {
        textSize = Math.max(textSize - 4, 5);
        setFont(fontForSize(textSize));
    }

    public void setTime(Date date) {
        setText(date.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setTime(new Date());
    }
}
