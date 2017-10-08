package com.mycompany.app;

// Work at Google — Example Coding/Engineering Interview  https://www.youtube.com/watch?v=XKu_SEDAykw

import java.util.List;
import java.util.Optional;

public class PairSummingUpToNumber {

    private List<Integer> list;

    public PairSummingUpToNumber(List<Integer> list) {
        this.list = list;
    }

    public Optional<Pair> findSumUpTo(int expectedSum){
        if(list.size()<2)
            return Optional.empty();
        int currentLeftIndex = 0;
        int currentRightIndex = list.size()-1;

        while(currentLeftIndex!=currentRightIndex) {
            int currentSum = list.get(currentLeftIndex) + list.get(currentRightIndex);
            if (currentSum < expectedSum) {
                currentLeftIndex++;
            } else if (currentSum > expectedSum) {
                currentRightIndex--;
            } else {
                return Optional.of(Pair.newPair(list.get(currentLeftIndex), list.get(currentRightIndex)));
            }
        }
        return Optional.empty();
    }

    public static final class Pair {
        private final Integer first;
        private final Integer second;

        private Pair(Integer first, Integer second) {
            this.first = first;
            this.second = second;
        }

        public Integer getFirst() {
            return first;
        }

        public Integer getSecond() {
            return second;
        }

        public static Pair newPair(Integer first, Integer second) {
            return new Pair(first, second);
        }
    }
}
