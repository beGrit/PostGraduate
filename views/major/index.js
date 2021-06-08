import {TopNavBarComponent} from "/components/TopNav/TopNav.js";
import {BottomNavComponent} from "/components/BottomNav/index.js";
window.onload = function () {
    const button = document.querySelector("#select-button");
    button.addEventListener("click", evt => {
        window.location.href = "/views/select/major";
    })
}
