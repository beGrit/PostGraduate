import {TopNavBarComponent} from "/components/TopNav/TopNav.js";

window.onload = function () {
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
}
