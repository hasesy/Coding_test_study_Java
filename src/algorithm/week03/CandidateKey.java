package algorithm.week03;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CandidateKey {
    public int solution(String[][] relation) {
        List<Set<Integer>> candidates = new ArrayList<>();
        int colSize = relation[0].length;

        for (int size = 1; size <= colSize; size++) {
            List<Set<Integer>> combinations = generateCombinations(colSize, size);

            for (Set<Integer> comb : combinations) {
                if (checkUnique(comb, relation) && checkMin(comb, candidates)) {
                    candidates.add(comb);
                }
            }
        }
        return candidates.size();
    }

    public List<Set<Integer>> generateCombinations(int colSize, int size) {
        List<Set<Integer>> combinations = new ArrayList<>();
        backtrack(0, new ArrayList<>(), colSize, size, combinations);
        return combinations;
    }

    public void backtrack(int start, List<Integer> path, int col, int size, List<Set<Integer>> combinations) {
        if (path.size() == size) {
            combinations.add(new HashSet<>(path));
            return;
        }

        for (int i = start; i < col; i++) {
            path.add(i);
            backtrack(i + 1, path, col, size, combinations);
            path.remove(path.size() - 1);
        }
    }

    public boolean checkUnique(Set<Integer> combinations, String[][] relation) {
        Set<String> checkSet = new HashSet<>();

        for (int i = 0; i < relation.length; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j : combinations) {
                sb.append(relation[i][j]).append(" ");
            }

            if (!checkSet.add(sb.toString())) return false;
            checkSet.add(sb.toString());
        }
        return true;
    }

    public boolean checkMin(Set<Integer> combinations, List<Set<Integer>> candidates) {
        for (Set<Integer> c : candidates) {
            if (combinations.containsAll(c)) return false;
        }
        return true;
    }
}
