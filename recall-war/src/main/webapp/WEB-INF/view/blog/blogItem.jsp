<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@include file="../../../context/context.jsp" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE>
<html>
<head>
    <meta charset="utf-8">

    <link type="text/css" rel="stylesheet" href="/css/blog/blogItem.css"/>
</head>

<body>
    <p>
        说到这儿，我朋友不禁吊了一下我的胃口。说：后来你猜怎么着？半年后，我陪我同事去修车，发现我这朋友圈里晒车的哥们儿是TMD是一修车的！

        车的苦累、工作的艰辛、车主是他人，这些没有晒在朋友圈的才是这哥们儿真实的生活。也许真等他坐拥豪车无数的时候，他反而会晒起来自己修车的乐趣。

        2014年，我去北京参观比尔·维奥拉的影像作品展。排了挺长的队，好不容易进去了。据说是比尔·维奥拉在北京的首次个展，还将全球首映其最新作品《逆生》。进去之后，我先找新作品哐哐一顿拍，然后赶紧的修图滤镜后发布到朋友圈。证明我来参加艺术展览了，我身边的同学打趣道：你看看你整的就跟多懂摄像，多么热爱艺术似的。

        那刻，我突然顿悟。我并不懂艺术，甚至连比尔·维奥拉的背景资料都不知道，只知道他是被国际公认的视象装置艺术先驱这个称号而已。更别提他的作品都有什么意义，有什么理念了。我发布到朋友圈的目的是什么？证明我来了？让自己显得有艺术气息？看起来更文艺？其实真实的我并不热爱，甚至是一个简笔画也画不好，拍照没了滤镜就没法看的人。

        我想呈现在朋友圈里的，只是那些让人觉得我更有档次的东西而已。我们都有过对要上传的照片精挑细选，为了凸显某些刻意用道具摆拍。我们也曾在朋友圈里无数次表达对妈妈的爱，却很少帮妈妈刷一次碗。

        在朋友圈里，女人大都晒自拍、美食、礼物和旅游，男人大都晒肌肉、车子、运动和事业上的规模。在这个浮夸的社会里，通过晒这种行为来获得满足感。人人都在晒，晒的都是自我认为的优越感。其实那些没有或者不敢放在朋友圈里晒的才是我们真实生活的主调。

        要知道我们是攒了多少个吃泡面的日子才买到了一个名牌包包；我们是熬了多少个加班的夜晚才拿到了这份offer；我们是用了多少次美颜加修饰才P出这么美丽的自己……那些晒出来的包包、offer、照片只是生活中的点缀而已，背后的一切才是真实的你我。别拿朋友圈的内容来评价他人的生活状态，因为我们晒的不是平时的生活，只是生活中某些触动自己的瞬间，某些彰显自己闪光点的瞬间而已。

        有意思的是，往往真正权高富有、过得很好的人会很不经意，甚至很避嫌一些会彰显特权和财富的细节。往往真正有文化底蕴的人，并不屑于在朋友圈晒自己读过什么书，写过什么文章。

        有人嫌秀恩爱和晒孩子烦，也有人嫌晒富是炫耀，更有人嫌晒什么晒多了就是low。晒幸福的也许并不是真的幸福，炫富的也许真的有钱。但是不管哪种晒，作为一个看客看看就好，别把朋友圈真的当成了生活圈。如同这纷扰的大千世界的一出戏，有真有假，真实的人生精彩其实在台下。


    </p>

    <div id="segmentation-div">
        <span>评论</span>
    </div>

    <div id="review-content-div">
        <div class="review-content-item-div">
            <div class="head-pic-div">
                <img width="50px" height="50px" src="${ctx}/image/head.png" class="head-pic"/>
            </div>
            <div class="head-nickName-div">
                <b>风中叶</b><br/>
                <b style="font-size: 9px">2016-02-18 23:40:58</b>
            </div>
            <div class="review-specific-content-div">
                <p>
                    分布式的版本控系统如果要在多个人之间协作不也是需要一个像github一样的的远程版本库吗，这与集中式的有什么区别呢？
                </p>
            </div>

            <div class="review-content-child-item-div">
                <div class="head-pic-div">
                    <img width="50px" height="50px" src="${ctx}/image/head.png" class="head-pic"/>
                </div>
                <div class="head-nickName-div">
                    <b>风中叶</b><br/>
                    <b style="font-size: 9px">2016-02-18 23:40:58</b>
                </div>
                <div class="review-specific-content-div">
                    <p>
                        分布式的版本控系统如果要在多个人之间协作不也是需要一个像github一样的的远程版本库吗，这与集中式的有什么区别呢？
                    </p>
                </div>
            </div>

            <div class="review-content-child-item-div">
                <div class="head-pic-div">
                    <img width="50px" height="50px" src="${ctx}/image/head.png" class="head-pic"/>
                </div>
                <div class="head-nickName-div">
                    <b>风中叶</b><br/>
                    <b style="font-size: 9px">2016-02-18 23:40:58</b>
                </div>
                <div class="review-specific-content-div">
                    <p>
                        分布式的版本控系统如果要在多个人之间协作不也是需要一个像github一样的的远程版本库吗，这与集中式的有什么区别呢？
                    </p>
                </div>
            </div>
        </div>

        <div class="review-content-item-div">
            <div class="head-pic-div">
                <img width="50px" height="50px" src="${ctx}/image/head.png" class="head-pic"/>
            </div>
            <div class="head-nickName-div">
                <b>风中叶</b><br/>
                <b style="font-size: 9px">2016-02-18 23:40:58</b>
            </div>
            <div class="review-specific-content-div">
                <p>
                    分布式的版本控系统如果要在多个人之间协作不也是需要一个像github一样的的远程版本库吗，这与集中式的有什么区别呢？
                </p>
            </div>

            <div class="review-content-child-item-div">
                <div class="head-pic-div">
                    <img width="50px" height="50px" src="${ctx}/image/head.png" class="head-pic"/>
                </div>
                <div class="head-nickName-div">
                    <b>风中叶</b><br/>
                    <b style="font-size: 9px">2016-02-18 23:40:58</b>
                </div>
                <div class="review-specific-content-div">
                    <p>
                        分布式的版本控系统如果要在多个人之间协作不也是需要一个像github一样的的远程版本库吗，这与集中式的有什么区别呢？
                    </p>
                </div>
            </div>

            <div class="review-content-child-item-div">
                <div class="head-pic-div">
                    <img width="50px" height="50px" src="${ctx}/image/head.png" class="head-pic"/>
                </div>
                <div class="head-nickName-div">
                    <b>风中叶</b><br/>
                    <b style="font-size: 9px">2016-02-18 23:40:58</b>
                </div>
                <div class="review-specific-content-div">
                    <p>
                        分布式的版本控系统如果要在多个人之间协作不也是需要一个像github一样的的远程版本库吗，这与集中式的有什么区别呢？
                    </p>
                </div>
            </div>
        </div>

        <div class="review-content-item-div">
            <div class="head-pic-div">
                <img width="50px" height="50px" src="${ctx}/image/head.png" class="head-pic"/>
            </div>
            <div class="head-nickName-div">
                <b>风中叶</b><br/>
                <b style="font-size: 9px">2016-02-18 23:40:58</b>
            </div>
            <div class="review-specific-content-div">
                <p>
                    分布式的版本控系统如果要在多个人之间协作不也是需要一个像github一样的的远程版本库吗，这与集中式的有什么区别呢？
                </p>
            </div>

            <div class="review-content-child-item-div">
                <div class="head-pic-div">
                    <img width="50px" height="50px" src="${ctx}/image/head.png" class="head-pic"/>
                </div>
                <div class="head-nickName-div">
                    <b>风中叶</b><br/>
                    <b style="font-size: 9px">2016-02-18 23:40:58</b>
                </div>
                <div class="review-specific-content-div">
                    <p>
                        分布式的版本控系统如果要在多个人之间协作不也是需要一个像github一样的的远程版本库吗，这与集中式的有什么区别呢？
                    </p>
                </div>
            </div>

            <div class="review-content-child-item-div">
                <div class="head-pic-div">
                    <img width="50px" height="50px" src="${ctx}/image/head.png" class="head-pic"/>
                </div>
                <div class="head-nickName-div">
                    <b>风中叶</b><br/>
                    <b style="font-size: 9px">2016-02-18 23:40:58</b>
                </div>
                <div class="review-specific-content-div">
                    <p>
                        分布式的版本控系统如果要在多个人之间协作不也是需要一个像github一样的的远程版本库吗，这与集中式的有什么区别呢？
                    </p>
                </div>
            </div>
        </div>
    </div>
</body>
</html>