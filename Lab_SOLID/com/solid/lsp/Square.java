package com.solid.lsp;

public class Square extends Shape {
    private int side;
    Square(){

    }

    Square(int side) {
        this.setSide(side);
    }

    public void setSide(int side) {
        this.side = side;
    }

    public int getSide(){
        return this.side;
    }
    public int getArea(){
        return this.side*this.side;
    }
}
