function daysInMonth(m, y) {
    let month = Number(m);
    let year = Number(y);

    let numberDays = new Date(year, month, 0).getDate();

    console.log(numberDays);
}


daysInMonth(2, 2008);