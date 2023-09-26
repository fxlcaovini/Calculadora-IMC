package com.uninter.trabalho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uninter.trabalho.entidade.EntidadeIMC;
import com.uninter.trabalho.repositorio.RepositorioIMC;

@Service
public class IMCService {

    @Autowired
    public RepositorioIMC repositorioimc;

    public List<EntidadeIMC> buscarTodosIMC() {
        return repositorioimc.findAll();
    }

    // Outros métodos para calcular o IMC, salvar dados, etc.
}
