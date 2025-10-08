// a. Desestructura el día, mes y año e imprime la fecha dado el array [‘06’, ‘Octubre’, ‘2021’].
const fecha = {dia: "06", mes: "Octubre", anno: "2021"};
function fechaD({dia, mes, anno}) {
    console.log(dia + "/" + mes + "/" + anno)
}
fechaD(fecha);
// b. Dado un array de números, desestructura los números en posiciones impares.
const numeros = [1,2,3,4,5,6,7,8,9]
for (let i = 1; i < numeros.length; i+=2) {
    console.log(numeros[i] + ", posición " + i)
}
// c. Desestructura el primer número, el segundo y el resto en otra variable.
const numeros1y2 = [primer, segundo, ...resto] = numeros
console.log("Primer valor: " + primer + "\n" + 
    "Segundo valor: " + segundo + "\n" +
    "El resto: " + resto)
// d. Desestructura nombre, apellidos y teléfono del siguiente objeto:
const person = { nombre: 'Luis', apellido: 'Molina', telefono: '+34666554433' };
function personDesest({nombre, apellido, telefono}) {
    console.log("Nombre: " + nombre + "\n" + 
                "Apellido: " + apellido + "\n" +
                "Telefono: " + telefono)
}
personDesest(person)
// e. Cambia el siguiente bucle para desestructurar cada entrada e imprimir llave y valor por separado:
for (const entrada of Object.entries(person)) {
    const key = entrada[0]
    const value = entrada[1]
    console.log(key)
    console.log(value)
}
// f. Dado [{x: 1, y: 2}, {x: 3, y: 4}], desestructura los puntos en las variables x1, y1, x2, y2.
const Dado = [{x: 1, y: 2}, {x: 3, y: 4}]
const dado = [{x: x1, y: y1}, {x: x2, y: y2}] = Dado
console.log(x1, y1, x2, y2)
/* g. Crea una función a la que le pasas un único objeto como parámetro con 5 propiedades cuales 
quiera, incluida la propiedad nombre y apellidos. Desestructura en la función la propiedad
nombre y apellidos e imprime el nombre completo:*/
const personaDotada = {nombre: "Diego", 
                    primerApellido: "Ramos",
                    segundoApellido: "Rubio",
                    telefono: "622934169",
                    email: "micuenta@gmail.com"}
function nombreCompleto({nombre, primerApellido, segundoApellido}) {
    console.log("Nombre completo: " + nombre + " " + primerApellido + " " + segundoApellido)
}
nombreCompleto(personaDotada)
/* h. Dados dos objetos, combínalos en uno solo utilizando el operador spread. Después, elimina
alguna de las propiedades:*/
const libros = [{titulo: "El quijote", paginas: "100"}, {titulo: "Padre rico padre pobre", paginas: "200"}]
const librosCopia = [...libros]
console.log(libros)
console.log(librosCopia)
delete librosCopia[0].paginas
console.log(libros)
console.log(librosCopia)
// i. Crea una función que retorna un array con 3 valores. Usa la función y desestructura los valores:
function bebidas() {
    return ["Cocacola", "Fanta", "Gaseosa"]
}
const bebidasSeparadas = [cocacola, fanta, gaseosa] = bebidas()
console.log(cocacola + ", " + fanta + ", " +gaseosa)
// j. Realiza una clonación profunda de un objeto que contiene otros objetos o arrays como propiedades:
const consola = {nombre: 'PS4',
                memoria: '512GB',
                precio: '399.99€'};
const clonProfundo = JSON.parse(JSON.stringify(consola));
console.log('Clon:', clonProfundo);