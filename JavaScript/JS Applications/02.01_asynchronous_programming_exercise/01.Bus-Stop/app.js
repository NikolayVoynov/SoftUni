async function getInfo() {

    // console.log("TODO...");

    const stopId = document.getElementById('stopId').value;
    const submitBtnElement = document.getElementById('submit');

    const stopNameElement = document.getElementById('stopName');
    const ulBusesElement = document.getElementById('buses');

    const url = `http://localhost:3030/jsonstore/bus/businfo/${stopId}`;

    try {
        ulBusesElement.innerHTML= '';
        // ulBusesElement.replaceChildren();
        submitBtnElement.disabled = true;

        const res = await fetch(url);

        if (res.status !== 200) {
            throw new Error('Stop ID not found')
        }

        const data = await res.json();

        stopNameElement.textContent = data.name;

        Object.entries(data.buses).forEach(b => {
            let liBusElement = document.createElement('li');
            liBusElement.textContent = `Bus ${b[0]} arrives in ${b[1]} minutes`;
            ulBusesElement.appendChild(liBusElement);
        });

        submitBtnElement.disabled = false;

    } catch (error) {
        stopNameElement.textContent = 'Error';
    }

}