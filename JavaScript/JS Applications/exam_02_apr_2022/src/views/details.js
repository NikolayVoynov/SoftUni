import { html, nothing } from '../../node_modules/lit-html/lit-html.js';
import * as petsService from '../api/pets.js';
import { getUserData } from '../util.js';

const detailsTemplate = (pet, user, onDelete) => html`
<section id="detailsPage">
    <div class="details">
        <div class="animalPic">
            <img src=${pet.image}>
        </div>
        <div>
            <div class="animalInfo">
                <h1>Name: ${pet.name}</h1>
                <h3>Breed: ${pet.breed}</h3>
                <h4>Age: ${pet.age}</h4>
                <h4>Weight: ${pet.weight}</h4>
                <h4 class="donation">Donation: 0$</h4>
            </div>
            ${user
            ? html`
            <div class="actionBtn">
                ${pet.isOwner
                ? html`
                <a href="/edit/${pet._id}" class="edit">Edit</a>
                <a @click=${onDelete} href="javascript:void(0)" class="remove">Delete</a>`
                : html`
                <a  href="#" class="donate">Donate</a>`}                
            </div>`
            : nothing}
        </div>
    </div>
</section>`;


export async function detailsPage(ctx) {
    const petId = ctx.params.id;
    const pet = await petsService.getById(petId);
    const user = ctx.user;

    if (ctx.user) {
        pet.isOwner = pet._ownerId == ctx.user._id;
    }

    ctx.render(detailsTemplate(pet, user, onDelete));

    async function onDelete() {
        const choice = confirm(`Are you sure you want to delete ${pet.name}`);

        if (choice) {
            const userId = getUserData()._id;
            await petsService.deleteById(petId);
            ctx.page.redirect('/');
        }

    }
}