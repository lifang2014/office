
function checkLogin() {
	var companyname = document.getElementById("companyname"); 
	var loguser = document.getElementById("loguser"); 
    var oldpassword = document.getElementById("oldpassword"); 
    if (companyname.value == ""||companyname.value == "公司名") { 
        alert('info','请输入公司名'); 
        companyname.focus(); 
        return false;
    } if (loguser.value==""||loguser.value == "用户名") { 
        alert('info','请输入用户名'); 
        loguser.focus(); 
        return false;
    }  
     if (oldpassword.value==""||oldpassword.value=="密码") { 
        alert('info','请输入密码'); 
        oldpassword.focus(); 
        return false;
    } else{
    	hash = hex_md5(oldpassword.value);
    	$("#password").val(hash);
    	document.getElementById('loginform').submit();
    }       
}

$(function() {
	$('textarea').keydown(function(e){
		var curKey = e.which; 
		if(curKey == 13){ 
			return false; 
		} 
	}); 

	if (!('placeholder' in document.createElement('input'))) {

		$('input[placeholder],textarea[placeholder]').each(function() {
			var that = $(this), text = that.attr('placeholder');
			if (that.val() === "") {
				that.val(text).addClass('placeholder');
			}
			that.focus(function() {
				if (that.val() === text) {
					that.val("").removeClass('placeholder');
				}
			}).blur(function() {
				if (that.val() === "") {
					that.val(text).addClass('placeholder');
				}
			}).closest('form').submit(function() {
				if (that.val() === text) {
					that.val('');
				}
			});
		});
	}
})