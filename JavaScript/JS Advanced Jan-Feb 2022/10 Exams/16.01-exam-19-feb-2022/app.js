function solve() {
    const firstNameInputElement = document.getElementById('fname');
    const lastNameInputElement = document.getElementById('lname');
    const emailInputElement = document.getElementById('email');
    const dateBirthInputElement = document.getElementById('birth');
    const positionInputElement = document.getElementById('position');
    const salaryInputElement = document.getElementById('salary');

    const hireButtonElement = document.getElementById('add-worker');

    const tableToAddRow = document.getElementById('tbody');

    const sumElement = document.getElementById('sum');


    hireButtonElement.addEventListener('click', (e) => {

        e.preventDefault();

        let fName = firstNameInputElement.value;
        let lName = lastNameInputElement.value;
        let email = emailInputElement.value;
        let birthDate = dateBirthInputElement.value;
        let position = positionInputElement.value;
        let salary = Number(salaryInputElement.value);

        if (!fName || !lName || !email || !birthDate || !position || !salary) {
            return;
        }


        let fNameTdElement = document.createElement('td');
        fNameTdElement.textContent = fName;

        let lNameTdElement = document.createElement('td');
        lNameTdElement.textContent = lName;

        let emailTdElement = document.createElement('td');
        emailTdElement.textContent = email;

        let dateBirthTdElement = document.createElement('td');
        dateBirthTdElement.textContent = birthDate;

        let positionTdElement = document.createElement('td');
        positionTdElement.textContent = position;

        let salaryTdElement = document.createElement('td');
        salaryTdElement.textContent = salary;

        let firedButtonElement = document.createElement('button');
        firedButtonElement.textContent = 'Fired';
        firedButtonElement.className = 'fired';

        let editedButtonElement = document.createElement('button');
        editedButtonElement.textContent = 'Edit';
        editedButtonElement.className = 'edit';

        let buttonsTdElement = document.createElement('td');
        buttonsTdElement.appendChild(firedButtonElement);
        buttonsTdElement.appendChild(editedButtonElement);


        let row = document.createElement('tr');

        row.appendChild(fNameTdElement);
        row.appendChild(lNameTdElement);
        row.appendChild(emailTdElement);
        row.appendChild(dateBirthTdElement);
        row.appendChild(positionTdElement);
        row.appendChild(salaryTdElement);
        row.appendChild(buttonsTdElement);

        tableToAddRow.appendChild(row);

        let sumBudget = (Number(sumElement.textContent) + salary).toFixed(2);
        sumElement.textContent = sumBudget;


        editedButtonElement.addEventListener('click', (e) => {

            firstNameInputElement.value = fName;
            lastNameInputElement.value = lName;
            emailInputElement.value = email;
            dateBirthInputElement.value = birthDate;
            positionInputElement.value = position;
            salaryInputElement.value = salary;

            sumBudget = (Number(sumElement.textContent) - salary).toFixed(2);
            sumElement.textContent = sumBudget;

            let currentRow = e.currentTarget.parentElement.parentElement;
            currentRow.remove();

        })



        firstNameInputElement.value = '';
        lastNameInputElement.value = '';
        emailInputElement.value = '';
        dateBirthInputElement.value = '';
        positionInputElement.value = '';
        salaryInputElement.value = '';

    });
}
solve()