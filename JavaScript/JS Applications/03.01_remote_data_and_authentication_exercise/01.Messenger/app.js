const url = 'http://localhost:3030/jsonstore/messenger';
const messages = document.getElementById('messages');

function attachEvents() {
    document.getElementById('submit').addEventListener('click', postMessage);
    document.getElementById('refresh').addEventListener('click', getAllMessages);
}

async function postMessage() {
    const author = document.getElementById('author');
    const content = document.getElementById('content');

    if (author.value !== '' || content.value !== '') {

        await request(url, { author: author.value, content: content.value });

        author.value = '';
        content.value = '';
    }
}

async function request(url, option) {
    if (option) {
        option = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'

            },
            body: JSON.stringify(option)
        };
    }

    const res = await fetch(url, option);

    return res.json();
}

async function getAllMessages() {
    const res = await fetch(url);
    const data = await res.json();

    messages.value = Object.values(data).map(({ author, content }) => `${author}: ${content}`).join('\n');
}

attachEvents();