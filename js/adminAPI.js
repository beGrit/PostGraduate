const basedUrl = "http://localhost:8081";

export function fetchUniversityByIds(id1, id2) {
    const url = basedUrl + "/api/v2.1/university/list/criteria?id1=" + id1 + "&" + "id2=" + id2;
    const promise = fetch(url);
    return promise;
}

