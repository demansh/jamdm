package io.demansh.jamdm.api.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import io.demansh.jamdm.api.resources.Songs;
import io.demansh.jamdm.domain.Song;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class SongsJsonSerializer extends JsonSerializer<Songs> {

    @Override
    public void serialize(
            Songs songs,
            JsonGenerator jsonGenerator,
            SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeArrayFieldStart("content");
        for (Song song : songs.content()) {
            jsonGenerator.writeObject(song);
        }
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }
}
