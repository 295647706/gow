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

    /**
     * 左侧 选中
     * */
    var check = $("#check").val();
    if(check){
        $(".layui-side-scroll ul li dd a").each(function () {
            var value = $(this).attr("data");
            if (value == check) {
                $(this).addClass("layui-this");
                return;
            }
        });
    }


}(window);