function search() {
   let arrayTowns = Array.from(document.querySelectorAll('#towns li'));
   let searchFor = document.getElementById('searchText').value;
   let numberMatches = document.getElementById('result');
   let count = 0;

   for (let town of arrayTowns) {

      if (town.textContent.includes(searchFor) && searchFor !== '') {
         town.style.fontWeight = 'bold';
         town.style.textDecoration = 'underline';
         count++;
      } else {
         town.style.fontWeight = 'normal';
         town.style.textDecoration = 'none';
      }
   }

   numberMatches.textContent = `${count} matches found`;
}
