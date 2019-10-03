/**
 * Closeable generic class
 *
 * @author Leroy Valencia
 */
enum ContainerState {
    OPEN, CLOSE;

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


public class Closeable<T> {
    boolean v = true;
    ContainerState state;
    private T t;


    Closeable(T item, ContainerState state) {
        //I had the state after the item so you can put something in the container and then close it.
        this.t = item;
        this.state = state;
        //places item in the container and sets the state to the specified value.
        //Note you can put something in the container then close it this way.
    }

    Closeable() {
        //puts null and sets state to closed
        this.t = null;
        this.state = ContainerState.CLOSE;
    }

    public void setValue(T item) {
        //If only open otherwise return null
        if (state == ContainerState.OPEN) {
            this.t = item;
            System.out.println("Item is set.");
        } else if (state == ContainerState.CLOSE) {
            //ignore the item
            System.err.println("Item did not set because the container is closed.");
        }

    }

    public T getValue() {
        //If only open otherwise return null
        if (state == ContainerState.OPEN) {
            return t;
        } else {
            System.err.println("Cannot get value when container is closed.\nReturning null...");
            return null;
        }
    }


    public ContainerState getState() {
        return state;
        //returns whether or not the container is open.
    }

    public void open() {
        state = ContainerState.OPEN;
        verbose("Container " + state.toString(getState()));
        //set the container state to OPEN.
    }

    public void close() {
        state = ContainerState.CLOSE;
        verbose("Container " + state.toString(getState()));
        //set the container state to CLOSE.
    }

    public String toString() {
        if (state == ContainerState.OPEN) {
            return "This container that is in state " + getState().toString() + " that has the value " + getValue();
        } else {
            return "";
        }
    }


    /**
     * Prints stuff to verbose
     *
     * @param stuff inputted type to print
     * @param <V>   generic type
     */
    public <V> void verbose(V stuff) {
        if (v) {
            System.err.println(stuff);
        }
    }


}


