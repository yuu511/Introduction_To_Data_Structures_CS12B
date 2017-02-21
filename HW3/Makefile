#------------------------------------------------------------------------------
# A Makefile with macros
#------------------------------------------------------------------------------

JAVASRC    = ChessBoard.java Bishop.java CheckHW3.java ChessPiece.java King.java Knight.java Node.java Pawn.java Queen.java Rook.java Utilities.java
SOURCES    = README Makefile $(JAVASRC)
MAINCLASS  = ChessBoard
CLASSES    = ChessBoard.class Bishop.class CheckHW3.class ChessPiece.class King.class Knight.class Node.class Pawn.class Queen.class Rook.class Utilities.class
JARFILE    = Chessmoves.jar


all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(CLASSES)
	rm Manifest

$(CLASSES): $(JAVASRC)
	javac -Xlint $(JAVASRC)



clean:
	rm $(CLASSES) $(JARFILE)

