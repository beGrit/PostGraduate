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

    // 第三方库区
    function initMap(location) {
        let longitude = location.longitude;
        let latitude = location.latitude;
        const map = new AMap.Map('gaode-map-container', {
            resizeEnable: true,
            center: [longitude, latitude],
            zoom: 13,
        });
    }


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
            curUname.textContent = data['name'];


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

            console.log(data['location'])
            // initMap(data["location"])
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

    gradeElm.addEventListener("click", evt => {
        window.location.href = "/views/university/grade/index.html?" + "uid=" + universityInfo.uid + "&" + "mid=" + "1";
    });
    gradeBox.addEventListener("click", evt => {
        window.location.href = "/views/university/grade/index.html?" + "uid=" + universityInfo.uid + "&" + "mid=" + "1";
    });
}
