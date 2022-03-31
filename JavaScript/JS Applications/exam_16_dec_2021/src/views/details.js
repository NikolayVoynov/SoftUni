import { html } from '../../node_modules/lit-html/lit-html.js';
import * as theatersService from '../api/theaters.js';
import { getUserData } from '../util.js';


const detailsTemplate = (theater, onDelete) => html`
<section id="detailsPage">
    <div id="detailsBox">
        <div class="detailsInfo">
            <h1>Title: ${theater.title}</h1>
            <div>
                <img src=${theater.imageUrl} />
            </div>
        </div>

        <div class="details">
            <h3>Theater Description</h3>
            <p>${theater.description}</p>
            <h4>Date: ${theater.date}</h4>
            <h4>Author: ${theater.author}</h4>
            <div class="buttons">
                ${theater.isOwner
                ? html`
                <a @click=${onDelete} class="btn-delete" href="javascript:void(0)">Delete</a>
                <a class="btn-edit" href="/edit/${theater._id}">Edit</a>`
                : html`
                <a class="btn-like" href="#">Like</a>
                `}

                
            </div>
            <p class="likes">Likes: 0</p>
        </div>
    </div>
</section>`;

export async function detailsPage(ctx) {
    const theaterId = ctx.params.id;
    const theater = await theatersService.getById(theaterId);

    if (ctx.user) {
        theater.isOwner = theater._ownerId == ctx.user._id;
    }

    ctx.render(detailsTemplate(theater, onDelete));

    async function onDelete() {
        const choice = confirm(`Are you sure you want to delete ${theater.title}`);

        if (choice) {
            const userId = getUserData()._id;
            await theatersService.deleteById(theaterId);
            ctx.page.redirect('/profile/' + userId)
        }

    }
}