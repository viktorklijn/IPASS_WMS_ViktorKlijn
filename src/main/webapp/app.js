import './authentication.js';
import {login} from "./service/LoginService.js";
import {logout} from "./service/LoginService.js";
import './view/TableResource.js';

const LOGOUTBUTTON = document.getElementById("logoutButton");
const LOGINBUTTON = document.getElementById("loginButton");

if (window.location.pathname === "/overview.html") {
    LOGOUTBUTTON.addEventListener("click", () => logout());
} else {
    document.addEventListener("DOMContentLoaded", () => {
        LOGINBUTTON.addEventListener("click", () => login());

    })
}

