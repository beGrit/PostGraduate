`use strict`
const template = document.createElement("template");

template.innerHTML = `
<link href="/views/university/articleList/components/articleNav/index.css" rel="stylesheet"/>
<div id="article-nav" class="article-nav">
    <a href="#">最新推荐</a>
    <a href="#">招生信息</a>
    <a href="#">招生简章</a>
</div>`;

class ArticleNavComponent extends HTMLElement {
    constructor() {
        super();
        this.attachShadow({mode: 'open'});
        this.shadowRoot.append(template.content.cloneNode(true));
        this.items = this.shadowRoot.querySelectorAll(".article-mav > a");
    }
}

/**
 * 挂载注册*/
customElements.define("article-nav-component", ArticleNavComponent);

export {ArticleNavComponent};
