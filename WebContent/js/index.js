function checkLogin(){
	return true;
}
function check() {
    var name = document.forms["regForm"]["name"].value;
    if (name === "") {
        alert("Name should not be empty");
        return false;
    }
    var email = document.forms["regForm"]["email"].value;
    if (email === "") {
        alert("Email should not be empty");
        return false;
    }
    var phone = document.forms["regForm"]["phone"].value;
    if (phone === "") {
        alert("Phone should not be empty");
        return false;
    }
//    if (phone < 1000000000 || phone > 9999999999) {
//        alert("Phone number should be 10 digits");
//        return false;
//    }
    var pass1 = document.forms["regForm"]["password1"].value;
    if (pass1 === "") {
        alert("Password should not be empty");
        return false;
    }
    var pass2 = document.forms["regForm"]["password2"].value;
    if (pass2 === "") {
        alert("Password should not be empty");
        return false;
    }
//    if (pass1 !== pass2) {
//        alert("Passwords do not match");
//        return false;
//    }
    else return true;
}