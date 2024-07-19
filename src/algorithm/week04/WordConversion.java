package algorithm.week04;

import java.util.*;

public class WordConversion {
    public int solution(String begin, String target, String[] words) {
        boolean exist = false;

        for (String word : words) {
            if (target.equals(word)) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            return 0;
        }

        return bfs(begin, target, words);
    }

    private static int bfs(String begin, String target, String[] words) {
        Queue<Pair> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(new Pair(begin, 0));
        visited.add(begin);

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            String currentWord = current.word;
            int steps = current.steps;

            if (currentWord.equals(target)) {
                return steps;
            }

            for (String word : words) {
                boolean isConversion = isConversion(currentWord, word);
                if (isConversion && !visited.contains(word)) {
                    queue.add(new Pair(word, steps + 1));
                    visited.add(word);
                }
            }
        }
        return 0;
    }

    private static boolean isConversion(String word1, String word2) {
        int diff = 0;

        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
            }
            if (diff > 1) return false;
        }
        return true;
    }
}

class Pair {
    String word;
    int steps;

    public Pair(String word, int steps) {
        this.word = word;
        this.steps = steps;
    }
}
