window.addEventListener('load', solve);

function solve() {
    const modelInputElement = document.getElementById('model');
    const yearInputElement = document.getElementById('year');
    const descriptionInputElement = document.getElementById('description');
    const priceInputElement = document.getElementById('price');
    const addButtonElement = document.getElementById('add');
    const furnitureListElement = document.getElementById('furniture-list');
    const totalPriceElement = document.querySelector('.total-price');

    addButtonElement.addEventListener('click', (e) => {
        e.preventDefault();

        let model = modelInputElement.value;
        let description = descriptionInputElement.value;
        let year = Number(yearInputElement.value);
        let price = Number(priceInputElement.value);

        if (!model || !description) {
            return;
        }

        if (year <= 0 || price <= 0) {
            return;
        }

        let rowElement = document.createElement('tr');
        let modelCellElement = document.createElement('td');
        let priceCellElement = document.createElement('td');
        let actionsCellElement = document.createElement('td');
        let moreInfoButtonElement = document.createElement('button');
        let buyButtonElement = document.createElement('button');
        let contentsRowElement = document.createElement('tr');
        let yearContentCellElement = document.createElement('td');
        let descriptionContentCellElement = document.createElement('td');


        modelCellElement.textContent = model;
        priceCellElement.textContent = price.toFixed(2);
        moreInfoButtonElement.textContent = 'More Info';
        buyButtonElement.textContent = 'Buy it';
        yearContentCellElement.textContent = `Year: ${year}`;
        descriptionContentCellElement.textContent = `Description: ${description}`;
        descriptionContentCellElement.setAttribute('colspan', 3);

        moreInfoButtonElement.addEventListener('click', (e) => {
            if (e.currentTarget.textContent == 'More Info') {
                e.currentTarget.textContent = 'Less Info'
                contentsRowElement.style.display = 'contents';
            } else {
                e.currentTarget.textContent = 'More Info'
                contentsRowElement.style.display = 'none';
            }

        });

        buyButtonElement.addEventListener('click', (e) => {
            let currentTotalPrice = Number(totalPriceElement.textContent);
            totalPriceElement.textContent = (currentTotalPrice + price).toFixed(2);
            rowElement.remove();
            contentsRowElement.remove();
        });

        actionsCellElement.appendChild(moreInfoButtonElement);
        actionsCellElement.appendChild(buyButtonElement);

        moreInfoButtonElement.classList.add('moreBtn');
        buyButtonElement.classList.add('buyBtn');
        rowElement.classList.add('info');

        contentsRowElement.classList.add('hide');
        contentsRowElement.style.display = 'none';

        rowElement.appendChild(modelCellElement);
        rowElement.appendChild(priceCellElement);
        rowElement.appendChild(actionsCellElement);

        contentsRowElement.appendChild(yearContentCellElement);
        contentsRowElement.appendChild(descriptionContentCellElement);

        furnitureListElement.appendChild(rowElement);
        furnitureListElement.appendChild(contentsRowElement);

        modelInputElement.value = '';
        descriptionInputElement.value = '';
        yearInputElement.value = '';
        priceInputElement.value = '';
    });
}
