window.addEventListener('load', solve);

function solve() {
    const genreInputElement = document.getElementById('genre');
    const nameInputElement = document.getElementById('name');
    const authorInputElement = document.getElementById('author');
    const dateInputElement = document.getElementById('date');

    const addButtonElement = document.getElementById('add-btn');

    const allHitsContainer = document.querySelector('.all-hits-container');
    const savedContainer = document.querySelector('.saved-container');


    addButtonElement.addEventListener('click', (e) => {
        e.preventDefault();

        let genre = genreInputElement.value;
        let nameSong = nameInputElement.value;
        let author = authorInputElement.value;
        let date = dateInputElement.value;

        if (!genre || !nameSong || !author || !date) {
            return;
        }

        let imgElement = document.createElement('img');
        imgElement.src = './static/img/img.png';

        let genreH2Element = document.createElement('h2');
        let nameSongH2Element = document.createElement('h2');
        let authorH2Element = document.createElement('h2');
        let dateH3Element = document.createElement('h3');
        genreH2Element.textContent = `Genre: ${genre}`;
        nameSongH2Element.textContent = `Name: ${nameSong}`;
        authorH2Element.textContent = `Author: ${author}`;
        dateH3Element.textContent = `Date: ${date}`;

        let saveButtonElement = document.createElement('button');
        let likeSongButtonElement = document.createElement('button');
        let deleteButtonElement = document.createElement('button');

        saveButtonElement.textContent = 'Save song';
        saveButtonElement.classList.add('save-btn');

        likeSongButtonElement.textContent = 'Like song';
        likeSongButtonElement.classList.add('like-btn');

        deleteButtonElement.textContent = 'Delete';
        deleteButtonElement.classList.add('delete-btn');

        let hitsInfoDivElement = document.createElement('div');
        hitsInfoDivElement.classList.add('hits-info');

        hitsInfoDivElement.appendChild(imgElement);
        hitsInfoDivElement.appendChild(genreH2Element);
        hitsInfoDivElement.appendChild(nameSongH2Element);
        hitsInfoDivElement.appendChild(authorH2Element);
        hitsInfoDivElement.appendChild(dateH3Element);
        hitsInfoDivElement.appendChild(saveButtonElement);
        hitsInfoDivElement.appendChild(likeSongButtonElement);
        hitsInfoDivElement.appendChild(deleteButtonElement);

        allHitsContainer.appendChild(hitsInfoDivElement);

        likeSongButtonElement.addEventListener('click', (e) => {
            let pElement = document.querySelector('.likes p');
            [el1, el2, el3] = pElement.innerHTML.split(' ');
            let numberLikes = Number(el3);
            numberLikes++;

            pElement.innerHTML = `Total Likes: ${numberLikes}`;
            likeSongButtonElement.disabled = true;
        });

        saveButtonElement.addEventListener('click', (e) => {
            let saveSongInfoElement = e.currentTarget.parentElement;
            saveSongInfoElement.querySelector('.save-btn').remove();
            saveSongInfoElement.querySelector('.like-btn').remove();

            savedContainer.appendChild(saveSongInfoElement);
        });

        deleteButtonElement.addEventListener('click', (e) => {
            e.currentTarget.parentElement.remove();
        });

        genreInputElement.value = '';
        nameInputElement.value = '';
        authorInputElement.value = '';
        dateInputElement.value = '';
    });

}