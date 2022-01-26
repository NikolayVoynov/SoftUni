function carFactory(input) {

    let car = {model : '', engine : {power : 0, volume : 0}, carriage : { type : '', color : ''}, wheels : [],};
    car.model = input.model;
    car.carriage.type = input.carriage;
    car.carriage.color = input.color;

    if (input.power <= 90) {
        car.engine.power = 90;
        car.engine.volume = 1800;
    } else if (input.power <= 120) {
        car.engine.power = 120;
        car.engine.volume = 2400;
    } else if (input.power <= 200) {
        car.engine.power = 200;
        car.engine.volume = 3500;
    };

    if (input.wheelsize % 2 === 0) {
        let wheelsizeFinal = input.wheelsize - 1;
        car.wheels = [wheelsizeFinal, wheelsizeFinal, wheelsizeFinal, wheelsizeFinal];
    } else {
        car.wheels = [input.wheelsize, input.wheelsize, input.wheelsize, input.wheelsize];
    };

    // return car;

    console.log(car);
}


carFactory({ model: 'VW Golf II',
  power: 90,
  color: 'blue',
  carriage: 'hatchback',
  wheelsize: 14 }
)