import './authentication.js';
import './view/TableResource.js';
import {login} from "./service/LoginService.js";

document.addEventListener("DOMContentLoaded", () => {
    const BUTTON = document.getElementById("loginButton");
    BUTTON.addEventListener("click", () => login());
})

