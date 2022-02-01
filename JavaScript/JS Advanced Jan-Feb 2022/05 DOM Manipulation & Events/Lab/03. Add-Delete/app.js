function addItem() {
    let inputElement = document.getElementById('newItemText');
    let listItemsElement = document.getElementById('items');
    let liElement = document.createElement('li');

    liElement.textContent = inputElement.value;
    inputElement.value = '';

    let hrefElement = document.createElement('a');
    hrefElement.href = '#';
    hrefElement.textContent = '[Delete]';


    hrefElement.addEventListener('click', (e) => {
        e.currentTarget.parentElement.remove();
    });

    liElement.appendChild(hrefElement);
    listItemsElement.appendChild(liElement);
}