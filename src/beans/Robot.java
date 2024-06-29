/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author PaccaudS
 */
public class Robot {

    private int lenght;
    private int width;
    private char facing;
    private String topLeft; // Coordonnée x,
    private String bottomRight; // Coordonnée y,

    public Robot() {
        this.lenght = lenght;
        this.width = width;
        this.facing = facing;
        this.topLeft = "0,0"; 
        this.bottomRight = "0,0";

    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public char getFacing() {
        return facing;
    }

    public void setFacing(char facing) {
        this.facing = facing;
    }

    public String gettopLeft() {
        return topLeft;
    }

    public void settopLeft(String topLeft) {
        this.topLeft = topLeft;
    }

    public String getbottomRight() {
        return bottomRight;
    }

    public void setbottomRight(String bottomRight) {
        this.bottomRight = bottomRight;
    }

  
    
    @Override
    public String toString() {
        return "Robot{" + "lenght=" + lenght + ", width=" + width + ", facing=" + facing + '}';
    }

}
