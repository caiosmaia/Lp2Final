package teste;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Composicao {
	private int numero;
    private Stack<Vagao> vagoes;

    public Composicao(int numero) {
        this.numero = numero;
        this.vagoes = new Stack<>();
    }

    public int getNumero() {
        return numero;
    }

    public Stack<Vagao> getVagoes() {
        return vagoes;
    }

    public void adicionarVagao(Vagao vagao) {
        vagoes.push(vagao);
        vagao.setDisponivel(false);
        System.out.println("Vag�o " + vagao.getNome() + " adicionado � composi��o " + numero + ".");
    }

    public void adicionarCarga(String identificador, String conteudo, int quantidade) {
        for (Vagao vagao : vagoes) {
            if (vagao.getNome().equals(identificador)) {
                vagao.adicionarCarga(conteudo, quantidade);
                System.out.println("Carga de " + quantidade + "kg de " + conteudo + " adicionada ao vag�o " +
                        vagao.getNome() + " na composi��o " + numero + ".");
                return;
            }
        }
        System.out.println("Vag�o " + identificador + " n�o encontrado na composi��o " + numero + ".");
    }

    public void desembarcarCarga(String identificador) {
        for (Vagao vagao : vagoes) {
            if (vagao.getNome().equals(identificador)) {
                if (vagao.isVazio()) {
                    System.out.println("Vag�o " + vagao.getNome() + " na composi��o " + numero + " j� est� vazio.");
                } else {
                    vagao.desembarcarCarga();
                    System.out.println("Carga desembarcada do vag�o " + vagao.getNome() + " na composi��o " + numero + ".");
                }
                return;
            }
        }
        System.out.println("Vag�o " + identificador + " n�o encontrado na composi��o " + numero + ".");
    }
}