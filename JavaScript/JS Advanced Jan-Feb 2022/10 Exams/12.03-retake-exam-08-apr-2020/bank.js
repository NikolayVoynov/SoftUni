class Bank {
    #bankName;
    #transactionsInfo;

    constructor(bankName) {
        this.#bankName = bankName;
        this.allCustomers = [];
        this.#transactionsInfo = [];
    }



    newCustomer(customer) {

        let isCustomer = this.allCustomers.some(c => c.firstName == customer.firstName &&
            c.lastName == customer.lastName && c.personalId == customer.personalId);

        if (isCustomer) {
            throw new Error(`${customer.firstName} ${customer.lastName} is already our customer!`);

        } else {
            let firstName = customer.firstName;
            let lastName = customer.lastName;
            let personalId = customer.personalId

            let newCustomer = {
                firstName,
                lastName,
                personalId,
                transactions: []
            }

            this.allCustomers.push(newCustomer);

            return newCustomer;
        }

    }

    depositMoney(personalId, amount) {
        let isCustomer = this.allCustomers.some(c => c.personalId == personalId);

        if (!isCustomer) {
            throw new Error('We have no customer with this ID!');
        } else {
            let foundCustomer = this.allCustomers.find(c => c.personalId == personalId);

            if (!foundCustomer.totalMoney) {
                foundCustomer.totalMoney = 0;
            }

            foundCustomer.totalMoney += amount;

            let numberCustomerTransactions = foundCustomer.transactions.length;

            foundCustomer.transactions.push(`${(numberCustomerTransactions + 1)}. ${foundCustomer.firstName} ${foundCustomer.lastName} made deposit of ${amount}$!`);

            return `${foundCustomer.totalMoney}$`;
        }

    }

    withdrawMoney(personalId, amount) {
        let isCustomer = this.allCustomers.some(c => c.personalId == personalId);

        if (!isCustomer) {
            throw new Error('We have no customer with this ID!');
        } else {
            let foundCustomer = this.allCustomers.find(c => c.personalId == personalId);

            if (!foundCustomer.totalMoney) {
                foundCustomer.totalMoney = 0;
            }

            if (foundCustomer.totalMoney < amount) {
                throw new Error(`${foundCustomer.firstName} ${foundCustomer.lastName} does not have enough money to withdraw that amount!`);
            } else {
                foundCustomer.totalMoney -= amount;

                let numberCustomerTransactions = foundCustomer.transactions.length;

                foundCustomer.transactions.push(`${(numberCustomerTransactions + 1)}. ${foundCustomer.firstName} ${foundCustomer.lastName} withdrew ${amount}$!`);

                return `${foundCustomer.totalMoney}$`;
            }
        }
    }

    customerInfo(personalId) {
        let isCustomer = this.allCustomers.some(c => c.personalId == personalId);

        if (!isCustomer) {
            throw new Error('We have no customer with this ID!');

        } else {
            let foundCustomer = this.allCustomers.find(c => c.personalId == personalId);

            let result = [];

            result.push(`Bank name: ${this.#bankName}`);
            result.push(`Customer name: ${foundCustomer.firstName} ${foundCustomer.lastName}`);
            result.push(`Customer ID: ${personalId}`);
            result.push(`Total Money: ${Number(foundCustomer.totalMoney)}$`);
            result.push(`Transactions:`);


            let numberTransactions = foundCustomer.transactions.length;

            for (let i = numberTransactions - 1; i >= 0; i--) {
                result.push(foundCustomer.transactions[i]);
            }

            return result.join('\n');
        }
    }
}


let bank = new Bank('SoftUni Bank');

console.log(bank.newCustomer({ firstName: 'Svetlin', lastName: 'Nakov', personalId: 6233267 }));
console.log(bank.newCustomer({ firstName: 'Mihaela', lastName: 'Mileva', personalId: 4151596 }));

bank.depositMoney(6233267, 250);
console.log(bank.depositMoney(6233267, 250));
bank.depositMoney(4151596, 555);

console.log(bank.withdrawMoney(6233267, 125));

console.log(bank.customerInfo(6233267));
