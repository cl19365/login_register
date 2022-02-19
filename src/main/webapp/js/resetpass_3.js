function chkform() {
	let userpass = document.getElementById("inputPass").value;
	let inputCheckPass = document.getElementById("inputCheckPass").value

	if (inputCheckPass == userpass) {
		return true;
	} else {
		alert("两次输入的密码不一致");
	}
}