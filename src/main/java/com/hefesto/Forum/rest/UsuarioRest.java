package com.hefesto.Forum.rest;

import com.hefesto.Forum.dto.UsuarioDTO;
import com.hefesto.Forum.form.UsuarioCreateForm;
import com.hefesto.Forum.model.Usuario;
import com.hefesto.Forum.service.UsuarioService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioRest {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping
    private List<Usuario> lista(){
        return usuarioService.findAll();
    }

    @PostMapping
    private ResponseEntity cadastraUsuario(@Valid @RequestBody UsuarioCreateForm usuarioForm, UriComponentsBuilder uriBuilder){
        Usuario usuario = usuarioForm.toUsuario();
        usuarioService.salva(usuario);
        URI uri = uriBuilder.path("/api/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(usuario);
    }
}
