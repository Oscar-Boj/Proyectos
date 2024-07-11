Algoritmo ProyectoFinal
	
	//Declaramos variables
	Definir n, opc, l, c, res Como Real;
	res <- 0;
	
	//Ciclo para menu de opciones y operaciones
	Repetir
		Escribir "1. SUMA";
		Escribir "2. RESTA";
		Escribir "3. MULTIPLICACION";
		Escribir "4. DIVISION";
		Escribir "5. POTENCIA";
		Escribir "6. RAIZ CUADRADA";
		Escribir "7. FINALIZAR";
		Escribir "Ingrese una opcion (1-7)";
		Leer opc;
		
		//Realizacion de las operaciones
		Segun opc Hacer
			//Operacion de la suma
			1:
				Escribir "-SUMA-";
				Escribir "Ingresa la cantidad de numeros a operar";
				leer l;
				Para c <- 1 Hasta l Con Paso 1 Hacer
					Escribir "Ingrese el numero";
					Leer n;
					res <- res + n;
					si c = l Entonces
						Escribir "El resultado es: ", res;
					FinSi
				Fin Para
				res <- 0;
			//Operacion de la resta
			2:
				Escribir "-RESTA-";
				Escribir "Ingresa la cantidad de numeros a operar";
				leer l;
				Para c <- 1 Hasta l Con Paso 1 Hacer
					Escribir "Ingrese el numero: ";
					Leer n;
					res <- -n - res;
					si c = l Entonces
						Escribir "El resultado es: ", res;
					FinSi
				Fin Para
				res <- 0;
			//Operacion de la multiplicacion
			3:
				Escribir "-MULTIPLICACION-";
				res <- 1;
				Escribir "Ingresa la cantidad de numeros a operar";
				leer l;
				Para c <- 1 Hasta l Con Paso 1 Hacer
					Escribir "Ingrese el numero";
					Leer n;
					res <- res * n;
					si c = l Entonces
						Escribir "El resultado es: ", res;
					FinSi
				Fin Para
				res <- 0;
			//Operacion de la division
			4:
				Escribir "-DIVIVSION-";
				res <- 1;
				Escribir "Ingresa la cantidad de numeros a operar";
				leer l;
				Para c <- 1 Hasta l Con Paso 1 Hacer
					Escribir "Ingrese el numero";
					Leer n;
					res <- n / res;
					si c = l Entonces
					Escribir "El resultado es: ", res;
					FinSi
				Fin Para
				res <- 0;
			//Operacion de la potencia
			5:
				Escribir "-POTENCIA-";
				Escribir "Ingrese la potencia";
				Leer c;
				Escribir "Ingrese el numero a elevar";
				Leer n;
				res <- n^c;
				Escribir "El resultado es: ", res;
			//Operacion de la raiz cuadrada
			6:
				Escribir "-RAIZ CUADRADA-";
				Escribir "Ingrese un numero";
				Leer n;
				res <- RC(n);
				Escribir "El resultado es: ", res;
			//Opcion para finalizar
			7:
				Escribir "Finalizando programa...";
			De Otro Modo:
				Escribir "Numero ingresado es incorrecto";
		Fin Segun
		
	//Fin del ciclo 
	Mientras Que opc <> 7;
	
FinAlgoritmo
