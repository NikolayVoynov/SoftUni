async function lockedProfile() {

    const url = 'http://localhost:3030/jsonstore/advanced/profiles';

    const main = document.getElementById('main');

    let i = 1;

    const res = await fetch(url);
    const data = await res.json();

    Object.entries(data).forEach((p) => {

        let id = p[1]._id;
        let username = p[1].username;
        let email = p[1].email;
        let age = p[1].age;

        createProfileCard(i, username, email, age);

        i++;
    });


    function createProfileCard(i, username, email, age) {

        let divClassProfile = createElement('div', ['class', 'profile']);

        let img = createElement('img', ['src', './iconProfile2.png', 'class', 'userIcon']);

        let labelLock = createElement('label', [], 'Lock');
        let inputLockRadio = createElement('input', [
            'type', 'radio',
            'name', `user${i}Locked`,
            'value', 'lock',
            'ckecked', true,
        ]);

        let labelUnlock = createElement('label', [], 'Unlock');
        let inputUnlockRadio = createElement('input', [
            'type', 'radio',
            'name', `user${i}Locked`,
            'value', 'unlock',
        ]);

        let br = createElement('br');
        let hr = createElement('hr');

        let labelUsername = createElement('label', [], 'Username');
        let inputUsernameElement = createElement('input', [
            'type', 'text',
            'name', `user${i}Locked`,
            'value', username,
            'disabled', 'disabled',
            'readonly', 'readonly',
        ]);

        let br2 = createElement('br');

        let divHiddenFields = createElement('div', ['id', `user${i}HiddenFields`]);
        divHiddenFields.style.display = 'none';

        let hr2 = createElement('hr');

        let labelEmail = createElement('label', [], 'Email:');
        let inputEmailElement = createElement('input', [
            'type', 'email',
            'name', `user${i}Email`,
            'value', email,
            'disabled', 'disabled',
            'readonly', 'readonly',
        ]);

        let labelAge = createElement('label', [], 'Age:');
        let inputAgeElement = createElement('input', [
            'type', 'email',
            'name', `user${i}Age`,
            'value', age,
            'disabled', 'disabled',
            'readonly', 'readonly',
        ]);

        let showMoreButton = createElement('button', [], 'Show more');
        showMoreButton.addEventListener('click', showMoreHandler);

        divHiddenFields.appendChild(hr2);
        divHiddenFields.appendChild(labelEmail);
        divHiddenFields.appendChild(inputEmailElement);
        divHiddenFields.appendChild(labelAge);
        divHiddenFields.appendChild(inputAgeElement);

        divClassProfile.appendChild(img);
        divClassProfile.appendChild(labelLock);
        divClassProfile.appendChild(inputLockRadio);
        divClassProfile.appendChild(labelUnlock);
        divClassProfile.appendChild(inputUnlockRadio);
        divClassProfile.appendChild(br);
        divClassProfile.appendChild(hr);
        divClassProfile.appendChild(labelUsername);
        divClassProfile.appendChild(inputUsernameElement);
        divClassProfile.appendChild(divHiddenFields);
        divClassProfile.appendChild(showMoreButton);

        main.appendChild(divClassProfile);
    }

    function showMoreHandler(e) {

        let currentButton = e.target;
        let divHiddenProfile = currentButton.parentElement.querySelector('div');
        let unlockRadio = currentButton.parentElement.querySelector('input[type="radio"][value="unlock"]');

        if (unlockRadio.checked && divHiddenProfile.style.display == 'none') {
            divHiddenProfile.style.display = 'block';
            currentButton.textContent = 'Hide it';
        } else if (unlockRadio.checked && divHiddenProfile.style.display == 'block') {
            divHiddenProfile.style.display = 'none';
            currentButton.textContent = 'Show more';
        }
    }


    function createElement(tag, attributes = [], content) {
        let element = document.createElement(tag);

        if (attributes.length > 0) {
            for (let i = 0; i < attributes.length; i += 2) {
                let name = attributes[i];
                let value = attributes[i + 1];

                element.setAttribute(name, value);
            }
        }

        if (content) {
            element.textContent = content;
        }

        return element;
    }
}