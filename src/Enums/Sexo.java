package Enums;

public enum Sexo {
    MASCULINO,
    FEMININO;

    public String getLabel() {
        switch (this) {
            case MASCULINO:
                return "Masculino";
            default:
                return "Feminino";
        }
    }

    public static Sexo getSexo(int opcaoSexo) {
        switch (opcaoSexo) {
            case 1:
                return MASCULINO;
            default:
                return FEMININO;
        }
    }

    public static Sexo getSexo(String sexo) {
        switch (sexo) {
            case "MASCULINO":
                return MASCULINO;
            default:
                return FEMININO;
        }
    }


}
