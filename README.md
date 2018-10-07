# Newspaper Compiler

Projeto de um compilador de linguagem de uma linguagem de descrição para um HTML em formato de jornal.
Feito como projeto 2 da disciplina de compiladores 2

### Exemplos de Código

```
    options (
        default (
            font (12 "Times New Roman")
        )
        name (
            font (36 bold)
        )
        date (
            format ( "$D $M $y/$m/$d" ) # Tuesday October 2018/10/02
        )
        header (
            format ( "$name $separator $city, $state $date" )
        )
        image (
            font (italic)
        )
    )

    header (
        name "New York Times"
        date 2018 10 02
        city "New York"
        state "New York"
    )

    row (
        col-full (
            article (
                title "Spoopy boys all around"
                description "Hide yourselves, we have spooky boys all over town"
                author "Matheus Bortoleto"
                content text (
                    paragraph "Lorem Ipsun Dolor"
                    image "doot.png" "One of the spooky boys"
                    paragraph "Lorem Ipsun Dolor"
                )
            )
        )
    )
```
