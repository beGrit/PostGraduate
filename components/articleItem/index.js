const template = document.createElement("template");

template.innerHTML = `
<link href="/components/articleItem/index.css" rel="stylesheet">
<article class="article-item-outer">
    <h3 class="article-title">标题</h3>
    <section class="article-content"></section>
    <div class="article-meta"></div>
</article>
`;

class ArticleItemComponent extends HTMLElement {
    constructor() {
        super();
        this.attachShadow({mode: 'open'});
        this.shadowRoot.append(template.content.cloneNode(true));
    }

    connectedCallback() {
        this.render();
    }

    render() {
        const titleDom = this.shadowRoot.querySelector(".article-title");
        const contentDom = this.shadowRoot.querySelector(".article-content");

        if (this.customData === undefined) {
            this.customData = {};
            this.customData.title = "未定义";
            this.customData.content = "";
        }

        titleDom.textContent = this.customData.title;
        contentDom.textContent = this.customData.content;
    }
}

/**
 * 挂载注册*/
customElements.define("article-item-component", ArticleItemComponent);

export {ArticleItemComponent};
