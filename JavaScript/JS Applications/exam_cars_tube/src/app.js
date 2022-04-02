import page from "../node_modules/page/page.mjs";

import { createPage } from "./views/create.js";
import { detailsPage } from "./views/details.js";
import { editPage } from "./views/edit.js";
import { homePage } from "./views/home.js";
import { loginPage } from "./views/login.js";
import { registerPage } from "./views/register.js";
import { myListingPage } from "./views/my_listing.js";
import { allListingPage } from "./views/all_listing.js";
import { searchPage } from "./views/search.js";

import {logout} from "./api/user.js"

import { addRender } from "./middlewares/render.js";
import { addSession } from "./middlewares/session.js";

page(addSession);
page(addRender);

page('/', homePage);
page('/login', loginPage);
page('/register', registerPage);
page('/edit/:id', editPage);
page('/create', createPage);
page('/details/:id', detailsPage);
page('/mylistings/:id', myListingPage);
page('/listingsAll', allListingPage);
page('/search', searchPage);
page('/logout', onLogout)

page.start();

function onLogout(ctx) {
    logout();
    ctx.page.redirect('/');
}