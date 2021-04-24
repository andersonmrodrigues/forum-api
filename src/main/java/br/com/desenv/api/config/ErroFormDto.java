package br.com.desenv.api.config;

public class ErroFormDto {
    private final String campo;
    private final String erro;

    public ErroFormDto(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }
}
