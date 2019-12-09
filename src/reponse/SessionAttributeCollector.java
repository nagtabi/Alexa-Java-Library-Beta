package reponse;

import java.util.HashMap;
import java.util.Map;

/**
 * Bug! In my code? Bitch! That is a feature.
 *
 * @author G
 */
public class SessionAttributeCollector {

    private final Map<String, Object> sessionAttributeCollection;

  

    private SessionAttributeCollector(Map<String, Object> sessionAttributeCollection) {
      this.sessionAttributeCollection=sessionAttributeCollection;
    }

   
    public Map<String, Object> getSessionAttributeCollection() {
        return sessionAttributeCollection;
    }

    public static class Builder {

        Map<String, Object> sessionAttributeCollection;

        public Builder() {
          this.sessionAttributeCollection=new HashMap<>();
        }

        public Builder addSessionAttribute(String key, Object data){
            sessionAttributeCollection.put(key, data);
            return this;
        }
        public SessionAttributeCollector build(){
            return new  SessionAttributeCollector(sessionAttributeCollection);
           
        }
    }

}
