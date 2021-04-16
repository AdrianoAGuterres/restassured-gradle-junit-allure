# restassured-gradle-junit-allure
> Resumo:
> Implementação de Testes Automatizados de API com o uso das tecnologias Java 8, REST-Assured, Gradle, Junit 4 e Allure Framework;

### Serviço usado:
> https://reqres.in/

### Caminho testado:
> /api/users

### Pré requisitos:
| requisito        | página de download |
| ------           | ------ |
| Java 8           | https://www.oracle.com/br/java/technologies/javase-jdk8-downloads.html |
| Gradle 6.8.3     | https://gradle.org/releases/ |
| Allure Framework | https://docs.qameta.io/allure/#_installing_a_commandline

```sh
Ps: é necessário a instalação e configuração das variáveis de ambiente do Java e do Gradle. 
A instalação do Allure Framework é necessária se decidir usa-lo por linha de comando e/ou 
não tiver a pasta .allure no projeto. 
```

### Dependências:
| Tecnologia usada | página oficial |
| ------           | ------ |
| junit 4          | https://junit.org/junit4/ |
| rest-assured     | https://rest-assured.io/ |
| json-simple      | https://code.google.com/archive/p/json-simple/ |
| jfairy           | https://devskiller.github.io/jfairy/ |

### Arquitetura usada:

![alt text](https://user-images.githubusercontent.com/80764831/115079215-3c320380-9ed7-11eb-8901-b372015309cf.png)

### Considerações:
Por default o Allure Framework cria pastas com o resultado do teste e o report dentro da pasta .build, 
porem a cada execução da task 'clean' estas pastas são removidas. Então para manter um histórico das execuções
foi configurado para as pastas resultTests e report resem criadas na raiz do projeto. 
A primeira pasta guardará os resultados das execuções dos testes enquanto a segunda terá os arquivos gerados pelo 
Allure Framework na geração do report. 
O arquivo index.html é o arquivo principal do report e pode ser aberto pelo navegador através da ide sem a necessidade 
de 'subir' o Allure Server ou por linha de comando 'subindo' o Allure Server.  

### Como executar o teste:
Os testes contidos na pasta "testCases" poderão ser executados diretamente como uma classe de testes pelo Junit.
Dentro da pasta "testSuite" a classe "GetAndPostTestSuite" tamém pode ser executada diretamente pelo Junit e executará 
os testes da pasta "testCases" em sistema de suite.

Também os testes podem ser executados através das seguintes tasks do Gradle:
- build -> build;
- verification -> check;
- verification -> test; 

### Geração do report:
Após executar os testes, independentemente de como foram executados, a task "allureReport" terá que ser executada.
O arquivo "index.html" será gerado e através do plugin da ide poderá ser aberto diretamente no navegador.




