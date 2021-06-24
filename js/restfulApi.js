const baseUrl = "http://localhost:1314";

export function fetchUniversitySelectListByMid(mid) {
    let url = baseUrl + "/api/v2.2/university/selectView/list/cretira/byMajor?" + "mid=" + mid;
    const promise = fetch(url);
    return promise;
}

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

export function fetchUniversityHeat(uid) {
    let url = baseUrl + "/api/v2.3/university/heat/one?uid=" + uid;
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

export function fetchUserConcernedUniversitiesGrades() {
    let url = baseUrl + "/api/v2.3/user/UniversityGradesVO/list";
    const promise = fetch(url);
    return promise;
}

export function addUserConcernedUniversity(uid) {
    let url = baseUrl + "/api/v2.3/user/university/one?uid=" + uid;
    const promise = fetch(url, {
        method: "POST"
    });
    return promise;
}

export function changeUserConcernedMasterMajor(mid) {
    let url = baseUrl + "/api/v2.3/user/major/one?mid=" + mid;
    const promise = fetch(url, {
        method: "PUT",
    });
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
