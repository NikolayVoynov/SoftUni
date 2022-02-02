function solutionAdd(number) {
    function add(a, b) {
        return a + b;
    }

    add.bind(this, number);
}