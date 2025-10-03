// a. Crea una cadena multilínea usando comillas dobles.
    let cadena = (`dani 
    cazalilla`)
    console.log(cadena)
// b. Agrega a la cadena un retorno de carro y tabuladores utilizando los símbolos de escape corres‑
// pondientes.
    let cadenaEscape = "cucaracha\rsaltamontes"
    console.log(cadenaEscape)
// c. Incluye en la cadena el carácter \.
    let cadenaCaracter = "Papa\\mama"
    console.log(cadenaCaracter)
// d. Concatena otra cadena utilizando el operador +.
    let conCadena = "hola " + "mundo"
    console.log(conCadena)
// e. Concatena cadenas usando un template string. Muestra el valor de varias variables en el tem‑plate string.
    let valor = 10
    let plateCadena = `Contando silabas: meteoritos = ${valor}`
    console.log(plateCadena)
// f. Separa un texto que contenga varias frases en un array, donde cada elemento del array sea una frase.
    let cadenaArray = "Acantilado Hierba Poderoso"
    let array = cadenaArray.split(" ")
    console.log(array)
// g. Convierte un texto dado a minúsculas.
    let cadenaA = "ESTOY MUY FURIOSO"
    let cadenaMinuscula = cadenaA.toLowerCase()
    console.log(cadenaMinuscula)
// h. Convierte un texto dado a mayúsculas.
    let cadenaB = "ESTOY MUY FURIOSO"
    let cadenaMayuscula = cadenaB.toUpperCase()
    console.log(cadenaMayuscula)
// i. Recorre el texto carácter por carácter usando un bucle e imprímelo
    let cadenaBucle = "Habia una vez un patito chiquitito"
    for (let index = 0; index < cadenaBucle.length; index++) {
        console.log(cadenaBucle[index])   
    }
// j. Busca una subcadena dentro de un texto.
    let cadenaBusco = "chiquitito"
    let posCadena = cadenaBucle.indexOf(cadenaBusco)
    console.log(`La subcadena: ${cadenaBusco} empieza a partir del caracter ${posCadena}`)
// k. Extrae una subcadena desde la posición 3 hasta el final del texto y guárdala en una variable.
    let extraeSubCadena1 = cadenaBucle.substring(3)
    console.log(extraeSubCadena1)
// l. Extrae una subcadena desde la posición 3 hasta la primera ocurrencia de una palabra en el texto y guárdala en una variable.
    let cadenaBusco1 = "patito"
    let extraeSubCadena2 = cadenaBucle.substring(3, cadenaBucle.indexOf(cadenaBusco1))
    console.log(extraeSubCadena2)
// m. Reemplaza todos los espacios en el texto por un guion ‑.
    let cadenaAReemplazar = "Cuantos años son los que tu tienes"
    let reemplazadaCadena = cadenaAReemplazar.replaceAll(" ", "-")
    console.log(reemplazadaCadena)
// n. Elimina los espacios en blanco antes y después del texto.
    let eliminaCadena = "                  Muschos espacios, son muchisimos                    "
    console.log(cadenaAReemplazar.trim())
// o. Crea una cadena que no contenga ningún espacio partiendo de otra cadena dada
    console.log(eliminaCadena.replaceAll(" ",""))
// p. Crea una función que invierta una cadena de texto.
    function cadenaInvertida(cadena) {
        return cadena.split('').reverse().join('');
    }    
    console.log(cadenaInvertida(cadenaAReemplazar))
// q. Usa una expresión regular para comprobar si la cadena contiene números
    let cadenaNumeros = "Yo tengo 14, y tu 18"
    let contieneNumeros = /\d/.test(cadenaNumeros);
    console.log(`Tiene numeros? ${contieneNumeros}`)
// r. Usa una expresión regular para comprobar si la cadena termina en un punto.
    let terminaPunto = /\.$/.test(cadenaNumeros)
    console.log(`Termina en punto? ${terminaPunto}`)
// s. Usa una expresión regular para comprobar si la cadena comienza con una mayúscula.
    let empiezaMayuscula = /^[A-Z]/.test(cadenaAReemplazar)
    console.log(`Empieza en mayuscula? ${empiezaMayuscula}`)
// t. Usa una expresión regular para comprobar si la cadena contiene un número de teléfono con código internacional.
    let numeroTelefono = "+34 671 250 924"
    let telefonoInternacional = /\+\d{1,3}\s\d{3}\s\d{3}\s\d{3}/.test(numeroTelefono)
    console.log(`El telefono es correcto? ${telefonoInternacional}`)
// u. Reemplaza cualquier ocurrencia de un + seguido de números por la cadena “SECRETO”
    let reemplazarPorSecreto = numeroTelefono.replace(/\+\d{1,3}/g, "SECRETO") 
    console.log(`Mi telefono es? ${reemplazarPorSecreto}`)