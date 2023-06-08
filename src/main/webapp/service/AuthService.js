
/**
 *
 * @param {String} token
 */
function verifyToken(token) {
          return fetch("http://localhost:8080/v1/login/verify", {
            method: "POST",
            body: JSON.stringify({"token": token}),
            headers: new Headers({"Content-Type": "application/json"})
        })
              .then((response) => response.json())
              .then((data) => data.username);
}

export {verifyToken};
