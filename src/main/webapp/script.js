// carregamento assincrono -> só executa o conteúdo do javascript
// após o conteúdo HTML ser carregada (content loaded = conteúdo carregado)
document.addEventListener('DOMContentLoaded', () => {

	function hello(msg){
		console.log(msg);
	};
	
	hello('hello world');
	
	// passagem de parâmetro e retorno de função
	// = significa atribuição: a = 0
	// == significa comparação -> igual :  "0" == 0
	// === significa comparação -> exatamente igual: "0" === "0"
	function  par(numero){
		return numero % 2 === 0;
	}
	
	const ePar = par(10);
	console.log(ePar);  // true
	
	function soma(num1, num2){
		return num1 + num2;
	}
	
	const total = soma(12, 13);
	// total = 10;  //erro
	console.log(total);
	
	if (total > 20){
		console.log("E maior que 20");
	} else {
		console.log('E menor ou igual a 20');
	}
	
	/*
		Math.round(x)	Retorna x arredondando para inteiro mais próximo
		Math.ceil(x)       ""          ""      para cima para o inteiro mais próximo
		Math.floor(x)      ""          ""      para baixo para o inteiro mais próximo
		Math.trunc(x)   Retorna a parte inteira de x
		Math.sign(x)    Retorna se x é negativo,null ou positivo
	*/
	
	function arredondar(numero){
		return Math.round(numero);
	}
	
	console.log(arredondar(7.9));  // 8
	
	// => arrow function = função arrow
	const somaArrow = (num1, num2) => {
		return num1 + num2;
	}
	
	// OU dessa forma
	// const somaArrow = (num1, num2) => num1 + num2;
	console.log(somaArrow(2, 3));
	
	const arrIntegers = [1,2,3,4,5,6,7,8,9,10,11];
	console.log(arrIntegers.length);   // 11
	console.log(arrIntegers[0]);       // 1
	
	const arrString = ['Gabriel', 'SOFTGRAF', 'Rafael'];
	console.log(arrString[1]);   // softgraf
	
	const arrMisto =  ['Gabriel', 'SOFTGRAF', 'Rafael', 1, 3, 7];
	console.log(arrMisto);
	
	console.log('=== Percorre o array com for')
	for (i=0; i<arrMisto.length; i++){
		console.log(arrMisto[i]);
	}
	
	console.log('=== Percorre o array com map')
	arrMisto.map(item => {
		console.log(item);
	});
	
	console.log('=== Retornando o array com alteração')
	const novoArr = arrIntegers.map(item => {
		return item + 2;
	});
	console.log(novoArr);
	
	console.log('===== Percorre o array com foreach')
	arrMisto.forEach(item => console.log(item));
	
	// criando objeto JS -> JSON
	const pessoa1 = {
		nome: 'Rafael',
		idade: 21,
		altura: 1.70
	};
	
	console.log(pessoa1);
	console.log('Nome pessoa1: ', pessoa1.nome);
	
	const pessoa2 = {
		nome: 'Gabriel',
		idade: 17,
		altura: 1.60
	};
	
	const pessoa3 = {
		nome: 'Fulano',
		idade: 13,
		altura: 1.65
	};
	
	// array de objetos JS
	const pessoas = [pessoa1, pessoa2, pessoa3];
	console.log(pessoas);
	
	console.log(pessoas[0].nome);
	
	const pessoa4 = {
		nome: 'Luiza',
		idade: 33,
		altura: 1.80
	};
	
	// adiciona pessoa4 no final do array pessoas
	pessoas.push(pessoa4);
	console.log(pessoas);
	
	// filtrando pessoas por idade
	const maiores = pessoas.filter((p) => p.idade >= 18);
	console.log(maiores);
	
	// busca uma pessoa pelo indice para remover
	const pos = pessoas.findIndex((p) => p.nome === 'Rafael');
	const itemRemovido = pessoas.splice(pos, 1); // 1 = quanto pra remover a partir do indice
	console.log('Item removido');
	console.log(itemRemovido);
	
	// verifica se TODAS as pessoas são maiores de 18 anos, retornando um boleano
	const todasAsPessoasMaiores = pessoas.every((p) => p.idade >= 18);
	console.log(todasAsPessoasMaiores);  // true ou false
	
	// verifica se ALGUMA pessoa é maior de 18
	const algumaPessoaMaior = pessoas.some((p) => p.idade >= 18);
	console.log(algumaPessoaMaior);  // true ou false
	
	// somando as idades com programação procedural
	let t = 0;
	for (let i=0; i<pessoas.length; i++){
		p = pessoas[i];
		t += p.idade;
	}
	
	console.log('Soma das idades: ' + t);  // 63
	
	// somando as idades usando programação funcional com reduce
	const somaIdades = pessoas.reduce((total, pessoa) => {
		return total + pessoa.idade;
	}, 0);
	
	console.log('Soma das idades: ' + somaIdades);
	
	// remove o item da última posição
	const ir = pessoas.pop();
	console.log(ir);
	
	// remove o teim da primeira posição
	const pr = pessoas.shift();
	console.log(pr);
	
	// remove item pela posição (posição, quantidade)
	pessoas.splice(0, 1);  
	console.log(pessoas.length); // 0
	
	
	
	




});