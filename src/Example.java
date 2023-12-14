import java.util.Arrays;

public class Example {
    public static void main(String[] args) {

        Main<Integer> mainList = new Main<Integer>(Arrays.asList(5, 2, 8, 1, 7));
        System.out.println("Default array " + Arrays.toString(mainList.toArray()));

        mainList.add(4);
        System.out.println("Add 4 " + Arrays.toString(mainList.toArray()));

        System.out.println("Element in index 2: " + mainList.get(2));

        mainList.remove(1);
        System.out.println("Array after removing " + Arrays.toString(mainList.toArray()));

        mainList.addAll(Arrays.asList(9, 3, 6));
        System.out.println("Array efter adding elements from other collection " + Arrays.toString(mainList.toArray()));

        mainList.bubbleSort();

        System.out.println("Elements after sorting: " + Arrays.toString(mainList.toArray()));
    }
}
