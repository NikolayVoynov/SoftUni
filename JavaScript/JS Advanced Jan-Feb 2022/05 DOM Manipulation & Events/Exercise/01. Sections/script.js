function create(words) {
   let parent = document.getElementById('content');

   for (let i = 0; i < words.length; i++) {
      let div = document.createElement('div');
      let p = document.createElement('p');
      let text = document.createTextNode(words[i]);

      p.style.display = 'none';
      p.appendChild(text);
      div.appendChild(p);

      div.addEventListener('click', eventFunction);

      parent.appendChild(div);
   }

   function eventFunction(event) {
      event.target.children[0].style.display = 'inline';
   }
}