/** 左侧 left.js */
;!function (e) {

    var manage = $("#manage").val();
    if(manage) {
        $(".layui-side-scroll ul li").each(function () {
            var value = $(this).attr("data");
            if (value == manage) {
                $(this).addClass("layui-nav-itemed");
                return;
            }
        });
    }

}(window);