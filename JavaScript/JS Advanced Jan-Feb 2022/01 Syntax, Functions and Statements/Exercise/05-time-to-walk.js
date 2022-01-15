function timeToWalk(steps, footprintM, speedKmH) {
    let distanceM = steps * footprintM;
    let numberBreaks = Math.floor(distanceM / 500);
    let totalTimeSec = (distanceM / speedKmH) * 3.6 + numberBreaks * 60;

    let hours = Math.floor(totalTimeSec / 3600).toFixed(0).padStart(2,'0');
    let minutes = Math.floor((totalTimeSec - hours * 3600) / 60).toFixed(0).padStart(2,'0');
    let seconds = Math.ceil(totalTimeSec - hours * 3600 - minutes * 60).toFixed(0).padStart(2,'0');

    console.log(`${hours}:${minutes}:${seconds}`);
}

timeToWalk(2564, 0.70, 5.5);