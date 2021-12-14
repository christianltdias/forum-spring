package com.hefesto.Forum.service;

import com.hefesto.Forum.model.Usuario;
import com.hefesto.Forum.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id){
        Optional<Usuario> usuarioBuscado = usuarioRepository.findById(id);
        if(!usuarioBuscado.isPresent()) return null;
        return  usuarioBuscado.get();
    }

    public Usuario findByName(String nome){
        return usuarioRepository.findByLogin(nome);
    }

    public void salva(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public Usuario autentica(String login, String senha){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return usuarioRepository.findByLoginAndSenha(login, encoder.encode(senha));
    }
}
