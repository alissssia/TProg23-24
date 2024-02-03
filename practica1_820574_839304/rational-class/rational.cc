/*
	Fichero: rational-class/rational.cc
	Autores: Alicia Lázaro Huerta y Manel Jordá Puig Rubio
	Fecha: 2/2/2024
*/

#include "rational.h"
#include <stdlib.h>

// Auxiliares

int Rational::mcd(int a, int b)
{
	return ( b == 0 ? a : mcd(b,a%b));
}

void Rational::reduce()
{
	//simplifica el racional
	int num = this->numerador;
	int den = this->denominador;

	if (den < 0){
		den = den * -1;
		num = num * -1;
	}

	int min = mcd(abs(num), abs(den));
	
	this->numerador = num / min;
	this->denominador = den / min;
}

// Constructores

Rational::Rational()
{
	this->numerador = 0;
	this->denominador = 1;
}

Rational::Rational(int num, int den)
{
	this->numerador = num;
	this->denominador = den;
	this->reduce();
}

// Entrada/salida

void Rational::write(std::ostream& os) const
{	
	if (this->denominador == 1){
		os << this->numerador;
	} else {
		os << this->numerador << "/" << this->denominador;
	}
}

void Rational::read(std::istream& is)
{
	int num, den;
	char barra;
	is >> num >> barra >> den;

	if (den == 0) {
		this->numerador = 0;
		this->denominador = 1;	
	} else {
		this->numerador = num;
		this->denominador = den;
		this->reduce();	
	}
}

// Operaciones aritmeticas

Rational Rational::add(const Rational& b) const
{
	int rnum, rden;
	rnum = this->numerador * b.denominador + b.numerador * this->denominador;
	rden = this->denominador * b.denominador;

	Rational resultado(rnum, rden);
	return resultado;
}

Rational Rational::sub(const Rational& b) const
{	
	int rnum, rden;
	rnum = this->numerador * b.denominador - b.numerador * this->denominador;
	rden = this->denominador * b.denominador;

	Rational resultado(rnum, rden);
	return resultado;
}

Rational Rational::mul(const Rational& b) const
{
	int rnum, rden;
	rnum = this->numerador * b.numerador;
	rden = this->denominador * b.denominador;

	Rational resultado(rnum, rden);
	return resultado;
}

Rational Rational::div(const Rational& b) const
{	
	if(b.numerador == 0){
		Rational resultado;
		return resultado;
	} else {
		int rnum, rden;
		rnum = this->numerador * b.denominador;
		rden = this->denominador * b.numerador;

		Rational resultado(rnum, rden);
		return resultado;
	}
	
}

// Operaciones logicas

bool Rational::equal(const Rational& b) const
{
	Rational a = *this;
	a.reduce();
	Rational c = b;
	c.reduce();
	return (a.numerador == c.numerador && a.denominador == c.denominador);
}

bool Rational::lesser_than(const Rational& b) const
{
	if (this->equal(b)) return false;

	float divprimero = this->numerador / this->denominador;
	float divsegundo = b.numerador / b.denominador;
	return divprimero < divsegundo;
}

bool Rational::greater_than(const Rational& b) const
{
	if (this->equal(b)) return false;

	float divprimero = this->numerador / this->denominador;
	float divsegundo = b.numerador / b.denominador;
	return divprimero > divsegundo;
}
