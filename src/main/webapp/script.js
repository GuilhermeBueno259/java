// Carregamento assincrono -> só executa o conteúdo do javascript após o conteúdo HTML ser carregado (content loaded = conteúdo carregado)
document.addEventListener('DOMContentLoaded', () => {
	function hello(msg) {
		console.log(msg);
	}

	hello('Hello, World!');

	// Passagem de parâmetro e retorno de função
	function par(numero) {
		return numero % 2 === 0;
	}

	var ePar = par(10);
	console.log('10 e par? ' + ePar); // true

	function soma(num1, num2) {
		return num1 + num2;
	}

	const total = soma(11, 13);
	// total = 10;   // erro
	console.log(total);

	if (total > 20) {
		console.log('E maior que 20');
	} else {
		console.log('E menor ou igual a 20');
	}

	/*
		Math.round(x)	Retorna x arredondando para inteiro mais próximo
		Math.ceil(x)	Retorna x arredondando para cima para o inteiro mais próximo
		Math.floor(x)	Retorna x arredondando para baixo para o inteiro mais próximo
		Math.trunc(x)	Retorna a parte inteira de x
		Math.sign(x)	Retorna se x é negativo, null ou positivo 
	*/

	function arredondar(numero) {
		return Math.round(numero);
	}

	console.log('Numero arredondado: ' + arredondar(7.9)); // 8

	// => arrow function = função arrow
	const somaArrow = (num1, num2) => {
		return num1 + num2;
	}

	console.log('Primeira soma: ' + somaArrow(2, 5));

	// ou dessa forma
	const segundaSomaArrow = (num1, num2) => num1 + num2;

	console.log('Segunda soma: ' + segundaSomaArrow(4, 6));

	const arrIntegers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11];
	console.log('Tamanho do array: ' + arrIntegers.length);	// 11 
	console.log('Elemento do indice 0 do array: ' + arrIntegers[0]);		// 1

	const arrString = ['Gabriel', 'SOFTGRAF', 'Rafael'];
	console.log(`Segundo elemento do array de strings: ${arrString[1]}`); // SOFTGRAF

	const arrMisto = ['Gabriel', 'SOFTGRAF', 'Rafael', 1, 6, 3];
	console.log(`Conteudo do array misto: ${arrMisto}`);

	console.log('Percorre o array com for');
	for (let i = 0; i < arrMisto.length; i++) {
		console.log(arrMisto[i]);
	}

	console.log('Percorre o array com map')
	arrMisto.map(item => console.log(item));

	console.log('Retorna o array com alteracao');
	const novoArr = arrIntegers.map(item => item + 2);

	console.log(novoArr);

	console.log('Percorre o array com forEach');

	arrMisto.forEach(item => console.log(item));
	
	// criando objetos javascript
});