package com.picpay.picpay.controllers;


import com.picpay.picpay.DTO.request.UsuarioRequest;
import com.picpay.picpay.DTO.response.UsuarioResponse;
import com.picpay.picpay.models.Usuario;

import com.picpay.picpay.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponse> criarUsuario(@RequestBody UsuarioRequest request) {
        Usuario usuario = usuarioService.criarUsuario(request);
        UsuarioResponse response = new UsuarioResponse(
                usuario.getId(),
                usuario.getNomeCompleto(),
                usuario.getCpf(),
                usuario.getEmail(),
                usuario.getLojista(),
                usuario.getSaldo()
        );
        return ResponseEntity.ok(response);
    }
}
