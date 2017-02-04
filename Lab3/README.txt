A majority of the code in FileReverse.c is from FileIO.c.
The main difference is that FileReverse.c has a function implemented that uses char indexes to reverse a string(which is an array of chars in C).
FileReverse.c uses strlen(string) to index the end of a string.
The makefile compiles and links the object FileReverse.o, and has a clean function at  the end.
