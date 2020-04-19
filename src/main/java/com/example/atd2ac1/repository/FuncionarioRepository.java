package com.example.atd2ac1.repository;

import com.example.atd2ac1.entidade.Funcionario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository <Funcionario, Integer> {

}