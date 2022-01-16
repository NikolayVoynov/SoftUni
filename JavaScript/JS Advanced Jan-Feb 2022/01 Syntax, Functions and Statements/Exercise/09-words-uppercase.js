function solve(input) {

    const template = /\w+/g;
    let matcher = input.match(template);
    if (matcher) {
        console.log(matcher.join(', ').toUpperCase());
    } else {
        return;
    }
}

solve('Hi, how are you?');