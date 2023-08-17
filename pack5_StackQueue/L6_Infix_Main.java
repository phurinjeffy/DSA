import code.MyQueueL_651463;
import code.MyRPN_651463;
import code.MyShuntingYard_651463;

public class L6_Infix_Main {
    public static void main(String[] args) {
        // demo1();
        String infixString = "( 4 + 2 ) / 3 * ( 8 - 5 )";
        // expect 4 2 + 3 / 8 5 - *
        if (args.length > 0)
            infixString = args[0];
        computeInfix(infixString);
    }

    public static void computeInfix(String infixString) {
        String postfixString = MyShuntingYard_651463.infixToPostfix(infixString);
        double ans = MyRPN_651463.computeRPN(postfixString);
        System.out.println(ans);
    }

    private static void demo1() {
        System.out.println("-----MyQueueL Tester-----");
        MyQueueL_651463 queue = new MyQueueL_651463();
        queue.enqueue("1");
        queue.enqueue("3");
        queue.enqueue("5");
        queue.enqueue("7");
        System.out.println(queue.dumpToString());
        System.out.println("Top " + queue.top());
        System.out.println("Last " + queue.getLast());
        System.out.println("Dequeue " + queue.dequeue());
        System.out.println("Dequeue " + queue.dequeue());
        System.out.println("Dequeue " + queue.dequeue());
        System.out.println("Dequeue " + queue.dequeue());
        queue.enqueue("9");
        System.out.println(queue);
        System.out.println("----MyQueueL Test End----");
    }
}