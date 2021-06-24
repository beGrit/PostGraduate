import {TopNavBarComponent} from "/components/TopNav/TopNav.js";
import {
    addUserConcernedUniversity,
    fetchUniversitySelectList,
    fetchUniversitySelectListByMid,
    fetchUserConcernedMasterMajor
} from "/js/restfulApi.js";

window.onload = function () {

    class UniversityCollection {
        constructor() {
            this.cityList = document.querySelector("#city-list");
            this.initialData();
        }

        render(data) {
            let template = document.createElement("template");

            template.innerHTML = `
            <li>
                <details>
                    <summary class="city-summary">
                        <span><!--北京--></span>
                        <i><!--数量--></i>
                    </summary>
                    <ol class="university-list">
    <!--                    <li>北京林业大学</li>
                        <li>北京师范大学</li>-->
                    </ol>
                </details>
            </li>`;

            for (let item of data) {
                const newNode = template.content.cloneNode(true);
                const city = newNode.querySelector(".city-summary");
                const universityList = newNode.querySelector(".university-list");

                city.querySelector("span").textContent = item.city.name;
                if (item.universities !== null && item.universities.length !== 0) {
                    // city.querySelector("i").textContent = item.universities.
                    for (let university of item.universities) {
                        const newLi = document.createElement("li");
                        newLi.uid = university.id;
                        newLi.textContent = university.name;
                        newLi.addEventListener("click", evt => {
                            addUserConcernedUniversity(newLi.uid)
                                .then(resp => {
                                    return resp.json();
                                })
                                .then(json => {
                                    if (json.code === 200) {
                                        history.back();
                                    }
                                })
                        })
                        universityList.appendChild(newLi);
                    }
                } else {
                    city.querySelector("i").textContent = 0;
                }

                this.cityList.appendChild(newNode);
            }
        }

        renderDefault() {
            let defaultData = [
                {
                    "city": {
                        "id": 1,
                        "name": "北京"
                    },
                    "universities": [
                        {
                            "id": 1,
                            "name": "北京大学"
                        },
                        {
                            "id": 3,
                            "name": "人民大学"
                        },
                        {
                            "id": 5,
                            "name": "清华大学"
                        }
                    ],
                },
                {
                    "city": {
                        "id": 2,
                        "name": "广东"
                    },
                    "universities": [
                        {
                            "id": 2,
                            "name": "广东大学"
                        },
                        {
                            "id": 4,
                            "name": "广东师范大学"
                        }
                    ],
                },
                {
                    "city": {
                        "id": 1,
                        "name": "杭州",
                    },
                    "universities": []
                }
            ]
        }

        initialData() {
            fetchUserConcernedMasterMajor()
                .then(resp => {
                    return resp.json();
                })
                .then(json => {
                    return json.data;
                })
                .then(data => {
                    let fetchPromise = fetchUniversitySelectListByMid(data.id);
                    fetchPromise.then(response => response.json())
                        .then(json => json.data)
                        .then(data => {
                            console.log(data)
                            this.render(data);
                        })
                        .catch(reason => {
                            console.log(reason)
                            this.renderDefault();
                        })
                });
        }
    }

    const container = new UniversityCollection();
}
