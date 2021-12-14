package com.hefesto.Forum.infra;

import com.hefesto.Forum.global.UsuarioUtils;
import com.hefesto.Forum.model.Usuario;
import com.hefesto.Forum.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.findByName(username);
        UsuarioDetails usuarioDetails = new UsuarioDetails(usuario);
        UsuarioUtils.getInstance().setUsuarioDetails(usuarioDetails);
        return usuarioDetails;
    }
}
