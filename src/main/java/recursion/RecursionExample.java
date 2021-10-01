package recursion;

public class RecursionExample {
    public static void main(String[] args) {
        recursivePrint(10);
    }

    static void recursivePrint(int count){
        if(count == 0)
            return;
        else {
            System.out.println("Hello");
            recursivePrint(--count);
        }
    }
}
