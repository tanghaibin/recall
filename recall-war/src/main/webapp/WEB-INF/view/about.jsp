<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@include file="../../context/context.jsp" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <link rel="stylesheet" type="text/css" href="/css/top.css">
    <link rel="stylesheet" type="text/css" href="/easyui/themes/bootstrap/easyui.css">
    <link rel="stylesheet" type="text/css" href="/easyui/themes/icon.css">
    <script src="${ctx}/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="/easyui/jquery.easyui.min.js"></script>

    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=CK1XurNTAzmyNSLAGHIYEfx2"></script>
    <script type="text/javascript" src="${ctx}/js/about.js" ></script>
</head>

<body>
    <jsp:include page="/context/top.jsp"></jsp:include>

    <div id="about-content-div">
        <div id="introduce-title">
            <span>About me</span>
        </div>
        <div id="introduce-content">
            <p>
            我们要把自己塑造成一个经久不衰的名牌，无论你穿20块钱的地摊货还是20万的高级定制，它们都只是你的陪衬。记住，你才是那个最有价值的品牌。如果你没有把两万块的名牌包随手丢到地上或者顶在头上挡雨的底气，那就别背。买回来供着，证明你用不起也配不上。买名牌不是宠爱自己的唯一途径，善待自己体现在生活的每一个细节里。
            我们谈过的恋爱，不是在教育我们如何选男人么？我们买过的包包，不是在教育我们什么才叫做经典么？我们吃过100家著名餐厅，只是为了培养一条懂得鉴赏美味的舌头。我们去过的地方越多，就越觉得自己渺小而又浅薄。于是学会了对我们不了解的事物表现出应有的尊重和谦卑。

            我们读过的书，走过的路，见过的人，花掉的钱其实都是在给一堂课交学费——那就是向这个世界学习如何变的体面。例如，穿款式简单质地上乘的衣物比花里胡哨blingbling的淘宝爆款体面；了解每个品牌的文化和背景比背着印满logo的包包体面；学习拍一张有质感的照片，比用ps软件修图一百遍体面。好好的谈一场严肃的恋爱，比隔三差五的换男友体面。做个被人尊重的独立女性，比彻底依附于一个男人体面。

            所以，一个女人最值得的投资永远都是投资自己。在豆蔻年华里好好读书别满脑子谈恋爱，更不要愚蠢到跟男朋友私奔或者怀孕。奔三的年纪，好好投资自己的事业，努力赚钱。这是你投资内在外在品味气质的资本。人到中年，也要学会把自己从家务和孩子中解脱出来，投资自己的兴趣爱好，投资旅行多看世界，不然退休以后多无趣！

            如此过一生，当你白发苍苍的时候，你就是一个又有钱又有趣又时髦的老太太。这一生，无论多少岁离开都没有遗憾，这就是最好的生活。如果这辈子年轻的时候用全部精力投资男人，中年用所有时间投资孩子，年老了如果孩子不在身边，跟老头子又没有共同话题，你的晚年生活是不是一眼都能望到尽头的荒芜？
            </p>
        </div>
    </div>

    <div id="info">
        <div id="item-info">
            <p>网名：DanceSmile | 即步非烟 </p>
            <p>姓名：唐海斌</p>
            <p>籍贯：四川省--广安市</p>
            <p>现居：四川省--成都</p>
            <p>职业：JAVA 工程师</p>
            <p>邮箱：tanghaibinhaohan@163.com</p>
            <p>喜欢的书：《红与黑》《红楼梦》</p>
        </div>
        <div id="map">
            <div id="allmap"></div>
        </div>
    </div>

    <link rel="stylesheet" type="text/css" href="/css/abouts.css">

</body>
</html>