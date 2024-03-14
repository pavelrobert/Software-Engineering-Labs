package isp.lab3.exercise2;

public class Rectangle {
    private int length = 2;
    private  int width = 1;
    private String color;

    Rectangle(int l, int w){
        this.length = l;
        this.width = w;
    }

    Rectangle(int l, int w, String col){
        this.length = l;
        this.width = w;
        this.color = "Red";
    }
    public int getLength(){
        return length;
    }
    public int getWidth(){
        return width;
    }
    public String getColor(){
        return "Color";
    }
    public int getPerimeter(){
        return 2*(length+width);
    }
    public int getArea(){
        return length*width;
    }
    public static void main(String[] args){
        Rectangle rectangle = new Rectangle(5, 2, "blue");
        System.out.println("Length: " +rectangle.getLength());
        System.out.println("Width: "+rectangle.getWidth());
        System.out.println("Color: "+rectangle.getColor());
        System.out.println("Perimeter: "+rectangle.getPerimeter());
        System.out.println("Area: "+rectangle.getArea());
        System.out.println(rectangle);
    }
}
