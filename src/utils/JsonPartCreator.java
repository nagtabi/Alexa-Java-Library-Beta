package utils;

/**
 * Bug! In my code? Bitch! That is a feature.
 *
 * @author G
 */
public class JsonPartCreator {

    private static final char OPEN_BRACE = '{';
    private static final char CLOSE_BRACE = '}';

    private JsonPartCreator() {
    }

    public static String getJsonPartByTagName(final String jsonText, String tagName) {

        int openBraceQuntity = 0;
        int closeBraceQuantity = -1;
        StringBuilder builder = new StringBuilder(jsonText);
        int startIndex = builder.indexOf(tagName);

        int index = startIndex;
        int lenght = 0;
        while (openBraceQuntity != closeBraceQuantity && index < builder.length()) {
            if (builder.charAt(index) == OPEN_BRACE) {
                if (openBraceQuntity == 0) {
                    closeBraceQuantity = 0;
                    startIndex += lenght;
                    lenght = 0;
                }
                openBraceQuntity++;
            }
            if (builder.charAt(index) == CLOSE_BRACE) {
                closeBraceQuantity++;
            }
            index++;
            lenght++;

        }

        return builder.substring(startIndex, (lenght + startIndex));

    }

}
