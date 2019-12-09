package request;

/**
 *
 * @author --G--
 */
public interface Value {

    /**
     * The unique ID defined for the resolved slot value. This is based on the
     * IDs defined in the slot type definition.
     *
     * @return
     */
    String getId();

    /**
     * The string for the resolved slot value.
     *
     * @return
     */
    String getName();
}
