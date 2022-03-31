import { html } from '../../node_modules/lit-html/lit-html.js';
import * as booksService from '../api/books.js';

const detailsTemplate = (book, onDelete) => html`
<section id="details-page" class="details">
    <div class="book-information">
        <h3>${book.title}</h3>
        <p class="type">Type: ${book.type}</p>
        <p class="img"><img src=${book.imageUrl}></p>
        <div class="actions">
            ${book.isOwner
            ? html`
            <a class="button" href="/edit/${book._id}">Edit</a>
            <a @click=${onDelete} class="button" href="javascript:void(0)">Delete</a>`
            : html`
            <a class="button" href="#">Like</a>`}

            <!-- ( for Guests and Users )  -->
            <div class="likes">
                <img class="hearts" src="/images/heart.png">
                <span id="total-likes">Likes: 0</span>
            </div>
            <!-- Bonus -->
        </div>
    </div>
    <div class="book-description">
        <h3>Description:</h3>
        <p>${book.description}</p>
    </div>
</section>`;

export async function detailsPage(ctx) {
    const bookId = ctx.params.id;
    const book = await booksService.getBookById(bookId);

    if (ctx.user) {
        book.isOwner = book._ownerId == ctx.user._id;
    }

    ctx.render(detailsTemplate(book, onDelete));

    async function onDelete() {
        const choice = confirm(`Do you want to delete ${book.title}`);

        if (choice) {
            await booksService.deleteBookById(bookId);
            ctx.page.redirect('/');
        }
    }
}