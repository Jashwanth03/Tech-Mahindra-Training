let month = "February";
let year = "2023";
let isLeap = (year % 4 === 0 && year % 100 !== 0) || (year % 400 === 0);
if (isLeap) {
    if (month == "February") {
        console.log("The year is leap year and the month is February with 29 days.")
    }
    else {
        console.log("The year is leap year and and the month is not Feb.")
    }
}
else {
    console.log("The year is not a leap year.")
}
