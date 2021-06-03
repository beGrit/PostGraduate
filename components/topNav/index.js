import {TopNavBarComponent} from "/components/TopNav/TopNav.js";

/**
 * 模板区*/
const template = document.createElement("template");

template.innerHTML = `
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<div class="card" style="width: 18rem;">
  <img src="/image/avatar.jpg" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 slot="title" class="card-title">
        <slot name="title">title to be replaced</slot>
    </h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
</div>
`;


class CardComponent extends HTMLElement {
    constructor() {
        super();
        this.attachShadow({mode: 'open'});
        this.shadowRoot.append(template.content.cloneNode(true));
    }

    connectedCallback() {

    }
}


/**
 * 挂载注册*/
customElements.define("card-component", CardComponent);
customElements.define("top-nav-bar-component", TopNavBarComponent);
