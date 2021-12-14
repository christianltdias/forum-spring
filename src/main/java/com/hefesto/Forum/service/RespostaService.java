package com.hefesto.Forum.service;

import com.hefesto.Forum.model.Resposta;
import com.hefesto.Forum.repository.RespostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespostaService {

    @Autowired
    private RespostaRepository respostaRepository;

    public List<Resposta> findAll() {
        return respostaRepository.findAll();
    }

}
