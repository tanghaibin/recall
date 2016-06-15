$(function(){
    $(".review-review-btn").click(function(){
        $(this).prev().append($("#review-ueditor"));
        var ue = UE.getEditor('editor');
        $(".review-review-btn").css("display",'');
        $(this).css("display","none");
        $("#review-ueditor").fadeIn("slow");
    })
})