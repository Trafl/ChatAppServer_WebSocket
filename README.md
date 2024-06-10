# ChatAppServer

## Description:
Server made with Spring WebSocket for connect two or more clients for switch messages in real time
  
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

## How to use with Front-End: 

  * On the folder project, run:
    ```
    docker-compose up
    ```
  * Go to URL: [ http://localhost/login]( http://localhost/login)

## Body
```json
    {
        "name": "Pedro",
        "message": "Hey how's it going ?",
        "type": "CHAT"
    }
```
## Response
```json
    {
        "name": "Pedro",
        "message": "Hey how's it going ??",
        "time": "12:30",
        "type": "CHAT" 
    }
```

## Server Login and Logout Notification:

The Msg entity has an enum field that contains 3 types.

JOIN -> when a user joins the chat server their name is added to the SimpMessageHeaderAccessor.

CHAT -> the message is sent normally to the server.

LEAVER -> When a user leaves, it activates the SessionDisconnectEvent, thus taking the username saved in the session and returning an message to the server.

The types are a reference for the front end to know which notification it will play.

## Technologies Used:
* Java 17
* SpringWeb
* SpringWebSocket
* Lombook
* Docker

## Contribution
This project was built together with [https://github.com/Vidall](https://github.com/Vidall)

The front-end that runs with this back-end is available at [https://github.com/Vidall/chat_frontEnd](https://github.com/Vidall/chat_frontEnd)<br>
