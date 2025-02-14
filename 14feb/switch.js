let num = 5;

switch (num) {
	case 0:
		console.log("Number is zero.");
		break;
	case 1:
		console.log("Nuber is one.");
		break;
	case 2:
		console.log("Number is two.");
		break;
	default:
		console.log("Number is greater than 2.");
};

//ternary operator
let num1 = 10;

let result = num >= 0 ? "Positive" : "Negative";

console.log(`The number is ${result}.`);