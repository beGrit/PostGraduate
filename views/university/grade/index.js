import {fetchGrade} from "/js/restfulApi.js";
import {TopNavBarComponent} from "/components/TopNav/TopNav.js";
import {getQueryVariable} from "/js/utils.js";

window.onload = function () {

    const uid = getQueryVariable("uid");
    const mid = getQueryVariable("mid");

    fetchGrade(uid, mid)
        .then(resp => {
            return resp.json();
        })
        .then(json => {
            return json.data;
        })
        .then(data => {
            if (data.length === 0) {

            } else {
                initChart(data);
            }
        });

    // echarts 第三方库
    function initChart(data) {
        console.log(data)

        const averageGradeChartDom = document.querySelector("#grade-average-chart");
        const maxGradeChartDom = document.querySelector("#grade-max-chart");
        const minGradeChartDom = document.querySelector("#grade-min-chart");

        let xList = []
        let yList = []

        data.forEach(item => {
            xList.push(item.year);
            yList.push(item.average);
        });
        renderChart(averageGradeChartDom, xList, yList);

        yList = [];
        data.forEach(item => {
            yList.push(item.maxGrade);
        });
        renderChart(maxGradeChartDom, xList, yList);

        yList = [];
        data.forEach(item => {
            yList.push(item.minGrade);
        });
        renderChart(minGradeChartDom, xList, yList);

    }

    function renderChart(dom, xList, yList) {
        let averageGradeChart = echarts.init(dom);
        let option;

        option = {
            xAxis: {
                type: 'category',
                data: xList
            },
            yAxis: {
                type: 'value'
            },
            series: [{
                data: yList,
                type: 'line'
            }]
        };

        option && averageGradeChart.setOption(option);
    }
}
