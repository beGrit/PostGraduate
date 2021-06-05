/**
 * 模板区*/
const template = document.createElement("template");

template.innerHTML = `
<link href="/css/TopNavBar.css" rel="stylesheet">
<div id="top-nav" class="top-nav">
    <!--返回按钮-->
    <div class="top-nav__icon-wrapper">
        <img id="back-entrance" src="/image/arrow-left-bold.png">
    </div>
    <!--标题-->
    <div class="top-nav__title-wrapper">
        <span>Unnamed</span>
    </div>
    <!--分享按钮--> <!--设计插槽-->
    <div class="top-nav__icon-wrapper">
        <img src="/image/share.png">
    </div>
</div>
`


class TopNavBarComponent extends HTMLElement {
    constructor() {
        super();
        this.attachShadow({mode: 'open'});
        this.shadowRoot.append(template.content.cloneNode(true));


        this.backEntrance = this.shadowRoot.querySelector("#back-entrance");
        this.backEntrance.addEventListener("click", evt => {
            window.history.back(-1);
        })
    }

    connectedCallback() {
        const title = this.shadowRoot.querySelector(".top-nav__title-wrapper span");
        title.textContent = this.getAttribute("title");
    }
}

export {TopNavBarComponent};

/**
 * 挂载注册*/
customElements.define("top-nav-bar-component", TopNavBarComponent);
