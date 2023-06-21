import ArticleService from "../service/ArticleService.js";

/**
 *
 * @param {Number}articleNumber
 * @param {Number}articleStock
 */
export default function openDialog(articleNumber, articleStock) {
    const DIALOG = document.querySelector("dialog#edit-stock-dialog");

    DIALOG.querySelector("#stock-input").value = articleStock;
    DIALOG.querySelector("#article-number-input").value = articleNumber;
    DIALOG.querySelector(".change-button").addEventListener("click", ArticleService.updateStock)

    DIALOG.showModal();
}