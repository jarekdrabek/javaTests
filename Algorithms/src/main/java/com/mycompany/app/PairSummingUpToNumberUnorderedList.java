package com.mycompany.app;

// Work at Google — Example Coding/Engineering Interview  https://www.youtube.com/watch?v=XKu_SEDAykw

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class PairSummingUpToNumberUnorderedList {

    private List<Integer> list;

    public PairSummingUpToNumberUnorderedList(List<Integer> list) {
        this.list = list;
    }

    public Optional<Pair> findSumUpTo(int expectedSum){
        HashMap<Integer, Integer> complementIndex = new HashMap<>();
        for(int i=0; i<list.size();i++){
            if(complementIndex.get(list.get(i))==null){
                int complement = expectedSum - list.get(i);
                complementIndex.put(complement, i);
            } else {
                Integer indexOfElement = complementIndex.get(list.get(i));
                return Optional.of(Pair.newPair(list.get(indexOfElement), list.get(i)));
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
