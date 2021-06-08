`use strict`

const template = document.createElement("template");

template.innerHTML = `
<link href="/components/BottomNav/index.css" rel="stylesheet"/>
<div id="bottom-nav" class="bottom-nav">
    <div class="bottom-nav-item--selected">
        <a href="/views/concern/index.html">关注</a>
    </div>
    <div class="bottom-nav-item">
        <a href="#">院校</a>
    </div>
    <div class="bottom-nav-item">
        <a href="#">专业</a>
    </div>
    <div class="bottom-nav-item">
        <a href="/views/user/index.html">个人</a>
    </div>
    <div class="bottom-nav-item">
        <a href="/views/compare/choose/index.html">比较</a>
    </div>
</div>`;

class BottomNavComponent extends HTMLElement {
    constructor() {
        super();

        this.attachShadow({mode: 'open'});
        this.shadowRoot.append(template.content.cloneNode(true));
        this.items = this.shadowRoot.querySelectorAll(".bottom-nav > div");
    }

    connectedCallback() {
        const index = Number.parseInt(this.getAttribute("selectedIndex"));
        this.items.forEach((item, key) => {
            if (item.className === 'bottom-nav-item--selected') {
                if (key !== index) {
                    item.className = 'bottom-nav-item';
                }
            } else {
                if (key === index) {
                    item.className = "bottom-nav-item--selected";
                }
            }
        })
    }
}


/**
 * 挂载注册*/
customElements.define("bottom-nav-component", BottomNavComponent);

export {BottomNavComponent};
