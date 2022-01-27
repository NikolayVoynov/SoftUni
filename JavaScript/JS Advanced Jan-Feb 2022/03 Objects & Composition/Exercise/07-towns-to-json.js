function townsToJson(input) {
    let towns = [];
    

    for (let i = 1; i < input.length; i++) {
        let array = input[i].split('|');
        let town = array[1].trim();
        let latitude = Number(Number(array[2]).toFixed(2));
        let longitude = Number(Number(array[3]).toFixed(2));        

        towns.push({ Town : town, Latitude : latitude, Longitude : longitude });
    }

    console.log(JSON.stringify(towns));
}


townsToJson(['| Town | Latitude | Longitude |',
'| Sofia | 42.696552 | 23.32601 |',
'| Beijing | 39.913818 | 116.363625 |']
);