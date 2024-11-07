package com.picpay.picpay.repositorys;


import com.picpay.picpay.models.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {}
