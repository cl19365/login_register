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
    let username = document.getElementById("cl_uname").value;  // 用户密码表单项的值
    let userpass = document.getElementById("cl_password").value;
    if (username.length >=1 && userpass.length >=1){
    		return true;
        
    }
    if (username.length < 1||userpass.length < 1) {
        alert("账号或密码未输入");
    } 
    return false;
}
