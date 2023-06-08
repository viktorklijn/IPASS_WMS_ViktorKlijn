// import './authentication.js';
if (window.location.pathname !== "/overview.html") {
    window.location.assign("/overview.html")
}
import './view/TableResource.js';
// import { verifyToken } from "./service/AuthService.js";
//
// if (window.location.pathname === "index.html" ||
//     window.location.pathname === "/" ||
//     window.location.pathname === "") {
//
//     if (sessionStorage.getItem("WMSToken") !== null) {
//         location.assign("/overview.html");
//     }
//
//
//     function login() {
//         let formData = new FormData(document.querySelector(".loginForm form"));
//         let jsonBody = {};
//
//         formData.forEach((value, key) => (jsonBody[key] = value));
//
//         fetch("/v1/login/authenticate", {
//             method: "POST",
//             body: JSON.stringify(jsonBody),
//             headers: new Headers({ "content-type": "application/json" }),
//         })
//             .then((response) => {
//                 if (response.ok) return response.json();
//                 else throw "Wrong username/password!";
//             })
//             .then((json) => {
//                 window.sessionStorage.setItem("WMSToken", json.JWT);
//                 window.sessionStorage.setItem("username", verifyToken(json.JWT));
//                 location.assign("/overview.html");
//             })
//             .catch((error) => console.log(error));
//     }




// }

