package com.hefesto.Forum.adapter;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.hefesto.Forum.model.Topico;

import java.lang.reflect.Type;

public class TopicoDetalhadoAdapter extends TopicoDTOAdapter{
    @Override
    public JsonElement serialize(Topico topico, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject json = (JsonObject) super.serialize(topico, type, jsonSerializationContext);
        json.addProperty("status", topico.getStatus().name());
        json.addProperty("autor", topico.getAutor().getNome());
        json.addProperty("curso", topico.getCurso().getNome());
        JsonArray array = new JsonArray();
        topico.getRespostas().stream().forEach(resposta -> {
            array.add(resposta.getMensagem());
        });
        json.add("respotas", array);
        return json;
    }
}
