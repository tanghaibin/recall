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