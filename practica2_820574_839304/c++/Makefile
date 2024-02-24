PROG:=main
SRCS:=pila_ints.cpp programa.cpp prog_suma.cpp instruccion.cpp add.cpp read.cpp write.cpp main.cpp 

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
	@del -f $(PROG)

programa.o: programa.cpp programa.h instruccion.h
pila_ints.o: pila_ints.cpp pila_ints.h
prog_suma.o: prog_suma.cpp prog_suma.h
instruccion.o: instruccion.cpp instruccion.h
add.o: add.cpp add.h
read.o: read.cpp read.h
write.o: write.cpp write.h
main.o: main.cpp prog_suma.h
main.s: main.cpp prog_suma.h
