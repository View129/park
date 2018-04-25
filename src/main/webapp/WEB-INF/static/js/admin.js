$(function(){

	

	$('#tabs').tabs({
		fit : true,
		border : false,
	});

	 $(".ul li").on('click', function () {
	 	$(".ul li").removeClass();
      $(this).addClass('selected');
    if ($('#tabs').tabs('exists',$(this).text())) {
      $('#tabs').tabs('select',$(this).text());
      
    }else{
    	$('#tabs').tabs('add',{
    		title: $(this).text(),
    		closable: true,
        content:'<iframe name="indextab" scrolling="auto" src="'+$(this).attr('data-url')+'" frameborder="0" style="width:100%;height:100%;"></iframe>',
    	});
    }
  });

   //登陆
   $.ajax({
              type : 'POST',
              url : '/user/session',
              beforeSend : function(){
              },
              success : function (data){
                if(data&&data.code===1){
                    $('#name').text(data.data.userName);
                    $.messager.show({
                        title : '提示',
                        msg : '登陆成功',
                    });
                }else{
                    window.location.href="/user";
                }
              },
              dataType: "json",
            });

   //退出
   $('#exit').click(function(e){
      $.ajax({
              type : 'POST',
              url : '/user/exit',
              beforeSend : function(){
              },
              success : function (data){
                if(data.code===1){
                    $.messager.show({
                  title : '提示',
                  msg : '退出成功',
                  });
                    //alert(data.code)
                  window.location.href="/user";
                }else{
                   $.messager.show({
                  title : '提示',
                  msg : '退出失败！',
                  
                 });
                }
              },
              dataType: "json",
            });
   });

});

          