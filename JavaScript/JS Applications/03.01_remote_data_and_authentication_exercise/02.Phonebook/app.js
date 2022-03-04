function attachEvents() {

    const url = 'http://localhost:3030/jsonstore/phonebook';

    const ulPhones = document.getElementById('phonebook');
    const loadButton = document.getElementById('btnLoad');
    const createButton = document.getElementById('btnCreate');
    const person = document.getElementById('person');
    const phone = document.getElementById('phone');

    loadButton.addEventListener('click', loadPhones);
    createButton.addEventListener('click', createPhone);

    async function loadPhones() {
        ulPhones.innerHTML = '';

        const res = await fetch(url);

        const data = await res.json();

        Object.values(data).forEach(x => {

            let { person, phone, _id } = x;

            let liElement = createElement('li', `${person}: ${phone}`, ulPhones);
            liElement.setAttribute('id', _id);

            let deleteButton = createElement('button', 'Delete', liElement);
            deleteButton.setAttribute('id', 'btnDelete');

            deleteButton.addEventListener('click', deletePhone);

        })
    }

    async function deletePhone(e) {

        let id = e.target.parentNode._id;
        e.target.parentNode.remove();

        let deleteElement = await fetch(`${url}/${id}`, {
            method: 'DELETE',
        });

    }


    async function createPhone() {

        if (person.value !== '' && phone.value !== '') {

            let response = await fetch(url, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ person: person.value, phone: phone.value })
            });

            loadButton.click();

            person.value = '';
            phone.value = '';
        }

    }

    function createElement(type, text, appender) {
        const element = document.createElement(type);

        element.textContent = text;

        appender.appendChild(element);

        return element;
    }


}

attachEvents();