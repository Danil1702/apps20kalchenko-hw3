package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.ArrayList;
import java.util.Arrays;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private final Object[] filteredArray;

    public FilterDecorator(SmartArray smartArray, MyPredicate predicate) {
        super(smartArray);
        ArrayList<Object> suitableObjects = new ArrayList<>();
        for (Object obj: smartArray.toArray()) {
            if (predicate.test(obj)) {
                suitableObjects.add(obj);
            }
        }
        filteredArray = new Object[suitableObjects.size()];
        int i = 0;
        for (Object obj: suitableObjects) {
            filteredArray[i] = obj;
            i++;
        }
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(filteredArray, filteredArray.length);
    }

    @Override
    public String operationDescription() {
        return "filtered by predicate";
    }

    @Override
    public int size() {
        return filteredArray.length;
    }
}
