import {baseURL} from "../backendServerConfig.js";

/**
 *
 * @param {String} token
 */
export function verifyToken(token) {
          return fetch(`${baseURL}/login/verify`, {
            method: "POST",
            body: JSON.stringify({"token": token}),
            headers: new Headers({"Content-Type": "application/json"})
        })
              .then((response) => response.json())
              .then((data) => data.username);
}

