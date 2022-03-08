function bookLibrary() {

    const urlAllBooks = 'http://localhost:3030/jsonstore/collections/books';

    const btnAllBooks = document.getElementById('loadBooks');
    const tbodyElement = document.getElementsByTagName('tbody')[0];

    let inputTitleElement = document.getElementById('title');
    let inputAuthorElement = document.getElementById('author');
    const btnSubmit = document.getElementsByClassName('btnSubmit')[0];

    btnAllBooks.addEventListener('click', loadAllBooks);

    async function loadAllBooks() {

        tbodyElement.innerHTML = '';

        let res = await fetch(urlAllBooks);
        let dataAllBooks = await res.json();

        Object.entries(dataAllBooks).forEach((e) => {

            let _id = e[0];
            let title = e[1].title;
            let author = e[1].author;

            let newRow = createNewRow(_id, title, author);

            tbodyElement.appendChild(newRow);
        });
    }

    btnSubmit.addEventListener('click', submitBook);

    async function submitBook(e) {
        e.preventDefault();

        let myForm = document.getElementById('formBook');
        let formData = new FormData(myForm);
        let entriesFormData = Object.fromEntries(formData.entries());

        if (entriesFormData.author !== '' && entriesFormData.title !== '') {

            let res = await fetch(urlAllBooks, {
                method: 'POST',
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(
                    {
                        author: entriesFormData.author,
                        title: entriesFormData.title
                    })
            });

            btnAllBooks.click();

            inputAuthorElement.value = '';
            inputTitleElement.value = '';

        } else {

            return alert('Input field cannot be empty!');
        }

    }

    async function deleteBook(e) {

        let id = e.target.parentNode.parentNode.id;
        e.target.parentNode.parentNode.remove();

        let deleteSelectedBook = await fetch(`${urlAllBooks}/${id}`, {
            method: 'DELETE',
        });

    }

    async function editBook(e) {

        let id = e.target.parentNode.parentNode.id;
        let res = await fetch(`${urlAllBooks}/${id}`);
        let data = await res.json();

        let rowValues = Object.values(data);

        let formElements = document.querySelector('form').elements;

        let formElementTitle = formElements['title'];
        formElementTitle.value = rowValues[1];

        let formElementAuthor = formElements['author'];
        formElementAuthor.value = rowValues[0];

        const formButtonElement = document.querySelector('form button');
        formButtonElement.style.display = 'none';

        let h3Form = document.querySelector('form h3');
        h3Form.textContent = 'Edit FORM';

        const formElement = document.querySelector('form');

        const btnSave = document.createElement('button');
        btnSave.textContent = 'Save';

        formElement.appendChild(btnSave);

        btnSave.addEventListener('click', saveEditBook);

        async function saveEditBook(e) {
            e.preventDefault();

            let put = await fetch(`${urlAllBooks}/${id}`, {
                method: 'PUT',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({
                    author: formElementAuthor.value,
                    title: formElementTitle.value,
                })
            });

            formButtonElement.style.display = 'block';
            btnSave.style.display = 'none';

            h3Form.textContent = 'FORM';
            formElementTitle.value = '';
            formElementAuthor.value = '';

            loadAllBooks();
        }


    }

    function createNewRow(_id, title, author) {

        let tr = document.createElement('tr');
        tr.setAttribute('id', _id);

        let tdTitle = document.createElement('td');
        tdTitle.textContent = title;

        let tdAuthor = document.createElement('td');
        tdAuthor.textContent = author;

        let btnEdit = document.createElement('button');
        btnEdit.className = 'btnEdit';
        btnEdit.textContent = 'Edit';
        btnEdit.addEventListener('click', editBook);

        let btnDelete = document.createElement('button');
        btnDelete.className = 'btnDelete';
        btnDelete.textContent = 'Delete';
        btnDelete.addEventListener('click', deleteBook);

        let tdAction = document.createElement('td');
        tdAction.appendChild(btnEdit);
        tdAction.appendChild(btnDelete);

        tr.appendChild(tdTitle);
        tr.appendChild(tdAuthor);
        tr.appendChild(tdAction);

        return tr;
    }



}

bookLibrary()