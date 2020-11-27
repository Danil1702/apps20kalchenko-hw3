package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;
import java.util.Arrays;


// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator{
    private final Object[] sortedArray;

    public SortDecorator(SmartArray smartArray, MyComparator comparator) {
        super(smartArray);
        sortedArray = Arrays.stream(smartArray.toArray()).sorted(comparator).toArray();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(sortedArray, sortedArray.length);
    }

    @Override
    public String operationDescription() {
        return "sort array";
    }

    @Override
    public int size() {
        return sortedArray.length;
    }
}
