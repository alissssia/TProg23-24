SRCS:= Main.java

JAVAC:=javac

CLSS:=$(SRCS:.java=.class)

all: $(CLSS)

%.class: %.java
	$(JAVAC) $<

.PHONY: edit

edit:
	@geany -s -i $(SRCS) &

clean:
	@del -f *.class core tags

