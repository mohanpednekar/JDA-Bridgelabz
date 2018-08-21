function identicalPasswords() {
    var p1 = document.forms["resetPasswordForm"]["password1"].value;
    var p2 = document.forms["resetPasswordForm"]["password2"].value;
    return p1 === p2;
}
