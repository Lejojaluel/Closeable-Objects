/** Testing class for Closeable @Author Leroy Valencia */
import java.lang.reflect.Array;
import java.util.ArrayList;

public class CloseableTest {
  public static void main(String[] args) {
    // Create a version that stores an Integer.  Test putting a value in and getting it out, both
    // when open and closed.
    // Print the results as you try the various operations.
    System.out.println("Testing Integer Closeable...");
    Closeable<Integer> zipInt = new Closeable<>(69, ContainerState.OPEN);
    zipInt.open();
    System.out.println("getState() = " + zipInt.getState());
    zipInt.setValue(69);
    System.out.println("getValue() = " + zipInt.getValue());
    System.out.println(zipInt.toString());
    zipInt.close();
    System.out.println("getState() = " + zipInt.getState());
    System.out.println("getValue() = " + zipInt.getValue());
    zipInt.setValue(40); // This should fail
    System.out.println(zipInt.toString());

    // Arraylist of Strings test
    System.out.println("Testing ArrayList of Strings Closeable...");
    ArrayList<String> arr = new ArrayList<String>();
    arr.add("pencil");
    arr.add("paper");
    arr.add("pen");
    arr.add("sharpie");
    arr.add("highlighter");
    arr.add("notebook");
    arr.add("note");
    Closeable<ArrayList> zipArr = new Closeable<ArrayList>(arr, ContainerState.OPEN);
    zipArr.open();
    System.out.println("getState() = " + zipArr.getState());
    // zipInt.setValue(69);
    System.out.println("getValue() = " + zipArr.getValue());
    System.out.println(zipArr.toString());
    zipArr.close();
    System.out.println("getState() = " + zipArr.getState());
    System.out.println("getValue() = " + zipArr.getValue());
    // zipArr.setValue(40); // This should fail
    System.out.println(zipArr.toString());
  }
}
