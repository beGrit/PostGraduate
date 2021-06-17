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

        }

        renderMajor(data) {
            console.log(data)
        }

        renderUniversityList(data) {
            console.log(data)
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
