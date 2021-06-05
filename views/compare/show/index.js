import {Component} from "/js/base.js";
import {fetchUniversityByIds} from "/js/adminAPI.js";
import {initChart} from "/js/grades-compare.js";
import {TopNavBarComponent} from "/components/TopNav/TopNav.js";
import {HeaderPostComponent} from "/views/compare/show/components/HeaderPost/index.js";

window.onload = function () {

    function initialData(id1, id2) {
        let fetchPromise = fetchUniversityByIds(id1, id2);
        fetchPromise.then(response => response.json())
            .then(json => json["data"])
            .then(data => {
                c1.render(data);
                let universities = [];
                for (let k = 0; k < data.length; k++) {
                    universities.push(data[k]["name"]);
                }
                return universities;
            })
            .then(universities => {
                c1.render(universities);
            })
            .catch(reason => {
                c1.render(null);
            });
    }

    /*控制流抽象*/
    class ContentController extends Component {
        constructor(id) {
            super();
            this.container = document.querySelector("#" + id);
            this.buttonList = this.container.querySelectorAll(".content-control__item--selected,.content-control__item");
        }

        bindEvents(container) {
            this.buttonList.forEach(item => {
                item.addEventListener("click", evt => {
                    console.log(item)
                    this.switchTo(item, container);
                });
            });
        }

        getNumOfButtonList() {
            return this.buttonList.length;
        }

        getCurSelectedItemIdx() {
            return Array.from(this.buttonList).indexOf(this.getCurSelectedItem());
        }

        getCurSelectedItem() {
            for (let item of this.buttonList) {
                if (item.className === "content-control__item--selected") {
                    return item;
                }
            }
        }

        switchTo(item, container) {
            let size = this.getNumOfButtonList();
            let curSelectedItem = this.getCurSelectedItem();
            if (item !== curSelectedItem) {
                item.className = "content-control__item--selected";
                curSelectedItem.className = "content-control__item";
                container.switchPanelByIdx(this.getCurSelectedItemIdx());
            }
        }
    }

    /*Header*/

    /*
        class CompareDetailHeader extends Component {
            constructor(id) {
                super();
                this.container = document.querySelector("#" + id);
            }

            registerPlugin(...plugins) {

            }

            render(data) {
                const nameWrapper = this.container.querySelector(".university-name-wrapper");
                const child1 = nameWrapper.firstElementChild;
                const child2 = child1.nextElementSibling;
                child1.textContent = data[0];
                child2.textContent = data[1];
            }
        }
        const c2 = new CompareDetailHeader("detail-header");

    */

    class PanelContainer extends Component {
        constructor() {
            super();
            this.container = document.querySelector("#compare-detail-content");
            this.panelList = this.container.querySelectorAll(".content-container-panel");
        }

        switchPanelByIdx(panelIndex) {
            console.log(panelIndex)
            let oldPosition = this.container.scrollLeft;
            let targetPosition = 275 * panelIndex;
            this.container.scrollLeft = targetPosition;
        }
    }

    /*综合比较面板*/
    class CompositeComparePanel extends Component {
        constructor(id, rowRegisterList = null) {
            super();
            this.container = document.querySelector("#" + id);
            this.table = this.container.querySelector("table");
            this.thead = this.table.querySelector("thead");
            this.tbody = this.table.querySelector("tbody");

            this.rowMapper = new Map();
            if (rowRegisterList == null) {
                this.defaultRegister();
            }
        }

        defaultRegister() {
            this.registerRow("isYJSY", "是否是研究生院");
            this.registerRow("isZHX", "是否是自划线院校");
            this.registerRow("rank", "排名");
            this.registerRow("isJBW", "是否是985院校");
            this.registerRow("officialUrl", "官方网址");
        }

        /**
         * 向表格注册Row行
         * @param rawName 原始数据下行的名称
         * @param rowName 生成表格中显示的名称
         * @param func 过滤函数(负责对该行新增数据的过滤)
         */
        registerRow(rawName, rowName, func = null) {
            if (func === null) {
                this.rowMapper.set(rawName, rowName);
            }
        }

        isRegistered(rowName) {
            return this.rowMapper.has(rowName);
        }

        getRealRowName(rowName) {
            if (this.isRegistered(rowName)) {
                return this.rowMapper.get(rowName);
            }
        }

        processData(rowName, rawData) {
            let rtn = rawData;
            switch (rowName) {
                case "isYJSY": {
                    rtn = rawData === 1 ? "是" : "否";
                }
                    break;
                default:
                    break;
            }
            return rtn;
        }

        render(data) {
            // 清除已渲染过的数据
            this.clearRendered();
            if (data == null) {
                this.renderEmpty();
            } else {
                // 渲染新数据
                this.renderTable(data);
            }
        }

        renderTable(data) {
            // 渲染 thead 的数据
            const thead = this.table.querySelector("thead");

            // 获取到template
            const theadTemplate = document.querySelector("#university-table-header");

            let dataSize = data.length;
            let clone = theadTemplate.content.cloneNode(true);
            for (let k = 0; k < dataSize; k++) {
                // 创建新的结点
                let newTh = document.createElement('th');
                newTh.textContent = data[k]['name'];
                newTh.className = "item-th";
                newTh.setAttribute("scope", "col");

                // 从模板中clone出结点
                let tr = clone.querySelector("tr");

                // 挂载
                tr.appendChild(newTh);
            }
            thead.appendChild(clone);

            // 渲染 tbody 的数据
            const keys = Object.keys(data[0]);
            const tbodyTemplate = document.querySelector("#university-table-data");
            for (let i = 0; i < keys.length; i++) {
                if (this.isRegistered(keys[i])) {
                    let cloneContent = tbodyTemplate.content.cloneNode(true);
                    let tr = cloneContent.querySelector("tr");

                    // 渲染th(第一格)
                    let th = cloneContent.querySelector("th");
                    th.textContent = this.getRealRowName(keys[i]);

                    // 渲染添加td
                    for (let k = 0; k < dataSize; k++) {
                        let newTd = document.createElement("td");
                        newTd.textContent = this.processData(keys[i], data[k][keys[i]]);
                        tr.appendChild(newTd);
                    }

                    // 挂载
                    let tbody = this.table.querySelector("tbody");
                    tbody.appendChild(cloneContent);
                }
            }
        }

        renderEmpty(message = "未选中任何数据") {
            const emptyTemplate = document.querySelector("#university-table-header--empty");
            let clone = emptyTemplate.content.cloneNode(true);
            this.thead.appendChild(clone);
        }

        clearRendered() {

        }
    }

    /*分数线比较面板*/
    class GradesComparePanel extends Component {

    }

    const c1 = new CompositeComparePanel("comprehensive-compare");
    const contentController = new ContentController("content-controller");
    const contentContainer = new PanelContainer();

    contentController.bindEvents(contentContainer);

    initialData(1, 2);
    initChart("main");

    let data = {
        "m_name": "哲学",
        "u_names": [
            "复旦大学", "北京大学"
        ]
    }
    const detailHeader = document.querySelector("#detail-header");
    detailHeader.data = data;
    // detailHeader.render();
}


