function attachGradientEvents() {
    let hoverElement = document.getElementById('gradient');
    let resultElement = document.getElementById('result');

    let hoverElementMouseoverHandler = (e) => {
        let percent = Math.floor((e.offsetX / e.target.offsetWidth) * 100);

        resultElement.textContent = `${percent}%`;
    };

    hoverElement.addEventListener('mousemove', hoverElementMouseoverHandler);
}