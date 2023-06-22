import { baseURL } from '../backendServerConfig.js';

export default class articleService {
    /**
     *
     * @returns {Promise<array<Article>>}
     */
    static getArticles() {
        const URL = `${baseURL}/article/articles/`;
        return fetch(URL, {method: "POST", body: JSON.stringify({"token": sessionStorage.getItem("WMSToken")}), headers: {'Content-Type': 'application/json' }})
            .then((response) => response.json());
    }

    static updateStock() {
        const URL = `${baseURL}/article/stock/update`;
        const FORM = document.querySelector("#dialog-form");
        const FORMDATA = new FormData(FORM);
        let jsonData = {};

        FORMDATA.forEach((value, key) => jsonData[key] = value);
        jsonData["token"] = sessionStorage.getItem("WMSToken");

        return fetch(URL, {method: "POST", body: JSON.stringify(jsonData), headers: {'Content-Type': 'application/json' }})
            .then((response) => response.json());
    }
}