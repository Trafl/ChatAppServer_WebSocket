# ChatAppServer

## Descrição:
Servidor criado utilizando o SpringWebSocket com o intuito de conectar dois ou mais clientes para trocas de mensagem em tempo real.  
  
## WebSocket:
WebSocket é um protocolo de comunicação que fornece canais de comunicação bidirecional full-duplex sobre uma única conexão TCP. 
Ele é projetado para ser implementado em navegadores e servidores web, permitindo interações em tempo real entre o cliente e o servidor com latência mínima.

## Como utilizar: 
* Instale o Docker
* Abrar o terminal, pode ser o padrão ou o da IDE, na pasta que for executar o projeto e utilize o comando

  ``
  docker push pivoluz/chat_realtime-api
  ``

* Depois de baixar a imagem execute

  ``
  docker run --rm -p "8080:8080" -t chatapi pivoluz/chat_realtime-api
  ``
  
* Conecte seu projeto corretamente:

  * Para se conectar ao servidor ``ws://localhost:8080/conect_websocket``
  
  * Topico para se inscrever: ``/chat``
    
  * Para enviar ``/app/chat_send_message``

## Tecnologias Utilizadas:
* Java 17
* SpringWeb
* SpringWebSocket
* Lombook
* Docker
