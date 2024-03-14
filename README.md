# Start

Hey! Welcome to my project, here you'll find a quck documentation to get access to my program, have fun!

# Documentation

To gain acces to my program you first need to clone the repository.

Now you need to run the program on intelliJ.

After starting Docker log in into Postman and localhost with one of these users:

## Admin

username: user

password: Uek295



## User

username: user2

password: Uek295_2


## After login

[Here](http://localhost:8080/rank/all)  you can access the localhost and [here](http://localhost:8080/swagger-ui/index.html#/rank-controller/) you can find my swagger documentation.

Thank you for using my program and have fun with it!

# Important information

If you want to send a put request that changes the content of your rank, but you keep the same rank, a 409 response code will be generated. 

Normally it should return a 200 status code. It doesn't work, because the statement in the backend contradicts itself, please note this.

