
package utils;


import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Bug!
 * In my code?
 * Bitch! That is a feature.
 * @author G
 */
public class DateJsonSerializier extends TypeAdapter<LocalDateTime> {

    private DateTimeFormatter dateFormatter;

    public DateJsonSerializier() {
    dateFormatter=DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ss");
    }
    
    
//    @Override
//    public JsonElement serialize(LocalDateTime date, Type type, JsonSerializationContext jsc) {
//             
//             return new JsonPrimitive(formattedText);
//    }
//
//    @Override
//    public LocalDateTime deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
//      String text=  je.getAsString();
//        System.out.println("date:"+text);
//        LocalDateTime date=LocalDateTime.parse(text, dateFormatter);
//        return date;
//    }

    @Override
    public void write(JsonWriter writer, LocalDateTime date) throws IOException {
        writer.value(date.format(dateFormatter));
    }

    @Override
    public LocalDateTime read(JsonReader reader) throws IOException {
        String text=  reader.nextString();
        text=text.replace("T", "");
        text=text.replace("Z", "");
       // System.out.println("date:"+text);
        LocalDateTime date=LocalDateTime.parse(text, dateFormatter);
        return date;
    }

}
