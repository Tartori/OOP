import org.w3c.dom.css.Rect;

import java.awt.*;
import java.util.Arrays;

import static java.lang.Math.log;
import static java.lang.Math.pow;

/**
 * Created by julia on 06.12.2016.
 */
public class MySort {
    public static void main(String[] args) {
        String[] words = { "hi", "hello", "hola", "bye", "goodbye", "adios" };
        sortByStringLength(words);
        sortByStringLengthDesc(words);
        Integer[] ints ={421,6123,8674,7221310,9,2,5,9,0,10,909};
        sortInt(ints);
        sortIntDesc(ints);
        sortIntByFirstNumber(ints);
        sortIntByLastNumber(ints);
        Rectangle[] rects ={new Rectangle(5,5), new Rectangle(6,3),new Rectangle(1,20)};
        sortRects(rects);
    }
    public static void sortByStringLength(String[] words){
        System.out.println("Original array: " + Arrays.asList(words));
        Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());
        System.out.println("Sorted by length ascending: " +
                Arrays.asList(words));
    }
    public static void sortByStringLengthDesc(String[] words){
        System.out.println("Original array: " + Arrays.asList(words));
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        System.out.println("Sorted by length descending: " +
                Arrays.asList(words));
    }
    public static void sortInt(Integer[] ints){
        System.out.println("Original array: " + Arrays.asList(ints));
        Arrays.sort(ints, (i1, i2) -> i1 - i2);
        System.out.println("Sorted int ascending: " +
                Arrays.asList(ints));
    }
    public static void sortIntDesc(Integer[] ints){
        System.out.println("Original array: " + Arrays.asList(ints));
        Arrays.sort(ints, (i1, i2) -> i2 - i1);
        System.out.println("Sorted int descending: " +
                Arrays.asList(ints));
    }

    public static void sortIntByFirstNumber(Integer[] ints){
        System.out.println("Original array: " + Arrays.asList(ints));
        Arrays.sort(ints, (i1, i2) -> i1.toString().charAt(0) - i2.toString().charAt(0));
        System.out.println("Sorted by first number ascending: " +
                Arrays.asList(ints));
    }

    public static void sortIntByLastNumber(Integer[] ints){
        System.out.println("Original array: " + Arrays.asList(ints));
        Arrays.sort(ints, (i1, i2) -> i1%10 - i2%10);
        System.out.println("Sorted by last number ascending: " +
                Arrays.asList(ints));
    }

    public static void sortRects(Rectangle[] rect){
        System.out.println("Original array: " + Arrays.asList(rect));
        Arrays.sort(rect, (r1, r2) -> ((int)(r1.getHeight()*r1.getWidth() - r2.getHeight()*r2.getWidth())));
        System.out.println("Sorted by Rect ascending: " + Arrays.asList(rect));
    }
}
