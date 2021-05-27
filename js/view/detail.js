import {Component} from "/js/base.js";
import {fetchUniversityByIds} from "/js/ajax.js";
import {initChart} from "/js/grades-compare.js";

window.onload = function () {
    function initialData() {
        let promise = fetchUniversityByIds(1, 2);
        promise.then(response => response.json())
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
                c2.render(universities);
            });
    }

    class ComparedContent extends Component {
        constructor(id) {
            super();
            this.container = document.querySelector("#" + id);
        }
    }

    class UniversityCompareTable extends ComparedContent {
        constructor(id, rowRegisterList = null) {
            super(id);
            this.table = this.container.querySelector("table");
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
            // 渲染table表头
            const thead = this.table.querySelector("thead");
            const theadTr = thead.querySelector("tr");
            let dataSize = data.length;

            const template = document.querySelector("#university-table-header");
            for (let k = 0; k < dataSize; k++) {
                let clone = template.content.cloneNode(true);
                let th = clone.querySelector("th");
                th.textContent = data[k]['name'];
                theadTr.appendChild(th);
            }

            // 渲染 template 的数据
            const keys = Object.keys(data[0]);
            for (let i = 0; i < keys.length; i++) {

                const template = document.querySelector("#university-table-data");
                if (this.isRegistered(keys[i])) {
                    let cloneContent = template.content.cloneNode(true);
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

        clearData() {

        }
    }

    class CompareDetailHeader extends Component {
        constructor(id) {
            super();
            this.container = document.querySelector("#" + id);
        }

        registerPlugin(...plugins) {

        }

        render(data = {universities: ["未选中", "未选中"]}) {
            const nameWrapper = this.container.querySelector(".university-name-wrapper");
            const child1 = nameWrapper.firstElementChild;
            const child2 = child1.nextElementSibling;
            child1.textContent = data[0];
            child2.textContent = data[1];
        }
    }

    const c1 = new UniversityCompareTable("comprehensive-compare");
    const c2 = new CompareDetailHeader("detail-header");
    initialData();
    initChart("main");

    const tempButton = document.querySelector("#temp-button");
    tempButton.addEventListener("click", evt => {
        const oldComponent = document.querySelector(".container--show");
        const newComponent = document.querySelector(".container--hidden");
        oldComponent.className = "container--hidden";
        newComponent.className = "container--show"
    })

}


// 控制流
