package Testes;

import Classes.Calculos;
import Classes.Pessoa;
import Classes.Repositorio;
import Enums.Sexo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculosTest {
    private Pessoa pessoa;
    private Calculos calculos;

    @BeforeEach
    void setUp() {
        pessoa = new Pessoa("Gabriela", 22, 53, 1.54, Sexo.FEMININO);
        calculos = new Calculos();
    }

    @Test
    void inserir() {
        calculos.inserir(pessoa);
        assertEquals(calculos.ultimaPessoaCadastrada(), pessoa);
    }

    @Test
    void imc() {
       String resultado = calculos.imc(0);
       assertEquals("Ideal (22.34778208804183)", resultado);
    }

    @Test
    void pesoIdeal() {
        double resultado = calculos.pesoIdeal(0);
        assertEquals(52.0, resultado);
    }

    @Test
    void taxaDeGorduraCorporal() {
        double resultado = calculos.taxaDeGorduraCorporal(0);
        assertEquals(26.477338505650195, resultado);
    }
}