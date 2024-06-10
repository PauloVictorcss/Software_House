package br.com.softwareGrup.comanda.exception;

public class ExceptionResponseMesa {

    private String messagem;

    public ExceptionResponseMesa(String messagem){
        this.messagem = messagem;
    }

    public String getMessagem() {
        return messagem;
    }

    public void setMessagem(String messagem) {
        this.messagem = messagem;
    }
}
