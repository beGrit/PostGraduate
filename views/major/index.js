import {TopNavBarComponent} from "/components/TopNav/TopNav.js";
import {BottomNavComponent} from "/components/BottomNav/index.js";
import {fetchUserConcernedMasterMajor} from "/js/restfulApi.js"
window.onload = function () {
    const button = document.querySelector("#select-button");
    button.addEventListener("click", evt => {
        window.location.href = "/views/select/major";
    })

    const promise = fetchUserConcernedMasterMajor();

    promise
        .then(resp => {
            return resp.json();
        })
        .then(json => {
            if (json.code === 200) {
                return json["data"];
            }
        })
        .then(data => {
            majorBox.render(data);
        });

    class MajorBox {
        constructor() {
            this.rootDom = document.querySelector("#major_box");
        }

        render(data) {
            const nameDom = this.rootDom.querySelector(".major-box-name");
            const articleDom = this.rootDom.querySelector(".major-box-description");

            nameDom.innerHTML = "<h1>" + data.name + "(专业代码：" + data.code + ")" + "</h1>";
            articleDom.textContent = data.description;

            console.log(data)
        }
    }

    const majorBox = new MajorBox();
}
