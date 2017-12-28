


// Websocket Endpoint url
var host = window.location.host;
var path = window.location.pathname;
var webCtx = path.substring(0, path.indexOf('/', 1));
console.log(window.location.host);
console.log(webCtx);
//var endPointURL = "ws://" + window.location.host + webCtx + "/chat";
var endPointURL = "ws://localhost:8082/PChat/chat";

var chatClient = null;

$(document).ready(function(){
   $('#connect_button').click(function(){
    var username = $('#userName').val();
     connect (username);

   })
});

function connect (username) {
    chatClient = new WebSocket(endPointURL+"/"+username);
    alert(username+' Connected successfully');
    $('#userName').attr('readonly', true);
    $('#userName').addClass('input-disabled');
    chatClient.onmessage = function (event) {
        var messagesArea = document.getElementById("messages");
        var jsonObj = JSON.parse(event.data);
        var message = jsonObj.user + ": " + jsonObj.message + "\r\n";
        messagesArea.value = messagesArea.value + message;
        messagesArea.scrollTop = messagesArea.scrollHeight;
    };
   
}

function disconnect () {
    chatClient.close();
}

function sendMessage() {
    var user = document.getElementById("userName").value.trim();
    if (user === "")
        alert ("Please enter your name!");
    
    var inputElement = document.getElementById("messageInput");
    var message = inputElement.value.trim();
    if (message !== "") {
        var jsonObj = {"user" : user, "message" : message};
        chatClient.send(JSON.stringify(jsonObj));
        inputElement.value = "";
    }
    inputElement.focus();
}
