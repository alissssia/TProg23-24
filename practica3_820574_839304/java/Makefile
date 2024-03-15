PROG:=main
SRCS:= camion.cc carga.cc contenedor.cc deposito.cc inventario.cc main.cc prodgenerico.cc producto.cc servivo.cc toxico.cc

CXX:= g++ -O2 -std=c++11

OBJS:=$(SRCS:.cc=.o)

ifeq ($(OS),Windows_NT)
    DEL := del
    EXE := .exe
else
    DEL := rm -f
    EXE :=
endif

all: $(PROG) main.s

$(PROG): $(OBJS)
	$(CXX) -o $@ $(OBJS)

.cc.o:
	$(CXX) -c $<

edit:
	geany -s *.h *.cc &

clean:
	$(DEL) $(PROG)$(EXE) $(OBJS) main.o

camion.o: camion.cc camion.h
carga.o: carga.cc carga.h
contenedor.o: contenedor.h toxico.h servivo.h
deposito.o: deposito.cc deposito.h
inventario.o: inventario.cc inventario.h
prodgenerico.o: prodgenerico.cc prodgenerico.h
producto.o: producto.cc producto.h
servivo.o: servivo.cc servivo.h
toxico.o: toxico.cc toxico.h
main.o: main.cc practica3.h
main.s: main.cc practica3.h camion.h carga.h contenedor.h deposito.h inventario.h prodgenerico.h producto.h servivo.h toxico.h


