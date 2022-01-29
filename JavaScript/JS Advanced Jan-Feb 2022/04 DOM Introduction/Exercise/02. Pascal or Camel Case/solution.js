function solve() {
  let inputText = document.getElementById('text').value;
  let convention = document.getElementById('naming-convention').value;
  let result = '';

  if (convention === 'Camel Case') {

    for (let i = 0; i < inputText.length; i++) {
      if (inputText[i] == ' ') {
        result += inputText[i + 1].toUpperCase();
        i++;

      } else {
        result += inputText[i].toLowerCase();
      }
    }

  } else if (convention === 'Pascal Case') {
    result += inputText[0].toUpperCase();

    for (let i = 1; i < inputText.length; i++) {

      if (inputText[i] == ' ') {
        result += inputText[i + 1].toUpperCase();
        i++;

      } else {
        result += inputText[i].toLowerCase();
      }
    }
  } else {
    result = 'Error!';
  }

  let resultText = document.getElementById('result');
  resultText.textContent = result;
}