package com.uninter.trabalho.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uninter.trabalho.entidade.EntidadeIMC;


@Repository
public interface RepositorioIMC extends JpaRepository<EntidadeIMC, Long> {

}
