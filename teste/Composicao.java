package teste;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Composicao {
	private int numero;
    private Stack<Vagao> vagoes;
    
    public static final String[] conteudosPossiveisRecebeR1 = {"amendoim", "feijao", "milho", "soja", "trigo"};
	public static final String[] conteudosPossiveisRecebeR2 = {"cobre", "ferro", "magnesita", "niquel"};
    
   
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
                vagao.adicionarCarga(quantidade, conteudo, quantidade);
                System.out.println("Carga de " + quantidade + "kg de " + conteudo + " adicionada ao vagão " +
                        vagao.getNome() + " na composição " + numero + ".");
                return;
            }
        }
        System.out.println("Vagão " + identificador + " não encontrado na composição " + numero + ".");
    }

    public void desembarcarCarga(String identificador, int composicao) {
    	List<String> conteudosPermitidos;
        if (composicao == 1) {
            conteudosPermitidos = Arrays.asList(conteudosPossiveisRecebeR1);
        } else if (composicao == 2) {
            conteudosPermitidos = Arrays.asList(conteudosPossiveisRecebeR2);
        } else {
            System.out.println("Composição inválida.");
            return;
        }

        for (Vagao vagao : vagoes) {
            if (vagao.getNome().equals(identificador)) {
                if (vagao.isVazio()) {
                    System.out.println("Vagão " + vagao.getNome() + " na composição " + numero + " já está vazio.");
                } else {
                    String carga = vagao.getCarga().toLowerCase();
                    if (conteudosPermitidos.contains(carga)) {
                        vagao.desembarcarCarga();
                        System.out.println("Carga desembarcada do vagão " + vagao.getNome() + " na composição " + numero + ".");
                    } else {
                        System.out.println("Não é permitido desembarcar a carga " + vagao.getCarga() +
                                " no vagão " + vagao.getNome() + " na composição " + numero + ".");
                    }
                }
                return;
            }
        }
        System.out.println("Vagão " + identificador + " não encontrado na composição " + numero + ".");
    }
}
