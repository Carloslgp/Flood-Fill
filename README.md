# Implementação do Algoritmo Flood Fill em Java

Este repositório contém uma implementação do algoritmo Flood Fill, desenvolvida como parte da disciplina de Resolução de Problemas Estruturados em Computação. O projeto demonstra o preenchimento de uma área em uma imagem a partir de um ponto inicial, utilizando estruturas de dados de Fila e Pilha para gerenciar os pixels a serem processados.

## Visão Geral

O Flood Fill é um algoritmo que determina e altera a cor de uma área conectada de pixels em uma imagem. Esta implementação foi projetada para colorir uma imagem PNG com cores sólidas, gerando uma animação do processo de preenchimento.

O projeto inclui implementações próprias das estruturas de dados de Fila e Pilha, conforme os requisitos do trabalho acadêmico.

![Animação do Flood Fill](https://imgur.com/a/CuQZp4i)


## Como Executar

### Pré-requisitos
* **Java Development Kit (JDK)** instalado.
* **(Opcional) FFmpeg** para gerar a animação em vídeo a partir dos frames.

### Passos para Execução

1.  **Clone o repositório:**
    ```bash
    git clone <URL_DO_REPOSITORIO>
    cd <NOME_DO_DIRETORIO>
    ```

2.  **Compile os arquivos Java:**
    A partir do diretório raiz do projeto, execute o comando:
    ```bash
    javac -d . src/Main.java src/FloodFill/*.java src/Queue/*.java src/Stack/*.java
    ```

3.  **Execute o programa:**
    ```bash
    java Main
    ```
    O programa começará a processar a imagem e a salvar os frames na pasta `frames/`.

### Como Mudar o Algoritmo (Fila vs. Pilha)

Para alternar entre a Fila e a Pilha, edite o arquivo `src/Main.java` e altere a chamada do método:

* **Para usar a Fila (padrão):**
    ```java
    floodFill2.FillQueue();
    ```

* **Para usar a Pilha:**
    ```java
    floodFill2.FillStack();
    ```

### Gerando a Animação

Após a execução do programa, a pasta `frames/` conterá todas as imagens geradas.
