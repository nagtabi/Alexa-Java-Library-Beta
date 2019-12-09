package reponse;

/**
 * The service for an Alexa skill must send its response in JSON format.
 *
 * Note the following size limitations for the response:
 *
 * The outputSpeech response cannot exceed 8000 characters. All of the text
 * included in a card cannot exceed 8000 characters. This includes the title,
 * content, text, and image URLs. An image URL (smallImageUrl or largeImageUrl)
 * cannot exceed 2000 characters. The token included in an audioItem.stream for
 * the AudioPlayer.Play directive cannot exceed 1024 characters. The url
 * included in an audioItem.stream for the AudioPlayer.Play directive cannot
 * exceed 8000 characters. The total size of your response cannot exceed 24
 * kilobytes.
 *
 * If your response exceeds these limits, the Alexa service returns an error.
 *
 * You can build your response with the AlexaResponseBuilder class for normal
 * response or with the AlexaCanFulfillIntentResponseBuilder class for
 * CanFulfillIntent response.
 *
 * @author --G--
 */
public interface AlexaResponse {

    /**
     * To send response to json format
     * @return the json object of the response
     */
    public String toJson();
}
