package com.picpay.picpay.service;


import com.picpay.picpay.DTO.request.UsuarioRequest;
import com.picpay.picpay.models.Usuario;
import com.picpay.picpay.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(UsuarioRequest request) {
        if (usuarioRepository.existsByCpf(request.getCpf())) {
            throw new IllegalArgumentException("CPF já cadastrado");
        }

        if (usuarioRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("E-mail já cadastrado");
        }

        Usuario usuario = new Usuario();
        usuario.setNomeCompleto(request.getNomeCompleto());
        usuario.setCpf(request.getCpf());
        usuario.setEmail(request.getEmail());
        usuario.setSenha(request.getSenha());
        usuario.setLojista(request.getLojista());
        usuario.setSaldo(request.getSaldoInicial() != null ? request.getSaldoInicial() : 0.0);

        return usuarioRepository.save(usuario);
    }
}
