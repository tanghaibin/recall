function timeStamp2String(time){
    if(time){
        var datetime = new Date();
        datetime.setTime(time);
        var year = datetime.getFullYear();
        var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
        var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
        var hour = datetime.getHours()< 10 ? "0" + datetime.getHours() : datetime.getHours();
        var minute = datetime.getMinutes()< 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
        var second = datetime.getSeconds()< 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
        return year + "-" + month + "-" + date+" "+hour+":"+minute+":"+second;
    }else{
        return "";
    }
}
function string2Datetime(string){
    var date=new Date();
    if(!string){
        return date;
    }
    var dateStrings=string.split(" ");
    var datePfixx=dateStrings[0];
    var timePfixx=dateStrings[1];
    var ymd=datePfixx.split("-");
    if(ymd){
        var y=ymd[0];
        var m=ymd[1]-1;
        var d=ymd[2];
        date.setFullYear(y, m, d);
    }
    var hms=timePfixx.split(":");
    if(hms){
        var h=hms[0];
        var M=hms[1];
        var s=hms[2];
        date.setHours(h, M, s, 0);
    }
    return date;
}
/**
 * 获取文件服务器主机
 * type:0图片服务器地址1文件服务器地址
 */
function getFileServerHost(type){
    if(type == 0){
        return "http://localhost:8084/project-picturs-server/";
    }else if(type == 1){
        return "http://localhost:8084/project-file-server/";
    }
}

/*图片浏览查看 多张图片用逗号隔开 事件触发原    从方法是 绑定onmouseup事件*/
function bindImage(srcs,event,id){
    event.stopPropagation();
    var imageitems=new Array();
    if(srcs != 'undefined' && srcs){
        var scr=srcs.split(",");
        for(var i=0;i<scr.length;i++){
            var image=new MyImage(scr[i]);
            imageitems.push(image);
        }

    }else{
        var is=new MyImage('http://img5.duitang.com/uploads/item/201307/22/20130722192550_4tWsr.thumb.224_0.gif');
        imageitems.push(is);
    }
    $("#"+id).magnificPopup({
        items: imageitems,
        gallery: {
            enabled: true
        },
        type: 'image' // this is default type
    });
}
function MyImage(src){
    this.src=src;
}