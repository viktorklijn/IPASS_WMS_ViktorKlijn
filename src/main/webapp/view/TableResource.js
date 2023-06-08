import articleService from "../service/ArticleService.js";

/**
 *
 * @param {Article} article
 * @returns {Node}
 */
function renderArticle(article) {
    const TEMPLATE = document.querySelector("#table-template");
    const CLONE = TEMPLATE.content.cloneNode(true);
    const ELEMENT = CLONE.querySelector("#table-template tr#table-row");

    // ELEMENT.id = article.name;
    CLONE.querySelector(".product-number").textContent = `${article.articleNumber}`;
    CLONE.querySelector(".product-name").textContent = article.name;
    CLONE.querySelector('.product-manufacturer').textContent = article.manufacturer.name;
    CLONE.querySelector(".product-category").textContent = article.category.name;
    CLONE.querySelector(".product-price").textContent = article.price;
    CLONE.querySelector(".product-barcode").innerHTML = `<img src="https://barcodeapi.org/api/auto/${article.barcode}" alt="Barcode: ${article.barcode}" height="100vh">`;


    return CLONE;
}

function render() {
    const articleTable = document.getElementById("overview-table");
    articleTable.innerHTML = "";
    articleService.getArticles()
        .then((articles) => {
            articles.forEach((article) => {
                articleTable.append(renderArticle(article));
            })
        })
}

if (window.location.pathname === "/overview.html") {
    render();
}

