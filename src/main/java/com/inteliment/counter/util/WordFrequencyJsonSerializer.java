package com.inteliment.counter.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.inteliment.counter.model.WordFrequency;

/**
 * Custom json serializer for WordFrequency
 * 
 * @see WordFrequency
 * @author Tharaka Manawardhana
 *
 */
public class WordFrequencyJsonSerializer extends StdSerializer<WordFrequency> {
     
    public WordFrequencyJsonSerializer() {
        this(null);
    }
 
    public WordFrequencyJsonSerializer(Class<WordFrequency> t) {
        super(t);
    }
 
    @Override
    public void serialize(WordFrequency wf, JsonGenerator jsonGenerator, SerializerProvider serializer) {
        try {
			jsonGenerator.writeStartObject();
	        jsonGenerator.writeNumberField(wf.getWord(), wf.getCount());
	        jsonGenerator.writeEndObject();
        } catch (IOException e) {
			e.printStackTrace();
		}

    }
}