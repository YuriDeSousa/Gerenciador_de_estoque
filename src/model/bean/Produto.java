package model.bean;

public class Produto {
    private int cod;
    private String nome;
    private double valor;
    private int qtd;
    private int qtd_venda;

    public int getQtd_venda() {
        return qtd_venda;
    }

    public void setQtd_venda(int qtd_venda) {
        this.qtd_venda = qtd_venda;
    }
    

    
    
    public Produto(String nome, double valor, int qtd){
        this.setNome(nome);
        this.setQtd(qtd);
        this.setValor(valor);
    }

    public Produto() {
       
    }

    
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    
}
