package me.tunisiaa;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private final int HEIGHT = 25;
    private final int WIDTH = 25;

    private Cell[][] chart;
    public GUI(){
        super();
        GridLayout layout = new GridLayout();
        layout.setColumns(25);
        layout.setRows(25);
        layout.setHgap(1);
        layout.setVgap(1);
        this.setLayout(layout);
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                chart[j][i] = new Cell(Cell.type.EMPTY);
                this.add(chart[j][i]);
            }
        }
    }
}
