async function createStudents() {

    const url = 'http://localhost:3030/jsonstore/collections/students';

    const studentsTable = document.querySelector('#results tbody');

    const submitButton = document.getElementById('submit');

    const res = await fetch(url);
    const data = await res.json();

    Object.values(data).forEach((x) => {
        let firstName = x.firstName;
        let lastName = x.lastName;
        let facultyNumber = x.facultyNumber;
        let grade = Number(x.grade);

        let trStudent = document.createElement('tr');
        trStudent.setAttribute('id', x._id);

        let firstNameCell = trStudent.insertCell(0);
        firstNameCell.innerText = firstName;

        let lastNameCell = trStudent.insertCell(1);
        lastNameCell.innerText = lastName;

        let facultyNumberCell = trStudent.insertCell(2);
        facultyNumberCell.innerText = facultyNumber;

        let gradeCell = trStudent.insertCell(3);
        gradeCell.innerText = grade;

        studentsTable.appendChild(trStudent);
    });

    submitButton.addEventListener('click', submitStudent);

    async function submitStudent(e) {
        e.preventDefault();

        let firstNameInput = document.getElementsByName('firstName')[0];
        let lastNameInput = document.getElementsByName('lastName')[0];
        let facultyNumberInput = document.getElementsByName('facultyNumber')[0];
        let gradeInput = document.getElementsByName('grade')[0];

        if (isNaN(gradeInput.value)) {
            return alert('Wrong grade type');
        }

        if (firstNameInput.value !== '' && lastNameInput.value !== '' && facultyNumberInput.value !== '' && gradeInput.value !== '') {

            let res = await fetch(url, {
                method: 'POST',
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({
                    firstName: firstNameInput.value,
                    lastName: lastNameInput.value,
                    facultyNumber: Number(facultyNumberInput.value),
                    grade: Number(gradeInput.value),
                }),
            });

            let trStudent = document.createElement('tr');
            
            let firstNameCell = trStudent.insertCell(0);
            firstNameCell.innerText = firstNameInput.value;

            let lastNameCell = trStudent.insertCell(1);
            lastNameCell.innerText = lastNameInput.value;

            let facultyNumberCell = trStudent.insertCell(2);
            facultyNumberCell.innerText = facultyNumberInput.value;

            let gradeCell = trStudent.insertCell(3);
            gradeCell.innerText = gradeInput.value;

            studentsTable.appendChild(trStudent);

        }

        firstNameInput.value = '';
        lastNameInput.value = '';
        facultyNumberInput.value = '';
        gradeInput.value = '';
    }

}

createStudents();