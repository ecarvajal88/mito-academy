#Examples

localhost:8080/students/
{
    "firstName": "Alma",
    "lastName": "Torres",
    "cardId" : "3265987412",
    "age" : 34
}


localhost:8080/courses
{
    "name": "Programacion",
    "acronym": "PG",
    "state" : true
}


localhost:8080/enrollments
{
    "dateTime" : "2024-09-14T14:30:00",
    "student" : {"idStudent" : 3},
    "state" : true,
    "details" : [
        {"course" : {"idCourse" : 2},"classroom" : "1B"}
    ]
}
