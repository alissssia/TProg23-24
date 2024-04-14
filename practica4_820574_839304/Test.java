import java.util.Stack;


public class Test {
    
    

    public static void main(String[] argv)
    {
        Stack<Integer> cwd = new Stack<Integer>();
        
        cwd.add(1);
        cwd.add(2);
        cwd.add(3);


        Stack<Integer> stackTemp = new Stack<Integer>();
        stackTemp.addAll(cwd);

        Stack<Integer> cwdCopy = new Stack<Integer>();
        cwdCopy.addAll(stackTemp);

        System.out.print(cwd.pop());
        System.out.print(cwd.pop());
        System.out.print(cwd.pop());
        System.out.println();
        
        System.out.print(stackTemp.pop());
        System.out.print(stackTemp.pop());
        System.out.print(stackTemp.pop());
        System.out.println();

        System.out.print(cwdCopy.pop());
        System.out.print(cwdCopy.pop());
        System.out.print(cwdCopy.pop());
        System.out.println();

    }
}
