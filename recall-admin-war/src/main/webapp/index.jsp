<html>
<head>
    <script src="http://localhost:8080/admin/js/cvi_busy_lib.js"></script>
    <%--<style type="text/css" media="all">--%>
        <%--@media screen, projection {--%>
            <%--body {background-color: #0000a0; color: #444;}--%>
            <%--h1, h2 {color: #0000a0; margin: .2em 0;}--%>
            <%--big {color: #0000a0;}--%>
            <%--img {--%>
                <%--margin-right: 8px;--%>
                <%--width: 64px;--%>
                <%--height: 64px;--%>
                <%--border: 2px solid blue;--%>
            <%--}--%>
            <%--small {font-size: 60%; color: red;}--%>
            <%--.wrapper {--%>
                <%--margin: 3% 2%;--%>
                <%--padding: 0;--%>
            <%--}--%>
            <%--.main {--%>
                <%--width: 100%;--%>
                <%--margin: 8px 0;--%>
                <%--padding: 0;--%>
                <%--color: #444;--%>
            <%--}--%>
            <%--.content {--%>
                <%--width: 66%;--%>
                <%--float: left;--%>
                <%--margin: 0;--%>
                <%--padding: 1% 2%;--%>
                <%--background-color: #ccc;--%>
                <%--border: 8px solid white;--%>
            <%--}--%>
            <%--.sidebar {--%>
                <%--margin-left: 73%;--%>
                <%--padding: 1%;--%>
                <%--font-size: 90%;--%>
                <%--background-color: #fcc;--%>
                <%--border: 8px solid white;--%>
                <%---moz-border-radius-bottomright: 32px;--%>
                <%---webkit-border-bottom-right-radius: 32px;--%>
            <%--}--%>
            <%--.clear {--%>
                <%--clear: both;--%>
                <%--height: 1px;--%>
                <%--overflow: hidden;--%>
                <%--margin: 0;--%>
            <%--}--%>
            <%--.header {--%>
                <%--background-color: #ccf;--%>
                <%--color: #444;--%>
                <%--font-size: 90%;--%>
                <%--margin: 0;--%>
                <%--padding: .2em 2%;--%>
                <%--border: 8px solid white;--%>
                <%---moz-border-radius-topleft: 16px;--%>
                <%---moz-border-radius-topright: 16px;--%>
                <%---webkit-border-top-left-radius: 16px;--%>
                <%---webkit-border-top-right-radius: 16px;--%>
            <%--}--%>
            <%--.footer {--%>
                <%--background-color: #cfc;--%>
                <%--color: #444;--%>
                <%--margin: 0;--%>
                <%--font-size: 90%;--%>
                <%--padding: 1% 2%;--%>
                <%--border: 8px solid white;--%>
                <%---moz-border-radius-topright: 32px;--%>
                <%---moz-border-radius-bottomleft: 16px;--%>
                <%---moz-border-radius-bottomright: 16px;--%>
                <%---webkit-border-top-right-radius: 32px;--%>
                <%---webkit-border-bottom-left-radius: 16px;--%>
                <%---webkit-border-bottom-right-radius: 16px;--%>
            <%--}--%>
            <%--a { outline: 0; -moz-outline: none; }--%>
        <%--}--%>
    <%--</style>--%>
    <%--<!--[if IE 6]>--%>
    <%--<style type="text/css">--%>
        <%--.header, .sidebar {position:relative}--%>
    <%--</style>--%>
    <%--<![endif]-->--%>
    <%--<script type="text/javascript" src="cvi_busy_lib.js"></script>--%>
    <%--<script type="text/javascript" charset="utf-8">--%>
        <%--var xval, tval, bval, rval, lval;--%>
        <%--function block_viewport() {--%>
            <%--xval=getBusyOverlay('viewport',{color:'blue', opacity:0.75, text:'viewport: loading...', style:'text-shadow: 0 0 3px black;font-weight:bold;font-size:16px;color:white'},{color:'#ff0', size:256, type:'o'});--%>
            <%--if(xval) {var c=0,t=100;--%>
                <%--xval.ntime=window.setInterval(function() {--%>
                    <%--xval.settext('viewport: loading...'+c+'%'); c++;--%>
                    <%--if(c>t) {window.clearInterval(xval.ntime); xval.remove();}--%>
                <%--},50);--%>
            <%--}--%>
        <%--}--%>
    <%--</script>--%>
</head>
<body>
<h2>Hello World!</h2>
<div onclick="try {lval.remove(); lval='';}catch(e) {lval=getBusyOverlay(this,{color:'black', opacity:0.5, text:'loading', style:'text-decoration:blink;font-weight:bold;font-size:12px;color:white'},{color:'#fff', size:128, type:'o'});}">

</div>
</body>
</html>
