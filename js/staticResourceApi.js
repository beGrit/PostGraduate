const baseUrl = 'localhost:8006';

export function fetchTextFile(path) {
    const url = baseUrl + path;
    const promise = fetch(url, {
        method: "GET",
        headers: {

        }
    });
    return promise;
}
