// based on prepared DOM, initialize echarts instance
export function initChart(id) {
    const chartDom = document.getElementById(id);
    let myChart = echarts.init(chartDom);
    let option;

    option = {
        xAxis: {
            type: 'category',
            data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: [150, 230, 224, 218, 135, 147, 260],
            type: 'line'
        }]
    };

    option && myChart.setOption(option);
}
