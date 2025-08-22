package com.senai.crud_aluno_springboot.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepositoy extends JpaRepository <Aluno, String> {
}
