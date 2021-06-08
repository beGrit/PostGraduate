const basedUrl = "http://localhost:1314";

export function fetchUniversitySelectList() {
    const url = basedUrl + "/api/v2.2/university/selectView/list";
    const promise = fetch(url);
    return promise;
}

export function authentication(data) {
    const url = basedUrl + "/api/v2.1/authentication";
    const promise = fetch(url, {
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data),
    });
    return promise;
}

export function fetchUserDetailInfo() {
    const url = basedUrl + "/api/v2.2/userinfo/detail";
    const promise = fetch(url);
    return promise;
}
