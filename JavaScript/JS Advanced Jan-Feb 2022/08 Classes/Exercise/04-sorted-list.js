class List {
    constructor() {
        this.result = [];
        this.size = this.result.length;
    }

    add(element) {
        this.result.push(element);
        this.result.sort((a, b) => a - b);
        this.size = this.result.length;
    }

    remove(index) {

        if (index < 0 || this.result.length <= index) {
            throw new Error('Invalid index');
        }
        this.result.splice(index, 1);
        this.result.sort((a, b) => a - b);
        this.size = this.result.length;
    }

    get(index) {

        if (index < 0 || this.result.length <= index) {
            throw new Error('Invalid index');
        }

        return this.result[index];
    }
}

let list = new List();
list.add(5);
list.add(6);
list.add(7);
console.log(list.get(1)); 
list.remove(1);
console.log(list.get(1));

