#pragma once

#include <iostream>

// Solucion con atributos privados.

class Rational
{
private:
	// Atributos
	int numerador;
	int denominador;

private:
	// Auxiliares

	static int mcd(int a, int b);
	void reduce();

public:
	// Constructores

	Rational();
	Rational(int num, int den);

	// Operadores aritmeticos

	Rational operator+(const Rational& b) const;
	Rational operator-(const Rational& b) const;
	friend Rational operator*(const Rational& a,const Rational& b);
	friend Rational operator/(const Rational& a,const Rational& b);

	// Operadores logicos

	bool operator==(const Rational& b) const;
	bool operator<(const Rational& b) const;
	bool operator>(const Rational& b) const;

	// Friends, en su caso
	friend std::ostream& operator<<(std::ostream& os,const Rational& r);
	friend std::istream& operator>>(std::istream& is,Rational& r);

};

// Operadores aritmeticos

Rational operator*(const Rational& a,const Rational& b);
Rational operator/(const Rational& a,const Rational& b);

// Entrada/salida

std::ostream& operator<<(std::ostream& os,const Rational& r);
std::istream& operator>>(std::istream& is,Rational& r);
