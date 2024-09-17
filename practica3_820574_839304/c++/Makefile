PROG:=main
SRCS:=main.cpp

CXX:=g++ -Wall -std=c++11

OBJS:=$(SRCS:.cpp=.o)
DEPS:=$(SRCS:.cpp=.d)

all: $(PROG)

$(PROG): $(OBJS)
	$(CXX) -o $@ $^

.cc.o:
	$(CXX) -c -MMD $<

.PHONY: edit go

go: $(PROG)
	$(PROG)

edit:
	@geany -s -i $(SRCS) *.h &

clean:
	@rm -f $(PROG) $(OBJS) $(DEPS) *.gch core tags

-include $(DEPS)
