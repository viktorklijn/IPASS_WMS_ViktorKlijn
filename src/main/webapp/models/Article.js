export default class Article {
    /**
     *
     * @param {Number} articleNumber
     * @param {String} name
     * @param {String} description
     * @param {Manufacturer} manufacturer
     * @param {Category} category
     * @param {Number} price
     * @param {Number} barcode
     */
    constructor({
        articleNumber,
        name,
        description,
        manufacturer,
        category,
        price,
        barcode
    } = {}) {
        this.articleNumber = articleNumber;
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
        this.category = category;
        this.price = price;
        this.barcode = barcode;
    }
}