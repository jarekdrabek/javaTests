package com.mycompany.app;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

public class PairSummingUpToNumberTest {


    @Test
    public void should_find_pair(){
        Optional<PairSummingUpToNumber.Pair> sumUpTo = new PairSummingUpToNumber(List.of(1, 2, 3, 4, 5)).findSumUpTo(8);
        Assertions.assertThat(sumUpTo.get()).isEqualToComparingFieldByField(PairSummingUpToNumber.Pair.newPair(3,5));
    }

    @Test
    public void should_return_empty_if_one_element(){
        Optional<PairSummingUpToNumber.Pair> sumUpTo = new PairSummingUpToNumber(List.of(1)).findSumUpTo(8);
        Assertions.assertThat(sumUpTo).isEmpty();
    }

    @Test
    public void should_return_empty_if_zero_elements(){
        Optional<PairSummingUpToNumber.Pair> sumUpTo = new PairSummingUpToNumber(List.of()).findSumUpTo(8);
        Assertions.assertThat(sumUpTo).isEmpty();
    }

    @Test
    public void should_return_empty_no_pairs(){
        Optional<PairSummingUpToNumber.Pair> sumUpTo = new PairSummingUpToNumber(List.of(1,2,4,5)).findSumUpTo(8);
        Assertions.assertThat(sumUpTo).isEmpty();
    }
}