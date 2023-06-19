import {verifyToken} from "./AuthService.js";
export function login() {
    let formData = new FormData(document.querySelector(".loginForm form"));
    let jsonBody = {};

    formData.forEach((value, key) => jsonBody[key] =  value);
    fetch("/v1/login/authenticate",
        {
            method: "POST",
            body: JSON.stringify(jsonBody),
            headers: new Headers({'Content-Type': 'application/json'})
        })
        .then((response) => {
            if (response.ok) return response.json();
            else throw "Wrong username/password!";
        })
        .then(async json => {
            window.sessionStorage.setItem("WMSToken", json.JWT);
            window.sessionStorage.setItem("username", await verifyToken(json.JWT));
            location.assign("/overview.html")
        })
        .catch(error => console.log(error));
}

export function logout() {
    window.sessionStorage.clear();
    location.assign("index.html");
}


