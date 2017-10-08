package com.mycompany.app;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public class PairSummingUpToNumberUnorderedListTest {

    @Test
    public void should_find_pair(){
        Optional<PairSummingUpToNumberUnorderedList.Pair> sumUpTo = new PairSummingUpToNumberUnorderedList(List.of(3, 4, 1,5, 2)).findSumUpTo(8);
        Assertions.assertThat(sumUpTo.get()).isEqualToComparingFieldByField(PairSummingUpToNumberUnorderedList.Pair.newPair(3,5));
    }
    @Test
    public void should_find_pair2(){
        Optional<PairSummingUpToNumberUnorderedList.Pair> sumUpTo = new PairSummingUpToNumberUnorderedList(List.of(3, 5)).findSumUpTo(8);
        Assertions.assertThat(sumUpTo.get()).isEqualToComparingFieldByField(PairSummingUpToNumberUnorderedList.Pair.newPair(3,5));
    }

    @Test
    public void should_find_pair3(){
        Optional<PairSummingUpToNumberUnorderedList.Pair> sumUpTo = new PairSummingUpToNumberUnorderedList(List.of(5, 3)).findSumUpTo(8);
        Assertions.assertThat(sumUpTo.get()).isEqualToComparingFieldByField(PairSummingUpToNumberUnorderedList.Pair.newPair(5,3));
    }

    @Test
    public void should_find_pair4(){
        Optional<PairSummingUpToNumberUnorderedList.Pair> sumUpTo = new PairSummingUpToNumberUnorderedList(List.of(5, 1, 3)).findSumUpTo(8);
        Assertions.assertThat(sumUpTo.get()).isEqualToComparingFieldByField(PairSummingUpToNumberUnorderedList.Pair.newPair(5,3));
    }

    @Test
    public void should_find_pair5(){
        Optional<PairSummingUpToNumberUnorderedList.Pair> sumUpTo = new PairSummingUpToNumberUnorderedList(List.of(3, 5, 2)).findSumUpTo(8);
        Assertions.assertThat(sumUpTo.get()).isEqualToComparingFieldByField(PairSummingUpToNumberUnorderedList.Pair.newPair(3,5));
    }

    @Test
    public void should_find_pair_in_repeating_list(){
        Optional<PairSummingUpToNumberUnorderedList.Pair> sumUpTo = new PairSummingUpToNumberUnorderedList(List.of(5, 4,3,  4)).findSumUpTo(8);
        Assertions.assertThat(sumUpTo.get()).isEqualToComparingFieldByField(PairSummingUpToNumberUnorderedList.Pair.newPair(5,3));
    }

    @Test
    public void should_find_pair_in_repeating_list2(){
        Optional<PairSummingUpToNumberUnorderedList.Pair> sumUpTo = new PairSummingUpToNumberUnorderedList(List.of(5, 4,2,  4)).findSumUpTo(8);
        Assertions.assertThat(sumUpTo.get()).isEqualToComparingFieldByField(PairSummingUpToNumberUnorderedList.Pair.newPair(4,4));
    }

    @Test
    public void should_return_empty_if_one_element(){
        Optional<PairSummingUpToNumberUnorderedList.Pair> sumUpTo = new PairSummingUpToNumberUnorderedList(List.of(1)).findSumUpTo(8);
        Assertions.assertThat(sumUpTo).isEmpty();
    }

    @Test
    public void should_return_empty_if_zero_elements(){
        Optional<PairSummingUpToNumberUnorderedList.Pair> sumUpTo = new PairSummingUpToNumberUnorderedList(List.of()).findSumUpTo(8);
        Assertions.assertThat(sumUpTo).isEmpty();
    }

    @Test
    public void should_return_empty_no_pairs(){
        Optional<PairSummingUpToNumberUnorderedList.Pair> sumUpTo = new PairSummingUpToNumberUnorderedList(List.of(4, 2, 1,5)).findSumUpTo(8);
        Assertions.assertThat(sumUpTo).isEmpty();
        HashSet<Integer> set = new HashSet<>();
    }
}