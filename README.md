# Sistema de Pedido de Quebra de Barreira
Trabalho da disciplina de Paradigmas de Programação

Feito por:
Artur Temporal Coelho
Larissa Hey D'Andrade
Eduardo Camargo Neves

O sistema tem por objetivo auxiliar o aluno no seu pedido de quebra de barreira, verificar a situação do
aluno e gerar um arquivo texto com o pedido de quebra e seus dados.

* Java 11
* Gerar .jar a ser executado com o comando java -jar
* Modularização e Padronização: MVC

**Regras para quebra de pré-requisito:**
1. IRA >= 0,8, todos os pedidos de matrícula serão aceitos
2. 3 matrículas para desempenho ruim (caso C)
3. 5 matrículas para desempenho bom (caso A)
4. 4 matrículas para casos intermediários (caso B)
5. Não conceder quebra para de CI212 para CI215
6. Proibido quebra para optativas.
7. Maximizada matrícula nos períodos mais próximos ao início do curso
8. Obrigatória a matrícula na maior quantidade possível de disciplinas dentro da barreira.

Casos:  
A: Aprovação em mais de 2/3 das disciplinas do sem. anterior  
B: 1/2 de aprovação no sem. anterior  
C > 1/2 aprovação no sem. anterior  

**Comandos:**

1. Criar o projeto (não é necessário):
```shell
mvn archetype:generate
```

2. Compilar
```shell
mvn compile
```

3. Executar
```shell
mvn exec:java
```
