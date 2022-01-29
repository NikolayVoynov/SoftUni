function sumTable() {
    let table = document.querySelectorAll("table tr");
    let totalSum = 0;

    for (let i = 1; i < table.length; i++) {
        let cols = table[i].children;
        let price = cols[cols.length - 1].textContent;
        totalSum += Number(price);
    }

    document.getElementById("sum").textContent = totalSum;
}