import { html } from '../../node_modules/lit-html/lit-html.js';
import * as memesService from '../api/memes.js';


const allMemesTemplate = (mems) => html`
<section id="meme-feed">
    <h1>All Memes</h1>
    <div id="memes">
        ${mems.length > 0
        ? mems.map(memeTemplate)
        : html`<p class="no-memes">No memes in database.</p>`
        }
    </div>
</section>`;

const memeTemplate = (mem) => html`
    <div class="meme">
        <div class="card">
            <div class="info">
                <p class="meme-title">${mem.title}</p>
                <img class="meme-image" alt="meme-img" src=${mem.imageUrl}>
            </div>
            <div id="data-buttons">
                <a class="button" href="/details/${mem._id}">Details</a>
            </div>
        </div>
    </div>`;


export async function allMemesPage(ctx) {
    const memes = await memesService.getAllMemes();
    ctx.render(allMemesTemplate(memes));
}