let mark = 101

if (mark === 100) {
    console.log("Phenomenal");
}

else if (mark > 85 && mark < 100) {
    console.log("Excellent");
}
else if (mark >= 71 && mark <= 85) {
    console.log("Good Work");
}

else if (mark >= 51 && mark <= 70) {
    console.log("Practice Well");
}
else if (mark <= 50 && mark >= 0) {
    console.log("HardWork is needed");
}
else {
    console.log("Invalid Mark");
}