## Resumo 
1. Estrutura modular para facilitar a implementação e compreensão de novas funcionalidades
2. Separação de responsabilidades para garantir que cada classe corresponda a uma única funcionalidade
3. Modularidade: A classe ```MathUtil``` permite reutilizar métodos auxiliares, enquanto ```MathService``` centraliza a lógica de negócios

## Estrutura:
### Descrita
1. controller: Contém a classe ```MathController```
2. service: Contém a lógica dos cálculos em uma classe ```MathService```
3. exception: Contém as classes de exceções personalizadas
4. util: Contém métodos auxiliares (conversão e validação) em uma classe ```MathUtil```
### Visual
```
br.com.venturini
│
├── controller
│   └── MathController.java
│
├── service
│   └── MathService.java
│
├── exception
│   └── UnsuportedMathOperationException.java
│
└── util
    └── MathUtil.java
```



## Sobre
### Controller
A classe ```MathController``` se concentra em lidar com as solicitações HTTP e delegar a lógica de negócios para a camada de serviço:
- Adicionei o <strong>@RequestMapping("/math")</strong> para garantir que para acessar a API, o usuário deva usar o caminho /math antes.
- Também usei <strong>@AutoWired</strong> pra gerir as dependências da aplicação, nesse caso, injetei a dependência de ```MathService``` dentro da ```MathController```.
- Troquei o <strong>@RequestMapping</strong> que era usado para criar os caminhos GET da aplicação por <strong>@GetMapping</strong> que faz com que simplifique o caminho da requisição e facilite a leitura e compreensão.
- Com isso tudo, pude diminuir drasticamente a quantidade de linhas e simplificar a leitura, tornando o código mais atraente e mantendo sua funcionalidade.

### Service
No pacote service, a classe ```MathService``` contém a lógica principal dos cálculos e usa a classe ```MathUtil``` para validação e conversão:
- Usei <strong>@Service</strong> para garantir que o Spring pudesse injetar as dependências e gerenciar o ciclo de vida da classe. É aqui que vai as regras de negócio, ou seja, funcionamento da nossa aplicação.
- Mantive o código limpo e simplificado para garantir o funcionamento e facilidade de leitura da aplicação.

### Exception
No pacote exception, a classe ```UnsuportedMathOperationException``` define a exceção personalizada usada na aplicação:
- Mantive o que estava antes, pois não há necessidade de modificar nada.

### Util
No pacote util, a classe ```MathUtil``` contém os métodos auxiliares para validação e conversão numérica:
- Simplificação dos métodos para garantir legibilidade e fluidez do código.