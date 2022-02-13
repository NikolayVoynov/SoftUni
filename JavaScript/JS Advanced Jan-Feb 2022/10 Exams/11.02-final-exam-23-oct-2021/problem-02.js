class SummerCamp {

    constructor(organizer, location) {
        this.organizer = organizer;
        this.location = location;
        this.priceForTheCamp = {
            child: 150,
            student: 300,
            collegian: 500
        };
        this.listOfParticipants = [];
    }

    registerParticipant(name, condition, money) {

        if (!this.priceForTheCamp[condition]) {
            throw new Error("Unsuccessful registration at the camp.");
        }

        if (this.listOfParticipants.includes(name)) {
            return `The ${name} is already registered at the camp.`;
        }

        if (this.priceForTheCamp[condition] > money) {
            return 'The money is not enough to pay the stay at the camp.'
        } else {
            let participant = {
                name,
                condition,
                power: 100,
                wins: 0
            }

            this.listOfParticipants.push(participant);

            return `The ${name} was successfully registered.`
        }
    }

    unregisterParticipant(name) {
        let isPresent = this.listOfParticipants.some(el => el.name == name);

        if (isPresent) {
            let index = this.listOfParticipants.indexOf(el => el.name == name);
            this.listOfParticipants.splice(index, 1);

            return `The ${name} removed successfully.`;

        } else {
            throw new Error(`The ${name} is not registered in the camp.`);

        }
    }

    timeToPlay(typeOfGame, participant1, participant2) {
        let isPresent = this.listOfParticipants.some(el => el.name == participant1);

        if (!isPresent) {
            throw new Error('Invalid entered name/s.');
        }

        let player1 = this.listOfParticipants.find(p => p.name == participant1);

        if (typeOfGame === 'WaterBalloonFights') {
            isPresent = this.listOfParticipants.some(el => el.name == participant2);

            if (!isPresent) {
                throw new Error('Invalid entered name/s.');
            }

            let player2 = this.listOfParticipants.find(p => p.name == participant2);

            if (player1.condition !== player2.condition) {
                throw new Error('Choose players with equal condition.');
            }

            if (player1.power > player2.power) {
                player1.wins++;
                return `The ${participant1} is winner in the game ${typeOfGame}.`;

            } else if (player1.power < player2.power) {
                player2.wins++;
                return `The ${participant2} is winner in the game ${typeOfGame}.`;

            } else {
                return `There is no winner.`;
            }


        } else if (typeOfGame === 'Battleship') {
            player1.power += 20;

            return `The ${participant1} successfully completed the game ${typeOfGame}.`;
        }

    }


    toString() {
        let result = [];

        let firstLine = `${this.organizer} will take ${this.listOfParticipants.length} participants on camping to ${this.location}`;
        result.push(firstLine);

        let sortedListParticipants = this.listOfParticipants.sort((a, b) => b.wins - a.wins);

        for (const p of sortedListParticipants) {
            result.push(`${p.name} - ${p.condition} - ${p.power} - ${p.wins}`);
        }


        return result.join('\n');
    }
}


// const summerCamp = new SummerCamp("Jane Austen", "Pancharevo Sofia 1137, Bulgaria");
// console.log(summerCamp.registerParticipant("Petar Petarson", "student", 200));
// console.log(summerCamp.registerParticipant("Petar Petarson", "student", 300));
// console.log(summerCamp.registerParticipant("Petar Petarson", "student", 300));
// console.log(summerCamp.registerParticipant("Leila Wolfe", "childd", 200));


// const summerCamp = new SummerCamp("Jane Austen", "Pancharevo Sofia 1137, Bulgaria");
// console.log(summerCamp.registerParticipant("Petar Petarson", "student", 300));
// console.log(summerCamp.unregisterParticipant("Petar"));
// console.log(summerCamp.unregisterParticipant("Petar Petarson"));

// const summerCamp = new SummerCamp("Jane Austen", "Pancharevo Sofia 1137, Bulgaria");
// console.log(summerCamp.registerParticipant("Petar Petarson", "student", 300));
// console.log(summerCamp.timeToPlay("Battleship", "Petar Petarson"));
// console.log(summerCamp.registerParticipant("Sara Dickinson", "child", 200));
// console.log(summerCamp.timeToPlay("WaterBalloonFights", "Petar Petarson", "Sara Dickinson"));
// console.log(summerCamp.registerParticipant("Dimitur Kostov", "student", 300));
// console.log(summerCamp.timeToPlay("WaterBalloonFights", "Petar Petarson", "Dimitur Kostov"));

// const summerCamp = new SummerCamp("Jane Austen", "Pancharevo Sofia 1137, Bulgaria");
// console.log(summerCamp.registerParticipant("Petar Petarson", "student", 300));
// console.log(summerCamp.timeToPlay("Battleship", "Petar Petarson"));
// console.log(summerCamp.registerParticipant("Sara Dickinson", "child", 200));
// console.log(summerCamp.timeToPlay("WaterBalloonFights", "Petar Petarson", "Sara Dickinson"));
// console.log(summerCamp.registerParticipant("Dimitur Kostov", "student", 300));
// console.log(summerCamp.timeToPlay("WaterBalloonFights", "Petar Petarson", "Dimitur Kostov"));

// console.log(summerCamp.toString());








