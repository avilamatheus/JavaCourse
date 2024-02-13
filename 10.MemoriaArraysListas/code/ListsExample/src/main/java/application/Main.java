package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        /**
         * There are two general-purpose List implementations —
         * ArrayList and LinkedList. Most of the time, you'll probably use ArrayList,
         * which offers constant-time positional access and is just plain fast.
         * It does not have to allocate a node object for each element in the List,
         * and it can take advantage of System.arraycopy when it has to move multiple elements at the same time.
         * Think of ArrayList as Vector without the synchronization overhead.
         *
         * If you frequently add elements to the beginning of the List or iterate
         * over the List to delete elements from its interior, you should consider using LinkedList.
         * These operations require constant-time in a LinkedList and linear-time in an ArrayList.
         * But you pay a big price in performance. Positional access requires linear-time in a
         * LinkedList and constant-time in an ArrayList. Furthermore, the constant factor for LinkedList
         * is much worse. If you think you want to use a LinkedList, measure the performance of your application
         * with both LinkedList and ArrayList before making your choice; ArrayList is usually faster.
         *
         * Source: https://docs.oracle.com/javase/tutorial/collections/implementations/list.html
         */
        List<String> list = new ArrayList<>();

        list.add("Maria");
        list.add("Alex");
        list.add("Bob");
        list.add("Anna");
        list.add(2, "Marco");

        System.out.println(list.size());
        for (String x : list) {
            System.out.println(x);
        }
        System.out.println("---------------------");

        /**
         * Remove all elements from the list that start with the letter 'M'
         *
         * removeIf: It's a method of the Collection interface (which List implements), introduced in Java 8.
         * It removes all elements from the list that satisfy a specified condition.
         *
         * x -> x.charAt(0) == 'M': This is a lambda expression.
         * The lambda expression (x -> x.charAt(0) == 'M') is an anonymous function that takes a parameter x
         * (in this case, an element of the list) and returns true if the first character of that element is equal to 'M',
         * and false otherwise.
         * Therefore, this lambda expression is a condition that determines whether an element should be removed from the list or not.
         *
         * x.charAt(0): This returns the first character of the String represented by the element x in the list.
         */
        list.removeIf(x -> x.charAt(0) == 'M');

        for (String x : list) {
            System.out.println(x);
        }
        System.out.println("---------------------");
        System.out.println("Index of Bob: " + list.indexOf("Bob"));
        System.out.println("Index of Marco: " + list.indexOf("Marco"));
        System.out.println("---------------------");

        /**
         * This snippet of code performs the following operations:
         * 1. list.stream(): This snippet converts the list 'list' into a stream of elements.
         *      A stream in Java is a sequence of elements that supports data processing operations on collections.
         *
         * 2. filter(x -> x.charAt(0) == 'A'): The filter method is an intermediate operation of a stream that filters
         *      elements based on a predicate. In this case, the predicate is a lambda expression (x -> x.charAt(0) == 'A'),
         *      which checks if the first character of each element is equal to 'A'.
         *
         * 3. toList(): This is a terminal method of a stream that collects the filtered elements into a list. Starting from Java 16,
         *      you can use the toList() method directly on a stream to collect the filtered elements into a list.
         *      In the past Versions of Java, this would be:
         *      List<String> result = list.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList());
         *
         * 4. List<String> result = ...: Here, the result of the filtering operation is assigned to the variable 'result',
         *      which is a list of strings. This list will contain only the elements from the original list 'list' whose first character is 'A'.
         */
        List<String> result = list.stream().filter(x -> x.charAt(0) == 'A').toList();

        for (String x : result) {
            System.out.println(x);
        }
        System.out.println("---------------------");


        /**
         * This snippet of code performs the following operations:
         *
         * 1. list.stream(): This converts the list 'list' into a stream of elements.
         *    A stream in Java is a sequence of elements that supports data processing operations on collections.
         *
         * 2. filter(x -> x.charAt(0) == 'J'): The filter method is an intermediate operation of a stream that filters
         *    elements based on a predicate. In this case, the predicate is a lambda expression (x -> x.charAt(0) == 'J'),
         *    which checks if the first character of each element is equal to 'J'.
         *
         * 3. findFirst(): This is a terminal operation of a stream that returns the first element of the stream, if present.
         *    If the stream is empty, it returns an empty Optional.
         *
         * 4. orElse(null): This is a method of Optional that returns the value contained in the Optional, if present.
         *    If the Optional is empty, it returns the value passed as a parameter, in this case, null.
         *
         * Therefore, this snippet of code searches for the first element in the 'list' whose first character is 'J'
         * and stores that element in the variable 'name'. If no element satisfies this criterion, 'name' is assigned null.
         */
        String name = list.stream().filter(x -> x.charAt(0) == 'J').findFirst().orElse(null);

        System.out.println(name);
    }
}