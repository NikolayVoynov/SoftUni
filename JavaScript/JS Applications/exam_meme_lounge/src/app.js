import page from "../node_modules/page/page.mjs";


import { allMemesPage } from "./views/all_memes.js";
import { createPage } from "./views/create.js";
import { detailsPage } from "./views/details.js";
import { editPage } from "./views/edit.js";
import { loginPage } from "./views/login.js";
import { profilePage } from "./views/profile.js";
import { registerPage } from "./views/register.js";
import { welcomePage } from "./views/welcome.js";

import { logout } from "./api/user.js";

import { addRender } from "./middlewares/render.js";
import { addSession } from "./middlewares/session.js";

page(addSession);
page(addRender);

page('/allmemes', allMemesPage);
page('/login', loginPage);
page('/register', registerPage);
page('/create', createPage);
page('/details/:id', detailsPage);
page('/edit/:id', editPage);
page('/profile', profilePage);
page('/logout', onLogout);
page('/', welcomePage);

page.start();

function onLogout(ctx) {
    logout()
    ctx.page.redirect('/');
}