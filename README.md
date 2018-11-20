# Newspaper Compiler

Membros do grupo:

- Marcelo Huffenbaecher
- Matheus Bortoleto
- Rene Ferrante Neto


Projeto de um compilador de linguagem de uma linguagem de descrição para um HTML em formato de jornal.
Feito como projeto 2 da disciplina de compiladores 2

## Requisitos para uso

- Java (de preferência a versão mais recente)
- Gradle (de preferência a versão mais recente)
- Navegador web com suporte a HTML 5 e CSS 3

## Instruções de Uso

1. Extrair o conteúdo do arquivo zip em um diretório de sua preferência.

2. No diretório onde foi extraído, compilar a gramática com o seguinte comando:

    ```bash
    gradle build
    ```

3. Então, para utilizar o compilador, executa-se o seguinte comando, substituindo "file.ndl" pelo caminho do arquivo ndl contendo o código a ser compilado e "output.html" pelo caminho do arquivo html a ser produzido como saída:

   ```bash
   java -jar buid/libs/Newspaper-Compiler.jar file.ndl output.html
   ```

4. Se houver algum erro de compilação do arquivo ndl, o erro será apresentado no terminal, juntamente com a linha em que ocorre.
5. Se não houver nenhum erro, o arquivo substituído no comando por "output.html" apresentará a página correspondente à saída do arquivo ndl.

## Exemplos de Código

```ndl
    header (
        name "New York Times"
        date 2018 10 02
        city "New York"
        state "New York"
    )

    row (
        col-full (
            article (
                id 123
                title "Spoopy boys all around"
                description "Hide yourselves, we have spooky boys all over town"
                author "Matheus Bortoleto"
                content (
                    paragraph "Lorem Ipsun Dolor"
                    image "doot.png" "One of the spooky boys"
                    paragraph "Lorem Ipsun Dolor"
                )
            )
        )
    )
```

 Mais exemplos de código e casos de teste são apresentados no diretório "test_cases"