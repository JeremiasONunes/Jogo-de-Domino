package Services;

import java.util.Random;
import Models.ListaDuplamenteEncadeada;
import Models.Peca;

public class LogicaComputador {
    private int contadorPassesCPU = 0;
    private Output saida = new Output();
    private Random random = new Random();

    public void logicaCpu(ListaDuplamenteEncadeada jogadorPrincipal, ListaDuplamenteEncadeada jogadorComputador, 
                          ListaDuplamenteEncadeada mesaJogo, ListaDuplamenteEncadeada mesaCompra) {
        // Evitar código repetido, extraído a lógica de escolha de peça para um método separado
        Peca pecaJogada = escolherPecaParaJogar(jogadorComputador, mesaJogo);
        if (pecaJogada != null) {
            contadorPassesCPU = 0;
            return;
        }
        
        // Simplificação da lógica de compra de peça
        comprarPeca(jogadorComputador, mesaCompra);
    }

    private Peca escolherPecaParaJogar(ListaDuplamenteEncadeada jogadorComputador, ListaDuplamenteEncadeada mesaJogo) {
        for (int i = 0; i <= jogadorComputador.getUltimoIndice(); i++) {
            Peca pecaComputador = jogadorComputador.getPecaPorIndice(i);
            if (pecaPodeSerJogada(pecaComputador, mesaJogo)) {
                jogadorComputador.transferirPecaPorIndice(i, mesaJogo);
                saida.exibirMensagem("O computador jogou uma peça.");
                return pecaComputador;
            }
        }
        return null;
    }

    private boolean pecaPodeSerJogada(Peca peca, ListaDuplamenteEncadeada mesaJogo) {
        if (mesaJogo.estaVazia() || peca.getNumero2() == mesaJogo.getPecaPorIndice(0).getNumero1()) {
            return true;
        } else if (mesaJogo.estaVazia() || peca.getNumero1() == mesaJogo.getPecaPorIndice(mesaJogo.getUltimoIndice()).getNumero2()) {
            return true;
        }
        return false;
    }

    private void comprarPeca(ListaDuplamenteEncadeada jogadorComputador, ListaDuplamenteEncadeada mesaCompra) {
        if (!mesaCompra.estaVazia()) {
            int indiceAleatorio = random.nextInt(mesaCompra.tamanho());
            mesaCompra.transferirPecaPorIndice(indiceAleatorio, jogadorComputador);
            saida.exibirMensagem("O computador comprou uma peça.");
        } else {
            saida.exibirMensagem("O computador passou a vez.");
            contadorPassesCPU++;
        }
    }

    public int getContadorPassesCPU() {
        return contadorPassesCPU;
    }

    public void resetContadorPassesCPU() {
        this.contadorPassesCPU = 0;
    }
}
