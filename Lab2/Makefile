#------------------------------------------------------------------------------
# A Makefile with macros
#------------------------------------------------------------------------------

JAVASRC    = FileCopy.java FileReverse.java FileTokens.java
SOURCES    = README Makefile $(JAVASRC)
MAINCLASS  = FileReverse
CLASSES    = FileCopy.class FileReverse.class FileTokens.class
JARFILE    = FileReverse.jar


all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(CLASSES)
	rm Manifest

$(CLASSES): $(JAVASRC)
	javac -Xlint $(JAVASRC)



clean:
	rm $(CLASSES) $(JARFILE)

