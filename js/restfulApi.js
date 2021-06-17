const baseUrl = "http://localhost:1314";

export function fetchUniversitySelectList() {
    const url = baseUrl + "/api/v2.2/university/selectView/list";
    const promise = fetch(url);
    return promise;
}

export function fetchMasterMajorSelectList() {
    const url = baseUrl + "/api/v2.2/major/selectView/list";
    const promise = fetch(url);
    return promise;
}

export function authentication(data) {
    const url = baseUrl + "/api/v2.1/authentication";
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
    const url = baseUrl + "/api/v2.2/userinfo/detail";
    const promise = fetch(url);
    return promise;
}

export function fetchUserConcernedUniversities() {
    const url = baseUrl + "/api/v2.3/user/university/list";
    const promise = fetch(url);
    return promise;
}

export function fetchUserConcernedMasterMajor() {
    const url = baseUrl + "/api/v2.3/user/major/one";
    const promise = fetch(url);
    return promise;
}

export function fetchGrade(uid, mid) {
    const url = baseUrl + "/api/v2.3/grade/one?uid=" + uid + "&mid=" + mid;
    const promise = fetch(url);
    return promise;
}

export function fetchAllNews() {
    const url = baseUrl + "/api/v2.1/news/list";
    const promise = fetch(url);
    return promise;
}

export function fetchOneNews(newsId) {
    const url = baseUrl + "/api/v2.1/news/one?newsId=" + newsId;
    const promise = fetch(url);
    return promise;
}

export function fetchFile(path) {

}

export function changeMajor(mid) {
    const url = baseUrl + "/api/v2.3/user/major/one?" + mid;
    const promise = fetch(url, {
        method: "PUT"
    });
    return promise;
}
