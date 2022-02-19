class LibraryCollection {
    constructor(capacity) {
        this.capacity = capacity;
        this.books = [];
    }

    addBook(bookName, bookAuthor) {

        if (this.books.length == this.capacity) {

            throw new Error('Not enough space in the collection.');
        } else {

            this.books.push({ bookName, bookAuthor, payed: false });

            return `The ${bookName}, with an author ${bookAuthor}, collect.`;
        }
    }

    payBook(bookName) {
        let isFound = this.books.some(b => b.bookName === bookName);
        let book = this.books.find(b => b.bookName === bookName);

        if (!isFound) {
            throw new Error(`${bookName} is not in the collection.`);

        } else if (book.payed === true) {

            throw new Error(`${bookName} has already been paid.`);
        } else {
            book.payed = true

            return `${bookName} has been successfully paid.`;
        }
    }

    removeBook(bookName) {
        let isFound = this.books.some(b => b.bookName === bookName);
        let book = this.books.find(b => b.bookName === bookName);
        let index = this.books.indexOf(book);

        if (!isFound) {

            throw new Error("The book, you're looking for, is not found.");
        } else if (book.payed === false) {

            throw new Error(`${bookName} need to be paid before removing from the collection.`);
        } else {

            this.books.splice(index, 1);

            return `${bookName} remove from the collection.`;
        }
    }

    getStatistics(bookAuthor) {
        let result = [];

        if (bookAuthor === undefined) {
            let emptySlots = this.capacity - this.books.length;

            let firstLine = `The book collection has ${emptySlots} empty spots left.`;
            result.push(firstLine);

            this.books.sort((a, b) => a.bookName.localeCompare(b.bookName))
                .forEach(b => result.push(`${b.bookName} == ${b.bookAuthor} - ${b.payed ? 'Has Paid' : 'Not Paid'}.`))

        } else {
            let availableBookWithAuthor = this.books.some(b => b.bookAuthor === bookAuthor);

            if (!availableBookWithAuthor) {
                throw new Error(`${bookAuthor} is not in the collection.`)
            } else {
                let book = this.books.find(b => b.bookAuthor === bookAuthor);

                result.push(`${book.bookName} == ${book.bookAuthor} - ${book.payed ? 'Has Paid' : 'Not Paid'}.`);
            }

        }

        return result.join('\n');
    }
}


// const library = new LibraryCollection(2)
// console.log(library.addBook('In Search of Lost Time', 'Marcel Proust'));
// console.log(library.addBook('Don Quixote', 'Miguel de Cervantes'));
// console.log(library.addBook('Ulysses', 'James Joyce'));

// const library = new LibraryCollection(2)
// library.addBook('In Search of Lost Time', 'Marcel Proust');
// console.log(library.payBook('In Search of Lost Time'));
// console.log(library.payBook('Don Quixote'));

// const library = new LibraryCollection(2)
// library.addBook('In Search of Lost Time', 'Marcel Proust');
// library.addBook('Don Quixote', 'Miguel de Cervantes');
// library.payBook('Don Quixote');
// console.log(library.removeBook('Don Quixote'));
// console.log(library.removeBook('In Search of Lost Time'));

const library = new LibraryCollection(5)
library.addBook('Don Quixote', 'Miguel de Cervantes');
library.payBook('Don Quixote');
library.addBook('In Search of Lost Time', 'Marcel Proust');
library.addBook('Ulysses', 'James Joyce');
console.log(library.getStatistics());


