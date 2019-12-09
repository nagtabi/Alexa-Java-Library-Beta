
package interfaces;

import reponse.AlexaResponse;
import request.AlexaRequest;

/**
 *
 * @author G
 */

public interface IntentHandler {

   public  AlexaResponse createResponse(AlexaRequest alexaRequest);

}
