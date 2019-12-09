package request;

/**
 * Bug! In my code? Bitch! That is a feature.
 *
 * @author G
 */
public class AlexaRequestFactory {

    private AlexaRequestFactory() {
    }

    public static AlexaRequest createAlexaRequestFromJson(String jsonText) {
        return AlexaRequestImpl.fromJSON(jsonText);
    }

}
