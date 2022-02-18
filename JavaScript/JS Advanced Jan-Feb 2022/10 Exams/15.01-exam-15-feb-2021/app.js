function solution() {
    const inputElement = document.querySelector('div.container section.card:nth-of-type(1) input');

    const addGiftButtonElement = document.querySelector('div.container section.card:nth-of-type(1) button');

    const sectionListGifts = document.querySelector('div.container section.card:nth-of-type(2) ul');
    const sectionSentGifts = document.querySelector('div.container section.card:nth-of-type(3) ul');
    const sectionDiscardGifts = document.querySelector('div.container section.card:nth-of-type(4) ul');

    addGiftButtonElement.addEventListener('click', (e) => {
        e.preventDefault();

        let name = inputElement.value;
        let giftLiElement = document.createElement('li');
        giftLiElement.className = 'gift';
        giftLiElement.textContent = name;

        let sendButtonElement = document.createElement('button');
        sendButtonElement.id = 'sendButton';
        sendButtonElement.textContent = 'Send';

        let discardButtonElement = document.createElement('button');
        discardButtonElement.id = 'discardButton';
        discardButtonElement.textContent = 'Discard';

        giftLiElement.appendChild(sendButtonElement);
        giftLiElement.appendChild(discardButtonElement);

        sectionListGifts.appendChild(giftLiElement);

        let allGifts = document.querySelectorAll('div.container section.card:nth-of-type(2) ul li')

        Array.from(allGifts)
            .sort((a, b) => a.textContent.localeCompare(b.textContent))
            .forEach(li => sectionListGifts.appendChild(li));

        inputElement.value = '';



        sendButtonElement.addEventListener('click', (e) => {

            sectionSentGifts.appendChild(e.currentTarget.parentElement);
            sendButtonElement.remove();
            discardButtonElement.remove();
        })


        discardButtonElement.addEventListener('click', (e) => {

            sectionDiscardGifts.appendChild(e.currentTarget.parentElement);
            sendButtonElement.remove();
            discardButtonElement.remove();
        })
    });
}