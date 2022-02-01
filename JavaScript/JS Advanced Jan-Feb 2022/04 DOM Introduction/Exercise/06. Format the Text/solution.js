function solve() {
  let input = document.getElementById('input');
  let inputArray = input.value.split('.').filter(sentence => sentence !== '');
  let output = document.getElementById('output');

  while (inputArray.length > 0) {
    let text = inputArray.splice(0, 3).join('. ') + '.';
    let paragraph = document.createElement('p');
    paragraph.textContent = text;
    output.appendChild(paragraph);
  }
}