#include<stdio.h>
#include<stdlib.h>
#include"Dictionary.h"

//Code taken from FileIO.c to read file and write output

int main(int argc, char* argv[]){
   FILE* in;  /* file handle for input */  
   FILE* out; /* file handle for output */
   char input[256]; /* char array to store words from input file */
   
    /* check command line for correct number of arguments */
   if( argc != 3 ){
      printf("Usage: %s <input file> <output file>\n", argv[0]);
      exit(EXIT_FAILURE);
   }

   /* open input file for reading */
   in = fopen(argv[1], "r");
   if( in==NULL ){
      printf("Unable to read from file %s\n", argv[1]);
      exit(EXIT_FAILURE);
   }

   /* open output file for writing */
   out = fopen(argv[2], "w");
   if( out==NULL ){
      printf("Unable to write to file %s\n", argv[2]);
      exit(EXIT_FAILURE);
   }
    //CreateLinkedlist
   LinkedList newList= newLinkedList();
   
   
    /* read input file, perform appropriate operations*/
   while (fgets (input,sizeof(input),in)){
	 char inputType[2];
	 int inputNum;
	 /*formats input and places them into char and int variables*/
	   sscanf(input,"%s %d",inputType,&inputNum);
	   
	   /*if statement depending on kind of operation needed (as indicated by char */

	   /*insert*/
	   if (inputType[0]=='i'){
		   insert(inputNum,newList);
		   fprintf(out,"inserted %d\n",inputNum);
	   }
	   
	   /*delete*/
	   if (inputType[0]=='d'){
		   Node dummy=find(inputNum,newList);		   
		   if (dummy!=NULL){
		   delete(inputNum,newList);
		   fprintf(out,"deleted %d\n",inputNum);
		   }
	   }
	   
	   /*find*/
	   if (inputType[0]=='f'){
		 Node dummy=find(inputNum,newList);		   
		 if (dummy==NULL)
			fprintf(out,"%d not present\n",inputNum);
		 else
		    fprintf(out,"%d present\n",inputNum);	
	   }
	   
	   /*print*/
	   if (inputType[0]=='p')
		   printLinkedList(out,newList);		   
   }
   
/*frees linked list*/   
freeLinkedList(&newList);
	
  /* close input and output files */
   fclose(in);
   fclose(out);
	return EXIT_SUCCESS;
}

