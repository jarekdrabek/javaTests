package com.mycompany.app;

import org.junit.Test;

import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

public class MyLinkedListTest {

    @Test(expected = IndexOutOfBoundsException.class)
    public void should_throw_ioobe_exception_when_getting_element_from_empty_list(){
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.get(1);
    }

    @Test
    public void should_get_zero_element_from_one_element_list(){
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(123);
        assertThat(linkedList.get(0)).isEqualTo(123);
    }

    @Test
    public void should_get_zero_element_from_two_elements_list(){
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        assertThat(linkedList.get(0)).isEqualTo(1);
    }

    @Test
    public void should_get_element_with_index1_from_two_elements_list(){
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        assertThat(linkedList.get(1)).isEqualTo(2);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void should_throw_ioobe_exception_when_getting_element_out_of_bound(){
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.get(2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void should_remove_the_last_element(){
        //given
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(1);
        //when
        linkedList.remove(0);
        linkedList.get(0);
    }

    @Test
    public void should_remove_element_from_inside(){
        //given
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        //when
        linkedList.remove(1);
        //then
        assertThat(linkedList.get(1)).isEqualTo(3);
    }

    @Test
    public void should_remove_element_from_the_beginning(){
        //given
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        //when
        linkedList.remove(0);
        //then
        assertThat(linkedList.get(0)).isEqualTo(2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void should_remove_element_from_the_end(){
        //given
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        //when
        linkedList.remove(1);
        //then
        System.out.println(linkedList.get(1));
        linkedList.get(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void should_throw_ioobe_exception_when_removing_not_existing_index(){
        //given
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        //when
        linkedList.remove(2);
    }








    @Test
    public void temp_tests(){
        LinkedList<Integer> linkedList2 = new LinkedList<>();
        linkedList2.add(123);
        linkedList2.add(234);
        System.out.println("Print:"+linkedList2.get(0));
    }

}