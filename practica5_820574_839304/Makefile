# Variables
CC = ghc
CFLAGS = -Wall -O2

# Archivos de origen
SRCS = main.hs

# Archivos objeto generados por la compilación
OBJS = $(SRCS:.hs=.o)

# Archivos ejecutables generados por la compilación
EXEC = main

# Regla para limpiar archivos
clean:
	rm -f *.svg *.hi *.o $(EXEC)

# Regla para compilar archivos Haskell
%.o: %.hs
	$(CC) $(CFLAGS) -c $<

