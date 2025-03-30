//FN without Parameter
function myFunction() {
    console.log("Inside Function!")
}

myFunction()

//FN with Parameter
function sum(x, y) {
    return x + y;
}
console.log(sum(6, 9));

//Arrow fn

let sum1 = (a, b) => a + b;
console.log(sum1(1, 2))

//Function as expressions and with parameters
var sum = function (x, y) {
    return x + y;
};
console.log(sum(4, 5));


//Creating objects in single line

const person = { firstName: "John", lastName: "Doe", age: 50, eyeColor: "blue" };
console.log(person)

//Creating objects in multiple line

const person11 = {
    firstName: "mark",
    lastName: "steve",
    age: 40,
    eyeColor: "green"
};
console.log(person11)

//Creating obj and adding properties

let person2 = {};
person2.firstName = "anto";
person2.lastName = "Doe";
person2.age = 30;
person2.eyeColor = "blue";

console.log(person2)

//Accessing the members of the objects

let age = person.age;
console.log(person.firstName + " is " + person.age + " years //old.");


let age1 = person["age"];
console.log(person["firstName"] + " is " + person["age"] + " years old.");


let x = "firstName";
let y = "age";
console.log(person[x] + " is " + person[y] + " years old.");

//Adding property to the object

person.nationality = "English";
console.log(person);

//Removing property from the object

delete person.age;
console.log(person);
