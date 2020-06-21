package Testes;

import Classes.Pessoa;
import Classes.Repositorio;
import Enums.Sexo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RepositorioTest {
    private Pessoa pessoa;

    @BeforeEach
    void setUp() {
        pessoa = new Pessoa("Gabriela", 22, 53, 1.54, Sexo.FEMININO);
    }

    @Test
    void verificaSeOArquivoFoiSalvo() {
        List<Pessoa> pessoas = new ArrayList<>();
        List<Pessoa> aux = new ArrayList<>();
        pessoas.add(pessoa);

        try {
            Repositorio.salvar(pessoas);
            aux = Repositorio.carregar();
            Pessoa ultimaPessoa = aux.get(aux.size() - 1);
            assertEquals(ultimaPessoa.getNome(), pessoa.getNome());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}