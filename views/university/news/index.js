import {TopNavBarComponent} from "/components/TopNav/TopNav.js";
import {BottomNavComponent} from "/components/BottomNav/index.js";
import {getQueryVariable} from "/js/utils.js";
import {fetchOneNews} from "/js/restfulApi.js";

window.onload = function () {
    let newsId = getQueryVariable("newsId");

    const promise = fetchOneNews(newsId);
    promise
        .then(resp => {
            return resp.json();
        })
        .then(json => {
            if (json.code === 200) {
                return json.data;
            }
        })
        .then(data => {
            console.log(data);
            render(data)
        });

    function render(data) {
        const headerDom = document.querySelector(".header-container");
        const contentDom = document.querySelector(".content-container > article");

        headerDom.innerHTML = data.title + '<br>' + data.university.name + " - " + data.publishTime;

        fetch(data.attachmentPath, {
            headers: {
                'Content-Type': "text/plain;charset=utf-8"
            }
        })
            .then(resp => {
                return resp.text();
            })
            .then(text => {
                contentDom.innerHTML = text;
            });
        // contentDom.textContent
    }
}
