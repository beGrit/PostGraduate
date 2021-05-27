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
                this.closeEntrance.style.display = "none";
                this.img.setAttribute("src", "img/unSelected.png");
            }
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
}
