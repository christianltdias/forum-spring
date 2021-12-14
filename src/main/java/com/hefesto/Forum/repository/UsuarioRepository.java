package com.hefesto.Forum.repository;

import com.hefesto.Forum.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByLogin(String nome);
    Usuario findByLoginAndSenha(String login, String senha);
}
