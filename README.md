### petz-api 

Componente que expõe RESTful api para registro de clientes e pets. 


#### Instrução para build e run

*  Executar command Windows cmd

   C:\>
   
*  Baixar código fonte

>> git clone https://github.com/mjaziel/petz.git

*  Entrar na pasta /petz

>> cd /petz   

*  Criar variáveis de ambiente

>> SET MYSQL_DB_HOST=sql10.freesqldatabase.com

>> SET MYSQL_DB_PORT=3306

>> SET MYSQL_DB_NAME=sql10366096

>> SET MYSQL_DB_USERNAME=sql10366096

>> SET MYSQL_DB_PASSWORD=inGVixtr9h 

*  Fazer o build

>> mvn clean install
   
*  executar a aplicação

>> java -jar   ./target/exam-1.0.0.jar

#### Instruções de uso 

*  Acessar a url

>> http://localhost:8081/petz-api/swagger-ui.html

