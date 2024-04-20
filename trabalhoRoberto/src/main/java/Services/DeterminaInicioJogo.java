package Services;

import Models.ListaDuplamenteEncadeada;
import Models.Peca;

public class DeterminaInicioJogo {

    private Output saida = new Output();

    public void determinarJogadorInicial(ListaDuplamenteEncadeada jogadorPrincipal,
                                         ListaDuplamenteEncadeada jogadorComputador, ListaDuplamenteEncadeada mesaJogo) {
        // Encontra a maior peça do jogador humano e do computador
        Peca maiorPecaJogador = encontrarMaiorPeca(jogadorPrincipal);
        Peca maiorPecaComputador = encontrarMaiorPeca(jogadorComputador);

        // Verifica se o jogador humano possui um carretão
        boolean jogadorPossuiCarretao = ehCarretao(maiorPecaJogador);
        // Verifica se o computador possui um carretão
        boolean computadorPossuiCarretao = ehCarretao(maiorPecaComputador);

        // Se ambos têm carretão, compara os valores dos carretões
        if (jogadorPossuiCarretao && computadorPossuiCarretao) {
            int totalJogador = totalPeca(maiorPecaJogador); // Total da maior peça do jogador
            int totalComputador = totalPeca(maiorPecaComputador); // Total da maior peça do computador

            // Compara os valores dos carretões
            if (totalJogador > totalComputador) {
                saida.exibirMensagem("Você possui um carretão maior. Você inicia o jogo!");
            } else if (totalComputador > totalJogador) {
                saida.exibirMensagem("O computador possui um carretão maior. O computador inicia o jogo!");
                jogadorComputador.transferirPecaPorIndice(jogadorComputador.indicePeca(maiorPecaComputador), mesaJogo);
                mesaJogo.imprimirTodasPecas();
            } else {
                // Se ambos têm carretões de igual valor, precisa ser feito um sorteio
                saida.exibirMensagem("Ambos têm carretões de igual valor. Sorteio para determinar quem inicia...");
                // Aqui você precisará adicionar a lógica de sorteio
                saida.exibirMensagem("Quem inicia é o jogador humano."); // Adicionei uma mensagem de exemplo
            }
        } else if (jogadorPossuiCarretao) {
            saida.exibirMensagem("Você possui um carretão. Você inicia o jogo!");
        } else if (computadorPossuiCarretao) {
            saida.exibirMensagem("O computador possui um carretão. O computador inicia o jogo!");
            jogadorComputador.transferirPecaPorIndice(jogadorComputador.indicePeca(maiorPecaComputador), mesaJogo);
            mesaJogo.imprimirTodasPecas();
        } else {
            // Se nenhum jogador tem carretão, compara as peças maiores
            int totalJogador = totalPeca(maiorPecaJogador != null ? maiorPecaJogador : jogadorPrincipal.getPecaPorIndice(0));
            int totalComputador = totalPeca(maiorPecaComputador != null ? maiorPecaComputador : jogadorComputador.getPecaPorIndice(0));

            if (totalJogador > totalComputador) {
                saida.exibirMensagem("Você possui a maior peça. Você inicia o jogo!");
            } else if (totalComputador > totalJogador) {
                saida.exibirMensagem("O computador possui a maior peça. O computador inicia o jogo!");
                jogadorComputador.transferirPecaPorIndice(jogadorComputador.indicePeca(maiorPecaComputador), mesaJogo);
                mesaJogo.imprimirTodasPecas();
            } else {
                // Se ambos os jogadores têm peças de igual valor, precisa ser feito um sorteio
                saida.exibirMensagem("Ambos os jogadores têm peças de igual valor. Sorteio para determinar quem inicia...");
                // Aqui você precisará adicionar a lógica de sorteio
                saida.exibirMensagem("Quem inicia é o jogador humano."); // Adicionei uma mensagem de exemplo
            }
        }
    }

    public Peca encontrarMaiorPeca(ListaDuplamenteEncadeada jogador) {
        if (jogador.estaVazia()) {
            return null; // Retorna null se a lista estiver vazia
        }

        Peca maiorPeca = null;

        for (int i = 0; i <= jogador.getUltimoIndice(); i++) {
            Peca pecaAtual = jogador.getPecaPorIndice(i);

            if (ehCarretao(pecaAtual)) {
                if (maiorPeca == null || totalPeca(pecaAtual) > totalPeca(maiorPeca)) {
                    maiorPeca = pecaAtual;
                }
            }
        }

        return maiorPeca;
    }

    private boolean ehCarretao(Peca peca) {
        if (peca != null) {
            return peca.getNumero1() == peca.getNumero2();
        }
        return false;
    }

    public int totalPeca(Peca peca) {
        return peca.getNumero1() + peca.getNumero2();
    }
}
