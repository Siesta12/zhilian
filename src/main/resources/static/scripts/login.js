<!--添加页头页脚-->
loadFragment("header", "../templates/header_unLog.html");
loadFragment("footer", "../templates/footer.html");

<!--login登录请求-->
document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('loginButton').addEventListener('click', function () {
        var username = document.getElementById('username').value;
        var password = document.getElementById('password').value;

        var user = {
            username: username,
            password: password
        };

        axios.post('/user/login', user, {
            withCredentials: true,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function (response) {
            if (response.data.code === 1) {
                window.location.href = '../views/dashboard.html';
            } else {
                alert(response.data.msg);
            }
        }).catch(function (error) {
            console.error(error);
            alert('登录失败，请稍后重试。')
        });
    });
});