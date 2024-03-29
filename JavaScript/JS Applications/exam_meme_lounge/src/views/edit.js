import { html } from '../../node_modules/lit-html/lit-html.js';
import { createSubmitHandler } from '../util.js';
import * as memesService from '../api/memes.js'


const editTemplate = (meme, onSubmit) => html`
<section id="edit-meme">
    <form @submit=${onSubmit} id="edit-form">
        <h1>Edit Meme</h1>
        <div class="container">
            <label for="title">Title</label>
            <input id="title" type="text" placeholder="Enter Title" name="title" .value=${meme.title}>
            <label for="description">Description</label>
            <textarea id="description" placeholder="Enter Description" name="description" .value=${meme.description}></textarea>
            <label for="imageUrl">Image Url</label>
            <input id="imageUrl" type="text" placeholder="Enter Meme ImageUrl" name="imageUrl" .value=${meme.imageUrl}>
            <input type="submit" class="registerbtn button" value="Edit Meme">
        </div>
    </form>
</section>`;

export async function editPage(ctx) {
    const memeId = ctx.params.id;
    const meme = await memesService.getMemeById(memeId);
    ctx.render(editTemplate(meme, createSubmitHandler(ctx, onSubmit)));
}

async function onSubmit(ctx, data, event) {
    const memeId = ctx.params.id;

    if (Object.values(data).some(m => m == '')) {
        return alert('All fields are required!');
    }

    await memesService.editMemeById(memeId, {
        title: data.title,
        description: data.description,
        imageUrl: data.imageUrl
    });

    event.target.reset();
    ctx.page.redirect('/details/' + memeId);
}

