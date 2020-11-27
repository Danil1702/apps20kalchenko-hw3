package ua.edu.ucu.smartarr;

import java.util.Arrays;
import java.util.HashSet;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {
    private final Object[] distinctArray;

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        HashSet<Object> temp = new HashSet<>(Arrays.asList(smartArray.toArray()));
        distinctArray = temp.toArray();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(distinctArray, distinctArray.length);
    }

    @Override
    public String operationDescription() {
        return "Distinct array";
    }

    @Override
    public int size() {
        return distinctArray.length;
    }
}
