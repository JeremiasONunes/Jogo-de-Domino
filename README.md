# Dominó em Java

Este é um jogo de Dominó implementado em Java, composto por várias classes que representam diferentes aspectos do jogo e sua lógica.

## Classes Principais

### Classe Jogo

Responsável por controlar o fluxo do jogo. Inicia um novo jogo, gerencia as interações com os jogadores e a mesa.

### Classe ListaDuplamenteEncadeada

Implementa uma lista duplamente encadeada para armazenar as peças do dominó. Possui métodos para adicionar, remover e manipular as peças na lista.

### Classe No

Define um nó que armazena uma peça do dominó e mantém referências para o nó anterior e o próximo nó na lista duplamente encadeada.

### Classe Peca

Representa uma peça de dominó com dois números.

### Classe DeterminaInicioJogo

Responsável por determinar qual jogador inicia o jogo com base nas peças que cada um possui.

### Classe Input

Fornece métodos para receber entrada do usuário, como números e strings.

### Classe LogicaComputador

Contém a lógica para a jogada do computador. Decide qual peça o computador deve jogar e quando comprar uma nova peça.

### Classe LogicaJogo

Centraliza a lógica do jogo, distribuindo peças, controlando turnos dos jogadores e decidindo o vencedor.

## Funcionamento Geral do Jogo

1. **Inicialização do Jogo:**
   - As peças de dominó são distribuídas entre os jogadores e a mesa.
   - A classe `DeterminaInicioJogo` decide qual jogador inicia o jogo com base nas peças iniciais de cada jogador.

2. **Turnos dos Jogadores:**
   - No início de cada turno, o jogador humano escolhe uma peça para jogar ou comprar uma nova peça (através da classe `Input`).
   - Em seguida, o computador (classe `LogicaComputador`) decide sua jogada.

3. **Lógica de Jogada:**
   - A lógica de cada jogada é executada com base nas regras do dominó, como verificar se uma peça pode ser jogada no início ou no final da mesa.
   - Se uma peça for jogada, ela é removida da mão do jogador e adicionada à mesa.
   - Se o jogador optar por comprar uma nova peça, ela é retirada do monte de peças disponíveis e adicionada à mão do jogador.

4. **Fim do Jogo:**
   - O jogo continua até que um dos jogadores fique sem peças.
   - Quando isso acontece, a classe `LogicaJogo` determina o vencedor com base nas peças restantes. O jogador com menos pontos é declarado vencedor. Os pontos são calculados somando os valores das peças restantes na mão de cada jogador.

5. **Reinício do Jogo:**
   - Após determinar o vencedor, os jogadores têm a opção de iniciar um novo jogo ou encerrar o programa.
6. **autores: Equipe milenniun Falcon**
   - jeremias O Nunes.
   - Rafael Mesquita.
   - Igor Flores Bento
