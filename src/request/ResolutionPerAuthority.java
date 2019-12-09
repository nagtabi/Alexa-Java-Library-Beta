package request;

import java.util.List;
import java.util.Map;

/**
 *
 * @author --G--
 */
public interface ResolutionPerAuthority {

    /**
     * The name of the authority for the slot values. For custom slot types,
     * this authority label incorporates your skill ID and the slot type name.
     *
     * @return
     */
    public String getAuthority();

    /**
     * A code indicating the results of attempting to resolve the user utterance
     * against the defined slot types. This can be one of the following:
     *
     * ER_SUCCESS_MATCH: The spoken value matched a value or synonym explicitly
     * defined in your custom slot type. ER_SUCCESS_NO_MATCH: The spoken value
     * did not match any values or synonyms explicitly defined in your custom
     * slot type. ER_ERROR_TIMEOUT: An error occurred due to a timeout.
     * ER_ERROR_EXCEPTION: An error occurred due to an exception during
     * processing.
     *
     * @return
     */
    public Code getStatusCode();

    /**
     * An array of resolved values for the slot. The values in the array are
     * ordered from the most likely to least likely matches. Therefore, the
     * first value in the array is considered the best match.
     *
     * @return
     */
    public List<? extends Value> getValues();

}
