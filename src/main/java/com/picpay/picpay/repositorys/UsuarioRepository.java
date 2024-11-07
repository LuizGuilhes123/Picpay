package com.picpay.picpay.repositorys;


import com.picpay.picpay.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
}
