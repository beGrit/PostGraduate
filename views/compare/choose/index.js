import {TopNavBarComponent} from "/components/TopNav/TopNav.js";
import {fetchUserConcernedMasterMajor, fetchUserConcernedUniversities} from "/js/restfulApi.js";

let template =
    `<template id="unSelected-button">
        <div class="university-item-outer">
            <button class="unSelected-button">
                <img src="imgs/unSelected.png">
            </button>
        </div>
    </template>`;

window.onload = function () {
    const universityPromise = fetchUserConcernedUniversities();
    const majorPromise = fetchUserConcernedMasterMajor();
    universityPromise
        .then(resp => {
            return resp.json();
        })
        .then(json => {
            if (json.code === 200) {
                return json.data;
            }
        })
        .then(data => {
            container.renderUniversityList(data);
        })

    majorPromise
        .then(resp => {
            return resp.json();
        })
        .then(json => {
            if (json.code === 200) {
                return json.data;
            }
        })
        .then(data => {
            container.renderMajor(data);
        })

    class UniversityItem {
        constructor(id) {
            this.root = document.querySelector("#" + id);
            this.img = this.root.querySelector(".item-content-img-wrapper > img");
            this.closeEntrance = this.root.querySelector(".item-remove");
        }

        isSelected() {
            if (this.root.className === "university-item--selected") {
                return true;
            } else {
                return false;
            }
        }

        getCurItemElement() {
            return this.root;
        }

        chooseUniversity(src) {

        }

        removeUniversity() {
            if (this.isSelected()) {
                // 修改class状态
                this.root.className = "university-item";
                const outer = this.root.querySelector(".university-item-outer");
                outer.remove();

                let emptyTemplate = document.querySelector("#unSelected-button");
                let clone = emptyTemplate.content.cloneNode(true);
                this.root.appendChild(clone);
                // this.closeEntrance.style.display = "none";
                // this.img.setAttribute("src", "imgs/unSelected.png");
            }
        }

        addUniversity() {

        }
    }

    class Container {
        constructor() {
            this.containerDom = document.querySelector("#university-items-div");
        }

        renderMajor(data) {
            console.log(data)
        }

        renderUniversityList(data) {
            console.log(data)
            /*
                let count = 0;
                for (let item of data) {
                    const template = document.createElement("template");

                    template.innerHTML = `
                    <div id="item-2" class="university-item--selected">
                        <div class="university-item-outer">
                            <div class="item-content-wrapper">
                                <a class="item-remove" href="#">
                                    <div class="item-remove-icon-wrapper">
                                        <img src="imgs/close-bold.png" height="10" width="10">
                                    </div>
                                </a>
                                <div class="item-content-img-wrapper">
                                    <img src="/image/university_log/dzkjdx.jpeg" class="item-content-img">
                                </div>
                            </div>
                            <p class="university-item__name">电子科技大学</p>
                        </div>
                    </div>
                    `;
                    const node = template.content.cloneNode(true);

                    node.querySelector(".university-item--selected").id = "item-" + count;
                    node.querySelector(".university-item__name").textContent = item.name;

                    this.containerDom.appendChild(node);
                }*/

        }
    }


    let itemModelList = [];
    for (let i = 1; i < 4; i++) { // 创建对象数组
        itemModelList.push(new UniversityItem("item-" + i));
    }

    // 控制流监听事件绑定
    const removeEntranceList = document.querySelectorAll(".item-remove");
    removeEntranceList.forEach((removeEntrance, key) => {
        removeEntrance.addEventListener("click", evt => {
            itemModelList[key].removeUniversity();
            evt.preventDefault();
        });
    });

    const compareBtn = document.querySelector("#compare-button-div");
    compareBtn.addEventListener("click", evt => {
        evt.preventDefault();
        window.location.href = "/views/compare/show/index.html";
    });

    const container = new Container();
}
