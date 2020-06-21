package Utilidades;

import Classes.Pessoa;
import Enums.Sexo;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Repositorio {

    public static void salvar(List<Pessoa> pessoas) throws IOException {
        BufferedWriter arquivo = new BufferedWriter(new FileWriter("ListaDePessoas.txt"));
        String dados = "";

        for (Pessoa pessoa: pessoas) {
            dados += pessoa.getCodigo() + "," +
                    pessoa.getNome() + "," +
                    pessoa.getIdade() + "," +
                    pessoa.getSexo() + "," +
                    pessoa.getPeso() + "," +
                    pessoa.getAltura() + "\n";
        }

        arquivo.append(dados);
        arquivo.close();
    }

    public static List<Pessoa> carregar() throws IOException {
        BufferedReader arquivo = new BufferedReader(new FileReader("ListaDePessoas.txt"));
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        String linha = arquivo.readLine();

        do {
            String [] aux = linha.split(",");
            Pessoa pessoa = new Pessoa(
                    aux[1],
                    Integer.parseInt(aux[2]),
                    Double.parseDouble(aux[4]),
                    Double.parseDouble(aux[5]),
                    Sexo.getSexo(aux[3])
            );

            pessoa.setCodigo(Integer.parseInt(aux[0]));
            pessoas.add(pessoa);
            linha = arquivo.readLine();

        } while (linha != null);
        arquivo.close();

        return pessoas;
    }

}
