
# Mito-Academy

Ejemplos de endpoints

## localhost:8080/students

{
"firstName": "Enrique",
"lastName": "Carvajal",
"cardId" : "3265987412",
"age" : 36
}


## localhost:8080/courses

{
"name": "Programacion",
"acronym": "PG",
"state" : true
}


## localhost:8080/enrollments

{
"dateTime" : "2024-09-14T14:30:00",
"student" : {"idStudent" : 3},
"state" : true,
"details" : [
{"course" : {"idCourse" : 2},"classroom" : "1B"}
]
}

## localhost:8080/users

{
"idUser": 1,
"role": {
"idRole": 1
},
"enabled": true,
"user_name": "admin"
}

## localhost:8080/roles

{
"idRole": 1,
"nameRole": "ADMIN",
"enabledRole": true
}

## localhost:8080/login

{
"username": "admin",
"password": "123"
}

### localhost:8080/enrollments/studentsByCourse

### localhost:8080/students/orderedByAge