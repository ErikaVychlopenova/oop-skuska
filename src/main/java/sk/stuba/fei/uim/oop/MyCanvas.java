package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class MyCanvas extends JPanel implements MouseListener, MouseMotionListener {

    private Tree newTree;
    private ArrayList<Tree> drawnObjects = new ArrayList<>();
    private int xPos;
    private int yPos;
    private Color colour;
    private String canvasMode = "draw";

    public MyCanvas(){
        xPos = 1;
        yPos = 1;
        colour = Color.blue;
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void paintComponent(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0,0, this.getWidth(),this.getHeight());
        for(Tree object : drawnObjects){
            object.paint(g);
        }
        if(newTree!=null){
            newTree.paint(g);
        }
    }
    public void setCanvasMode(String canvasMode){
        this.canvasMode = canvasMode;
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        if(canvasMode.equals("draw")) {
            xPos = e.getX();
            yPos = e.getY();
            newTree = new Tree(xPos, yPos, 0, 0, colour);
        }
//        if(canvasMode.equals("move")){
//            for(Tree tree: drawnObjects){
//                if(tree.contains(e.getX(),e.getY())){
//                    newTree = tree;
//                    xPos = e.getX();
//                    yPos = e.getY();
//                    tree.setX1(xPos + tree.getX1());
//                    tree.setX2(xPos + tree.getX2());
//                    tree.setY1(yPos + tree.getY1());
//                    tree.setY1(yPos + tree.getY1());
//                }
//            }
//        }
        repaint();

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        drawnObjects.add(newTree);
        repaint();
        newTree = null;

    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {
        int draggedX = e.getX();
        int draggedY = e.getY();
        if(canvasMode.equals("draw")) {
            if (newTree != null) {
                if (draggedX > xPos && draggedY > yPos) {
                    newTree.setX2(draggedX - xPos);
                    newTree.setY2(draggedY - yPos);
                }
                if (draggedX < xPos && draggedY > yPos) {
                    newTree.setX1(draggedX);
                    newTree.setX2(xPos - draggedX);
                    newTree.setY2(draggedY - yPos);
                }
                if (draggedX > xPos && draggedY < yPos) {
                    newTree.setY1(draggedY);
                    newTree.setX2(draggedX - xPos);
                    newTree.setY2(yPos - draggedY);
                }
                if (draggedX < xPos && draggedY < yPos) {
                    newTree.setX1(draggedX);
                    newTree.setY1(draggedY);
                    newTree.setX2(xPos - draggedX);
                    newTree.setY2(yPos - draggedY);
                }
            }
        }
        repaint();
    }

    public void mouseMoved(MouseEvent e) {}

    public void setColour(Color colour){
        this.colour = colour;
    }
}
