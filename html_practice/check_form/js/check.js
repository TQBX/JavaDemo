//点击切换验证码图片
var changeImg = function () {
    var image = document.getElementById("img");
    var base_path = "../image/";
    var images_array = ["stop.png", "Lock.png", "resume.png", "suspend.png"];
    //产生[0-3]的随机数
    var image_index = Math.floor(Math.random() * 4);
    image.src = base_path + images_array[image_index];

};

//增加二级列表
var selectCity = function () {
    var data = {

        "浙江省": ["衢州市", "杭州市", "温州市"],
        "北京市": ["朝阳区", "丰台区", "海淀区"]
    };
    var province = document.getElementById("province").value;

    var city_array = data[province];
    var city_div = document.getElementById("city");

    city_div.innerHTML = "<option value='city_null'>--请选择--</option>";

    for (var i = 0; i < city_array.length; i++) {
        city_div.innerHTML += "<option value =" + city_array[i] + ">" + city_array[i] + "</option>";
    }
};
//增加失去焦点事件
//TODO
//表单校验
function checkData() {

    var flag = true;

    flag = checkNull("username", "用户名不能为空！") && flag;
    flag = checkNull("password", "密码不能为空！") && flag;
    flag = checkNull("rePassword", "确认密码不能为空！") && flag;
    flag = checkNull("name", "昵称不能为空！") && flag;
    flag = checkNull("email", "邮件不能为空！") && flag;
    flag = checkNull("file", "头像未上传！") && flag;
    flag = checkNull("info", "个人信息不能为空！") && flag;
    flag = checkNull("code", "验证码不能为空！") && flag;

    //邮箱单独判断

    flag = checkEmail() && flag;

    //确认密码单独判断
    flag = checkPassword() && flag;


    //判断地址
    flag = checkAddr() && flag;

    //判断爱好,爱好不能为空

    flag = checkHobby() && flag;

    return flag;
}

//判断地址
function checkAddr() {
    var province = document.getElementById("province");
    var city = document.getElementById("city");

    document.getElementById("addr_msg").innerText = "";

    //任意一个没选择，就提示错误
    if ((province.value === "province_null")
        || (city.value === "city_null")) {
        document.getElementById("addr_msg").innerText = "请选择省市";
        return false;
    }
    return true;


}


//判断邮箱
function checkEmail() {
    var email = document.getElementById("email");
    //检验邮箱的正则
    var reg = /^[A-Za-z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
    // document.getElementById("email_msg").innerText = "";
    if (email.value !== "" && !reg.test(email.value)) {
        document.getElementById("email_msg").innerText = "邮箱格式错误!";
        //不能直接return false;不然后面的校验无法执行
        return false;
    }

    return true;
}

//判断密码
function checkPassword() {
    var password = document.getElementById("password").value;
    var rePassword = document.getElementById("rePassword").value;

    if (password !== "" && rePassword !== "" && password !== rePassword) {
        document.getElementById("rePassword_msg").innerText = "两次密码不一致！";
        return false;
    }
    return true;
}

//判断爱好
function checkHobby() {

    var hobby_flag = false;
    document.getElementById("hobby_msg").innerText = "";
    var hobbyArray = document.getElementsByName("hobby");
    for (var i = 0; i < hobbyArray.length; i++) {
        //不能用value不为""判断，因为都有value值
        // if (hobbyArray[i].value != "") {
        //     hobby_flag = true;
        //     flag = true;
        // }

        if (hobbyArray[i].checked === true) {
            hobby_flag = true;
            return true;

        }
    }
    if (!hobby_flag) {
        document.getElementById("hobby_msg").innerText = "爱好不能为空！";
        return false;

    }
}

//公共判空
function checkNull(name, message) {
    var tag = document.getElementById(name).value;
    var tag_name = name + "_msg";
    document.getElementById(tag_name).innerText = "";
    if (tag === "") {
        document.getElementById(tag_name).innerText = message;
        return false;
    }
    return true;

}