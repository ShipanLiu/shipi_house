//  主要是 为了实现一种 友好的 效果

var opt = {
    alert : function(msg){
        layer.alert(msg);
    },

    load : function () {
        layer.load(1, {
            shade: [0.5,'#fff'] //0.1透明度的白色背景
        });
    },

    confirm : function(url, msg) {
        var msg = msg ? msg : "确定该操作吗？";
        layer.confirm(msg,function(index){
            opt.load();
            window.location = url;
        });
    },

    dialog : function(message, messageType) {
        if(message != '' && message != null) {
            if(messageType == '1') {
                layer.msg(message, {icon: 1});
            } else {
                layer.alert(message, {icon: 2});
            }
        }
    },
    // 打开窗口函数
    openWin : function(url,title, width,height) {
        var title = title ? title : false;
        layer.open({
            type: 2,
            title: title,
            zIndex:10000,
            anim: -1,
            maxmin: true,
            aini:2,
            shadeClose: false, //点击遮罩关闭层
            area: [width+"px", height+"px"],
            content: url
        });
    },
    // 关闭窗口 函数
    closeWin : function(refresh,call) {
        var index = parent.layer.getFrameIndex(window.name);
        // 你关闭窗口之后， 有一个 refresh 的 作用
        if(refresh) {
            parent.location.reload();
        }
        if(call) {
            parent.init();
        }
        parent.layer.close(index); //执行关闭
    }
}