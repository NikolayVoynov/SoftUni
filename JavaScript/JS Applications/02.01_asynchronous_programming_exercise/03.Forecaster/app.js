function attachEvents() {

    const conditions = {
        'Sunny': '\u2600',
        'Partly sunny': '\u26c5',
        'Overcast': '\u2601',
        'Rain': '\u2614',
    }

    const locationsURL = 'http://localhost:3030/jsonstore/forecaster/locations';
    const divIdForecast = document.getElementById('forecast');
    const divIdCurrent = document.getElementById('current');
    const divIdUpcoming = document.getElementById('upcoming');


    let locationInput = document.getElementById('location');
    let getWeatherButton = document.getElementById('submit');

    getWeatherButton.addEventListener('click', getWeatherForecast);

    async function getWeatherForecast(e) {

        e.preventDefault();

        const resLocation = await fetch(locationsURL);

        if (resLocation.status !== 200) {
            divIdForecast.innerHTML = 'Error';
            divIdForecast.style.display = 'block'
            return alert('Cannot get locations info!');
        }

        const dataLocation = await resLocation.json();

        let currentLocation = dataLocation.find(x => x.name === locationInput.value);

        if (currentLocation === undefined) {
            divIdForecast.innerHTML = 'Error';
            divIdForecast.style.display = 'block'
            return alert('There is no such location!');
        }

        let currentCode = currentLocation.code;

        const todayURL = `http://localhost:3030/jsonstore/forecaster/today/${currentCode}`;

        const resToday = await fetch(todayURL);
        const dataToday = await resToday.json();
        const conditionToday = dataToday.forecast.condition;

        let divClassForecasts = document.createElement('div');
        divClassForecasts.className = 'forecasts';

        let spanClassConditionSymbol = document.createElement('span');
        spanClassConditionSymbol.className = 'condition symbol';
        spanClassConditionSymbol.textContent = conditions[conditionToday];

        let spanClassCondition = document.createElement('span');
        spanClassCondition.className = 'condition';

        let spanClassForecastData1 = document.createElement('span');
        spanClassForecastData1.className = 'forecast-data';
        spanClassForecastData1.textContent = dataToday.name;

        let spanClassForecastData2 = document.createElement('span');
        spanClassForecastData2.className = 'forecast-data';
        spanClassForecastData2.textContent = `${dataToday.forecast.low}\u00B0/${dataToday.forecast.high}\u00B0`

        let spanClassForecastData3 = document.createElement('span');
        spanClassForecastData3.className = 'forecast-data';
        spanClassForecastData3.textContent = conditionToday;

        spanClassCondition.appendChild(spanClassForecastData1);
        spanClassCondition.appendChild(spanClassForecastData2);
        spanClassCondition.appendChild(spanClassForecastData3);

        divClassForecasts.appendChild(spanClassConditionSymbol);
        divClassForecasts.appendChild(spanClassCondition);

        divIdCurrent.appendChild(divClassForecasts);




        const upcomingURL = `http://localhost:3030/jsonstore/forecaster/upcoming/${currentCode}`;

        const resUpcoming = await fetch(upcomingURL);
        const dataUpcoming = await resUpcoming.json();

        const divClassForecastInfo = document.createElement('div');
        divClassForecastInfo.className = 'forecast-info';

        let spanClassUpcoming = document.createElement('span');
        spanClassUpcoming.className = 'upcoming';

        dataUpcoming.forecast.map(f => {

            let condition = f.condition;

            let spanClassSymbol = document.createElement('span');
            spanClassSymbol.className = 'symbol';
            spanClassSymbol.textContent = conditions[condition];

            let spanClassForecastData1 = document.createElement('span');
            spanClassForecastData1.className = 'forecast-data';
            spanClassForecastData1.textContent = `${f.low}\u00B0/${f.high}\u00B0`

            let spanClassForecastData2 = document.createElement('span');
            spanClassForecastData2.className = 'forecast-data';
            spanClassForecastData2.textContent = f.condition;

            spanClassUpcoming.appendChild(spanClassSymbol);
            spanClassUpcoming.appendChild(spanClassForecastData1);
            spanClassUpcoming.appendChild(spanClassForecastData2);

            divClassForecastInfo.appendChild(spanClassUpcoming);

        });

        divIdUpcoming.appendChild(divClassForecastInfo);

        divIdForecast.style.display = 'inline-block'

    }

}

attachEvents();