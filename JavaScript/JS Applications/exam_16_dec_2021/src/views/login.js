import { html } from '../../node_modules/lit-html/lit-html.js';
import { createSubmitHandler } from '../util.js';
import * as userService from '../api/user.js';

const loginTemplate = (onSubmit) => html`
<section id="loginaPage">
    <form @submit=${onSubmit} class="loginForm">
        <h2>Login</h2>
        <div>
            <label for="email">Email:</label>
            <input id="email" name="email" type="text" placeholder="steven@abv.bg" value="">
        </div>
        <div>
            <label for="password">Password:</label>
            <input id="password" name="password" type="password" placeholder="********" value="">
        </div>

        <button class="btn" type="submit">Login</button>

        <p class="field">
            <span>If you don't have profile click <a href="/register">here</a></span>
        </p>
    </form>
</section>
`;


export async function loginPage(ctx) {
    ctx.render(loginTemplate(createSubmitHandler(ctx, onSubmit)));
}

async function onSubmit(ctx, data, event) {

    if (data.email == '' || data.password == '') {
        return alert('All fields are required!');
    }

    await userService.login(data.email, data.password);
    event.target.reset();
    ctx.page.redirect('/');
}
