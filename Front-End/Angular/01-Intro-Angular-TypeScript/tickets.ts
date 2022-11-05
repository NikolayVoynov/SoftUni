class Ticket {
    destination: string;
    price: number;
    status: string;

    constructor(destination: string, price: number, status: string) {
        this.destination = destination;
        this.price = price;
        this.status = status
    }
}

function tickets(array: string[], criteria: string) {
    const sortedTickets = array
        .map(string => string.split('|'))
        .map(([destination, price, status]) => new Ticket(destination, Number(price), status))
        .sort((a, b) => a[criteria].localeCompare(b[criteria]));

    console.log(sortedTickets);

    return sortedTickets;
}

tickets(
    [
        'Philadelphia|94.20|available',
        'New York City|95.99|available',
        'New York City|95.99|sold',
        'Boston|126.20|departed'
    ],
    'destination'
)


tickets(
    [
        'Philadelphia|94.20|available',
        'New York City|95.99|available',
        'New York City|95.99|sold',
        'Boston|126.20|departed'
    ],
    'status'
)