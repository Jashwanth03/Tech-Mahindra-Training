function displayFactors(number) {
    console.log(`Factors of ${number}:`);
    for (let i = 1; i <= number; i++) {
        if (number % i === 0) {
            console.log(i);
        }
    }
}

displayFactors(16);