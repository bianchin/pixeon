# Project to Pixeon Tech Challenge


## Construção

Foi desenvolvido com Springboot versão 2.2.2.RELEASE

Foquei na contrução usando microserviços e não ligações diretas via banco de dados.

Pensei na possíbilidade de usar um banco H2 para facilitar a execução, mas foi construido em um banco NoSQL em um servidor remoto (mongodb atlas, dados de acesso link)  para não ter que instalar localmente.

Os serviços se comunicam via REST, o que nesse caso geralmente eu adotaria um event source ou uma mensageria simples.

Foi criado 2 servicos (Exam e Healthcare), um servidor de configuração e um service discovery

Arquivos de configuração estáo no repositorio [repositorio git](https://github.com/bianchin/pixeon-configs)


## Solution



#### Create a Healthcare

curl -X POST -H 'Content-Type: application/json' -d '{"name": "Hospital Sao Jose 1", "cnpj": "74588658000100"}' http://localhost:9094/api/healthcares/

Retorna o código do healthcareId a ser usado nas proximas requisições

#### Create an exam

curl -X POST -H 'Content-Type: application/json' -d '{"patient" : {"name": "Jose Silva","age": 25, "gender": "M" }, "physician" : {"name": "Dr Joao","crm": 12345 }, "procedureName": "Raio X"}' http://localhost:9093/api/healthcares/<healthcareId>/exams/

Retorna o examId a ser usado nas próximas requisições

#### Update an exam

curl -X PUT -H 'Content-Type: application/json' -d '{"patient" : {"name": "Jose Silva","age": 25, "gender": "M" }, "physician" : {"name": "Dr Joao","crm": 12346 }, "procedureName": "Raio X"}' http://localhost:9093/api/healthcares/<healthcareId>/exams/<examId>


#### Delete an exam 

curl -I -X DELETE http://localhost:9093/api/healthcares/<healthcareId>/exams/<examId>


#### Get an exam by its identifier

curl -X GET http://localhost:9093/api/healthcares/<healthcareId>/exams/<examId>




## Functional requirements

#### Each new healthcare institution must receive 20 pixeon coins to save exams and retrieve them.

É criada a partir do recurso [Create a Healthcare](#create-a-healthcare)
Este é usado o servico de healthcare

#### Every exam successfully created must charge 1 pixeon coin from the healthcare institution's bugdet

É criada a partir do recurso [Create an exam](#create-an-exam)
Ao criar um Exam ele usa o micro serviço healthcare para descontar coins

#### You must charge 1 pixeon coin from the budget when one healthcare institution retrieves an exame but if the institution retrieves the same exame more than once you must not charge it, which means you have to charge only the first access to the exam.

É recuperado a partir do recurso [Get an exam by its identifier](#get-an-exam-by-its-identifier)
Ele verifica se o exame já foi recuperado anteriormente, senao ele desconta um coin do micro serviço healthcare

#### A healthcare institution must not have access to an exam that belongs to other healthcare institution.

Uma healthcare não tem acesso direto aos exames, mas poderiamos fazer esse bloqueio via recurso. 
Poderiamos bater o token de acesso com o path do recurso /healthcare/healthcareId do serviço de Exam. Onde apenas poderia acessar a partir desse path o token que possuir o acesso a healthcare.

Para trabalhar uma ideia paralela eu coloquei o @PostAuthorize na classe pixeon.controller.ExamController que verifica o retorno com o path enviado.

Obs.: Não é a ideia proposta acima, e sim um outro ponto de segurança.


#### A healthcare institution is not allowed to create or get an exam when running out of budget. 

Desenvolvido nos recursos [Create a Healthcare](#create-a-healthcare) e [Create an exam](#create-an-exam)

Este retorna um erro 500 com uma mensagem amigável.

#### We are expecting you to build the solution using Spring Framework and we also do not care about the database or any other tool that you might choose.

Desenvolvido com springboot versão 2.2.2.RELEASE



## Acesso mongodb

host: cluster0-shard-00-00-96z4g.mongodb.net
port: 27017
database: admin
username: pixeon
password: vcs1gFUK5i7rsGAZ

mongo "mongodb://cluster0-shard-00-00-96z4g.mongodb.net:27017,cluster0-shard-00-01-96z4g.mongodb.net:27017,cluster0-shard-00-02-96z4g.mongodb.net:27017/test?replicaSet=Cluster0-shard-0" --ssl --authenticationDatabase admin --username pixeon --password <password>




