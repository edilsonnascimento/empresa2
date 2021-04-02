package com.avaliacao.jpa.empresa2;

import com.avaliacao.jpa.empresa2.entity.Cargo;
import com.avaliacao.jpa.empresa2.service.FuncionarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Empresa2ApplicationTests {

    @Autowired
    private FuncionarioService funcionarioService;


    @Test
    void contextLoads() {
    }

    @Test
    void testSalvarFuncioanrio(){
        Cargo cargo = new Cargo();
        cargo.setNomeCargo("Funcionario");
        cargo.setId(1l);

    }

}
