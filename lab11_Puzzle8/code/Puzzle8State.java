package code;

import java.util.Arrays;

public class Puzzle8State {
    int score = 0;
    int size = 3;
    public int[] sequence;

    public Puzzle8State(int[] inputArray) {
        sequence = inputArray;
    }

    @Override
    public String toString() {
        return Arrays.toString(sequence);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Puzzle8State otherState = (Puzzle8State) obj;
        return Arrays.equals(sequence, otherState.sequence);
    }
}
