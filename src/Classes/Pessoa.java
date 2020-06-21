package Classes;

import Enums.Sexo;

public class Pessoa {
    private String nome;
    private int idade;
    private double peso;
    private double altura;
    private int codigo;
    private Sexo sexo;

    public Pessoa(String nome, int idade, double peso, double altura, Sexo sexo) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Sexo getSexo() {
        return this.sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public int getK() {
        switch (this.sexo) {
            case MASCULINO:
                return 4;
            default:
                return 2;
        }
    }

    public int getS() {
        switch (this.sexo) {
            case MASCULINO:
                return 1;
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        return  "Nome: " + nome + "\n" +
                "Idade: " + idade + " anos\n" +
                "Peso: " + peso + "kg\n" +
                "Altura: " + altura + "m\n" +
                "Sexo: " + sexo.getLabel();
    }

    public double getAlturaCM() {
        return altura * 100;
    }
}
