import { html } from "../../node_modules/lit-html/lit-html.js";


const searchTemplate = () => html`
<section id="search-cars">
    <h1>Filter by year</h1>

    <div class="container">
        <input id="search-input" type="text" name="search" placeholder="Enter desired production year">
        <button class="button-list">Search</button>
    </div>

    <h2>Results:</h2>
    <div class="listings">

        <!-- Display all records -->
        <div class="listing">
            <div class="preview">
                <img src="/images/audia3.jpg">
            </div>
            <h2>Audi A3</h2>
            <div class="info">
                <div class="data-info">
                    <h3>Year: 2018</h3>
                    <h3>Price: 25000 $</h3>
                </div>
                <div class="data-buttons">
                    <a href="#" class="button-carDetails">Details</a>
                </div>
            </div>
        </div>

        <!-- Display if there are no matches -->
        <p class="no-cars"> No results.</p>
    </div>
</section>`;


export function searchPage(ctx) {
    ctx.render(searchTemplate())
}