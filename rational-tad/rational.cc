#include "rational.h"
#include <string>
#include <stdlib.h>

// Auxiliares, privadas

int mcd(int a, int b)
{
	return ( b==0 ? a : mcd(b,a%b) );
}

void reduce(Rational& r)
{
	//simplifica el racional
	int num = r.numerador;
	int den = r.denominador;

	int min = mcd(num, den);
	
	r.numerador = num / min;
	r.denominador = den / min;
}

// Inicializadores

void init(Rational& r)
{
	r.numerador = 0;
	r.denominador = 1;
}

void init(Rational& r,int num, int den)
{	
	r.numerador = num;
	r.denominador = den;
	reduce(r);
}

// Entrada/salida

void write(std::ostream& os, const Rational& r)
{
	os << r.numerador << "/" << r.denominador;
}

void read(std::istream& is, Rational& r)
{
	int num, den;
	char barra;
	is >> num >> barra >> den;

	if (den == 0) exit(1);
	
	init(r, num, den);
}

// Operaciones aritmeticas

Rational add(const Rational& r1, const Rational& r2)
{
	int rnum, rden;
	rnum = r1.numerador * r2.denominador + r2.numerador * r1.denominador;
	rden = r1.denominador * r2.denominador;

	Rational resultado;
	init(resultado, rnum, rden);
	return resultado;
}

Rational sub(const Rational& r1, const Rational& r2)
{
	int rnum, rden;
	rnum = r1.numerador * r2.denominador - r2.numerador * r1.denominador;
	rden = r1.denominador * r2.denominador;
	
	Rational resultado;
	init(resultado, rnum, rden);
	return resultado;
}

Rational mul(const Rational& r1, const Rational& r2)
{
	int rnum, rden;
	rnum = r1.numerador * r2.numerador;
	rden = r1.denominador * r2.denominador;
	
	Rational resultado;
	init(resultado, rnum, rden);
	return resultado;
}

Rational div(const Rational& r1, const Rational& r2)
{
	if (r2.numerador == 0) exit(1);
	
	int rnum, rden;
	rnum = r1.numerador * r2.denominador;
	rden = r1.denominador * r2.numerador;
	
	Rational resultado;
	init(resultado, rnum, rden);
	return resultado;
}

// Operaciones logicas

bool equal(const Rational& r1, const Rational& r2)
{
	Rational primer = r1;
	Rational segundo = r2;
	reduce(primer);
	reduce(segundo);
	return primer.numerador == segundo.numerador && primer.denominador == segundo.denominador;
}

bool lesser_than(const Rational& r1, const Rational& r2)
{
	if (equal(r1, r2)){
		return false;
	}

	float divprimero = r1.numerador / r1.denominador;
	float divsegundo = r2.denominador / r2.denominador;
	return divprimero < divsegundo;
}

bool greater_than(const Rational& r1, const Rational& r2)
{
	if (equal(r1, r2)){
		return false;
	}
	
	float divprimero = r1.numerador / r1.denominador;
	float divsegundo = r2.denominador / r2.denominador;
	return divprimero > divsegundo;
}