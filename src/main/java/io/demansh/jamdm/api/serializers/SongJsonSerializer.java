package io.demansh.jamdm.api.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import io.demansh.jamdm.domain.Song;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class SongJsonSerializer extends JsonSerializer<Song> {

    @Override
    public void serialize(
            Song song,
            JsonGenerator jsonGenerator,
            SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("html",
                String.format("/song?author=%s&song=%s&id=%s",
                        song.author().pathName(),
                        song.pathName(),
                        song.id()));
        jsonGenerator.writeStringField("name", song.name());
        jsonGenerator.writeObjectField("author", song.author());
        jsonGenerator.writeEndObject();
    }
}
