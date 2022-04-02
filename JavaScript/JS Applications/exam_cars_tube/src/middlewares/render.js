import { render, html } from "../../node_modules/lit-html/lit-html.js";
// import { getUserData } from "../util.js";

const navTemplate = (user) => html`
<nav>
    <a class="active" href="/">Home</a>
    <a href="/listingsAll">All Listings</a>
    <a href="/search">By Year</a>
    ${user
    ? html`
    <div id="profile">
        <a>Welcome ${user.username}</a>
        <a href="/mylistings/${user._id}">My Listings</a>
        <a href="/create">Create Listing</a>
        <a href="/logout">Logout</a>
    </div>`
    : html`
    <div id="guest">
        <a href="/login">Login</a>
        <a href="/register">Register</a>
    </div>`}
</nav>`;

const header = document.getElementById('my-header');
const root = document.getElementById('site-content');

function ctxRender(content) {
    render(content, root);
}

export function addRender(ctx, next) {
    // const userId = getUserData().id;
    render(navTemplate(ctx.user), header);
    ctx.render = ctxRender;
    next();
}