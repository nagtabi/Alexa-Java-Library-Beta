package reponse;

import com.google.gson.Gson;
import java.util.Map;

/**
 * Bug! In my code? Bitch! That is a feature.
 *
 * @author G
 */
class AlexaResponseImpl implements AlexaResponse {

    String version = "1.0";
    Response response=new Response();
    Map<String, Object> sessionAttributes;
    String userAgent;

    public static AlexaResponseImpl fromJson(String jsonText) {
        Gson gson = new Gson();
        return gson.fromJson(jsonText, AlexaResponseImpl.class);

    }

    @Override
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

}
