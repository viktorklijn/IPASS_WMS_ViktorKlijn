import './authentication.js';
import {login, logout} from "./service/LoginService.js";
import './view/TableResource.js';

document.addEventListener("DOMContentLoaded", () => {
    const LOGINBUTTON = document.getElementById("loginButton");
    LOGINBUTTON.addEventListener("click", () => login());

})
document.addEventListener("DOMContentLoaded", () => {
    const LOGOUTBUTTON = document.getElementById("logoutButton");
    LOGOUTBUTTON.addEventListener("click", () => logout());

})



