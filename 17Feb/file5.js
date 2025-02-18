const student = {
    id: 101,
    name: 'John Doe',
    department: 'Computer Science',
    college: 'ABC University',
    email: 'johndoe@example.com'
};
function displayStudentDetails() {
    console.log(`ID: ${student.id}`);
    console.log(`Name: ${student.name}`);
    console.log(`Department: ${student.department}`);
    console.log(`College: ${student.college}`);
    console.log(`Email: ${student.email}`);
}
displayStudentDetails();
function displayStudentBasicDetails() {
    console.log(`ID: ${student.id}`);
    console.log(`Name: ${student.name}`);
    console.log(`Email: ${student.email}`);
}
displayStudentBasicDetails();
student.address = {
    doorNo: '123',
    street: 'Main Street',
    area: 'Downtown',
    pincode: '123456'
};
function displayStudentDetailsWithAddress() {
    displayStudentDetails();
    console.log(`Address: ${student.address.doorNo}, ${student.address.street}, ${student.address.area}, 
        ${student.address.pincode}`);
}
displayStudentDetailsWithAddress();
delete student.email;
delete displayStudentBasicDetails;
displayStudentDetailsWithAddress();