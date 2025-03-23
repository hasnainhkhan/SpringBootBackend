console.log("this is js file")

function removeMessage() {
    let msg = document.getElementById("message");
    if (msg) {
        msg.remove(); // Removes the message from the DOM
    }
}
document.addEventListener("DOMContentLoaded", function () {
    const sidebar = document.getElementById("sidebar");
    const sidebarToggle = document.getElementById("sidebarToggle");
    const sidebarClose = document.getElementById("sidebarClose");

    // Sidebar Toggle Button (☰)
    sidebarToggle.addEventListener("click", function () {
        sidebar.classList.add("open");
        document.body.classList.add("no-scroll"); 
    });

    // Sidebar Close Button (×)
    sidebarClose.addEventListener("click", function () {
        sidebar.classList.remove("open");
        document.body.classList.remove("no-scroll");
    });

    // Click outside sidebar to close
    document.addEventListener("click", function (event) {
        if (!sidebar.contains(event.target) && !sidebarToggle.contains(event.target)) {
            sidebar.classList.remove("open");
            document.body.classList.remove("no-scroll");
        }
    });
});



