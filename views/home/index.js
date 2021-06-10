import {TopNavBarComponent} from "/components/TopNav/TopNav.js";
import {BottomNavComponent} from "/components/BottomNav/index.js";
import {fetchAllNews} from "/js/restfulApi.js";

window.onload = function () {
    const promise = fetchAllNews();
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
            contentContainer.render(data);
        });

    class ContentContainer {
        constructor() {
            this.rootDom = document.querySelector("#content-container");
        }

        render(data) {
            this.renderData(data);

            this.renderColor();
        }

        renderData(data) {
            /**
             * 模板区*/
            const template = document.createElement("template");

            template.innerHTML = `
            <section class="section-box content">
                <h5><!--title--></h5>
                <article>
                    <!--content-->
                </article>
                <button class="detail-button">详情</button>
            </section>`;

            const reader = new FileReader();
            for (let item of data) {
                const sectionDom = template.content.cloneNode(true);
                sectionDom.querySelector("h5").textContent = item.title;
                const detailButton = sectionDom.querySelector(".detail-button");
                detailButton.addEventListener("click", evt => {
                    evt.preventDefault();
                    console.log(item.id)
                    window.location.href = "/views/university/news/index.html?newsId=" + item.id;
                });
                this.rootDom.appendChild(sectionDom);
            }
        }

        renderColor() {
            /*渲染section颜色*/
            this.sectionList = this.rootDom.querySelectorAll("section");
            let colorList = ["white-content", "green-content", "yellow-content", "blue-content"]

            for (let i = 0; i < this.sectionList.length; i++) {
                this.sectionList[i].classList.add(colorList[i % 5]);
            }
        }

    }

    countDown();

    function addZero(i) {
        return i < 10 ? "0" + i : i + "";
    }

    function countDown() {
        let nowtime = new Date();
        let endtime = new Date("2021/12/24,17:57:00");
        let lefttime = parseInt((endtime.getTime() - nowtime.getTime()) / 1000);
        let d = parseInt(lefttime / (24 * 60 * 60))
        let h = parseInt(lefttime / (60 * 60) % 24);
        let m = parseInt(lefttime / 60 % 60);
        let s = parseInt(lefttime % 60);
        d = addZero(d)
        h = addZero(h);
        m = addZero(m);
        s = addZero(s);
        document.querySelector(".count").innerHTML = `${d}天 ${h} 时 ${m} 分 ${s} 秒`;
        if (lefttime <= 0) {
            document.querySelector(".count").innerHTML = "活动已结束";
            return;
        }
        setTimeout(countDown, 1000);
    }

    const contentContainer = new ContentContainer();
}
