package com.avaliacao.jpa.empresa2.repository;

import com.avaliacao.jpa.empresa2.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    List<Funcionario> findAllByOrderByNome();

    @Query("SELECT count(f.id) FROM Funcionario f")
    Integer countTodosFuncionarios();
}
