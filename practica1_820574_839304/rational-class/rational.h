/*
	Fichero: rational-class/rational.h
	Autores: Alicia Lázaro Huerta y Manel Jordá Puig Rubio
	Fecha: 2/2/2024
*/

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

	// Entrada/salida

	void write(std::ostream& os) const;
	void read(std::istream& is);

	// Operaciones aritmeticas

	Rational add(const Rational& b) const;
	Rational sub(const Rational& b) const;
	Rational mul(const Rational& b) const;
	Rational div(const Rational& b) const;

	// Operaciones logicas

	bool equal(const Rational& b) const;
	bool lesser_than(const Rational& b) const;
	bool greater_than(const Rational& b) const;
};
