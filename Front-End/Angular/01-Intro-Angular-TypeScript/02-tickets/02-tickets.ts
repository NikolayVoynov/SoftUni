import Ticket from "./ticket";

function processTickets(t, sortCrit): Array<Ticket> {
    let result = [];
  
    for (const data of t) {
      const args = data.split("|");
      const [destination, price, status] = args;
  
      result.push(new Ticket(destination, Number(price), status));
    }
  
    switch (sortCrit) {
      case "destination":
        result = result.sort((a, b) => a.destination.localeCompare(b.destination));
        break;
      case "price":
        result = result.sort((a, b) => a.price - b.price);
        break;
      case "status":
        result = result.sort((a, b) => a.status.localeCompare(b.status));
        break;
    }
  
    return result;
  }

  const sortedDest = processTickets([
    "Philadelphia|94.20|available",
    "New York City|95.99|available",
    "New York City|95.99|sold",
    "Boston|126.20|departed",
  ], "destination");
  
  const sortedStatus = processTickets([
    "Philadelphia|94.20|available",
    "New York City|95.99|available",
    "New York City|95.99|sold",
    "Boston|126.20|departed",
  ], "status");
  
  const sortedPrice = processTickets([
    "Philadelphia|94.20|available",
    "New York City|95.99|available",
    "New York City|95.99|sold",
    "Boston|126.20|departed",
  ], "price");
  
  console.log("--------------");
  console.log(sortedDest);
  console.log("--------------");
  console.log(sortedStatus);
  console.log("--------------");
  console.log(sortedPrice);
  console.log("--------------");