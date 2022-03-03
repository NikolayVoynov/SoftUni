async function solution() {

    const mainSection = document.getElementById('main');
    const url = 'http://localhost:3030/jsonstore/advanced/articles/list';

    const res = await fetch(url);
    const data = await res.json();


    Array.from(data).forEach(x => {
        let divAccordion = createElement('div', '', ['class', 'accordion']);
        let divHead = createElement('div', '', ['class', 'head']);
        let span = createElement('span', x.title);
        let button = createElement('button', 'More', ['class', 'button', 'id', x._id]);
        let divExtra = createElement('div', '', ['class', 'extra']);
        let p = createElement('p');

        button.addEventListener('click', toggle);

        divHead.appendChild(span);
        divHead.appendChild(button);
        divExtra.appendChild(p);
        divAccordion.appendChild(divHead);
        divAccordion.appendChild(divExtra);
        mainSection.appendChild(divAccordion);
    });


    async function toggle(e) {

        const id = e.target.id;
        const url = `http://localhost:3030/jsonstore/advanced/articles/details/${id}`;

        const res = await fetch(url);
        const data = await res.json();

        const extra = e.target.parentNode.parentNode.children[1];

        const p = e.target.parentNode.parentNode.children[1].children[0];
        p.textContent = data.content;

        if (e.target.textContent === 'More') {
            extra.style.display = 'block';
            e.target.textContent = 'Less'
        } else {
            extra.style.display = 'none';
            e.target.textContent = 'More';
        }


    }


    function createElement(type, content, attributes = []) {

        const element = document.createElement(type);

        if (content) {
            element.textContent = content;
        }

        if (attributes.length > 0) {
            for (let i = 0; i < attributes.length; i += 2) {
                element.setAttribute(attributes[i], attributes[i + 1])
            }
        }


        return element;
    }

}

solution()