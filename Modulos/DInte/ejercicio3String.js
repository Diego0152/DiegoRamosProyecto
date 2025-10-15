// a. Crea un array “datos” vacío con un literal.
const vacio = []
console.log("array vacio")
console.log(vacio)
// b. Añade a “datos” los números del 1 al 50 con un bucle for.
for (let i = 0; i < 50; i++) {
    vacio[i] = i + 1
}
console.log("array con 50 valores")
console.log(vacio)
// c. Elimina los elementos del 25 al 50 asignando un nuevo tamaño a la propiedad length.
vacio.length = 25
for (let i = 25; i < vacio.length; i++) {
    vacio[i] 
}
console.log("array con 25 valores")
console.log(vacio)
// d. Usa el operador spread para hacer una copia del array anterior.
const vacioLleno = [...vacio]
console.log("array con 25 valores copiado")
console.log(vacioLleno)
// e. Crea un array de tamaño 50 con el constructor Array
const arrayconst = new Array(50)
console.log("array hecho por constructor")
console.log(arrayconst)
// f. Copia el array anterior a otro con la factoría from.
const copiaArray = Array.from(arrayconst)
console.log("Copiando el array con Array.from")
console.log(copiaArray)
// g. Crea un array multidimensional de 10 filas (i) y 10 columnas (j). Inicializa cada celda con el valor i*j.
const arrayMultid = [];
for (let i = 0; i < 10; i++) {
    arrayMultid[i] = []
    for (let j = 0; j < 10; j++) {
        arrayMultid[i][j] = i * j
    }
}
console.log(arrayMultid)
/* h. Crea un array con la factoría of con los números del 1 al 5. Después, añade un elemento en la
posición 10 y otro en la 50. Recorre el array con un for imprimiendo los valores, y después con
forEach. ¿Cuál es la diferencia? ¿Cuál es el tamaño del array?*/
const arrayFact = Array.of(1,2,3,4,5)
arrayFact[10] = 10
arrayFact[50] = 50
// bucle for normal
for (let i = 0; i < arrayFact.length; i++) {
    console.log(arrayFact[i])
}
// bucle forEach
arrayFact.forEach(valor=>console.log(valor))
//La diferencia es que el bucle for muestra las posiciones vacías, y el forEach solo los valores.
// i. Elimina dos elementos con delete.
delete arrayFact[2]
delete arrayFact[4]
arrayFact.forEach(valor=>console.log(valor))
// j. Calcula el producto de todos los números del array “datos” con forEach.
console.log("Producto")
let producto = 1; 
vacio.forEach(valor=>console.log(producto*=valor))

// k. Cada elemento x del array “datos” debe cambiarse por x*x. Usa forEach.
console.log("Multiplicacion")
vacio.forEach(valor=>console.log(valor*valor))
/* l. Crea un nuevo array con map recorriendo cada elemento x de “datos”, donde cada elemento
sea un string “El valor es: x”. Usa template strings.*/
const vacioMap = vacio.map(x=>console.log(`El valor es: ${x}`))
// m. Crea un nuevo array mediante map que incremente cada elemento de “datos” en 5 unidades.
const vacioIncrem = vacio.map(valor=>console.log(valor += 5))
// n. Mediante filter, quédate con los números impares en un nuevo array impares
const impares = vacio.filter(valor=>valor % 2 !== 0)
console.log(impares)
// o. Usa find para buscar el número 13
const imparTrece = impares.find(valor=>valor===13)
console.log(imparTrece)
// p. Usa every para comprobar si todos los números son positivos.
const numerosEvery = impares.every(valor=>valor > 0)
console.log(numerosEvery)
// q. Calcula la sumatoria del array “datos” mediante reduce.
const sumatoria = vacio.reduce((valor, index)=>valor + index, 0)
console.log(sumatoria)
// r. Calcula el valor más pequeño del array mediante reduce.
const valorMPequenno = vacio.reduce((valor, index)=> index < valor ? index : valor, vacio[0])
console.log(valorMPequenno) 
// s. Usa flat para aplanar el array multidimensional que creaste anteriormente.
const flatMultid = arrayMultid.flat()
console.log(flatMultid)
/* t. Tenemos la cadena: “Vamos a usar flatMap. Es igual que map. Pero aplana los arrays”. Separa
mediante split las distintas frases. Después, mediante map, quita los espacios sobrantes (trim).
A continuación, usa flatMap para extraer todas las palabras de cada frase en un único array.*/ 
let cadena = "Vamos a usar flatMap. Es igual que map. Pero aplana los arrays";
let cadenaSplit = cadena.split(". ");
let palabras = cadenaSplit.flatMap(frase => frase.trim().split(" "));
console.log(palabras)
/* u. Crea el array a = [1,2,3,4,5] y b = [6,7,8,9,10] con literales. Concatena los arrays a y b con concat.
Después, usa el operador spread. Crea una variable const cola. Usa unshift y shift para añadir y
quitar elementos. Dado el array resultante de la concatenación de a y b, obtén el subarray desde
el índice 2 hasta el penúltimo elemento (slice). Usa splice para quitar los 2 últimos elementos
de un array.*/
const a = [1,2,3,4,5]
const b = [6,7,8,9,10]
const c = a.concat(b)
console.log(c)
const arraySpread = [...a, ...b]
const cola = [...arraySpread]
cola.unshift(0);
cola.shift();
let subArray = arraySpread.slice(2, arraySpread.length - 1)
subArray.slice(subArray.length - 2, 2)
console.log(subArray)
// v. Rellena con fill un array de 100 elementos con ‑1.
const arrayFill = new Array(100).fill(-1)
console.log(arrayFill)
// w. Crea un array de cadenas. Busca con indexOf una cadena.
const arrayCadenas = ["Hola", "Soy", "Diego", "Ramos", "Rubio", "Tengo", "18", "Annos"]
console.log(arrayCadenas.indexOf("Diego"))
// x. Comprueba si la cadena “hola” está dentro del array anterior.
const comprobarHola = arrayCadenas.includes("Hola")
console.log(comprobarHola)
// y. Ordena la lista de cadenas anterior de forma alfabética con sort.
const cadenaOrdenada = arrayCadenas.sort()
console.log(cadenaOrdenada)
/* z. Crea un array vacío de 50 posiciones. Con forEach, asigna valores aleatorios entre 0 y 100. Des‑
pués, ordena con sort de menor a mayor. Cambia y ordena de mayor a menor*/
const vacioPosic = new Array(50).fill(0)
vacioPosic.forEach((_, index)=> {vacioPosic[index] = Math.floor(Math.random() * 101)});
console.log(vacioPosic)
vacioPosic.sort((a,b)=> a - b)
console.log(vacioPosic)
vacioPosic.sort((a,b)=> b - a)
console.log(vacioPosic)
// aa. Usa reverse para invertir el array anterior.
const vacioPosicRevert = vacioPosic.reverse()
console.log(vacioPosicRevert)