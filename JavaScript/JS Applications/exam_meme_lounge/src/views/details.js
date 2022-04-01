import { html, nothing } from '../../node_modules/lit-html/lit-html.js';
import * as memesService from '../api/memes.js'


const detailsTemplate = (meme, onDelete) => html`
<section id="meme-details">
    <h1>Meme Title: ${meme.title}

    </h1>
    <div class="meme-details">
        <div class="meme-img">
            <img alt="meme-alt" src=${meme.imageUrl}>
        </div>
        <div class="meme-description">
            <h2>Meme Description</h2>
            <p>${meme.description}</p>

            ${meme.isOwner
            ? html`
            <a class="button warning" href="/edit/${meme._id}">Edit</a>
            <button @click=${onDelete} class="button danger">Delete</button>`
            : nothing}
        </div>
    </div>
</section>`;


export async function detailsPage(ctx) {
    const memeId = ctx.params.id;
    const meme = await memesService.getMemeById(memeId);

    if (ctx.user) {
        meme.isOwner = meme._ownerId == ctx.user._id;
    }

    ctx.render(detailsTemplate(meme, onDelete));

    async function onDelete() {
        const choice = confirm(`Are you sure you want to delete ${meme.title}`);

        if (choice) {
            await memesService.deleteMemeById(memeId);
            ctx.page.redirect('/allmemes');
        }
    }

}