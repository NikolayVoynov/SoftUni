import { html } from '../../node_modules/lit-html/lit-html.js';
import * as memesService from '../api/memes.js';


const profileTemplate = (memes, user, hasMemes) => html`
<section id="user-profile-page" class="user-profile">
    <article class="user-info">
        <img id="user-avatar-url" alt="user-profile" src=${user.gender=='male' ? "/images/male.png"
            : "/images/female.png" }>
        <div class="user-content">
            <p>Username: ${user.username}</p>
            <p>Email: ${user.email}</p>
            <p>My memes count: ${memes.length}</p>
        </div>
    </article>
    <h1 id="user-listings-title">User Memes</h1>
    <div class="user-meme-listings">
        ${hasMemes
        ? memes.map(memeTemplate)
        : html`<p class="no-memes">No memes in database.</p>`}
    </div>
</section>`;

const memeTemplate = (meme) => html`
<div class="user-meme">
    <p class="user-meme-title">${meme.title}</p>
    <img class="userProfileImage" alt="meme-img" src=${meme.imageUrl}>
    <a class="button" href="/details/${meme._id}">Details</a>
</div>`;

export async function profilePage(ctx) {
    const user = ctx.user;
    const userId = ctx.user._id;

    const memes = await memesService.getMemesByUserId(userId);

    let hasMemes = true;

    if (memes.length == 0) {
        hasMemes = false;
    }

    ctx.render(profileTemplate(memes, user, hasMemes));
}