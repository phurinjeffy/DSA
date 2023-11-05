import java.util.Arrays;

import code.*;

public class Demo {
    public static void main(String[] args) {
        demo3();
    }

    static void demo1() {
        Puzzle8_651463 game = new Puzzle8_651463(new int [] {9,0,0,1,0,1,3,0,2,4,1,0,2,1,1,5,1,2,7,2,0,8,2,1,6,2,2});
        game.displayBoard();
    }

    static void demo2() {
        Puzzle8_651463 game = new Puzzle8_651463(new int[] {9,0,0,1,0,1,3,0,2,4,1,0,2,1,1,5,1,2,7,2,0,8,2,1,6,2,2});
        game.generateNextMove();
    }

    static void demo3() {
        Puzzle8_651463 game = new Puzzle8_651463(new int[] {9,0,0,1,0,1,3,0,2,4,1,0,2,1,1,5,1,2,7,2,0,8,2,1,6,2,2});
        game.nextMoveWithStack();
        System.out.println("number of pop invocation = " + game.popinvocation);
        System.out.println("stack size = " + game.dfs.size());
        System.out.println("explored size = " + game.explored.size());
        System.out.println("Partial Explored State");
        for (Puzzle8State s : game.explored) {
            if (s.sequence[0] == 1 && s.sequence[1] == 2 && s.sequence[2] == 3 && s.sequence[3] == 4)
                System.out.println(Arrays.toString(s.sequence));
        }
        System.out.println("Note that the Program terminates prior to pushing goal state into explored!!");
    }
}
