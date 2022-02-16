
function solve() {
   const authorInputElement = document.getElementById('creator');
   const titleInputElement = document.getElementById('title');
   const categoryInputElement = document.getElementById('category');
   const contentInputElement = document.getElementById('content');

   const createButtonElement = document.getElementsByClassName("btn create")[0];

   const articlesSection = document.querySelector(".site-content main section");

   const olElement = document.getElementsByTagName('ol')[0];


   createButtonElement.addEventListener('click', (e) => {

      e.preventDefault();

      let author = authorInputElement.value;
      let title = titleInputElement.value;
      let category = categoryInputElement.value;
      let content = contentInputElement.value;

      let titleH1Element = document.createElement('h1');
      titleH1Element.textContent = title;

      let categoryParagraphElement = document.createElement('p');
      categoryParagraphElement.innerHTML = `Category:<strong>${category}</strong>`;

      let creatorParagraphElement = document.createElement('p');
      creatorParagraphElement.innerHTML = `Creator:<strong>${author}</strong>`;

      let contentParagraphElement = document.createElement('p');
      contentParagraphElement.textContent = content;

      let deleteButtonElement = document.createElement('button');
      deleteButtonElement.classList = 'btn delete';
      deleteButtonElement.textContent = 'Delete';

      let archiveButtonElement = document.createElement('button');
      archiveButtonElement.classList = 'btn archive';
      archiveButtonElement.textContent = 'Archive';

      let divClassButtonsElement = document.createElement('div');
      divClassButtonsElement.classList = 'buttons';

      divClassButtonsElement.appendChild(deleteButtonElement);
      divClassButtonsElement.appendChild(archiveButtonElement);

      let articleElement = document.createElement('article');

      articleElement.appendChild(titleH1Element);
      articleElement.appendChild(categoryParagraphElement);
      articleElement.appendChild(creatorParagraphElement);
      articleElement.appendChild(contentParagraphElement);
      articleElement.appendChild(divClassButtonsElement);

      articlesSection.appendChild(articleElement);

      archiveButtonElement.addEventListener('click', (e) => {

         let currentArticle = e.currentTarget.parentElement.parentElement;
         let title = currentArticle.childNodes[0].textContent;

         let liElement = document.createElement('li');
         liElement.textContent = title;
         olElement.appendChild(liElement);

         let arrayLi = Array.from(olElement.getElementsByTagName('li'));
         olElement.innerHTML = '';

         arrayLi.sort((a, b) => a.textContent.localeCompare(b.textContent))

         arrayLi.forEach(element => {
            olElement.appendChild(element);
         });

         articlesSection.removeChild(currentArticle);
      });

      deleteButtonElement.addEventListener('click', (e) => {

         let currentArticle = e.currentTarget.parentElement.parentElement;
         articlesSection.removeChild(currentArticle);
      });

      authorInputElement.value = '';
      titleInputElement.value = '';
      categoryInputElement.value = '';
      contentInputElement.value = '';
   });

}
