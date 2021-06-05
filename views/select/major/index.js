import {TopNavBarComponent} from "/components/TopNav/TopNav.js";

window.onload = function () {
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

    }

    const majorCollection = new MajorCollection();
    majorCollection.render(defaultData);
}
