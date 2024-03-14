package isp.lab3.exercise1;

public class Tree {

    public int height;

    public Tree() {
        this.height = 15;
    }

    public void grow(int meters){
        if(meters >= 1){
            height += meters;
        }
    }
    @Override
    public String toString(){
        return "The height is:"+ this.height;
    }
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.grow(10);

        System.out.println(tree);
    }
}


