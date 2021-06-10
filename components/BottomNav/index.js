`use strict`

const template = document.createElement("template");

template.innerHTML = `
<link href="/components/BottomNav/index.css" rel="stylesheet"/>
<div id="bottom-nav" class="bottom-nav">
    <div class="bottom-nav-item--selected">
        <a href="/views/home/index.html"><img src="/image/icons/首页.png"></a>
    </div>
    <div class="bottom-nav-item">
        <a href="/views/university/index.html"><img src="/image/icons/管理.png"></a>
    </div>
    <div class="bottom-nav-item">
        <a href="/views/major/index.html"><img src="/image/icons/资料.png"></a>
    </div>
    <div class="bottom-nav-item">
        <a href="/views/user/index.html"><img src="/image/icons/我的.png"></a>
    </div>
<!--    <div class="bottom-nav-item">
        <a href="/views/compare/choose/index.html">比较</a>
    </div>-->
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
