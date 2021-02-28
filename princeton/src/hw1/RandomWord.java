package hw1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public RandomWord() {}

    public static void main(String[] args) {
        String currentChampion = null;
        int index = 1; // the only word in stdin will be the champion

        while (! StdIn.isEmpty()) {
            String word = StdIn.readString();
            double p = 1/(double)index;
            if (StdRandom.bernoulli(p)) {
                currentChampion = word;
            }
            index++;
        }

        StdOut.println(currentChampion);
    }
}
