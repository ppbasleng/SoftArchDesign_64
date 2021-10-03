package com.solid.lsp;


public class Main {

    private static final int width = 4;
    private static final int height = 5;
    private static final int side = 5;

    public static void main(String[] args) {
        Shape reg1 = new Rectangle(width, height);
        System.out.println("==== Rectangle ====");
        System.out.println("Width = " + width);
        System.out.println("Height = " + height);
        System.out.println("Area = " + reg1.getArea());
        System.out.println(((Rectangle) reg1).getWidth());

        System.out.println("====   Square  ====");
        Shape reg2 = new Square(side);
        System.out.println("Side = " + side);
        // reg2.setSide(width);
        // reg2.setSide(height);
        System.out.println("Area = " + reg2.getArea());
    }
}
