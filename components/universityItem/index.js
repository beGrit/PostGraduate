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

    let universityItem = new UniversityItem("university-item");

    const removeEntrance = document.querySelector(".item-remove");
    removeEntrance.addEventListener("click", evt => {
        universityItem.removeUniversity();
        console.log(evt)
        evt.preventDefault();
    })
}
