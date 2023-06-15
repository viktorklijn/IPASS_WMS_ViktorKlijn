import {verifyToken} from "./service/AuthService.js";

const token = sessionStorage.getItem("WMSToken");

let username;
if (token) {
    verifyToken(token)
        .then((usernm) => {
            username = usernm;
        })
        .catch((error) => {
            console.log(error.toString());
        })
}


switch (location.pathname) {
    case "/overview.html":
        if (token === null) {
            location.assign("/index.html")
        }
        else {
            if (!username) {
                window.sessionStorage.clear();
                location.assign("/index.html");
            }
        }
        break;
    case "":
    case "/":
    case "/index.html":
        if (token !== null) {
            if (username) {
                location.assign("/overview.html")
                window.sessionStorage.setItem("username", username);
            }
        }
        break;
}