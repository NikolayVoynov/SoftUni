import { render, html } from "../../node_modules/lit-html/lit-html.js";

const navTemplate = (user) => html`

    <a href="/allmemes">All Memes</a>
    <!-- Logged users -->
    ${user
    ? html`
    <div class="user">
        <a href="/create">Create Meme</a>
        <div class="profile">
            <span>Welcome, ${user.email}</span>
            <a href="/profile">My Profile</a>
            <a href="/logout">Logout</a>
        </div>
    </div>`
    : html`
    <div class="guest">
        <div class="profile">
            <a href="/login">Login</a>
            <a href="/register">Register</a>
        </div>
        <a class="active" href="/">Home Page</a>
    </div>`}`;

const navigation = document.getElementById('nav');
const root = document.getElementById('content');

function ctxRender(content) {
    render(content, root);
}

export function addRender(ctx, next) {
    render(navTemplate(ctx.user), navigation);
    ctx.render = ctxRender;
    next();
}