// 图片上传demo
jQuery(function () {
    var $ = jQuery,
        $list = $('#fileList'),
    // 优化retina, 在retina下这个值是2
        ratio = window.devicePixelRatio || 1,
    // 缩略图大小
        thumbnailWidth = 100 * ratio,
        thumbnailHeight = 100 * ratio,
        uploader;   // Web Uploader实例
    // 初始化Web Uploader
    uploader = WebUploader.create({
        auto: false,   // 自动上传。
        swf: BASE_URL + '/uploader/Uploader.swf',    // swf文件路径
        server: BASE_URL + '/upload',  // 文件接收服务端。
        pick: '#filePicker',    // 选择文件的按钮。可选。内部根据当前运行是创建，可能是input元素，也可能是flash.
        // 只允许选择文件，可选。
        duplicate:true,
        accept: {
            title: 'Images',
            extensions: 'gif,jpg,jpeg,bmp,png',
            mimeTypes: 'image/*'
        },
        fileSingleSizeLimit:1024*1024*5//限制图片大小为5M
    });
    // 当有文件添加进来的时候
    //uploader.on('fileQueued', function (file) {
    //    var $li = $(
    //            '<div id="' + file.id + '" class="file-item thumbnail">' +
    //            '<img>' + '<div class="info">' + file.name + '</div>' +
    //            '</div>'
    //        ),
    //        $img = $li.find('img');
    //    $list.append($li);
    //    // 创建缩略图
    //    uploader.makeThumb(file, function (error, src) {
    //        if (error) {
    //            $img.replaceWith('<span>不能预览</span>');
    //            return;
    //        }
    //        $img.attr('src', src);
    //    }, thumbnailWidth, thumbnailHeight);
    //});
    uploader.on("error",function(type){
        if(type == "F_EXCEED_SIZE")
        alert("文件大小超过5M");
    })
    uploader.on("beforeFileQueued",function(file){

    });
    uploader.on("uploadStart",function(file){

    });
    uploader.on('fileQueued', function (file) {
        uploader.makeThumb(file, function (error, src) {
            if (error) {
                $.messager.alert("提示","请选择图片文件");
                return false;
            }
            $("#imgtemp2").remove();
            $("<img src='"+src+"' id = 'imgtemp2' style='display:none;' />").appendTo(document.body);
            imgtemp2.onload = function() {
                if($("#imgtemp2").width()==$("#width").val() &&$("#imgtemp2").height()==$("#height").val()){
                    $("#file-0").remove();
                    var $li = $(
                        '<div id="file-0" class="file-item thumbnail">' +
                        '<img>' + '<div class="info">' + file.name + '</div>' +
                        '</div>'
                    );
                    $img = $li.find('img');
                    $list.append($li);
                    // 创建缩略图
                    uploader.makeThumb(file, function (error, src) {
                        if (error) {
                            $img.replaceWith('<span>不能预览</span>');
                            return;
                        }
                        $img.attr('src', src);
                    }, thumbnailWidth, thumbnailHeight);




                    uploader.upload(file);
                }else{
                    $.messager.alert("提示","图片尺寸不正确!");
                    uploader.removeFile( file,true );
                    return false;
                }

            }
        }, 1, 1);

    });


    // 文件上传过程中创建进度条实时显示。
    uploader.on('uploadProgress', function (file, percentage) {
        //var $li = $('#' + file.id),$percent = $li.find('.progress span');
        var $li = $('#file-0'),$percent = $li.find('.progress span');
        // 避免重复创建
        if (!$percent.length) {
            $percent = $('<p class="progress"><span></span></p>').appendTo($li).find('span');
        }
        $percent.css('width', percentage * 100 + '%');
    });
    // 文件上传成功，给item添加成功class, 用样式标记上传成功。
    uploader.on('uploadSuccess', function (file,response) {
        //$('#' + file.id).addClass('upload-state-done');
        $('#file-0').addClass('upload-state-done');
        //alert(response);
        var picObj = $("#picAddress");
        if(null!=picObj)
            picObj.val(response);
    });
    // 文件上传失败，现实上传出错。
    uploader.on('uploadError', function (file) {
        var $li = $('#' + file.id),$error = $li.find('div.error');
        // 避免重复创建
        if (!$error.length) {
            $error = $('<div class="error"></div>').appendTo($li);
        }
        $error.text('上传失败');
    });
    // 完成上传完了，成功或者失败，先删除进度条。
    uploader.on('uploadComplete', function (file) {
        //$('#' + file.id).find('.progress').remove();
        $('#file-0').find('.progress').remove();
    });
});