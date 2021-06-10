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
        })
}
