$("#confirm").click(function(){
    if(document.getElementById("cl_uname").value.length>=1){
    if(document.getElementById("checkbox").checked==true){
        window.location.href="../html/resetpass_2.html"
        return true;
    }else{
        alert("请阅读并同意《专业技术职称评审系统用户身份验证服务协议》");
    }
}else{
    alert("请输入要找回密码的账号");
}
}) 