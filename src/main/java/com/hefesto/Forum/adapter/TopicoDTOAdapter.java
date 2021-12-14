package com.hefesto.Forum.adapter;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.hefesto.Forum.model.Topico;

import java.lang.reflect.Type;
import java.time.format.DateTimeFormatter;

public class TopicoDTOAdapter implements JsonSerializer<Topico> {

    @Override
    public JsonElement serialize(Topico topico, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject json = new JsonObject();
        json.addProperty("titulo", topico.getTitulo());
        json.addProperty("mensagem", topico.getMensagem());
        String dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(topico.getDataCriacao());
        json.addProperty("dataCriacao", dataFormatada);
        return json;
    }
}
