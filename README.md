# Sistema de Pedido de Quebra de Barreira
Trabalho da disciplina de Paradigmas de Programação

O sistema tem por objetivo auxiliar o aluno no seu pedido de quebra de barreira, verificar a situação do
aluno e gerar um arquivo texto com o pedido de quebra e seus dados.

Requisitos:
- Importar CSV com informações do aluno (exibir)
- Importar CSV com as disciplinas, disponibilidade no semestre, grade curricular (exibir)
- Listar matérias cursadas e matérias do curso (exibir)
- Apresentar tabela com as matérias cursadas por período e matérias pendentes (exibir)
- Apresentar dados de aprovação do último período (% de aprovação + quantas matérias reprovou por falta)
- Mostrar ao aluno conj. de disciplinas ofertadas no semestre que não foram cursadas neste semestre, ordenadas por período
- Possibilitar que o aluno selecione um conj. de disciplinas que ele deseja cursar (podendo escolher a prioridade delas)
- O sistema deve calcular o número de disciplinas sugerido pelas regras aprovadas em colegiado e mostrar resultado.
- O sistema deve permitir salvar os dados do pedido em um arquivo (podendo editar depois)
- Ao clicar em enviar, o sistema deve gerar um arquivo texto contendo todos os dados do pedido.

Tela inicial:
- Opções:
    * Solicitar quebra de pré-requisito (TelaSolicitacao)
    * Exibir minhas informações (TelaInfoAluno)

TelaSolicitacao: 
- De acordo com o pdf quebra-barreira-requisito1
- Opções:
    * Selecionar disciplinas que ele deseja cursar
    * Cálculo do núm. de disciplinas sugeridos pelas regras do colegiado
    * Salvar dados do pedido
    * Enviar (gerar arquivo .txt com os dados do pedido)

TelaInfoAluno:
- Opções para o usuário:
    * Listar disciplinas ofertadas esse semestre que não foram cursadas
    * Matérias cursadas x Matérias do curso (Listar)
    * Matérias cursadas x pendentes (por período)
    * Dados de aprovação:
        % Aprovação     |    num. de reprov. por falta



* Java 11
* Interface gráfica
* Makefile
* Gerar .jar a ser executado com o comando java -jar
* Modularização e Padronização: MVC

Regras para quebra de pré-requisito:  
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


Estrutura de projeto maven:
- main: arquivos .java
- resources
- test

Comandos:
1. Criar o projeto:
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
