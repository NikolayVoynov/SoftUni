window.addEventListener('load', solution);

function solution() {
  const fNameInputElement = document.getElementById('fname');
  const emailInputElement = document.getElementById('email');
  const phoneInputElement = document.getElementById('phone');
  const addressInputElement = document.getElementById('address');
  const codeInputElement = document.getElementById('code');


  const submitButtonElement = document.getElementById('submitBTN');
  const editButtonElement = document.getElementById('editBTN');
  const continueButtonElement = document.getElementById('continueBTN');

  const infoPreviewElement = document.getElementById('infoPreview');
  const blockElement = document.getElementById('block');

  submitButtonElement.addEventListener('click', (e) => {
    // e.preventDefault();

    let fName = fNameInputElement.value;
    let email = emailInputElement.value;
    let phone = phoneInputElement.value;
    let address = addressInputElement.value;
    let code = codeInputElement.value;

    if (!fName || !email) {
      return;
    }

    let fNameLiElement = document.createElement('li');
    let emailLiElement = document.createElement('li');
    let phoneLiElement = document.createElement('li');
    let addressLiElement = document.createElement('li');
    let codeLiElement = document.createElement('li');

    fNameLiElement.textContent = `Full Name: ${fName}`;
    emailLiElement.textContent = `Email: ${email}`;
    phoneLiElement.textContent = `Phone Number: ${phone}`;
    addressLiElement.textContent = `Address: ${address}`;
    codeLiElement.textContent = `Postal code: ${code}`;

    infoPreviewElement.appendChild(fNameLiElement);
    infoPreviewElement.appendChild(emailLiElement);
    infoPreviewElement.appendChild(phoneLiElement);
    infoPreviewElement.appendChild(addressLiElement);
    infoPreviewElement.appendChild(codeLiElement);

    submitButtonElement.disabled = true;
    editButtonElement.disabled = false;
    continueButtonElement.disabled = false;

    fNameInputElement.value = '';
    emailInputElement.value = '';
    phoneInputElement.value = '';
    addressInputElement.value = '';
    codeInputElement.value = '';

    editButtonElement.addEventListener('click', (e) => {

      // let infoArr = Array.from(document.getElementsByTagName('li'))
      // let inputArr = Array.from(document.getElementsByTagName('input'))

      // for (let i = 0; i < infoArr.length; i++) {

      //   inputArr[i].value = infoArr[i].textContent.split(': ')[1];
      // }


      fNameInputElement.value = fName;
      emailInputElement.value = email;
      phoneInputElement.value = phone;
      addressInputElement.value = address;
      codeInputElement.value = code;

      // let ul = document.querySelector("ul");
      // let child = ul.lastElementChild;
      // while (child) {
      //   ul.removeChild(child);
      //   child = ul.lastElementChild;
      // }

      document.querySelector("ul").innerHTML = '';

      submitButtonElement.disabled = false;
      editButtonElement.disabled = true;
      continueButtonElement.disabled = true;
    });

    continueButtonElement.addEventListener('click', (e) => {

      document.querySelector('#block').innerHTML = "<h3>Thank you for your reservation!</h3>";

      // let h3Element = document.createElement('h3');
      // h3Element.textContent = 'Thank you for your reservation!';

      // blockElement.appendChild(h3Element);

      submitButtonElement.disabled = false;
      editButtonElement.disabled = true;
      continueButtonElement.disabled = true;
    });
  });
}
