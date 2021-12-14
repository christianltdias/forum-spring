package com.hefesto.Forum.service;

import com.hefesto.Forum.model.Curso;
import com.hefesto.Forum.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    public Curso findByName(String nome) {
        return cursoRepository.findByNome(nome);
    }

}
