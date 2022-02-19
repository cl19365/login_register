 var i=false;
 var a=0;
   $(".cl_repass>div").click(function(){
	   a++;
   if(i==false){
        i=true;
    $(".cl_repass img").css({
        "opacity":"10"
    })
}else{
    $(".cl_repass img").toggle();
}
})
function chkform() {
    //用户名表单项的值
    let username = document.getElementById("inputName").value;  // 用户密码表单项的值
    let userpass = document.getElementById("inputPass").value;
    let inputCheckPass=document.getElementById("inputCheckPass").value
    let inputPhoneNum=document.getElementById("inputPhoneNum").value
    var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
    if(username.length <1 && userpass.length <1&& inputCheckPass.length<1&&inputPhoneNum.length<1){
        alert("还未输入注册信息");
    }else{
    if (username.length >=1 && userpass.length >=1&& inputCheckPass==userpass&&myreg.test(inputPhoneNum)){
    	if(a%2!=0){
    		return true;
    	}else{
    		alert("请阅读并同意《专业技术职称评审系统用户身份验证服务协议》");
    	}
    }else{
        alert("请输入正确的注册信息");
    }
}
    return false;
}
