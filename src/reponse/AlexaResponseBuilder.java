package reponse;

import java.util.HashMap;

/**
 * Bug! In my code? Bitch! That is a feature.
 *
 * @author G
 */
public class AlexaResponseBuilder {

    AlexaResponseImpl response;

    public AlexaResponseBuilder() {
        response = new AlexaResponseImpl();
    }

    /**
     * The object containing the speech to render to the user
     *
     * @param text A string containing the speech to render to the user.
     * @param type An enum containing the type of output speech to render. Valid
     * types are:
     *
     * "PlainText": Indicates that the output speech is defined as plain text.
     * "SSML": Indicates that the output speech is text marked up with SSML.
     *
     * @param behavior An enum that determines the queuing and playback of this
     * output speech. Valid values are:
     *
     * "ENQUEUE": Add this speech to the end of the queue. Do not interrupt
     * Alexa's current speech. This is the default value for all skills that do
     * not use the GameEngine interface. "REPLACE_ALL": Immediately begin
     * playback of this speech, and replace any current and enqueued speech.
     * This is the default value for all skills that use the GameEngine
     * interface. "REPLACE_ENQUEUED": Replace all speech in the queue with this
     * speech. Do not interrupt Alexa's current speech.
     *
     * @return
     */
    public AlexaResponseBuilder outputSpeech(String text, SpeechType type,
            PlayBehavior behavior) {
        response.response.outputSpeech = createOutputSpeech(text, type, behavior);
        return this;
    }

    /**
     * The object containing the outputSpeech to use if a re-prompt is
     * necessary.
     *
     * This is used if your service keeps the session open after sending the
     * response (shouldEndSession is false), but the user does not respond with
     * anything that maps to an intent defined in your voice interface while the
     * microphone is open. The user has a few seconds to respond to the reprompt
     * before Alexa closes the session.
     *
     * If this is not set, the user is not re-prompted.
     *
     * @param text A string containing the speech to render to the user.
     * @param type An enum containing the type of output speech to render. Valid
     * types are:
     *
     * "PlainText": Indicates that the output speech is defined as plain text.
     * "SSML": Indicates that the output speech is text marked up with SSML.
     *
     * @param behavior An enum that determines the queuing and playback of this
     * output speech. Valid values are:
     *
     * "ENQUEUE": Add this speech to the end of the queue. Do not interrupt
     * Alexa's current speech. This is the default value for all skills that do
     * not use the GameEngine interface. "REPLACE_ALL": Immediately begin
     * playback of this speech, and replace any current and enqueued speech.
     * This is the default value for all skills that use the GameEngine
     * interface. "REPLACE_ENQUEUED": Replace all speech in the queue with this
     * speech. Do not interrupt Alexa's current speech.
     *
     * @return
     */
    public AlexaResponseBuilder withReprompt(String text, SpeechType type,
            PlayBehavior behavior) {

        response.response.reprompt = new Reprompt();
        response.response.reprompt.outputSpeech
                = createOutputSpeech(text, type, behavior);
        response.response.shouldEndSession = false;
        return this;
    }

    private OutputSpeech createOutputSpeech(String text, SpeechType type,
            PlayBehavior behavior) {
        OutputSpeech outputSpeech = new OutputSpeech();
        outputSpeech.playBehavior = behavior;

        if (type == SpeechType.SSML) {
            outputSpeech.ssml = text;
            outputSpeech.type = type;
        } else {
            outputSpeech.text = text;
        }
        return outputSpeech;
    }

    /**
     * A card that contains a title and plain text content.
     *
     * @param title A string containing the title of the card.
     * @param text A string containing the contents of a Simple card
     * @return
     */
    public AlexaResponseBuilder withSimpleCard(String title, String text) {
        Card card = new Card();
        card.content = text;
        card.title = title;
        response.response.card = card;
        return this;
    }

    /**
     * A card that contains a title, text content, and an image to display.
     *
     * You can provide images in the following formats:
     *
     * JPEG PNG
     *
     * Images should be less than 500 KB in size.
     *
     * When including an image, you provide two URLs: a smaller resolution image
     * and a larger resolution image. The different sizes are used when
     * displaying cards on different sized screens. f you only provide one URL,
     * the Alexa app uses that image regardless of the screen size where it is
     * displayed. This may cause your cards to display poorly. For example, if
     * you only provide smallImageUrl, the Alexa app must scale up that image
     * when displaying on larger screens, which could degrade the quality of the
     * image.
     *
     * The Alexa app loads the images from the provided URL at runtime. The
     * image files you provide must be hosted on an HTTPS endpoint
     *
     * @param title A string containing the title of the card.
     * @param text A string containing the contents of a Standard card
     * @param smallImageUrl Recommended Size (in pixels) 720w x 480h
     * @param largeImageUrl Recommended Size (in pixels) 1200w x 800h
     * @return
     */
    public AlexaResponseBuilder withStandardCard(String title, String text,
            String smallImageUrl, String largeImageUrl) {
        Card card = new Card();
        card.text = text;
        card.title = title;
        card.type = CardType.Standard;
        Image image = new Image();
        image.largeImageUrl = largeImageUrl;
        image.smallImageUrl = smallImageUrl;
        card.image = image;
        response.response.card = card;
        return this;
    }

    /**
     * When returning your response, you can include data you need to persist
     * during the session in the sessionAttributes property. The attributes you
     * provide are then passed back to your skill on the next request.
     *
     * @param sessionAttributeCollector
     * @return AlexaResponseBuilder
     */
    public AlexaResponseBuilder withSessionAttributes(SessionAttributeCollector sessionAttributeCollector) {
        response.sessionAttributes = new HashMap<>(sessionAttributeCollector
                .getSessionAttributeCollection());
        return this;
    }

    /**
     * A card that displays a link to an authorisation URI that the user can use
     * to link their Alexa account with a user in another system. The card
     * includes your skill icon and name. The "Link Account" button opens the
     * authorization URI you configure in the developer console when setting up
     * account linking for your skill.
     *
     * @return
     */
    public AlexaResponseBuilder withLinkAccountCard() {
        Card card = new Card();
        card.type = CardType.LinkAccount;
        response.response.card = card;
        return this;

    }

    public AlexaResponse build() {
        return response;
    }
}
