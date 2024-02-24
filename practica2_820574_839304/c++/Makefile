PROG:=main
SRCS:=prog_suma.cpp main.cpp

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
	@rm -f $(PROG) $(OBJS) core *.s

prog_suma.o: prog_suma.cpp prog_suma.h
main.o: main.cpp prog_suma.h
main.s: main.cpp prog_suma.h
