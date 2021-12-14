package com.hefesto.Forum.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hefesto.Forum.adapter.TopicoDTOAdapter;
import com.hefesto.Forum.adapter.TopicoDetalhadoAdapter;
import com.hefesto.Forum.dto.TopicoDTO;
import com.hefesto.Forum.form.TopicoAtualizaForm;
import com.hefesto.Forum.form.TopicoForm;
import com.hefesto.Forum.model.Curso;
import com.hefesto.Forum.model.Topico;
import com.hefesto.Forum.service.CursoService;
import com.hefesto.Forum.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/topicos")
public class TopicoRest {

    @Autowired
    private TopicoService topicoService;
    @Autowired
    private CursoService cursoService;

    // Pageable manual
//    @RequestMapping
//    @ResponseBody
//    private Page<TopicoDTO> listaTodos(
//            @RequestParam(name = "curso", required = false) String nomeCurso,
//            @RequestParam(name = "pagina") int pagina,
//            @RequestParam(name = "qtd") int qtd,
//            @RequestParam(name = "ordenacao") String ordenacao){
//
//        Pageable paginacao = PageRequest.of(pagina, qtd, Sort.Direction.DESC, ordenacao);
//
//        Page<Topico> pageTopicos = topicoService.listaTodos(nomeCurso, paginacao);
//        return TopicoDTO.converter(pageTopicos);
//    }

    // Pageable do spring. Precisa habilitar no application
    @RequestMapping
    @Cacheable(value = "listaTopicos")
    private Page<TopicoDTO> listaTodos(
            @RequestParam(name = "curso", required = false) String nomeCurso,
            Pageable paginacao){

        Page<Topico> pageTopicos = topicoService.listaTodos(nomeCurso, paginacao);
        return TopicoDTO.converter(pageTopicos);
    }

    @RequestMapping(method = RequestMethod.POST)
    @CacheEvict(value = "listaTopicos", allEntries = true)
    private ResponseEntity insereTopico(@RequestBody @Valid TopicoForm topicoForm, UriComponentsBuilder uriBuilder){
        Curso curso = cursoService.findByName(topicoForm.getCursoNome());
        Topico topico = topicoForm.toTopico(curso);
        topicoService.save(topico);
        URI uri = uriBuilder.path("/api/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDTO(topico));
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    private ResponseEntity bucaPorId(@PathVariable Long id){
        Optional<Topico> topicoBuscado = topicoService.findById(id);
        if(!topicoBuscado.isPresent())
            return ResponseEntity.notFound().build();
        Gson gson = new GsonBuilder().registerTypeAdapter(Topico.class, new TopicoDTOAdapter()).create();
        return ResponseEntity.ok().body(gson.toJson(topicoBuscado.get()));
    }

    @RequestMapping(path = "detalhar/{id}", method = RequestMethod.GET)
    private ResponseEntity bucaPorIdDetalhado(@PathVariable Long id){
        Optional<Topico> topicoBuscado = topicoService.findById(id);
        if(!topicoBuscado.isPresent())
            return ResponseEntity.notFound().build();
        Gson gson = new GsonBuilder().registerTypeAdapter(Topico.class, new TopicoDetalhadoAdapter()).create();
        return ResponseEntity.ok().body(gson.toJson(topicoBuscado.get()));
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    @CacheEvict(value = "listaTopicos", allEntries = true)
    private ResponseEntity atualiza(@PathVariable Long id, @RequestBody @Valid TopicoAtualizaForm topicoForm){
        Optional<Topico> topicoBuscado = topicoService.findById(id);
        if(!topicoBuscado.isPresent())
            return ResponseEntity.notFound().build();
        Topico topico = topicoBuscado.get();
        topicoForm.atualiza(topico);
        topicoService.save(topico);
        return ResponseEntity.ok().body(new TopicoDTO(topico));
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @CacheEvict(value = "listaTopicos", allEntries = true)
    private ResponseEntity deleta(@PathVariable Long id){
        Optional<Topico> topicoBuscado = topicoService.findById(id);
        if(!topicoBuscado.isPresent())
            return ResponseEntity.notFound().build();
        topicoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
