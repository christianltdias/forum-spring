package com.hefesto.Forum.service;

import com.hefesto.Forum.model.Topico;
import com.hefesto.Forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.nonNull;
import static org.apache.logging.log4j.util.Strings.isEmpty;

@Service
public class TopicoService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private TopicoRepository topicoRepository;

    public Page<Topico> listaTodos(String nomeCurso, Pageable pageable){
        if(nonNull(nomeCurso) && !isEmpty(nomeCurso)){
            return topicoRepository.findByCursoNome(nomeCurso, pageable);
        }else{
            return topicoRepository.findAll(pageable);
        }
    }

//    public List<Topico> listaTodos(String nomeCurso) {
//        String sql = "select new Topico(t.titulo, t.mensagem, t.curso) from Topico t";
//        String where = " ";
//        List<Object> parametros = new ArrayList<>();
//        int qtdParametros = 0;
//        if(nonNull(nomeCurso) && !isEmpty(nomeCurso)){
//            where = where.concat("where t.curso.nome = ?0");
//            qtdParametros++;
//            parametros.add(nomeCurso);
//        }
//        String orderBy = " order by t.titulo desc";
//
//        TypedQuery query = entityManager.createQuery(sql + where + orderBy, Topico.class);
//        if(qtdParametros > 0){
//            for(int i= 0;i<qtdParametros;i++)
//                query.setParameter(i, parametros.get(i));
//        }
//
//        return query.getResultList();
//    }

    public void save(Topico topico){
        topicoRepository.save(topico);
    }

    public Optional<Topico> findById(Long id){
        return topicoRepository.findById(id);
    }

    public void delete(Long id){ topicoRepository.deleteById(id);}

}
