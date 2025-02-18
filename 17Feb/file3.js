function isSumOfDigitsEvenOrOdd(number) {
    let sum = 0;
    let num = number;

    while (num > 0) {
        sum += num % 10;
        num = Math.floor(num / 10);
    }

    if (sum % 2 === 0) {
        console.log(`The sum of the digits of ${number} is ${sum}, which is an even number.`);
    } else {
        console.log(`The sum of the digits of ${number} is ${sum}, which is an odd number.`);
    }
}

// Example usage:
isSumOfDigitsEvenOrOdd(1234);