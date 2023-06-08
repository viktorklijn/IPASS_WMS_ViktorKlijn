import { baseURL } from '../backendServerConfig.js';

export default class articleService {
    /**
     *
     * @returns {Promise<array<Article>>}
     */
    static getArticles() {
        const url = `${baseURL}/dashboard/articles/`;
        return fetch(url)
            .then((response) => response.json());
    }
}