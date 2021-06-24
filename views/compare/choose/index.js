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
            container.setUniversityItemList(data);
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

    /*
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
    */

    class Container {
        constructor(capacity = 3) {
            this.containerDom = document.querySelector("#university-items-div");
            this.universityItemList = [];
            this.capacity = capacity;
        }

        renderMajor(data) {
            console.log(data)
        }

        setUniversityItemList(data) {
            this.universityItemList = data;
            this.renderUniversityList();
            if (this.universityItemList.length < this.capacity) {
                this.renderEmpty();
            }
            this.addPlugins();
        }

        renderUniversityList() {
            let data = this.universityItemList;
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
            const template = document.createElement("template");

            template.innerHTML = `
                <div class="university-item university-item--selected">
                    <div class="university-item-outer">
                        <div class="item-content-wrapper">
                            <a class="item-remove" href="#">
                                <div class="item-remove-icon-wrapper">
                                    <img src="imgs/close-bold.png">
                                </div>
                            </a>
                            <div class="item-content-img-wrapper">
                                <img src="/image/university_log/cdlgdx.png" class="item-content-img">
                            </div>
                        </div>
                        <p class="university-item__name">成都理工大学</p>
                    </div>
                </div>
            `;

            for (let item of data) {
                const cloneNode = template.content.cloneNode(true);
                cloneNode.querySelector(".university-item__name").textContent = item.name;
                cloneNode.querySelector(".item-content-img-wrapper > img").src = item.iconPath;
                cloneNode.querySelector(".university-item").id = 'item-' + item.id;
                this.containerDom.appendChild(cloneNode);
            }

        }

        renderEmpty() {
            const template = document.createElement("template");

            template.innerHTML = `
                <div class="university-item-outer">
                    <button class="unSelected-button">
                        <img src="imgs/unSelected.png">
                    </button>
                </div>
            `;

            let n = this.capacity - this.universityItemList.length;
            while (n !== 0) {
                const cloneNode = template.content.cloneNode(true);
                this.containerDom.appendChild(cloneNode);
                n -= 1;
            }
        }

        removeUniversity(id) {
            const item = this.containerDom.querySelector("#" + id);
            item.remove();
            this.renderEmpty();
        }

        addPlugins() {
            // 控制流监听事件绑定
            const universityItemsDom = document.querySelectorAll(".university-item");
            universityItemsDom.forEach((removeEntrance, key) => {
                removeEntrance.addEventListener("click", evt => {
                    evt.preventDefault();
                    console.log(evt.currentTarget)
                    this.removeUniversity(evt.currentTarget.id);
                });
            });

            const compareBtn = document.querySelector("#compare-button-div");
            compareBtn.addEventListener("click", evt => {
                evt.preventDefault();
                window.location.href = "/views/compare/show/index.html";
            });

            const addButtons = this.containerDom.querySelectorAll(".unSelected-button");
            addButtons.forEach(btn => {
                btn.addEventListener("click", evt => {
                    evt.preventDefault();
                    window.location.href = "/views/select/university/index.html";
                })
            })
        }
    }


    const container = new Container();
}
