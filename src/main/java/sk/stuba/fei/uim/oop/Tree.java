package sk.stuba.fei.uim.oop;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class Tree extends Rectangle {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private Color colour;

    public Tree(int x1, int y1, int width, int height, Color colour){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = width;
        this.y2 = height;
        this.colour = colour;
    }


    public void paint(Graphics g){
        g.setColor(this.colour);
        g.fillRect(this.x1+this.x2/3,this.y1+this.y2/3,x2/3,2*y2/3);
        g.fillOval(this.x1,this.y1,this.x2,2*this.y2/3);
    }

//    public boolean contains(double x, double y){
//        if((this.x1 <= x) && (this.x1+width >= x)){
//            if((this.y1 <= y) && (this.y+height >= y)){
//                return true;
//            }
//        }
//        return false;
//    }
}
