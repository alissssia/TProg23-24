# Fichero: add.cc
# Autores: Alicia Lazaro Huerta y Manel Jorda Puig Rubio
# Fecha: 27/02/2023
# Para compilar, ejecutar con 'make', limpiar con 'make clean'

PROG:=main
SRCS:=pila_ints.cc programa.cc prog_suma.cc prog_cuenta_atras.cc prog_factorial.cc instruccion.cc add.cc read.cc write.cc push.cc dup.cc jump_if.cc mul.cc swap.cc over.cc main.cc

CXX:= g++ -O2

OBJS:=$(SRCS:.cc=.o)

all: $(PROG) main.s

$(PROG): $(OBJS)
	$(CXX) -o $@ $(OBJS)

.cc.o:
	$(CXX) -c $<

edit:
	geany -s *.h *.cc &

clean:
	rm $(PROG) $(OBJS).o main.o

programa.o: programa.cc programa.h
pila_ints.o: pila_ints.cc pila_ints.h
prog_suma.o: prog_suma.cc prog_suma.h
prog_cuenta_atras.o: prog_cuenta_atras.cc prog_cuenta_atras.h
prog_factorial.o: prog_factorial.cc prog_factorial.h
instruccion.o: instruccion.cc instruccion.h
add.o: add.cc add.h
read.o: read.cc read.h
write.o: write.cc write.h
push.o: push.cc push.h
dup.o: dup.cc dup.h
jump_if.o: jump_if.cc jump_if.h
mul.o: mul.cc mul.h
swap.o: swap.cc swap.h
over.o: over.cc over.h
main.o: main.cc prog_suma.h prog_cuenta_atras.h prog_factorial.h
main.s: main.cc prog_suma.h prog_cuenta_atras.h prog_factorial.h

