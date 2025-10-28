
import java.util.Arrays;
import java.util.Scanner;

public class C1230435 <T>{
    public static void main(String[] args) {
        C1230435 <Integer> stack=new C1230435<>(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.push(70);

        stack.displayStack();
        System.out.println("peek " + stack.peek());
        System.out.println("pop " + stack.pop());
        System.out.println("isempty " + stack.isEmpty());
        System.out.println("pop " + stack.pop());
        System.out.println("peek "  + stack.peek());

        System.out.println("searchin..");
//        stack.serach(10);

        Scanner input=new Scanner(System.in);
        System.out.println("soo gali numberka laradinaayo");
        int num=input.nextInt();
        stack.serach(num);

    }
    private int top;
    private T[] mystack;
    private static final int capacity=3;

    public C1230435(){
        this(capacity);
    }
    public C1230435(int newcapacity){
        top=0;
        mystack=(T[])new Object[newcapacity];
    }
    //siz3

    public int size(){
        return top;
    }

    //isEmpty

    public boolean isEmpty(){
        return top==0;

    }

    //expand

    public void expandCapacity(){
        mystack= Arrays.copyOf(mystack,mystack.length*2);

    }

    //peek
    public T peek(){
        return mystack[top-1];

    }

    //pop

    public T pop(){
        T removedElement=mystack[--top];
        mystack[top]=null;
        return removedElement;
    }

    //push

    public void push(T element){
        if (size()==mystack.length)
            expandCapacity();
        mystack[top]=element;
        top++;

    }

    public void serach(T element){
        boolean found=false;
        for (int i=0;i<top;i++){
            if(mystack[i].equals(element)){
                System.out.println(element + " found ");
                found=true;
                break;
            }

        }
        if (!found){
            System.out.println(element + "not found in the stack");
        }
    }

    public void displayStack() {
        T[] current=Arrays.copyOf(mystack,top);
        System.out.println(Arrays.toString(current));

    }
}
