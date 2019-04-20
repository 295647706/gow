$(function(){

	var footer_active = $("#footer-active").val();
    $("#footer li").each(function () {
		if(footer_active==$(this).attr("data")){
            $(this).addClass("active");
		}
    });






});