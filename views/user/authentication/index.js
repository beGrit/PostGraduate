import {authentication} from "/js/restfulApi.js";

window.onload = function () {
    const formElem = document.querySelector("#login-form");
    formElem.addEventListener("submit", evt => {
        evt.preventDefault();
        const formData = new FormData(formElem);
        let data = {};
        formData.forEach((value, key) => data[key] = value);
        authentication(data)
            .then(resp => {
                return resp.json();
            })
            .then(json => {
                if (json['code'] !== 200) {
                    throw new Error("登录失败");
                } else {
                    window.location.href = "..";
                }
            })
            .catch(reason => {
                alert(reason);
            });
    });
}
