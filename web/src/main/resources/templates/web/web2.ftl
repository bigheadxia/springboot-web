<#assign base = request.contextPath />
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="fyunli">

    <base id="base" href="${base}">
    <title>Spring Boot - hello</title>

    <!-- Bootstrap core CSS -->
    <link href="//cdn.jsdelivr.net/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <link href="${base}/css/main.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="//cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="//cdn.jsdelivr.net/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<!-- Begin page content -->
<div class="container">
    <div class="page-header">
        <h1>Sprint Boot: Hello</h1>
    </div>

    <div>
        Date: ${time?date}
        <br>
        Time: ${time?time}
        <br>
        Message: ${message}
    </div>
</div>

<footer class="footer">
    <div class="container">
        <p class="text-muted">©2016 fyunli</p>
    </div>
</footer>


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="//cdn.jsdelivr.net/ie10-viewport/1.0.0/ie10-viewport.min.js"></script>
<script src="//cdn.jsdelivr.net/jquery/1.12.1/jquery.min.js"></script>
<script src="//cdn.jsdelivr.net/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<script type="text/javascript">
    start();
    function start() {
        var eventSource = new EventSource("call?id=123");
        eventSource.onmessage = function(event) {
            fn(event.data);
        };
//        eventSource.addEventListener("data", function(e){
//            fn(e);
//        },false);
    }
</script>

<script>
//    getMessage(fn);
    function getMessage(fn) {
        $.ajax({
            url: "/call", //一个能够提供消息的页面
            dataType: "text",    //响应类型，可以是JSON，XML等其它类型
            type: "get",         //HTTP请求类型，还可以是post
            success: function (d, s) {
                fn(d);           //得到了正常的响应时，利用回调函数通知外部
            },
            complete: function (x, s) {
                setTimeout(function () {
                    getMessage(fn);
                }, 5000);       //无论响应成功或失败，在若干秒后再询问一次服务器
            }
        });
    }

    function fn(msg) {
        if (window.Notification) {
            if (Notification.permission === 'granted') {
                var notification = new Notification('温馨提示', { body: msg ,icon:'http://upload.lairen.com/boUser/mobile_share/20170622094725960_share.jpg?r=0.6834564079754084',silent:true});
                notification.onclick = function (e) {
                    alert("点击了我")//可以点击打开一个网址
                }
            } else {
                Notification.requestPermission();//设置允许通知
            }
        }
    }
</script>
</body>
</html>