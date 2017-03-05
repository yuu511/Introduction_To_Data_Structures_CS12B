# Makefile for dictionaryClient.c with macros

FLAGS   = -std=c99 -Wall
SOURCES = Dictionary.c DictionaryClient.c
OBJECTS = Dictionary.o DictionaryClient.o
EXEBIN  = DictionaryClient

all: $(EXEBIN)

$(EXEBIN) : $(OBJECTS)
	gcc -o $(EXEBIN) $(OBJECTS)

$(OBJECTS) : $(SOURCES)
	gcc -c $(FLAGS) $(SOURCES)
	
clean:
	rm -f $(EXEBIN) $(OBJECTS)

check:
	valgrind --leak-check=full ./$(EXEBIN) in out
