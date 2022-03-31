import page from "../node_modules/page/page.mjs";

import { createPage } from "./views/create.js";
import { detailsPage } from "./views/details.js";
import { editPage } from "./views/edit.js";
import { homePage } from "./views/home.js";
import { loginPage } from "./views/login.js";
import { profilePage } from "./views/profile.js";
import { registerPage } from "./views/register.js";

import {logout} from "./api/user.js"

import { addRender } from "./middlewares/render.js";
import { addSession } from "./middlewares/session.js";

import * as api from './api/theaters.js';
window.api = api;

page(addSession);
page(addRender);

page('/', homePage);
page('/login', loginPage);
page('/register', registerPage);
page('/profile/:id', profilePage);
page('/edit/:id', editPage);
page('/create', createPage);
page('/details/:id', detailsPage);
page('/logout', onLogout)

page.start();

function onLogout(ctx) {
    logout();
    ctx.page.redirect('/');
}