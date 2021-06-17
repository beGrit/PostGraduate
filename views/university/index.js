import {TopNavBarComponent} from "/components/TopNav/TopNav.js";
import {BottomNavComponent} from "/components/BottomNav/index.js";
import {fetchUserConcernedUniversities} from "/js/restfulApi.js";

window.onload = function () {
    // 网络请求区
    const promise = fetchUserConcernedUniversities();
    promise
        .then(resp => {
            return resp.json();
        })
        .then(json => {
            return json["data"];
        })
        .then(data => {
            universityInfo.initial(data);
        });

    // 数据处理区
    class UniversityInfo {
        constructor() {
            this.root = document.querySelector("#university_img");
        }

        initial(dataList) {
            // 数据保留
            this.dataList = dataList;

            this.renderSelect(dataList);

            let data = dataList[0];

            this.renderContent(data);

            this.renderLocation(data.location)
        }

        renderSelect(dataList) {
            const universityNames = this.root.querySelector("#university_names");

            universityNames.querySelectorAll("*").forEach(elm => {
                elm.remove();
            });

            let count = 0;

            for (let item of dataList) {
                const newOption = document.createElement("option");
                const newH3 = document.createElement("h3");

                newOption.value = count;
                count++;
                newH3.textContent = item['name'];

                newOption.appendChild(newH3);
                universityNames.appendChild(newOption);
            }
        }

        renderContent(data) {
            this.uid = data.id;
            // 定位
            const curUname = this.root.querySelector("#university_name > h3");

            const basicInfo1 = this.root.querySelector("#university_nature > p");

            basicInfo1.querySelectorAll("*").forEach(elm => {
                elm.remove();
            });

            // 渲染
            if (data["isJBW"] !== undefined && data["isJBW"] === 1) {
                const spanItem = document.createElement("span");
                spanItem.textContent = "985 ";
                basicInfo1.appendChild(spanItem);
            }

            if (data["isEYY"] !== undefined && data["isEYY"] === 1) {
                const spanItem = document.createElement("span");
                spanItem.textContent = "211 ";
                basicInfo1.appendChild(spanItem);
            }

            if (data["isYJSY"] !== undefined && data["isYJSY"] === 1) {
                const spanItem = document.createElement("span");
                spanItem.textContent = "研究生院 ";
                basicInfo1.appendChild(spanItem);
            }

            if (data["isZHX"] !== undefined && data["isZHX"] === 1) {
                const spanItem = document.createElement("span");
                spanItem.textContent = "自划线 ";
                basicInfo1.appendChild(spanItem);
            }
        }

        renderLocation(location) {
            console.log(location)
            var map = new AMap.Map('map-container', {
                center: [104.148339, 30.676023],
                zoom: 11
            });
        }
    }

    const universityInfo = new UniversityInfo();


    // 事件监听区
    const selectUniversityElm = document.querySelector("#university_names");
    selectUniversityElm.addEventListener("change", evt => {
        const value = evt.target.value;
        universityInfo.renderContent(universityInfo.dataList[value]);
    });

    const button = document.querySelector("#select-button");
    button.addEventListener("click", evt => {
        window.location.href = "/views/select/university";
    });

    const compareElm = document.querySelector("#compare_box");
    compareElm.addEventListener("click", evt => {
        window.location.href = "/views/compare/choose";
    });


    const gradeElm = document.querySelector("#grade-item");
    const gradeBox = document.querySelector("#grade_box");
    const exBox = document.querySelector("#ex_box");

    gradeElm.addEventListener("click", evt => {
        window.location.href = "/views/university/grade/index.html?" + "uid=" + universityInfo.uid + "&" + "mid=" + "1";
    });
    gradeBox.addEventListener("click", evt => {
        window.location.href = "/views/university/grade/index.html?" + "uid=" + universityInfo.uid + "&" + "mid=" + "1";
    });

    exBox.addEventListener("click", evt => {
        console.log('备考经验')
        window.location.href = "/views/university/ex/index.html?" + "uid=" + universityInfo.uid + "&" + "mid=" + "1";
    })
}
