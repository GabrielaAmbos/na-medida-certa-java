import Classes.Calculos;
import Classes.Pessoa;
import Enums.Sexo;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);
    private static Calculos calculos = new Calculos();

    public static void main(String[] args) {
        int escolha;

        do {
            System.out.println(" ---- Menu principal ---- ");
            System.out.println("[1] Cadastrar pessoa \n" +
                    "[2] Calcular IMC \n" +
                    "[3] Calcular Peso Ideal \n" +
                    "[4] Calcular Taxa de Gordura Corporal \n" +
                    "[5] Listar todas as pessoas cadastradas\n" +
                    "[0] Sair");
            escolha = in.nextInt();
            in.nextLine();

            switch (escolha) {
                case 1:
                    inserirPessoa();
                    break;

                case 2:
                    calcularImc();
                    break;

                case 3:
                    calcularPesoIdeal();
                    break;

                case 4:
                    calcularTaxaGorduraCorporal();
                    break;

                case 5:
                    listarTodasPessoasCadastradas();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!!!!");
            }
        } while (escolha != 0);
    }

    private static void listarTodasPessoasCadastradas() {
        System.out.println(" ---- Listar todas as pessoas ---- ");

        List<Pessoa> pessoas = calculos.listarTodasAsPessoas();

        if(pessoas.isEmpty()) {
            System.out.println("Não há pessoas cadastradas! \n");

        } else {
            for (int i = 0; i < pessoas.size(); i++) {
                System.out.println(pessoas.get(i).toString());
                System.out.println("IMC: " + calculos.imc(i));
                System.out.println("Peso ideal: " + calculos.pesoIdeal(i));
                System.out.println("Taxa de Gordura corporal: " + calculos.taxaDeGorduraCorporal(i));
                System.out.println("\n");
            }
        }
    }

    private static void calcularTaxaGorduraCorporal() {
        System.out.println(" ---- Calcular Taxa de Gordura Corporal ---- ");

        int posicao = escolherPessoa();

        if(posicao >= 0) {
            double resultado = calculos.taxaDeGorduraCorporal(posicao);
            System.out.println("Taxa de gordura corporal: " + resultado + "%");
        }
    }

    private static void calcularPesoIdeal() {
        System.out.println(" ---- Calcular Peso Ideal ---- ");

        int posicao = escolherPessoa();

        if(posicao >= 0) {
            double resultado = calculos.pesoIdeal(posicao);
            System.out.println("Peso ideal: " + resultado + "kg");
        }
    }

    private static void calcularImc() {
        System.out.println(" ---- Calcular IMC ---- ");

        int posicao = escolherPessoa();

        if(posicao >= 0) {
            System.out.println("IMC: " + calculos.imc(posicao));
        }
    }

    private static int escolherPessoa() {
        List<Pessoa> pessoas = calculos.listarTodasAsPessoas();

        if(pessoas.isEmpty()) {
            System.out.println("Não há pessoas cadastradas! \n");
            return -1;

        } else {
            System.out.println("Escolha uma pessoa: ");
            for (int i = 0; i < pessoas.size(); i++) {
                System.out.println("[" + i + "] " + pessoas.get(i).getNome());
            }
            int posicao = in.nextInt();
            in.nextLine();

            return posicao;
        }
    }

    private static void inserirPessoa() {
        System.out.println(" ---- Cadastrar nova pessoa ---- ");

        System.out.print("Nome: ");
        String nome = in.nextLine();

        System.out.print("Idade: ");
        int idade = in.nextInt();
        in.nextLine();

        System.out.print("Peso: ");
        double peso = in.nextDouble();
        in.nextLine();

        System.out.print("Altura(m): ");
        double altura = in.nextDouble();
        in.nextLine();

        System.out.print("Sexo: \n[1] Masc \n[2] Fem\n");
        int opcaoSexo = in.nextInt();
        in.nextLine();
        Sexo sexo = Sexo.MASCULINO;
        if(opcaoSexo == 2) {
            sexo = Sexo.FEMININO;
        }

        Pessoa pessoa = new Pessoa(nome, idade, peso, altura, sexo);

        if(calculos.inserir(pessoa)) {
            System.out.println("Cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar, tente novamente!");
        }
    }
}
