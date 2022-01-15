function numberDayWeek(input) {
    let typeInput = typeof (input);

    if (typeInput === "string") {

        let day = String(input);
        let dayNumber;

        switch (day) {
            case 'Monday': dayNumber = 1; break;
            case 'Tuesday': dayNumber = 2; break;
            case 'Wednesday': dayNumber = 3; break;
            case 'Thursday': dayNumber = 4; break;
            case 'Friday': dayNumber = 5; break;
            case 'Saturday': dayNumber = 6; break;
            case 'Sunday': dayNumber = 7; break;
            default: dayNumber = 'error';
        }

        console.log(dayNumber);

    } else {
        console.log('error');
    }
}

numberDayWeek('Monday');
numberDayWeek('Tuesday');
numberDayWeek('Wednesday');
numberDayWeek('Invalid');