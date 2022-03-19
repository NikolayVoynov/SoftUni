import { html, render } from "../node_modules/lit-html/lit-html.js";

document.getElementById('btnLoadTowns').addEventListener('click', createListTowns);

const listTemplate = (data) => html`
    <ul>
    ${data.map(town => html`<li>${town}</li>`)}
    </ul>
    `;

function createListTowns(event) {
    event.preventDefault();

    if (document.getElementById('towns').value !== '') {
        const root = document.getElementById('root');
        let listTowns = document.getElementById('towns').value.split(', ');

        let result = listTemplate(listTowns);

        render(result, root);

        document.getElementById('towns').value !== '';
    }
}
