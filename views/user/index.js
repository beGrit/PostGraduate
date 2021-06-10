import {TopNavBarComponent} from "/components/TopNav/TopNav.js";
import {BottomNavComponent} from "/components/BottomNav/index.js";
import {fetchUserDetailInfo} from "/js/restfulApi.js";

window.onload = function () {
    const promise = fetchUserDetailInfo();
    promise
        .then(resp => {
            return resp.json();
        })
        .then(json => {
            console.log(json);
            if (json['code'] !== 200) {
                throw new Error(json);
            } else {
                return json.data;
            }
        })
        .then(data => {
            userInfo.render(data);
            localStorage.setItem("userInfo", data);
        })
        .catch(reason => {
            let json = reason.message;
            if (json["code"] === 401) {
                console.log(json.message);
            }
        });

    class UserInfo {
        constructor() {
            this.root = document.querySelector("#user_info_box");
        }

        render(data) {
            this.root.querySelector("#user_nickname > h3").textContent = data['nickName'];
            this.root.querySelector("#msg_img > img").src = data["avatarPath"];

            // let concernedUniversities = data.
        }
    }

    let userInfo = new UserInfo();
}
