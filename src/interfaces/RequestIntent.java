package interfaces;

import reponse.AlexaResponse;
import request.AlexaRequest;

/**
 *
 * @author --G--
 */
public interface RequestIntent {
   AlexaResponse handleIntent(AlexaRequest request);
}
