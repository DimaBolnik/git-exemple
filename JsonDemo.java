package Jakcon;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonDemo {
    public static void main( String[] args ) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        FileWriter writer = new FileWriter("jsonSerial");

        Cat cat = new Cat();
        cat.name = "Pupsick";
        cat.age = 5;
        cat.weight = 10;
        cat.properties = new HashMap<>();
        cat.properties.put("Hello", "Vasya");
        cat.properties.put("Good", "byi");
        mapper.writerWithDefaultPrettyPrinter().writeValue(writer, cat);
        String str = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cat);
        System.out.println(str);


//
//
//
//        Cat cat = mapper.readValue(new File("json"), Cat.class);
//        System.out.println(cat.toString());

    }
}
//@JsonIgnoreType
//class Animal {
//   static String str = "Garf";
//}
class Views {
    public interface Public { }
    public interface Internal extends Public { }
}


class CustomDateSerializer extends JsonSerializer<Integer> {

    @Override
    public void serialize(Integer value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(String.valueOf(value));
    }
}
