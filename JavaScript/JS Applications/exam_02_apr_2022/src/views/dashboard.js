import { html } from '../../node_modules/lit-html/lit-html.js';
import * as petsService from '../api/pets.js'


const dashboardTemplate = (pets) => html`
<section id="dashboard">
    <h2 class="dashboard-title">Services for every animal</h2>
    <div class="animals-dashboard">
        ${pets.length > 0
        ? pets.map(petTemplate)
        : html`
        <div>
            <p class="no-pets">No pets in dashboard</p>
        </div>`
        }        
    </div>
</section>`;


const petTemplate = (pet) => html`
<div class="animals-board">
    <img class="animal-image-cover" src=${pet.image}>
    <h2 class="name">${pet.name}</h2>
    <h3 class="breed">${pet.breed}</h3>
    <div class="action">
        <a class="btn" href="/details/${pet._id}">Details</a>
    </div>
</div>`;

export async function dashboardPage(ctx) {
    const pets = await petsService.getAllPets();
    ctx.render(dashboardTemplate(pets));
}