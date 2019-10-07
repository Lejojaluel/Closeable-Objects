/**
 * Closeable generic class
 *
 * @author Leroy Valencia
 */
/*
 * Enumeration class for the Container state. Either OPEN or CLOSE
 */
enum ContainerState {
  OPEN,
  CLOSE;

  public String toString(ContainerState state) {
    switch (state) {
      case OPEN:
        return "Opened";
      case CLOSE:
        return "Closed";
      default:
        System.err.println("Impossible state in the ContainerState Enum");
        System.exit(1);
    }
    return "Impossible Reach in the end of the switch in the enum.";
  }
}

/**
 * The Main Generic Class
 *
 * @param <T>
 */
public class Closeable<T> {
  boolean v = true;
  ContainerState state;
  private T t;

  /**
   * First Constructor to create a new closeable
   *
   * @param item
   * @param state
   */
  Closeable(T item, ContainerState state) {
    // I had the state after the item so you can put something in the container and then close it.
    this.t = item;
    this.state = state;
    // places item in the container and sets the state to the specified value.
    // Note you can put something in the container then close it this way.
  }

  /** A default null closeable constructor */
  Closeable() {
    // puts null and sets state to closed
    this.t = null;
    this.state = ContainerState.CLOSE;
  }

  /**
   * This method sets the value of what is inside the closeable only when the State is Open. The
   * validation of the T item is handled by the compiler
   *
   * @param item
   */
  public void setValue(T item) {
    // If only open otherwise return null
    if (state == ContainerState.OPEN) {
      this.t = item;
      System.out.println("Item is set.");
    } else if (state == ContainerState.CLOSE) {
      // ignore the item
      System.err.println("Item did not set because the container is closed.");
    }
  }

  /**
   * A getter for the value. Returns the value only when the state is OPEN.
   *
   * @return the T value of the container when open.
   */
  public T getValue() {
    // If only open otherwise return null
    if (state == ContainerState.OPEN) {
      return t;
    } else {
      System.err.println("Cannot get value/s when container is closed.\nReturning null...");
      return null;
    }
  }

  /**
   * This method returns the state that the container is in. Not the string verison.
   *
   * @return the ContainerState value of the container.
   */
  public ContainerState getState() {
    return state;
    // returns whether or not the container is open.
  }

  /** This method opens the container for writing and reading */
  public void open() {
    state = ContainerState.OPEN;
    verbose("Container " + state.toString(getState()));
    // set the container state to OPEN.
  }

  /** This method closes the container. No reading or writing. */
  public void close() {
    state = ContainerState.CLOSE;
    verbose("Container " + state.toString(getState()));
    // set the container state to CLOSE.
  }

  /**
   * A method that returns a string printout of information of the container.
   *
   * @return A string of the information of the container.
   */
  public String toString() {
    if (state == ContainerState.OPEN) {
      return "This container that is in state "
          + getState().toString()
          + " that has the value/s "
          + getValue();
    } else {
      return "";
    }
  }

  /**
   * Prints stuff to verbose
   *
   * @param stuff inputted type to print
   * @param <V> generic type
   */
  public <V> void verbose(V stuff) {
    if (v) {
      System.err.println(stuff);
    }
  }
}
