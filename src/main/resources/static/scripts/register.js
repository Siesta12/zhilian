document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('registerButton').addEventListener('click', function () {
        var username = document.getElementById('username').value;
        var password = document.getElementById('password').value;
        var confirmPassword = document.getElementById('confirm_password').value;
        var userType = document.getElementById('user_type').value;
        var agree = document.getElementById('agree').checked;

        // 客户端验证
        if (!agree) {
            alert('请同意服务条款和隐私政策');
            return;
        }
        if (password !== confirmPassword) {
            alert('密码和确认密码不一致');
            return;
        }

        // 构造用户对象
        var user = {
            username: username,
            password: password,
            userType: userType
        };

        // 发送注册请求
        axios.post('/user/register', user, {
            withCredentials: true,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function (response) {
            if (response.data.code === 1) {
                alert('注册成功，请登录');
                window.location.href = '../views/login.html'; // 假设登录页面路径
            } else {
                alert(response.data.msg);
            }
        }).catch(function (error) {
            console.error(error);
            alert('注册失败，请稍后重试。');
        });
    });
});
