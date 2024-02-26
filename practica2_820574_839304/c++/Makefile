PROG:=main
SRCS:=pila_ints.cpp programa.cpp prog_suma.cpp prog_cuenta_atras.cpp prog_factorial.cpp instruccion.cpp add.cpp read.cpp write.cpp push.cpp dup.cpp jump_if.cpp mul.cpp swap.cpp over.cpp main.cpp

CXX:= g++ -O2

OBJS:=$(SRCS:.cc=.o)

all: $(PROG) main.s

$(PROG): $(OBJS)
	$(CXX) -o $@ $(OBJS)

.cc.o:
	$(CXX) -c $<

edit:
	geany -s *.h *.cpp &

clean:
	rm $(PROG)

programa.o: programa.cpp programa.h
pila_ints.o: pila_ints.cpp pila_ints.h
prog_suma.o: prog_suma.cpp prog_suma.h
prog_cuenta_atras.o: prog_cuenta_atras.cpp prog_cuenta_atras.h
prog_factorial.o: prog_factorial.cpp prog_factorial.h
instruccion.o: instruccion.cpp instruccion.h
add.o: add.cpp add.h
read.o: read.cpp read.h
write.o: write.cpp write.h
push.o: push.cpp push.h
dup.o: dup.cpp dup.h
jump_if.o: jump_if.cpp jump_if.h
mul.o: mul.cpp mul.h
swap.o: swap.cpp swap.h
over.o: over.cpp over.h
main.o: main.cpp prog_suma.h prog_cuenta_atras.h prog_factorial.h
main.s: main.cpp prog_suma.h prog_cuenta_atras.h prog_factorial.h

