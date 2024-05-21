# ChatAppServer

## Description:
Server made with SpringWebSocket for conect two or more clients for swith messagens in real time
  
## WebSocket:
WebSocket is a communication protocol that provides full-duplex bidirectional communication channels over a single TCP connection.
It is designed to be implemented in browsers and web servers, enabling real-time interactions between the client and server with minimal latency.

## How to use: 
* Install Docker
*Open the terminal, it can be the standard one or the IDE one, in the folder where you want to run the project and use the command

  ``
  docker push pivoluz/chat_realtime-api
  ``

* After downloading the image, run

  ``
  docker run --rm -p "8080:8080" -t chatapi pivoluz/chat_realtime-api
  ``
  
* Connect your project correctly:

  * To connect to the server ``ws://localhost:8080/conect_websocket``
  
  * Topic to subscribe: ``/chat``
    
  * To send ``/app/chat_send_message``

## Body
```json
    {
        "name": "Pedro",
        "message": "Hey how's it going ?"
    }
```
## Response
```json
    {
        "name": "Pedro",
        "message": "Hey how's it going ??",
        "time": "12:30"
    }
```

## Technologies Used:
* Java 17
* SpringWeb
* SpringWebSocket
* Lombook
* Docker
