
package request;

import java.util.List;
import java.util.Map;

/**
 * Bug!
 * In my code?
 * Bitch! That is a feature.
 * @author G
 */
class ResolutionsPerAuthorityImpl implements ResolutionPerAuthority{
String authority;
Status status;
List<ValueImpl> values;

    @Override
    public String getAuthority() {
        return authority;
    }

    @Override
    public Code getStatusCode() {
        return status.code;
    }

    @Override
    public List<? extends Value> getValues() {
        return values;
    }

   

    


}
