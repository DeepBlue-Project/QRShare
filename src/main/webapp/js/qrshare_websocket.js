function initSocketConnection(topicToken) {
    let socket = new SockJS("/jssockets");
    let stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        stompClient.subscribe(`/topic/${topicToken}`, function (message) {
            stompClient.disconnect();
            document.getElementById('qrcode_image').style.display = 'none';
            document.getElementById('shared_content').textContent = JSON.parse(message.body).content;
            document.getElementById('shared_content').hidden = false;
        });
    });
}

function copyTokenToClipboard() {
    let textArea = document.getElementById("token_text_area");
    textArea.select();
    textArea.setSelectionRange(0, 99999); /* For mobile devices */
    /* Copy the text inside the text field */
    document.execCommand("copy"); // TODO: deprecated : find an alternative
}
