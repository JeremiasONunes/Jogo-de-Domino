package Models;

import Services.Output;

public class ListaDuplamenteEncadeada {
    No inicio;
    No fim;
    public Output saida = new Output();

    public ListaDuplamenteEncadeada() {
        inicio = null;
        fim = null;
    }

    public void adicionar(Peca peca) {
        No novoNo = new No(peca);
        if (inicio == null) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            fim.proximo = novoNo;
            novoNo.anterior = fim;
            fim = novoNo;
        }
    }

    public void removerTodasPecas() {
        inicio = null;
        fim = null;
    }

    public void imprimirPorIndice(int indice) {
        if (indice < 0 || inicio == null) {
            saida.exibirMensagem("Índice inválido ou lista vazia.");
            return;
        }

        No atual = inicio;
        int contador = 0;
        while (atual != null) {
            if (contador == indice) {
                saida.exibirMensagem("[" + atual.peca.getNumero1() + "|" + atual.peca.getNumero2() + "]");
                return;
            }
            atual = atual.proximo;
            contador++;
        }
        saida.exibirMensagem("Índice fora do intervalo da lista.");
    }

    public void removerPorIndice(int indice) {
        if (indice < 0 || inicio == null) {
            saida.exibirMensagem("Índice inválido ou lista vazia.");
            return;
        }

        No atual = inicio;
        int contador = 0;
        while (atual != null) {
            if (contador == indice) {
                if (atual.anterior != null) {
                    atual.anterior.proximo = atual.proximo;
                } else {
                    inicio = atual.proximo;
                }
                if (atual.proximo != null) {
                    atual.proximo.anterior = atual.anterior;
                } else {
                    fim = atual.anterior;
                }
                return;
            }
            atual = atual.proximo;
            contador++;
        }
        saida.exibirMensagem("Índice fora do intervalo da lista.");
    }

    public void imprimirTodasPecas() {
        No atual = inicio;
        int indice = 0;
        saida.exibirMensagem("-------------Peças-------------");
        while (atual != null) {
            saida.exibirMensagem(indice + ": [" + atual.peca.getNumero1() + "|" + atual.peca.getNumero2() + "]");
            atual = atual.proximo;
            indice++;
        }
        System.out.println();
    }

    public void imprimirTodasPecasMesa() {
        No atual = inicio;
        saida.exibirMensagem("-------------Peças mesa-------------\n");
        while (atual != null) {
            System.out.print("[" + atual.peca.getNumero1() + "|" + atual.peca.getNumero2() + "] ");
            atual = atual.proximo;
        }
        System.out.print("\n\n");
    }

    public Peca transferirPecaPorIndice(int indice, ListaDuplamenteEncadeada listaDestino) {
        if (indice < 0 || inicio == null) {
            saida.exibirMensagem("Índice inválido ou lista vazia.");
            return null;
        }

        No atual = inicio;
        int contador = 0;

        while (atual != null) {
            if (contador == indice) {
                if (atual.anterior != null) {
                    atual.anterior.proximo = atual.proximo;
                } else {
                    inicio = atual.proximo;
                }
                if (atual.proximo != null) {
                    atual.proximo.anterior = atual.anterior;
                } else {
                    fim = atual.anterior;
                }

                Peca pecaTransferida = atual.peca;
                listaDestino.adicionar(pecaTransferida);
                return pecaTransferida;
            }
            atual = atual.proximo;
            contador++;
        }
        saida.exibirMensagem("Índice fora do intervalo da lista.");
        return null;
    }

    public Peca transferirPecaParaInicio(int indice, ListaDuplamenteEncadeada listaDestino) {
        if (indice < 0 || inicio == null) {
            saida.exibirMensagem("Índice inválido ou lista vazia.");
            return null;
        }

        No atual = inicio;
        int contador = 0;

        while (atual != null) {
            if (contador == indice) {
                No noTransferido = new No(atual.peca);
                listaDestino.inserirNoInicio(noTransferido.peca);

                if (atual.anterior != null) {
                    atual.anterior.proximo = atual.proximo;
                } else {
                    inicio = atual.proximo;
                }
                if (atual.proximo != null) {
                    atual.proximo.anterior = atual.anterior;
                } else {
                    fim = atual.anterior;
                }

                return noTransferido.peca;
            }
            atual = atual.proximo;
            contador++;
        }
        saida.exibirMensagem("Índice fora do intervalo da lista.");
        return null;
    }

    public Peca getPecaPorIndice(int indice) {
        if (indice < 0 || inicio == null) {
            saida.exibirMensagem("Índice inválido ou lista vazia.");
            return null;
        }

        No atual = inicio;
        int contador = 0;
        while (atual != null) {
            if (contador == indice) {
                return atual.peca;
            }
            atual = atual.proximo;
            contador++;
        }
        saida.exibirMensagem("Índice fora do intervalo da lista.");
        return null;
    }

    public int getUltimoIndice() {
        if (inicio == null) {
            return -1;
        }

        No atual = inicio;
        int ultimoIndice = 0;

        while (atual.proximo != null) {
            atual = atual.proximo;
            ultimoIndice++;
        }

        return ultimoIndice;
    }

    public int getPrimeiroIndice() {
        return inicio != null ? 0 : -1;
    }

    public void inverterNumerosPeca(int indice) {
        if (indice < 0 || inicio == null) {
            saida.exibirMensagem("Índice inválido ou lista vazia.");
            return;
        }

        No atual = inicio;
        int contador = 0;
        while (atual != null) {
            if (contador == indice) {
                int temp = atual.peca.getNumero1();
                atual.peca.setNumero1(atual.peca.getNumero2());
                atual.peca.setNumero2(temp);
                return;
            }
            atual = atual.proximo;
            contador++;
        }
        saida.exibirMensagem("Índice fora do intervalo da lista.");
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    public int tamanho() {
        int contador = 0;
        No atual = inicio;
        while (atual != null) {
            contador++;
            atual = atual.proximo;
        }
        return contador;
    }

    public void inserirNoInicio(Peca peca) {
        No novoNo = new No(peca);
        if (inicio == null) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            novoNo.proximo = inicio;
            inicio.anterior = novoNo;
            inicio = novoNo;
        }
    }

    public Peca buscarPecaPorNumero(int numero1, int numero2) {
        No atual = inicio;
        while (atual != null) {
            Peca peca = atual.peca;
            if ((peca.getNumero1() == numero1 && peca.getNumero2() == numero2)
                    || (peca.getNumero1() == numero2 && peca.getNumero2() == numero1)) {
                return peca;
            }
            atual = atual.proximo;
        }
        return null;
    }

    public int indicePeca(Peca peca) {
        No atual = inicio;
        int indice = 0;
        while (atual != null) {
            if (atual.peca.equals(peca)) {
                return indice;
            }
            atual = atual.proximo;
            indice++;
        }
        return -1;
    }

    public boolean contemPeca(Peca peca) {
        No atual = inicio;
        while (atual != null) {
            if (atual.peca.equals(peca)) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }
}
