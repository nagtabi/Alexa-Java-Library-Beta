package request;

import com.google.gson.annotations.SerializedName;

/**
 * Bug! In my code? Bitch! That is a feature.
 *
 * @author G
 */
 public class SlotImpl implements Slot {

  
    String name;
    String value;
    ConfirmationStatus confirmationStatus;
    String source;
    @SerializedName("resolutions")
    Resolution resolution;

    @Override
    public String getName() {
    return name;
    }
    @Override
    public String getStringValue() {
       return value;
    }

    @Override
    public ConfirmationStatus getConfirmationStatus() {
        return confirmationStatus;
    }

    @Override
    public String getSource() {
       return source;
    }

    @Override
    public int getIntegerValue() throws SlotNullValueException, SlotParseException {
        checkNullValue();
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new SlotParseException(e.getMessage(), e);
        }
        
    }

    @Override
    public long getLongValue() throws SlotNullValueException, SlotParseException {
         checkNullValue();
         try{
             return Long.parseLong(value);
         }catch(NumberFormatException ex){
             throw new SlotParseException(ex.getMessage(), ex);
         }
    }

    @Override
    public double getDoubleValue() throws SlotNullValueException, SlotParseException {
      checkNullValue();
        try{
             return Double.parseDouble(value);
         }catch(NumberFormatException ex){
             throw new SlotParseException(ex.getMessage(), ex);
         }
    }

    @Override
    public float getFloatValue() throws SlotNullValueException, SlotParseException {
        checkNullValue();
        try{
             return Float.parseFloat(value);
         }catch(NumberFormatException ex){
             throw new SlotParseException(ex.getMessage(), ex);
         }
    }

    @Override
    public byte getByteValue() throws SlotNullValueException, SlotParseException {
      checkNullValue();
        try{
             return Byte.parseByte(value);
         }catch(NumberFormatException ex){
             throw new SlotParseException(ex.getMessage(), ex);
         }
    }

    @Override
    public boolean getBooleanValue() throws SlotNullValueException {
       checkNullValue();
             return Boolean.parseBoolean(value);
         
    }

    @Override
    public short getShortValue() throws SlotNullValueException, SlotParseException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <T extends CustomSlotType> T getCustomSlotTypeValue() throws SlotNullValueException, SlotParseException {
        return null;
    }
    
    private void checkNullValue(){
        if (value==null) {
            throw new SlotNullValueException();
        }
    }

    @Override
    public <T extends ResolutionPerAuthority> T getResolutionPerAuthority() {
         return (T) resolution.resolutionsPerAuthority;
    }

    
    
    

   
    

}
