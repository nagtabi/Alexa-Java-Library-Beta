
package factories;

import interfaces.RequestIntent;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Bug!
 * In my code?
 * Bitch! That is a feature.
 * @author G
 */
public class RequestIntentFactory {

    private RequestIntentFactory() {
    }
    
    public static <T extends RequestIntent> T createRequestIntent(String className) {
            Class c;
        try {
            c = Class.forName(className);
            return (T)createRequestIntent(c);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RequestIntentFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new RequestIntentCreateException("InstantiationException", ex);
        }
        

    }
    
    public static <T extends RequestIntent> T createRequestIntent(Class<? extends RequestIntent> clazz){
        try {
            return (T)clazz.newInstance();
            // try {
            // return (T)clazz.getConstructor().newInstance(new Object[]{});
            //} catch ( NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            //   Logger.getLogger(RequestIntentFactory.class.getName()).log(Level.SEVERE, null, ex);
            //  throw new RequestIntentCreateException("InstantiationException", ex);
            // }
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(RequestIntentFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new RequestIntentCreateException("InstantiationException", ex);
        }
    }
    

}
