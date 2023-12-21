package me.tunisiaa;

import javax.swing.*;
import java.awt.*;

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
    public Cell(Cell.type type){
        switch (type){
            case START -> this.setBackground(new Color(0x006900));
            case FINISH -> this.setBackground(new Color(0xFF0000));
            case EMPTY -> this.setBackground(new Color(0xFFFFFF));
            case WALL -> this.setBackground(new Color(0x696969));
            case PATH -> this.setBackground(new Color(0xFF69FF));
            case OPEN -> this.setBackground(new Color(0x69FF69));
            case CLOSED -> this.setBackground(new Color(0x69696FF));
        }
    }
    private final int HEIGHT = 25;
    private final int WIDTH = 25;
}
