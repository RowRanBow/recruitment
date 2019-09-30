
$(function () {
    map();
    function map() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('map_1'));
var data = [
     {name: '北京', value: 69},
     {name: '天津', value: 12},
     {name: '上海', value: 12},
     {name: '重庆', value: 12},
     {name: '河北', value: 14},
     {name: '河南', value: 15},
     {name: '云南', value: 16},
     {name: '辽宁', value: 18},
     {name: '黑龙江', value: 18},
     {name: '湖南', value: 19},
     {name: '安徽', value: 21},
     {name: '山东', value: 21},
     {name: '新疆', value: 21},
     {name: '江苏', value: 22},
     {name: '浙江', value: 23},
     {name: '江西', value: 24},
     {name: '湖北', value: 24},
     {name: '广西', value: 25},
     {name: '甘肃', value: 25},
     {name: '山西', value: 25},
     {name: '内蒙古', value: 25},
     {name: '陕西', value: 25},
     {name: '吉林', value: 25},
     {name: '福建', value: 26},
     {name: '贵州', value: 26},
     {name: '广东', value: 26},
     {name: '青海', value: 27},
     {name: '西藏', value: 27},
     {name: '四川', value: 27},
     {name: '宁夏', value: 28},
     {name: '海南', value: 29},
     {name: '台湾', value: 30},
     {name: '香港', value: 30},
     {name: '澳门', value: 31}
];

//经纬度
var geoCoordMap = {
    '北京':[39.9046900000,116.4071700000],
    '天津':[39.0851000000,117.1993700000],
    '上海':[31.2303700000,121.4737000000],
    '重庆':[29.5647100000,106.5507300000],
    '河北':[38.0427600000,114.5143000000],
    '河南':[34.7472500000,113.6249300000],
    '云南':[24.8796600000,102.8332200000],
    '辽宁':[41.6771800000,123.4631000000],
    '黑龙江':[45.8021600000,126.5358000000],
    '湖南':[28.2277800000,112.9388600000],
    '安徽':[31.8205700000,117.2290100000],
    '山东':[36.5535800000,116.7519900000],
    '新疆':[43.8266300000,87.6168800000],
    '江苏':[32.0583800000,118.7964700000],
    '浙江':[30.2741500000,120.1551500000],
    '江西':[28.6820200000,115.8579400000],
    '湖北':[30.5927600000,114.3052500000],
    '广西':[22.8167300000,108.3669000000],
    '甘肃':[36.0613800000,103.8341700000],
    '山西':[37.8705900000,112.5506700000],
    '内蒙古':[40.8414900000,111.7519900000],
    '陕西':[34.3412700000,108.9398400000],
    '吉林':[43.8160200000,125.3235700000],
    '福建':[26.0742100000,119.2964700000],
    '贵州':[26.6470200000,106.6302400000],
    '广东':[23.1290800000,113.2643600000],
    '青海':[36.6172900000,101.7778200000],
    '西藏':[29.6441500000,91.1145000000],
    '四川':[30.5702000000,104.0647600000],
    '宁夏':[38.4864400000,106.2324800000],
    '海南':[20.0442200000,110.1998900000],
    '台湾':[25.0307240000,121.5200760000],
    '香港':[22.2753400000,114.1654600000],
    '澳门':[22.1987500000,113.5491300000]
};
var convertData = function (data) {
    var res = [];
    for (var i = 0; i < data.length; i++) {
        var geoCoord = geoCoordMap[data[i].name];
        if (geoCoord) {
            res.push({
                name: data[i].name,
                value: geoCoord.concat(data[i].value)
            });
        }
    }
    return res;
};

option = {
   // backgroundColor: '#404a59',
  /***  title: {
        text: '实时行驶车辆',
        subtext: 'data from PM25.in',
        sublink: 'http://www.pm25.in',
        left: 'center',
        textStyle: {
            color: '#fff'
        }
    },**/
    tooltip : {
        trigger: 'item',
		formatter: function (params) {
              if(typeof(params.value)[2] == "undefined"){
              	return params.name + ' : ' + params.value;
              }else{
              	return params.name + ' : ' + params.value[2];
              }
            }
    },
  
    geo: {
        map: 'china',
        label: {
            emphasis: {
                show: false
            }
        },
        roam: false,//禁止其放大缩小
        itemStyle: {
            normal: {
                areaColor: '#4c60ff',
                borderColor: '#002097'
            },
            emphasis: {
                areaColor: '#293fff'
            }
        }
    },
    series : [
        {
            name: '消费金额',
            type: 'scatter',
            coordinateSystem: 'geo',
            data: convertData(data),
            symbolSize: function (val) {
                return val[2] / 15;
            },
            label: {
                normal: {
                    formatter: '{b}',
                    position: 'right',
                    show: false
                },
                emphasis: {
                    show: true
                }
            },
            itemStyle: {
                normal: {
                    color: '#ffeb7b'
                }
            }
        }
		
		/**
		,
        {
            name: 'Top 5',
            type: 'effectScatter',
            coordinateSystem: 'geo',
            data: convertData(data.sort(function (a, b) {
                return b.value - a.value;
            }).slice(0, 6)),
            symbolSize: function (val) {
                return val[2] / 20;
            },
            showEffectOn: 'render',
            rippleEffect: {
                brushType: 'stroke'
            },
            hoverAnimation: true,
            label: {
                normal: {
                    formatter: '{b}',
                    position: 'right',
                    show: true
                }
            },
            itemStyle: {
                normal: {
                    color: '#ffd800',
                    shadowBlur: 10,
                    shadowColor: 'rgba(0,0,0,.3)'
                }
            },
            zlevel: 1
        }
		**/
    ]
};
		
        myChart.setOption(option);
        window.addEventListener("resize",function(){
            myChart.resize();
        });
    }

})

