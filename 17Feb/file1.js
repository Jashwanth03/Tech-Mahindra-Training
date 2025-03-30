let num = 8;
let limit = 10;

function displayMultiplicationTable() {
    for (let i = 1; i <= limit; i++) {
        console.log(`${num} x ${i} = ${num * i}`);
    }
}

displayMultiplicationTable();
