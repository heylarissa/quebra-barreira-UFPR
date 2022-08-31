# Sistema de Pedido de Quebra de Barreira
Trabalho da disciplina de Paradigmas de Programação

O sistema tem por objetivo auxiliar o aluno no seu pedido de quebra de barreira, verificar a situação do
aluno e gerar um arquivo texto com o pedido de quebra e seus dados.

O sistema deve permitir que o aluno obtenha as suas informações do histórico importando um arquivo
.CSV. Além disso, o sistema deverá importar dados sobre as disciplinas, sua disponibilidade no semestre
e a grade curricular, também de arquivo .CSV.

O sistema deverá colocar estes dados em uma lista com as matérias cursadas e uma lista das matérias
do curso. O sistema deverá então apresentar uma tabela com as matérias cursadas por período e as
matérias que faltam cursar para a barreira. Além disso, o sistema deverá apresentar os dados de aprovação
do último período como porcentagem de aprovação e quantas matérias reprovou por falta.

O sistema deverá mostrar ao aluno o conjunto de disciplinas ofertadas neste semestre que não foram
cursadas neste semestre por ordem de período. O sistema deverá possibilitar que o aluno selecione um
conjunto de disciplinas que ele deseja cursar com informação sobre a prioridade delas.  

O sistema deverá calcular o número de disciplinas sugerido pelas regras aprovadas em colegiado e
mostrar este resultado. O sistema deve permitir salvar os dados do pedido em um arquivo de forma a
permitir que o aluno os edite posteriormente. Quando o aluno selecionar enviar, o sistema deverá gerar
um arquivo texto contendo os dados do pedido.


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

