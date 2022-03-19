import { html, render } from '../node_modules/lit-html/lit-html.js';
import { towns } from './towns.js';

const searchTemplate = (towns, matcher) => html`
<article>
        <div id="towns">
            <ul>
                ${towns.map(t => townTemplate(t, matcher))}
            </ul>
        </div>
        <input type="text" id="searchText" />
        <button @click = ${search}>Search</button>
        <div id="result">${countMatches(towns, matcher)}</div>
    </article>
`;

const townTemplate = (townName, matcher) => html`
<li class = ${(matcher && townName.toLowerCase().includes(matcher.toLowerCase())) ? 'active' : ''}>${townName}</li>
`;

const body = document.body;
update();

function update(matcher = '') {
   let result = searchTemplate(towns, matcher);
   render(result, body);
}

function search() {
   let matcher = document.getElementById('searchText').value;
   update(matcher);
}

function countMatches(towns, matcher) {
   let numberMatches = towns.filter(t => matcher && t.toLowerCase().includes(matcher.toLowerCase())).length;
   return numberMatches ? `${numberMatches} matches found` : '';
}
