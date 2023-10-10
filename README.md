# MicroServices-SpringCloud
Projeto em Spring usando microserviços cartoes e clientes com eureka server, gateway  mensageria rabbitMQ, e gerenciamento de acesso  pelo keycloak em docker
O Sistema faz uma etapa para criacao de um cartao de credito, um microserviço fica responsavel pelo cadastro do cliente, outro microserviço fica responsavel pela criacao do cartao apos verificar se o cliente esta apto a poder ter seu cartao criado e vinculado, outro microserviço é o gateway que fica responsavel pelo balanceamento de carga do usuario externo para os microserviços. e o Eureka Server usado para registrar e descobrir serviços na arquitetura dos microservices. O rabbitMQ fica responsavel pela fila de mensagens entre os microserviços e o keycloak foi uma opção mais apropriado para esse projeto do que usar apenas o Spring security. cada um dos microserviços ficaram em um container no Docker para facilitar na hora de subir para a nuvem, fazendo apenas o levantamento do eureka e gateway deixa o sistema mais otmizado.

Ferramentas usadas no projeto:
- Java 11
- Spring 2.6
- MySQL / h2 database
- RabiitMQ
- Keycloak
- Docker
