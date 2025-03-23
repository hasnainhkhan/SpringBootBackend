console.log("this is js file")

function removeMessage() {
    let msg = document.getElementById("message");
    if (msg) {
        msg.remove(); // Removes the message from the DOM
    }
}
document.addEventListener("DOMContentLoaded", function () {
    let sidebar = document.querySelector(".sidebar");
    let toggleBtn = document.querySelector("#sidebarToggle");

    toggleBtn.addEventListener("click", function () {
        sidebar.classList.toggle("open");
    });
});
