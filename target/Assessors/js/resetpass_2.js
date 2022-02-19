function chkform() {
	var myreg = /^[1][3,4,5,7,8][0-9]{9}$/;

	let userPhone = document.getElementById("cl_uname").value;

	if (myreg.test(userPhone)) {
		return true;
	} else {
		alert("请输入正确的手机号码");
	}
}