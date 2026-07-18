# Jota Imóveis

Aplicação desktop JavaFX criada como trabalho final da disciplina de Programação de Computadores II. A interface permanece em português e o código-fonte usa nomes em inglês.

## Requisitos

- JDK 21
- Maven 3.9 ou superior

## Executar localmente

```powershell
mvn clean javafx:run
```

Para apenas compilar e validar o projeto:

```powershell
mvn clean package
```

O catálogo gerado pela aplicação é armazenado em `~/.jota-properties/properties.tsv`, fora do diretório de instalação.

## Estrutura

```text
src/main/java/com/jotaproperties/
├── app/          ponto de entrada JavaFX
├── controller/   controladores das telas
├── model/        entidades de domínio
├── repository/   persistência do catálogo
└── service/      geração, filtros e regras da aplicação

src/main/resources/
├── audio/
├── images/
├── styles/
└── views/
```

## Publicar uma versão para Windows x64

A workflow `Windows Release` também pode ser executada manualmente para testar o instalador como artefato. Para publicar uma GitHub Release, crie e envie uma tag semântica:

```powershell
git tag v1.0.0
git push origin v1.0.0
```

O GitHub Actions compila o projeto em um runner Windows x64, gera um instalador `.exe` com o runtime necessário e o anexa automaticamente à Release da tag.

## Autores

- Caio Lopes Malta
- Emanuel Victor Fonseca
- Gabriel Araujo Barbosa
- Lucas Henrique Ferreira

O diagrama original está em [`docs/architecture.png`](docs/architecture.png).
