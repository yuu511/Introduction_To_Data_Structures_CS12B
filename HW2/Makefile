#------------------------------------------------------------------------------
# A Makefile with macros
#------------------------------------------------------------------------------

JAVASRC    = Chessboard.java Bishop.java ChessPiece.java King.java Knight.java Node.java Pawn.java Queen.java Rook.java
SOURCES    = README Makefile $(JAVASRC)
MAINCLASS  = Chessboard
CLASSES    = Chessboard.class Bishop.class ChessPiece.class King.class Knight.class Node.class Pawn.class Queen.class Rook.class
JARFILE    = Chessboard.jar


all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(CLASSES)
	rm Manifest

$(CLASSES): $(JAVASRC)
	javac -Xlint $(JAVASRC)



clean:
	rm $(CLASSES) $(JARFILE)

