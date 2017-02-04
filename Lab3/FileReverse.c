/*
*  FileReverse.c
*  Reads input file and prints each word reversed on a separate line of
*  the output file.
*  A majority of the code is taken from FileIO.c
*/
#include<stdio.h>
#include <string.h>
#include<stdlib.h>

int main(int argc, char* argv[]){
   FILE* in;  /* file handle for input */  
   FILE* out; /* file handle for output */
   char word[256]; /* char array to store words from input file */

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

	   

   
   /* read words from input file, print on separate lines ,reversed, to output file*/
   
   void StringReverse(char* s){
	 /*declare i, and j, which are used for indexing: i starts at the first letter, while j starts at the last letter*/  
	   int i=0;
	   int j=strlen(s)-1;
	   char temp;
	   
    while (j>i){
     /*stores index i in a temp*/
       temp=word[i];
	 /*swaps i and j*/
       word[i]=word[j];
       word[j]=temp;
     /*increment until while loop is done*/
       ++i;
       --j;
	} 	
    }   
	   
	   
	   
   while( fscanf(in, " %s", word) != EOF ){
	  StringReverse(word);
      fprintf(out, "%s\n",word);
   }

   /* close input and output files */
   fclose(in);
   fclose(out);

   return(EXIT_SUCCESS);
}