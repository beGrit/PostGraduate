const basedUrl = "http://localhost:1314";

export function fetchUniversitySelectList() {
    const url = basedUrl + "/api/v2.2/university/selectView/list";
    const promise = fetch(url);
    return promise;
}
