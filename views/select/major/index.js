import {TopNavBarComponent} from "/components/TopNav/TopNav.js";
import {fetchMasterMajorSelectList} from "/js/restfulApi.js";

window.onload = function () {
    const promise = fetchMasterMajorSelectList();
    promise
        .then(resp => {
            return resp.json()
        })
        .then(json => {
            return json.data;
        })
        .then(data => {
            majorCollection.render2(data);
        });

    let defaultData = [
        {
            "type": "学术硕士",
            "majors": [
                {
                    "哲学": [],
                },
                {
                    "经济学": [],
                }
            ]
        },
        {
            "type": "专业硕士",
            "majors": [
                {
                    "法学": [],
                },
                {
                    "经济学": [],
                }
            ]
        }
    ]

    class MajorCollection {
        constructor() {
            this.majorList = document.querySelector("#major-list");
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
            </li>
            `;
            let defaultData = [
                {
                    "type": "学术硕士",
                    "majors": [
                        {
                            "哲学": [],
                        },
                        {
                            "经济学": [],
                        }
                    ]
                },
                {
                    "type": "专业硕士",
                    "majors": [
                        {
                            "法学": []
                        },
                        {
                            "经济学": []
                        }
                    ]
                }
            ]
            for (let item of data[0]) {

            }
        }

        render2(data) {
            for (let item of data) {
                const newLi = document.createElement("li");
                newLi.textContent = item.name;
                this.majorList.appendChild(newLi);
            }
        }

    }

    const majorCollection = new MajorCollection();
    // majorCollection.render(defaultData);
}
