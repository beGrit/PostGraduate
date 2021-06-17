import {ArticleItemComponent} from "/components/articleItem/index.js";
import {TopNavBarComponent} from "/components/TopNav/TopNav.js";
import {ArticleNavComponent} from "/views/university/articleList/components/articleNav/index.js";
import {readTextFile} from "/js/utils.js";
import {fetchTextFile} from "/js/staticResourceApi.js";

class ArticleList {
    constructor() {
        this.rootDom = document.querySelector("#item-list");
        this.items = [];
    }

    render(data) {
        for (let item of data) {
            const articleItem = document.createElement("article-item-component");
            articleItem.customData = {
                title: item.title,
                content: item.content,
            }
            this.rootDom.appendChild(articleItem);
        }
    }
}

const articleList = new ArticleList();
let data = [
    {
        title: '电子科技大学2022年',
        content: '...',
    },
    {
        title: '\n' +
            '2021年电子科技大学硕士研究生招生网上报名公告',
        content: '',
    }
]

fetchTextFile("/resources/document/foo5.txt");

articleList.render(data);
