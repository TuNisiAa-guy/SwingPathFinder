package me.tunisiaa;

import javax.swing.*;

public class Cell extends JPanel {
    enum type{
        START,
        FINISH,
        EMPTY,
        WALL,
        PATH,
        OPEN,
        CLOSED
    }
    private final Color startColor = new Color();
    private final int HEIGHT = 25;
    private final int WIDTH = 25;

    private JPanel[][] chart;
    public GUI(){

    }
}
