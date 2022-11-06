import { Airmelon, Earthmelon, Firemelon, Watermelon } from "./elemelons";

const watermelon = new Watermelon(12.5, "Kingsize");
const firemelon = new Firemelon(21, "SuperDuperSize");
const earthmelon = new Earthmelon(10, "Normalsize");
const airmelon = new Airmelon(5, "Smallsize");

console.log(watermelon.toString());
console.log(firemelon.toString());
console.log(earthmelon.toString());
console.log(airmelon.toString());