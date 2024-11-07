package com.picpay.picpay.service;


import com.picpay.picpay.DTO.response.TransferenciaResponse;
import com.picpay.picpay.models.Transacao;
import com.picpay.picpay.models.Usuario;
import com.picpay.picpay.repositorys.TransacaoRepository;
import com.picpay.picpay.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferenciaService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Transactional
    public TransferenciaResponse transferir(Long payerId, Long payeeId, Double valor) {
        Usuario payer = usuarioRepository.findById(payerId)
                .orElseThrow(() -> new IllegalArgumentException("Pagador não encontrado"));
        Usuario payee = usuarioRepository.findById(payeeId)
                .orElseThrow(() -> new IllegalArgumentException("Recebedor não encontrado"));

        if (payer.getLojista()) throw new IllegalArgumentException("Lojistas não podem enviar dinheiro");
        if (payer.getSaldo() < valor) throw new IllegalArgumentException("Saldo insuficiente");

        payer.setSaldo(payer.getSaldo() - valor);
        payee.setSaldo(payee.getSaldo() + valor);

        Transacao transacao = new Transacao(null, valor, payer, payee);
        transacaoRepository.save(transacao);

        usuarioRepository.save(payer);
        usuarioRepository.save(payee);
        return new TransferenciaResponse(
                "sucesso",
                "Transferência realizada com sucesso!",
                payer.getNomeCompleto(),
                payee.getNomeCompleto(),
                valor
        );
    }
}
