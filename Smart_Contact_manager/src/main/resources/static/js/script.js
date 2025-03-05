console.log("this is js file")
function removeMessage() {
    let msg = document.getElementById("message");
    if (msg) {
        msg.remove(); // Removes the message from the DOM
    }
}