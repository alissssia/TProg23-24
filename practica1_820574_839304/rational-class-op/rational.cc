#include "rational.h"

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

	int min = mcd(num, den);
	
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

// Operadores aritmeticos

Rational Rational::operator+(const Rational& b) const
{
	int rnum, rden;
	rnum = this->numerador * b.denominador + b.numerador * this->denominador;
	rden = this->denominador * b.denominador;

	Rational resultado(rnum, rden);
	return resultado;
}

Rational Rational::operator-(const Rational& b) const
{
	int rnum, rden;
	rnum = this->numerador * b.denominador - b.numerador * this->denominador;
	rden = this->denominador * b.denominador;

	Rational resultado(rnum, rden);
	return resultado;
}

Rational operator*(const Rational& a, const Rational& b) 
{
	int rnum, rden;
	rnum = a.numerador * b.numerador;
	rden = a.denominador * b.denominador;

	Rational resultado(rnum, rden);
	return resultado;
}

Rational operator/(const Rational& a,const Rational& b)
{
	if (b.numerador == 0) exit(1);
	
	int rnum, rden;
	rnum = a.numerador * b.denominador;
	rden = a.denominador * b.numerador;

	Rational resultado(rnum, rden);
	return resultado;
}

// Operadores logicos

bool Rational::operator==(const Rational& b) const
{
	Rational a = *this;
	a.reduce();
	Rational c = b;
	c.reduce();
	return (a.numerador == c.numerador && a.denominador == c.denominador);
}

bool Rational::operator<(const Rational& b) const
{
	float divprimero = this->numerador / this->denominador;
	float divsegundo = b.numerador / b.denominador;
	return divprimero < divsegundo;
}

bool Rational::operator>(const Rational& b) const
{
	float divprimero = this->numerador / this->denominador;
	float divsegundo = b.numerador / b.denominador;
	return divprimero > divsegundo;
}

// Entrada/salida

std::ostream& operator<<(std::ostream& os,const Rational& r)
{
	os << r.numerador << "/" << r.denominador;
	return os;
}

std::istream& operator>>(std::istream& is, Rational& r)
{
	int num, den;
	char barra;
	is >> num >> barra >> den;

	if(den == 0) exit(1);
	
	r.numerador = num;
	r.denominador = den;
	r.reduce();

	return is;
}



