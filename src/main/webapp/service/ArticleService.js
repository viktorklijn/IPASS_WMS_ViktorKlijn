import { baseURL } from '../backendServerConfig.js';

export default class articleService {
    /**
     *
     * @returns {Promise<array<Article>>}
     */
    static getArticles() {
        const url = `${baseURL}/dashboard/articles/`;
        console.log(JSON.stringify({"token": sessionStorage.getItem("WMSToken")}))
        return fetch(url, {method: "POST", body: JSON.stringify({"token": sessionStorage.getItem("WMSToken")}), headers: {'Content-Type': 'application/json' }})
            .then((response) => response.json());
    }
}