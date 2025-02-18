const chooseOperation = () => {
    const operation = 'divide';
    const a = 20;
    const b = 5;

    const add = (x, y) => x + y;
    const subtract = (x, y) => x - y;
    const multiply = (x, y) => x * y;
    const divide = (x, y) => {
        if (y === 0) {
            return 'Cannot divide by zero';
        } else {
            return {
                quotient: Math.floor(x / y),
                remainder: x % y
            };
        }
    };

    switch (operation) {
        case 'add':
            console.log(`Sum: ${add(a, b)}`);
            break;
        case 'subtract':
            console.log(`Difference: ${subtract(a, b)}`);
            break;
        case 'multiply':
            console.log(`Product: ${multiply(a, b)}`);
            break;
        case 'divide':
            const result = divide(a, b);
            if (typeof result === 'string') {
                console.log(result);
            } else {
                console.log(`Quotient: ${result.quotient}, Remainder: ${result.remainder}`);
            }
            break;
        default:
            console.log('Invalid operation');
    }
};

chooseOperation();
