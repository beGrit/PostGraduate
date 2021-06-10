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

export function fetchUserConcernedUniversities() {
    const url = basedUrl + "/api/v2.3/user/university/list";
    const promise = fetch(url);
    return promise;
}

export function fetchUserConcernedMasterMajor() {
    const url = basedUrl + "/api/v2.3/user/major/one";
    const promise = fetch(url);
    return promise;
}

export function fetchGrade(uid, mid) {
    const url = basedUrl + "/api/v2.3/grade/one?uid=" + uid + "&mid=" + mid;
    const promise = fetch(url);
    return promise;
}

export function fetchAllNews() {
    const url = basedUrl + "/api/v2.1/news/list";
    const promise = fetch(url);
    return promise;
}

export function fetchOneNews(newsId) {
    const url = basedUrl + "/api/v2.1/news/one?newsId=" + newsId;
    const promise = fetch(url);
    return promise;
}
