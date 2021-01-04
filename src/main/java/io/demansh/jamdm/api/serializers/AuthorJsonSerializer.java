package io.demansh.jamdm.api.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import io.demansh.jamdm.domain.Author;
import io.demansh.jamdm.domain.Song;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class AuthorJsonSerializer extends JsonSerializer<Author> {

    @Override
    public void serialize(
            Author author,
            JsonGenerator jsonGenerator,
            SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("name", author.name());
        jsonGenerator.writeStringField("uri",
                String.format("/search?author=%s", author.pathName()));
        jsonGenerator.writeEndObject();
    }
}
