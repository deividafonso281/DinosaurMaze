# Projeto DinosaurMaze

# Descrição Resumida do Jogo

   Os dinossauros estão correndo risco de extinção! Para que isso não ocorra, você precisa ajudar Max a fugir de alguns meteoros. O jogo ocorre em um espaço delimitado onde se encontram o dinossauro, Max, alguns meteoros e o cenário local: árvores, que terão que ser contornadas, e arbustos, que escondem surpresas que podem ajudar ou atrapalhar Max em sua jornada. Também é preciso ficar esperto com o tempo, já que durante a noite a capacidade de visão do protagonista é reduzida. O objetivo do jogo é conseguir o maior número possível de pontos. Para isso, faça com que o dinossauro sobreviva durante o máximo de tempo que conseguir. O jogo acaba quando um dos meteoros finalmente colide contra o dinossauro.

# Equipe
* David Afonso Borges dos Santos - 261032
* Mariana Sartorato Jorge - 241334

# Vídeos do Projeto

## Vídeo da Prévia
> [Link do vídeo da prévia](https://www.youtube.com/watch?v=qXy4wn0Sr80)

## Vídeo do Jogo
> <Coloque um link para o vídeo em que é demonstrada a versão final do jogo. Esse vídeo deve ter em torno de 5 minutos. Este vídeo não apresenta slides, nem substitui a apresentação final do projeto, que será feita por conferência. Ele mostra apenas o jogo em funcionamento.>

# Slides do Projeto

## Slides da Prévia
[Link apresentação de slides da prévia](https://docs.google.com/presentation/d/1z7tYh_-3t55z-gPLHGo0pKrxIzfjaR9ctWesbCXJPjg/edit#slide=id.g86f2d35873_0_0)

## Slides da Apresentação Final
`<Coloque um link para os slides da apresentação final do projeto.>`

## Relatório de Evolução

Em um primeiro momento, buscamos decidir que tipo de jogo iríamos fazer. Para isso, começamos a listar jogos que gostamos e que se encaixassem em um espaço celular. Decidimos então seguir um padrão estilo pacman, um personagem principal procurando fugir de outros dentro de um espaço limitado. A partir disso, tivemos ideias que completassem o jogo e desse a nossa cara para ele. Inicialmente, decidímos por um dinossauro, fugindo de meteoros, que iria ter que comer toda comida disposta sobre o tabuleiro antes de ser capturado por uma bola de fogo. Pensamos também em algum tipo de ajuda que o dinossauro pudesse ter ao longo do jogo, até que esse pensamento acabou se tornando os arbustos escondendo objetos que ajudam ou atrapalham o personagem principal. Com o tempo, também decidimos colocar as árvores e adicionar a noite, para tornar o jogo mais emocionante. Uma mudança que acabamos fazendo foi contar a pontuação a partir do tempo que o personagem sobrevivia, não a partir de casas andadas ou peças comidas. Isso ocorreu para que o jogo pudesse durar mais tempo, não tendo assim um teto máximo de pontuação.

Com todas as ideias prontas, começamos a escrever o código. Foi um tanto diferente, pois foi o primeiro momento que mexemos com interface gráfica, então tivemos que procurar coisas a respeito, o que nos abriu um novo universo cheio de oportunidades. Ademais, outra ferramenta nova que utilizamos foi o timer do Java, importante para o projeto, mas que causou certo estranhamento no início. Com o desenvolvimento do projeto, novas ideias foram surgindo e sendo implementadas ao jogo, como a música de fundo e as mudanças de imagens. As principais dificuldades que encontramos ao longo do caminho foi saber como utilizar algumas ferramentas, nunca utilizadas anteriormente, como o uso do cardlayout para mudar de página, ler, escrever e salvar os placares na lista e também colocar a música de fundo. Entretanto, após pesquisar bastante em fontes diversas, foi possível chegar ao resultado final.

Enquanto jogávamos, fomos percebendo algumas coisas que nos desagradavam, ou que tornavam o jogo um tanto quanto fácil, como as surpresas debaixo do arbusto e o uso do machado em certas circunstâncias. Apesar de, no princípio, serem aleatórias a cada novo jogo, se um jogador desse muita sorte poderia recolher muitos machados ou não ter buracos em seu caminho, e as surpresas se manteriam as mesmas embaixo de cada arbusto, sendo repostas a cada vez que recolhidas. Decidimos então que um novo arbusto apareceria após que um personagem passase por cima desse, com uma outra surpresa aleatória embaixo. Também tomamos o cuidado para que não fosse possível o dinossauro ficar escondido o tempo todo em uma árvore, assim que utilizasse o machado, como ocorria nas primeiras versões do jogo. Agora, o jogador só pode ficar em umas dessas casas inalcançáveis por algumas rodadas.

# Destaques de Código

> <Escolha trechos relevantes e/ou de destaque do seu código. Apresente um recorte (você pode usar reticências para remover partes menos importantes). Veja como foi usado o highlight de Java para o código.>

~~~java
// Recorte do seu código
public void algoInteressante(…) {
   …
   trechoInteressante = 100;
}
~~~

# Destaques de Pattern
`<Destaque de patterns adotados pela equipe. Sugestão de estrutura:>`

## Diagrama do Pattern
`<Diagrama do pattern dentro do contexto da aplicação.>`

## Código do Pattern
~~~java
// Recorte do código do pattern seguindo as mesmas diretrizes de outros destaques
public void algoInteressante(…) {
   …
   trechoInteressante = 100;
}
~~~

> <Explicação de como o pattern foi adotado e quais suas vantagens, referenciando o diagrama.>

# Documentação dos Componentes

# Diagramas

## Diagrama Geral do Projeto

> <Apresente um diagrama geral de organização da organização do seu sistema. O formato é livre. A escolha de um ou mais estilos arquiteturais será considerado um diferencial.>

> <Faça uma breve descrição do diagrama.>

## Diagrama Geral de Componentes

### Exemplo 1

Este é o diagrama compondo componentes para análise:

![Diagrama Analise](diagrama-componentes-analise.png)

Para cada componente será apresentado um documento conforme o modelo a seguir:

## Componente Tabuleiro

Onde o jogo ocorre, o espaço onde todas as peças serão alocadas e se movimentarão. Responsável por atualizar a posição de alguma peça quando essa realiza movimento, além de controlar o tempo.

![Componente](diagrama-componente.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | Tabuleiro
Autores | David e Mariana
Interfaces | ITabuleiro

### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](diagrama-interfaces.png)

Interface agregadora do componente em Java:

~~~java
public interface ITabuleiro {
	public void criaMapa();
	public void mataMax();
	public void amanhecer();
	public void anoitecer();
	public void iniciaTempo();
	public void daUmLoop();
}
~~~

## Detalhamento das Interfaces

### Interface `ITabuleiro`

Inicializa o tabuleiro e é responsável por atualizar o jogo, todas as movimentações e passagens de tempo.

~~~
public interface ITabuleiro {
	public void criaMapa();
	public void mataMax();
	public void amanhecer();
	public void anoitecer();
	public void iniciaTempo();
	public void daUmLoop();
}
~~~

Método | Objetivo
-------| --------
criaMapa() | Posiciona todas as peças no tabuleiro para iniciar o jogo
mataMax() | Verifica se o Max encontrou com algum meteoro, se sim, encerra o jogo
amanhecer() | Torna todo o cenário visível novamente
anoitecer() | Torna noite, parte do cenário fica escondida
iniciaTempo() | inicia o timer
daUmLoop() | atualiza o tabuleiro após uma "rodada", incrementa a pontuação

## Componente Peças com movimento

Dinossauro e meteoros, se deslocam pelo tabuleiro, seus movimentos definem a dinâmica do jogo, aumentando a pontuação ou determinando o fim do jogo.

![Componente](diagrama-componente.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | PMovimento
Autores | David e Mariana
Interfaces | IMovable

### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](diagrama-interfaces.png)

Interface agregadora do componente em Java:

~~~java
public interface IMovable {
	public void move();
	public void viraDireita();
	public void viraEsquerda();
	public int[] getDireita();
	public int[] getEsquerda();
	public int[] getAtual();
	public int[] getProx();
}
~~~

## Detalhamento das Interfaces

### Interface `IMovable`

Responsável pelo movimento das personagens, mostra as posições próximas as peças e determina o movimento que será realizado.

~~~
public interface IMovable {
	public void move();
	public void viraDireita();
	public void viraEsquerda();
	public int[] getDireita();
	public int[] getEsquerda();
	public int[] getAtual();
	public int[] getProx();
}
~~~

Método | Objetivo
-------| --------
move() | Movimenta a peça
viraDireita() | Vira para a direira
viraEsquerda() | Vira para a esquerda
getDireita() | Retorna o que tem na direita da personagem
getEsquerda() | Retorna o que tem na esquerda da personagem
getAtual() | Retorna a posição atual da personagem
getProx() | Retorna o que tem na casa da frente da personagem

## Componente Cenário

Peças que compõe a paisagem do jogo, são dispostas sobre o tabuleiro e interagem com as peças que se movimentam

![Componente](diagrama-componente.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | Cenario
Autores | David e Mariana
Interfaces | ICenario

### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](diagrama-interfaces.png)

Interface agregadora do componente em Java:

~~~java
public interface ICenario {
	public void setVisivel(boolean vis);
	public boolean getVisivel();
	public char qualObjeto();
	public void setSrc(String src);
}
~~~

## Detalhamento das Interfaces

### Interface `ICenario`

Relação do cenário com o resto do jogo, se está visível/invisível e qual o tipo de relação que exerce com os personagens que se movimentam.

~~~
public interface ICenario {
	public void setVisivel(boolean vis);
	public boolean getVisivel();
	public char qualObjeto();
	public void setSrc(String src);
}
~~~

Método | Objetivo
-------| --------
setVisivel() | Torna o objeto visível
getVisivel() | Retorna a visibilidade do objeto
qualObjeto() | Decide o tipo de objeto, um para árvores e quatro tipos para o arbusto, dependendo do que ele esconde 
setSrc() | Nome da imagem

## Componente Placar

Pontuação do jogador da rodada atual

![Componente](diagrama-componente.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | Score
Autores | David e Mariana
Interfaces | IScore

### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](diagrama-interfaces.png)

Interface agregadora do componente em Java:

~~~java
public interface IScore {
	public void incrementa();
}
~~~

## Detalhamento das Interfaces

### Interface `IScore`

Incrementa a pontuação a cada rodada.

~~~
public interface IScore {
	public void incrementa();
}
~~~

Método | Objetivo
-------| --------
setIncrementa() | Incrementa o placar

# Plano de Exceções

## Diagrama da hierarquia de exceções
`<Elabore um diagrama com a hierarquia de exceções como detalhado abaixo>`

![Hierarquia Exceções](exception-hierarchy.png)

## Descrição das classes de exceção

`<Monte uma tabela descritiva seguindo o exemplo>:`

Classe | Descrição
----- | -----
DivisaoInvalida | Engloba todas as exceções de divisões não aceitas.
DivisaoInutil | Indica que a divisão por 1 é inútil.
DivisaoNaoInteira | Indica uma divisão não inteira.
