package com.hefesto.Forum.global;

import com.hefesto.Forum.infra.UsuarioDetails;
import org.springframework.security.core.context.SecurityContextHolder;

import static java.util.Objects.isNull;

public class UsuarioUtils {

    private UsuarioDetails usuarioDetails;

    private static UsuarioUtils instance;

    public static UsuarioUtils getInstance(){
        if(isNull(instance)){
            instance = new UsuarioUtils();
        }
        return instance;
    }

    public UsuarioUtils() {
        if (
                SecurityContextHolder.getContext() != null &&
                        SecurityContextHolder.getContext().getAuthentication() != null &&
                        SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UsuarioDetails) {
            usuarioDetails = (UsuarioDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }
    }

    public UsuarioDetails getUsuarioDetails() {
        return usuarioDetails;
    }

    public void setUsuarioDetails(UsuarioDetails usuarioDetails) {
        this.usuarioDetails = usuarioDetails;
    }
}
