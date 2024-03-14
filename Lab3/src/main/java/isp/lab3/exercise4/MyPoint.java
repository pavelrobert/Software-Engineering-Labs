package isp.lab3.exercise4;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class MyPoint {
        int x;
        int y;
        int z;

    public MyPoint(){
        System.out.println("No argument constructor called");
    }
    public MyPoint(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public int getX(){
        return x;
    }
    public void setX(int newX){
        this.x = x;
    }
    public int getY(){
        return y;
    }
    public void setY(int newY){
        this.y = y;
    }
    public int getZ(){
        return z;
    }
    public void setZ(int newZ){
        this.z = z;
    }

    public void setXYZ(int x, int y, int z){
        this.x = x;
        this.y= y;
        this.z = z;
    }

    @Override
    public String toString(){
        return "("+this.x+","+this.y+","+this.z+")";
    }
    public double distance(int x, int y, int z){
        double distance;
        distance = sqrt(pow((this.getX() - x), 2) + pow((this.getY() - y), 2) + pow((this.getZ() - z), 2));
        return distance;
    }
    public double distance(MyPoint another){
        return distance(another.getX(), another.getY(), another.getZ());
    }
    public static void main(String[] args){
        MyPoint point1 = new MyPoint(4,3,2);
        MyPoint point2 = new MyPoint(6,7,3);

        double distance = point1.distance(point2);
        System.out.println("The distance between: " +point1+ "and "+point2+ " is "+ distance);
    }
}