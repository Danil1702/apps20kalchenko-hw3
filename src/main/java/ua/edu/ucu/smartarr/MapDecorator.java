package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.Arrays;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    private final Object[] mappedArray;

    public MapDecorator(SmartArray smartArray, MyFunction function) {
        super(smartArray);
        mappedArray = new Object[smartArray.size()];
        int i = 0;
        for (Object obj: smartArray.toArray()) {
            mappedArray[i] = function.apply(obj);
            i++;
        }
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(mappedArray, mappedArray.length);
    }

    @Override
    public String operationDescription() {
        return "map using function";
    }

    @Override
    public int size() {
        return mappedArray.length;
    }
}
