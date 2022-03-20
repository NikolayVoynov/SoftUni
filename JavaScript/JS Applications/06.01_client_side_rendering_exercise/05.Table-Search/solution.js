import { html, render } from '../node_modules/lit-html/lit-html.js';

const url = 'http://localhost:3030/jsonstore/advanced/table';


const searchTemplate = (info, matcher) => html`
${info.map(element => rowTemplate(element, matcher))}
`;

const rowTemplate = (el, matcher) => html`
<tr class = ${(matcher && (el.firstName.toLowerCase().includes(matcher.toLowerCase()) ||
      el.lastName.toLowerCase().includes(matcher.toLowerCase()) ||
      el.email.toLowerCase().includes(matcher.toLowerCase()) ||
      el.course.toLowerCase().includes(matcher.toLowerCase()))) ? 'select' : ''}>
   <td>${el.firstName} ${el.lastName}</td>
   <td>${el.email}</td>
   <td>${el.course}</td>
   </tr>
   `;

let values = Object.values(await getData());

async function getData() {
   let res = await fetch(url);
   return await res.json();
}

const tbody = document.querySelector('tbody');
update();

function update(matcher = '') {
   let result = searchTemplate(values, matcher);
   render(result, tbody);
}

document.querySelector('#searchBtn').addEventListener('click', onClick);

function onClick(e) {
   e.preventDefault();

   let matcher = document.getElementById('searchField').value;

   if (matcher !== '') {
      update(matcher);
   }

   document.getElementById('searchField').value = '';
}


