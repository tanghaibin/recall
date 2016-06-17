$(function(){
    buildMap();
})

function buildMap(){
    // 百度地图API功能
    var map = new BMap.Map("allmap");
    var point = new BMap.Point(116.331398,39.897445);
    map.centerAndZoom(point,12);
// 创建地址解析器实例
    var myGeo = new BMap.Geocoder();
// 将地址解析结果显示在地图上,并调整地图视野
    myGeo.getPoint("四川省成都市领馆国际城", function(point){
        if (point) {
            map.centerAndZoom(point, 16);
            map.addOverlay(new BMap.Marker(point));
        }else{
            alert("您选择地址没有解析到结果!");
        }
    }, "成都市");

    add_control(map);
}


//添加地图类型和缩略图
function add_control(map){
    var mapType1 = new BMap.MapTypeControl({mapTypes: [BMAP_NORMAL_MAP,BMAP_HYBRID_MAP]});
    var mapType2 = new BMap.MapTypeControl({anchor: BMAP_ANCHOR_TOP_LEFT});
    var overView = new BMap.OverviewMapControl();
    var overViewOpen = new BMap.OverviewMapControl({isOpen:true, anchor: BMAP_ANCHOR_BOTTOM_RIGHT});
    map.addControl(mapType1);          //2D图，卫星图
    map.addControl(mapType2);          //左上角，默认地图控件
    map.setCurrentCity("成都");        //由于有3D图，需要设置城市哦
    map.addControl(overView);          //添加默认缩略地图控件
    //map.addControl(overViewOpen);      //右下角，打开
}
