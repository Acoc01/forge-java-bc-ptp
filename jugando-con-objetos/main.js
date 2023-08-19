var users = [{name: "Michael", age:37}, {name: "John", age:30}, {name: "David", age:27}];

//Edad de John

console.log(users[1].age)

//Nombre de primer objeto
console.log(users[0].name)

//Imprimir todo
users.map((a) => console.log(a.name+' '+a.age));

//Imrpimir mayores de edad.
users.map((a) => {if(a.age >= 18) console.log(a.age)})

