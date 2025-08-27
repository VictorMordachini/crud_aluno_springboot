package com.senai.crud_aluno_springboot.controller;

import com.senai.crud_aluno_springboot.model.Aluno;
import com.senai.crud_aluno_springboot.model.AlunoRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepositoy alunoRepositorio;

    //Método para criar um aluno
    @PostMapping
    public Aluno createAluno(@RequestBody Aluno aluno) {
        return alunoRepositorio.save(aluno);
    }

    //Método para listar todos os alunos
    @GetMapping
    public List<Aluno> getAllAlunos() {
        return alunoRepositorio.findAll();
    }

    //Método para buscar um aluno por ID
    @GetMapping("/{id}")
    public Aluno getAlunoById(@PathVariable String id) {
        return alunoRepositorio.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }

    //Método para atualizar um aluno
    @PutMapping("/{id}")
    public Aluno updateAluno(@PathVariable String id, @RequestBody Aluno alunoDetails) {
        Aluno aluno = alunoRepositorio.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        //aluno.setId(alunoDetails.getId());
        aluno.setNome(alunoDetails.getNome());
        aluno.setEmail(alunoDetails.getEmail());
        aluno.setIdAcesso(alunoDetails.getIdAcesso());
        aluno.setCpf(alunoDetails.getCpf());
        aluno.setCurso(alunoDetails.getCurso());

        return alunoRepositorio.save(aluno);

    }

    //Método para deletar um aluno
    @DeleteMapping("/{id}")
    public void deleteAluno(@PathVariable String id) {
        alunoRepositorio.deleteById(id);
    }
}
