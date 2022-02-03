function attachEventsListeners() {
    let days = document.getElementById('days');
    let hours = document.getElementById('hours');
    let minutes = document.getElementById('minutes');
    let seconds = document.getElementById('seconds');

    let unitsRatio = {
        days: 1,
        hours: 24,
        minutes: 1440,
        seconds: 86400
    };

    let daysBtnListener = document.getElementById('daysBtn').addEventListener('click', onConvert);
    let hoursBtnListener = document.getElementById('hoursBtn').addEventListener('click', onConvert);
    let minutesBtnListener = document.getElementById('minutesBtn').addEventListener('click', onConvert);
    let secondsBtnListener = document.getElementById('secondsBtn').addEventListener('click', onConvert);


    function convert(value, unit) {
        let days = value / unitsRatio[unit];

        return {
            days: days,
            hours: days * unitsRatio.hours,
            minutes: days * unitsRatio.minutes,
            seconds: days * unitsRatio.seconds
        };
    }

    function onConvert(event) {
        let input = event.target.parentElement.querySelector('input[type = "text"]');

        let time = convert(Number(input.value), input.id);

        days.value = time.days;
        hours.value = time.hours;
        minutes.value = time.minutes;
        seconds.value = time.seconds;
    };

}