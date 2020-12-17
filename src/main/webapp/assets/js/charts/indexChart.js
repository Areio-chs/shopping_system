//堆叠条形图
(function(){

    var columnar2 = echarts.init(document.getElementById("columnar2"));

    option = {

        title : {
            text: "",
            x:'left'
        },

        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            data: ['java', 'php','C++','python','C'],
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis:  {
            type: 'value'
        },
        yAxis: {
            type: 'category',
            data: ['周一','周二','周三','周四','周五','周六','周日']
        },
        series: [
            {
                name: 'java',
                type: 'bar',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                        position: 'insideRight'
                    }
                },
                data: [320, 302, 301, 334, 390, 330, 320]
            },
            {
                name: 'php',
                type: 'bar',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                        position: 'insideRight'
                    }
                },
                data: [120, 132, 101, 134, 90, 230, 210]
            },
            {
                name: 'C++',
                type: 'bar',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                        position: 'insideRight'
                    }
                },
                data: [220, 182, 191, 234, 290, 330, 310]
            },
            {
                name: 'python',
                type: 'bar',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                        position: 'insideRight'
                    }
                },
                data: [150, 212, 201, 154, 190, 330, 410]
            },
            {
                name: 'C',
                type: 'bar',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                        position: 'insideRight'
                    }
                },
                data: [820, 832, 901, 934, 1290, 1330, 1320]
            }
        ]
    };

    columnar2.setOption(option);
})();


//
// (function(){
//     $.ajax({
//         url: "/admin/find/all/type",
//         type: "GET",//请求方式
//         dataType: "json",//预期服务器返回的数据类型
//         success: function (result) {
//             var map = result.extend.map;
//             var myChart = echarts.init(document.getElementById("index-pie-1"));
//             $.each(map,function(key,values){
//                 console.log("key="+key);
//                 console.log("values="+values);
//             });
//             option = {
//                 tooltip : {
//                     trigger: 'item',
//                     formatter: "{a} <br/>{b} : {c} ({d}%)"
//                 },
//                 legend: {
//                     orient : 'vertical',
//                     x : 'left',
//                     data:[
//                         ['java','php','C++','python','C']
//                     ]
//                 },
//                 toolbox: {
//                     show : true,
//                     feature : {
//                         mark : {show: true},
//                         dataView : {show: true, readOnly: false},
//                         magicType : {
//                             show: true,
//                             type: ['pie', 'funnel'],
//                             option: {
//                                 funnel: {
//                                     x: '25%',
//                                     width: '50%',
//                                     funnelAlign: 'center',
//                                     max: 1548
//                                 }
//                             }
//                         },
//                         restore : {show: true},
//                         saveAsImage : {show: true}
//                     }
//                 },
//                 calculable : true,
//                 series : [
//                     {
//                         name:'占百分比',
//                         type:'pie',
//                         radius : ['50%', '70%'],
//                         itemStyle : {
//                             normal : {
//                                 label : {
//                                     show : false
//                                 },
//                                 labelLine : {
//                                     show : false
//                                 }
//                             },
//                             emphasis : {
//                                 label : {
//                                     show : true,
//                                     position : 'center',
//                                     textStyle : {
//                                         fontSize : '20',
//                                         fontWeight : 'bold'
//                                     }
//                                 }
//                             }
//                         },
//                         data:[
//                             {value:335, name:'java'},
//                             {value:310, name:'php'},
//                             {value:234, name:'C++'},
//                             {value:135, name:'python'},
//                             {value:1548, name:'C'}
//                         ]
//                     }
//                 ]
//             };
//
//
//             myChart.setOption(option);
//         }
//     })
//
// })();



