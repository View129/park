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

});