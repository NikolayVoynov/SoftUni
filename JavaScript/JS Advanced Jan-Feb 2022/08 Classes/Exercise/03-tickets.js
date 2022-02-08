function createTickets(array, sortBy) {

    class Ticket {

        constructor(destination, price, status) {
            this.destination = destination;
            this.price = price;
            this.status = status;
        }
    }

    let tickets = [];

    while (array.length > 0) {
        let [destination_, price_, status_] = array.shift().split('|');


        let ticket = new Ticket(destination_, Number(price_), status_);

        tickets.push(ticket);
    }

    tickets.sort((a, b) => {

        if (sortBy === 'price') {
            return a[sortBy] - b[sortBy];
        } else {
            return a[sortBy].localeCompare(b[sortBy]);
        }
    })

    return tickets;
}


createTickets(['Philadelphia|94.20|available',
    'New York City|95.99|available',
    'New York City|95.99|sold',
    'Boston|126.20|departed'],
    'destination'
);