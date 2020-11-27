package ua.edu.ucu;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

public class SmartArrayApp {
    public static Integer[]
    filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {

        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr);
        sa = new SortDecorator(sa, cmp);
        sa = new MapDecorator(sa, func);

        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
    findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(
                                                        Student[] students) {
        final double neededGPA = 4.0;
        MyPredicate yearCheck = new MyPredicate() {
            @Override
            public boolean test(Object student) {
                return ((Student) student).getYear() == 2;
            }
        };

        MyPredicate gpaCheck = new MyPredicate() {
            @Override
            public boolean test(Object student) {
                return ((Student) student).getGpa() >= neededGPA;
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object student) {
                return ((Student) student).getSurname() + " "
                        + ((Student) student).getName();
            }
        };


        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object first, Object second) {
                return ((Student) first).getSurname().compareTo(
                        ((Student) second).getSurname());
            }
        };

        SmartArray studentSmartArray = new BaseArray(students);

        studentSmartArray = new DistinctDecorator(studentSmartArray);
        studentSmartArray = new FilterDecorator(studentSmartArray, yearCheck);
        studentSmartArray = new FilterDecorator(studentSmartArray, gpaCheck);
        studentSmartArray = new SortDecorator(studentSmartArray, cmp);
        studentSmartArray = new MapDecorator(studentSmartArray, func);

        Object[] result = studentSmartArray.toArray();
        return Arrays.copyOf(result, result.length, String[].class);
    }
}
