import { html, render } from '../node_modules/lit-html/lit-html.js';
import { styleMap } from "../node_modules/lit-html/directives/style-map.js";

const url = 'http://localhost:3030/jsonstore/collections/books';

// let entries = '';


const loadBooksTemplate = (entries) => html`
        <thead>
            <tr>
                <th>Title</th>
                <th>Author</th>
                <th>Action</th>     
            </tr>
        </thead>
        <tbody>
        ${entries.map(entry => bookRowTemplate(entry))}
        </tbody>
`;

const bookRowTemplate = (entry) => html`
            <tr id=${entry[0]}>
                <td>${entry[1].title}</td>
                <td>${entry[1].author}</td>
                <td>
                    <button @click = ${editBook}>Edit</button>
                    <button @click = ${deleteBook}>Delete</button>
                </td>
            </tr>
`;

const editBookTemplate = (title, author) => html`
    <form id="edit-form">
        <input type="hidden" name="id">
        <h3>Edit book</h3>
        <label>TITLE</label>
        <input type="text" name="title" placeholder="Title...">
        <label>AUTHOR</label>
        <input type="text" name="author" placeholder="Author...">
        <input type="submit" value="Save">
    </form>
`;

async function getBooks() {
    let res = await fetch(url);
    return await res.json();
}

document.getElementById('loadBooks').addEventListener('click', loadBooks);

async function loadBooks() {
    let entries = Object.entries(await getBooks());
    const table = document.querySelector('table');

    let result = loadBooksTemplate(entries);
    render(result, table);
}

async function deleteBook(e) {
    let id = e.target.parentNode.parentNode.id;

    let deleteSelectedBook = await fetch(`${url}/${id}`, {
        method: 'DELETE',
    });

    loadBooks();
}

async function editBook(e) {
    let id = e.target.parentNode.parentNode.id;

    let res = await fetch(`${url}/${id}`);
    let book = await res.json();
    let values = Object.values(book);

    let author = values[0];
    let title = values[1];

    console.log(values);

    editBookTemplate(title, author);

}