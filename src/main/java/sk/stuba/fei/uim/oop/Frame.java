package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener {

    private JButton tree = new JButton("Draw tree");
    private JButton movement = new JButton("Move object");
    private JButton nextColour = new JButton("Colour");
    private JLabel activeColour = new JLabel("Current mode: Draw");
    private JPanel panel = new JPanel();
    private MyCanvas canvas = new MyCanvas();
    private String canvasMode = "draw";
    private Color actColor = Color.blue;

    public Frame(){
        panel.add(tree); panel.add(movement); panel.add(nextColour); panel.add(activeColour);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        this.add("Center", canvas);
        this.add("South",panel);
        tree.addActionListener(this); tree.setFocusable(false);
        movement.addActionListener(this); movement.setFocusable(false);
        nextColour.addActionListener(this); nextColour.setFocusable(false);
        activeColour.setOpaque(true);
        activeColour.setBackground(actColor);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==tree){
            System.out.println("kreslenie");
            canvas.setCanvasMode("draw");
            activeColour.setText("Current mode: Draw");
        }
        if(e.getSource()==movement){
            System.out.println("presun");
            canvas.setCanvasMode("move");
            activeColour.setText("Current mode: Move");
        }
        if(e.getSource()==nextColour){
            System.out.println("zmena farby");
            nextColor();
        }
    }

    private void nextColor(){
        if (Color.blue.equals(actColor)) {
            actColor = Color.red;
        }
        else if (Color.red.equals(actColor)) {
            actColor = Color.green;
        }
        else if (Color.green.equals(actColor)) {
            actColor = Color.blue;
        }
        System.out.println(actColor);
        activeColour.setBackground(actColor);
        canvas.setColour(actColor);
    }
}
