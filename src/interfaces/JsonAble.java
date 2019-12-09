package interfaces;

import com.google.gson.Gson;

/**
 *
 * @author --G--
 */
public interface JsonAble {

    public static <T extends JsonAble> T fromJson(String jsonText, Class clazz) {
        Gson gson = new Gson();
        return (T) gson.fromJson(jsonText, clazz);
    }
    public String toJson();
}
