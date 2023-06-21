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
        System.out.println("Vagão " + vagao.getNome() + " adicionado à composição " + numero + ".");
    }

    public void adicionarCarga(String identificador, String conteudo, int quantidade) {
        for (Vagao vagao : vagoes) {
            if (vagao.getNome().equals(identificador)) {
                vagao.adicionarCarga(conteudo, quantidade);
                System.out.println("Carga de " + quantidade + "kg de " + conteudo + " adicionada ao vagão " +
                        vagao.getNome() + " na composição " + numero + ".");
                return;
            }
        }
        System.out.println("Vagão " + identificador + " não encontrado na composição " + numero + ".");
    }

    public void desembarcarCarga(String identificador) {
        for (Vagao vagao : vagoes) {
            if (vagao.getNome().equals(identificador)) {
                if (vagao.isVazio()) {
                    System.out.println("Vagão " + vagao.getNome() + " na composição " + numero + " já está vazio.");
                } else {
                    vagao.desembarcarCarga();
                    System.out.println("Carga desembarcada do vagão " + vagao.getNome() + " na composição " + numero + ".");
                }
                return;
            }
        }
        System.out.println("Vagão " + identificador + " não encontrado na composição " + numero + ".");
    }
}