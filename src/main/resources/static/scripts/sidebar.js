// 新增cookie解析函数
function getCookie(name) {
    const value = `; ${document.cookie}`;
    const parts = value.split(`; ${name}=`);
    if (parts.length === 2) return parts.pop().split(';').shift();
}

// 修改后的加载函数
function loadCookie() {
    // 填充用户名
    const usernameElement = document.getElementById('username');
    usernameElement.innerHTML = getCookie('username');
}

loadCookie();