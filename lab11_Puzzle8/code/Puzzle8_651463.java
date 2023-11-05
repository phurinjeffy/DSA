package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Puzzle8_651463 {
    int size = 3;
    int[] sequence;
    public ArrayList<Puzzle8State> explored;
    public Stack<Puzzle8State> dfs;
    public int popinvocation = 0;
    boolean status = false;

    public Puzzle8_651463(int[] inputArray) {
        sequence = new int[size * size];
        int data = 0;
        int index = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (i % size == 0)
                data = inputArray[i];
            else if (i % size == 1)
                index += inputArray[i] * size;
            else {
                index += inputArray[i];
                sequence[index] = data;
                index = 0;
            }
        }
        explored = new ArrayList<Puzzle8State>();
        dfs = new Stack<Puzzle8State>();
    }

    public void displayBoard() {
        for (int i = 0; i < sequence.length; i++) {
            if (i % size == 0 && i != 0)
                System.out.println();
            System.out.print(sequence[i] + " ");
        }
        System.out.println();
    }

    public void generateNextMove() {
        int blankPos = -1;
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] == 9) {
                blankPos = i;
                break;
            }
        }
        if (blankPos == -1)
            return;

        // int possibleMove = 0;
        if (blankPos + 3 < size * size && status == false) { // south
            stateCheck(blankPos, blankPos + 3, "south");
            // possibleMove++;
        }
        if (blankPos - 3 > -1 && status == false) { // north
            stateCheck(blankPos, blankPos - 3, "north");
            // possibleMove++;
        }
        if (blankPos % 3 < 2 && status == false) { // east
            stateCheck(blankPos, blankPos + 1, "east");
            // possibleMove++;
        }
        if (blankPos % 3 > 0 && status == false) { // west
            stateCheck(blankPos, blankPos - 1, "west");
            // possibleMove++;
        }

        // if (possibleMove == 0) System.out.println(false);
        // else System.out.println(true);
    }

    private void stateCheck(int blankPos, int otherPos, String direction) {
        swap(blankPos, otherPos);

        Puzzle8State state = new Puzzle8State(Arrays.copyOf(sequence, sequence.length));
        // System.out.println("pushing " + direction + " " + state);

        if (isGoal(state.sequence)) {
            status = true;
            return;
        }
        if (!explored.contains(state)) {
            explored.add(state);
            dfs.push(new Puzzle8State(Arrays.copyOf(state.sequence, state.sequence.length)));
        }

        swap(blankPos, otherPos);
    }

    private void swap(int a, int b) {
        sequence[a] = sequence[a] ^ sequence[b];
        sequence[b] = sequence[a] ^ sequence[b];
        sequence[a] = sequence[a] ^ sequence[b];
    }

    public void nextMoveWithStack() {
        Puzzle8State start = new Puzzle8State(Arrays.copyOf(sequence, sequence.length));
        dfs.push(start);
        while (!dfs.isEmpty()) {
            sequence = dfs.pop().sequence;
            popinvocation++;
            generateNextMove();
            if (status == true)
                break;
        }
    }

    private boolean isGoal(int[] seq) {
        Puzzle8State current = new Puzzle8State(Arrays.copyOf(seq, seq.length));
        Puzzle8State goal = new Puzzle8State(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
        return current.equals(goal);
    }
}
