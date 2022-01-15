function solveCircleAreaProblem(input) {
    let typeInput = typeof(input);

    if(typeInput === "number") {
        let area = Math.pow(input, 2) * Math.PI;
        console.log(area.toFixed(2));
    } else{
        console.log(`We can not calculate the circle area, because we receive a ${typeInput}.`)
    }
}


solveCircleAreaProblem(5);
solveCircleAreaProblem('nikolay');
solveCircleAreaProblem(null);
solveCircleAreaProblem(true);
solveCircleAreaProblem(undefined);