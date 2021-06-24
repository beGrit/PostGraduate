// based on prepared DOM, initialize echarts instance
export function initChart(id, data) {
    const chartDom = document.getElementById(id);
    let myChart = echarts.init(chartDom);
    let option;

    let colors = ['#5470C6', '#EE6666'];
    option = {
        color: colors,
        tooltip: {
            trigger: 'none',
            axisPointer: {
                type: 'cross'
            }
        },
        legend: {
            data: ['电子科技大学', '成都理工大学']
        },
        grid: {
            top: 70,
            bottom: 50
        },
        xAxis: [
            {
                type: 'category',
                axisTick: {
                    alignWithLabel: true
                },
                axisLine: {
                    onZero: false,
                    lineStyle: {
                        color: colors[1]
                    }
                },
                axisPointer: {
                    label: {
                        formatter: function (params) {
                            return '降水量  ' + params.value
                                + (params.seriesData.length ? '：' + params.seriesData[0].data : '');
                        }
                    }
                },
                // data2: ['2016-1', '2016-2', '2016-3', '2016-4', '2016-5', '2016-6', '2016-7', '2016-8', '2016-9', '2016-10', '2016-11', '2016-12']
                // ,
                data: ['2018', '2019', '2020', '2021']
            },
            {
                type: 'category',
                axisTick: {
                    alignWithLabel: true
                },
                axisLine: {
                    onZero: false,
                    lineStyle: {
                        color: colors[0]
                    }
                },
                axisPointer: {
                    label: {
                        formatter: function (params) {
                            return '降水量  ' + params.value
                                + (params.seriesData.length ? '：' + params.seriesData[0].data : '');
                        }
                    }
                },
                data: ['2018', '2019', '2020', '2021']
            }
        ],
        yAxis: [
            {
                type: 'value'
            }
        ],
        series: [
            {
                name: '电子科技大学',
                type: 'line',
                xAxisIndex: 1,
                smooth: true,
                emphasis: {
                    focus: 'series'
                },
                data: [350, 355, 370, 390]
            },
            {
                name: '成都理工大学',
                type: 'line',
                smooth: true,
                emphasis: {
                    focus: 'series'
                },
                data: [370, 366, 378, 370]
            }
        ]
    };

    option && myChart.setOption(option);
}

export function initChart2(id, data) {
    const chartDom = document.getElementById(id);
    let myChart = echarts.init(chartDom);
    let option;
    let colors = ['#5470C6', '#EE6666', '#547058', '#EE1122'];
    option = {
        color: colors,
        tooltip: {
            trigger: 'none',
            axisPointer: {
                type: 'cross'
            }
        },
        legend: {
            data: []
        },
        grid: {
            top: 70,
            bottom: 50
        },
        xAxis: [
            {
                type: 'category',
                axisTick: {
                    alignWithLabel: true
                },
                axisLine: {
                    onZero: false,
                    lineStyle: {
                        color: colors[1]
                    }
                },
                axisPointer: {
                    label: {
                        formatter: function (params) {
                            return '成绩  ' + params.value
                                + (params.seriesData.length ? '：' + params.seriesData[0].data : '');
                        }
                    }
                },
                data: ['2018', '2019', '2020']
            },
        ],
        yAxis: [
            {
                type: 'value'
            }
        ],
        series: [
            /*            {
                            name: '电子科技大学',
                            type: 'line',
                            xAxisIndex: 1,
                            smooth: true,
                            emphasis: {
                                focus: 'series'
                            },
                            data: [350, 355, 370, 390]
                        },
                        {
                            name: '成都理工大学',
                            type: 'line',
                            smooth: true,
                            emphasis: {
                                focus: 'series'
                            },
                            data: [370, 366, 378, 370]
                        }*/
        ]
    };
    let count = 0;
    for (let item of data) {
        console.log(item)
        option.legend.data.push(item.university.name);
        option.xAxis.push({
            type: 'category',
            axisTick: {
                alignWithLabel: true
            },
            axisLine: {
                onZero: false,
                lineStyle: {
                    color: colors[count++]
                }
            },
            axisPointer: {
                label: {
                    formatter: function (params) {
                        return '成绩  ' + params.value
                            + (params.seriesData.length ? '：' + params.seriesData[0].data : '');
                    }
                }
            },
            data: ['2018', '2019', '2020']
        });
        let grades = [];
        for (let grade of item.grades) {
            grades.push(grade.average);
        }
        option.series.push({
            name: item.university.name,
            type: "line",
            smooth: true,
            emphasis: {
                focus: 'series'
            },
            data: grades
        });
    }
    option && myChart.setOption(option);
}
