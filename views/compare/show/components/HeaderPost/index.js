/**
 * 数据格式
 * data_form:
 *  {
        "m_name": "哲学",
        "u_names": [
            "复旦大学", "北京大学"
        ]
    }
 * @type {HTMLTemplateElement}
 */
const template = document.createElement("template");

template.innerHTML = `
    <link href="/views/compare/show/components/HeaderPost/index.css" rel="stylesheet" />
    <div class="header-inner">
        <div class="major-name-wrapper">
            <h3>软件工程</h3>
        </div>
        <div class="university-name-wrapper">
<!--            <h3>复旦大学</h3>|<h3>东南大学</h3>-->
        </div>
        <div class="university-choice-button-wrapper">
            <button>重新选择</button>
        </div>
    </div>
`

class HeaderPostComponent extends HTMLElement {
    constructor() {
        super();
        this.attachShadow({mode: 'open'});
        this.shadowRoot.append(template.content.cloneNode(true));

        const resetBtn = this.shadowRoot.querySelector(".university-choice-button-wrapper");
        console.log(resetBtn)
        resetBtn.addEventListener("click", evt => {
            window.history.back();
        });
    }

    connectedCallback() {
        let data = this.data;
        this.render("软件工程", data);
    }

    render(mname, unames) {
        const majorHeader = this.shadowRoot.querySelector(".major-name-wrapper h3");
        const uWrapper = this.shadowRoot.querySelector(".university-name-wrapper");

        majorHeader.textContent = mname; // 渲染majorHeader
        let length = unames.length;
        for (let i = 0; i < length; i++) {
            const h3 = document.createElement("h3");
            h3.textContent = unames[i];
            uWrapper.appendChild(h3);
            if (i !== length - 1) {
                uWrapper.appendChild(document.createTextNode("|"));
            }
        }
    }
}

export {HeaderPostComponent};

customElements.define("header-post-component", HeaderPostComponent);

