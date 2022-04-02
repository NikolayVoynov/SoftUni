import { html } from "../../node_modules/lit-html/lit-html.js";
import * as carsService from '../api/cars.js';


const myListingTemplate = (myCars, hasCars) => html`
<section id="my-listings">
    <h1>My car listings</h1>
    <div class="listings">
        ${hasCars
        ? myCars.map(carTemplate)
        : html`<p class="no-cars"> You haven't listed any cars yet.</p>`}
    </div>
</section>`;

const carTemplate = (car) => html`
<div class="listing">
    <div class="preview">
        <img src=${car.imageUrl}>
    </div>
    <h2>${car.brand} ${car.model}</h2>
    <div class="info">
        <div class="data-info">
            <h3>Year: ${car.year}</h3>
            <h3>Price: ${car.price} $</h3>
        </div>
        <div class="data-buttons">
            <a href="/details/${car._id}" class="button-carDetails">Details</a>
        </div>
    </div>
</div>`;


export async function myListingPage(ctx) {
    const user = ctx.user;
    const userId = user._id;
    const myCars = await carsService.getAllCarsByUser(userId);

    let hasCars = true;

    if (myCars.length == 0) {
        hasCars = false;
    }

    ctx.render(myListingTemplate(myCars, hasCars))
}