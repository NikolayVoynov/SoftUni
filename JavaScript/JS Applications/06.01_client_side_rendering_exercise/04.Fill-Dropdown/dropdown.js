import { html, render } from '../node_modules/lit-html/lit-html.js';

const url = 'http://localhost:3030/jsonstore/advanced/dropdown';

async function getOptions() {
    const res = await fetch(url);
    return await res.json();
}

const optionTemplate = (options) => html`
    <select id="menu">
        ${options.map(opt => html`<option value=${opt._id}> ${opt.text}</option>`)}
    </select>
`;

let options = Object.values(await getOptions());
let divOptions = document.querySelector('div');

update(options);

function update(options) {
    const result = optionTemplate(options);
    render(result, divOptions);
}

document.querySelector('form').addEventListener('click', addItem);

async function addItem(event) {
    event.preventDefault();

    if (document.getElementById('itemText').value !== '') {
        let option = document.getElementById('itemText').value;

        let res = await fetch(url, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ text: option })
        });

        options.push(await res.json());
        update(options);
    }

    document.getElementById('itemText').value = '';
}