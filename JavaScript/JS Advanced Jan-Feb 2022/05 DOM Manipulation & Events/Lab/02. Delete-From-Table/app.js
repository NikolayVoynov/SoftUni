function deleteByEmail() {
    let inputEmail = document.getElementsByName('email')[0].value;
    let cellsEmail = document.querySelectorAll('#customers tr td:nth-child(2)');
    let resultElement = document.getElementById('result');
    let cellsEmailArray = Array.from(cellsEmail);

    let foundEmail = cellsEmailArray.find(x => x.textContent === inputEmail);

    if (foundEmail) {
        foundEmail.parentElement.remove();
        document.getElementsByName('email')[0].value = '';
        resultElement.textContent = 'Deleted.';
    } else {
        resultElement.textContent = 'Not found.';
    }
}