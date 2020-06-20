package Classes;

import java.util.ArrayList;
import java.util.List;

public class Calculos {
    private List<Pessoa> pessoas;

    public Calculos() {
        this.pessoas = new ArrayList<Pessoa>();
    }

    public boolean inserir(Pessoa pessoa) {
        pessoa.setCodigo(this.pessoas.size() + 1);
        return this.pessoas.add(pessoa);
    }

    private double calcularIMC(int posicao) {
        Pessoa pessoa = pessoas.get(posicao);
        return pessoa.getPeso() / Math.pow(pessoa.getAltura(), 2);
    }

    public String imc(int posicao) {
        String resposta = "";
        double calculo = calcularIMC(posicao);

        switch (pessoas.get(posicao).getSexo()) {
            case MASCULINO:
                if (calculo < 20.7) {
                    resposta = "Abaixo do peso (" + calculo + ")";
                } else if (calculo > 26.4) {
                    resposta = "Obeso (" + calculo + ")";
                } else {
                    resposta = "Ideal (" + calculo + ")";
                }
                break;

            case FEMININO:
                if (calculo < 19.1) {
                    resposta = "Abaixo do peso (" + calculo + ")";
                } else if (calculo > 25.8) {
                    resposta = "Obeso (" + calculo + ")";
                } else {
                    resposta = "Ideal (" + calculo + ")";
                }
                break;

            default:
                resposta = "Nao foi possivel calcular";
                break;
        }
        return resposta;
    }

    public double pesoIdeal(int posicao) {
        Pessoa pessoa = pessoas.get(posicao);
        return (pessoa.getAlturaCM() - 100) - (pessoa.getAlturaCM() - 150) / pessoa.getK();
    }

    public double taxaDeGorduraCorporal(int posicao) {
        Pessoa pessoa = pessoas.get(posicao);
        return (1.2 * calcularIMC(posicao)) - (10.8 * pessoa.getS()) + (0.23 * pessoa.getIdade()) - 5.4;
    }

    public List<Pessoa> listarTodasAsPessoas() {
        return this.pessoas;
    }
}
