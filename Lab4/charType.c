//charType.c
//Code to read from file taken from FileIO.c

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<ctype.h>

int main(int argc, char* argv[]){
   FILE* in;  /* file handle for input */  
   FILE* out; /* file handle for output */ 
   
   int i;    /* int for indexing of string*/  
   int j;   /*int for indexing of letters*/
   int j1;   /*"" numbers*/
   int j2; /*"" puncuation*/
   int j3; /*""whitespace*/
  
   int lineNumber=1; /*int to keep track of line number*/
   
   int countA; /*int to keep track of how many l there are*/
   int countD; /*int to keep track of how many numbers there are*/
   int countP; /*"" punctuation*/
   int countW; /*"" whitespace*/
   
   char ch; /*variable to store character for functions*/
   int wordlen; /*int to keep track of max length of the string derived from reading a line */
   wordlen=256; /*define max length of string*/
   
   char* s;/*pointer for calloc storage for strings read from file*/ 
   s=(char*)calloc(wordlen,wordlen*sizeof(char)); /*allocates memory to store strings read from file*/
   /*if calloc fails, print an error*/
   if(s==NULL ){
   fprintf(stderr, "calloc failed\n");
   exit(EXIT_FAILURE);
   }
   
   char* a;/*pointer for calloc storage for letters read from file*/
   a=(char*)calloc(wordlen,wordlen*sizeof(char)); /*allocates memory to store letters*/
   /*if calloc fails, print an error*/
   if(a==NULL ){
   fprintf(stderr, "calloc failed\n");
   exit(EXIT_FAILURE);
   }
   
   char* d;/*pointer for calloc storage for digits read from file*/
   d=(char*)calloc(wordlen,wordlen*sizeof(char)); /*allocates memory to store digits*/
   /*if calloc fails, print an error*/
   if(d==NULL ){
   fprintf(stderr, "malloc failed\n");
   exit(EXIT_FAILURE);
   }
   
   char* p;/*pointer for calloc storage for punctuation read from file*/
   p=(char*)calloc(wordlen,wordlen*sizeof(char)); /*allocates memory to store punctuation*/
   /*if calloc fails, print an error*/
   if(p==NULL ){
   fprintf(stderr, "calloc failed\n");
   exit(EXIT_FAILURE);
   }
   
   char* w;/*pointer for calloc storage for whitepace read from file*/
   w=(char*)calloc(wordlen,wordlen*sizeof(char)); /*allocates memory to store whitespace*/
   /*if calloc fails, print an error*/
   if(w==NULL ){
   fprintf(stderr, "calloc failed\n");
   exit(EXIT_FAILURE);
   }
   
   
   
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

  /*The main method for sorting out characters*/
  /*while loop reads input from file line by line and parses the input into a string*/
  while (fgets (s,wordlen,in)){	  
  /*prints line number*/
  fprintf(out,"line %d contains:\n", lineNumber); 
  lineNumber++;
  
  /*set inital values to zero, so that the program counts line by line and not cumulatively*/
  countA=0; /*int to hold amount of alphabetical characters*/
  countD=0; /*digits*/
  countP=0; /*punctuation*/
  countW=0; /*whitespace*/
  ch=s[0];
  i=0;
  j=0;
  j1=0;
  j2=0;
  j3=0;
  
  /*Depending on the type of character passed, the program will store the character
    in the appropriate array allocated for it and count how many characters are inserted
	within that array.*/
	
  while ( ch!='\0' ){
  //checks for letters
  if (isalpha((int)ch)){
	  countA++;
	  a[j]=ch;
	  j++;	  
  }
  
  //digits
   if (isdigit((int)ch)){
	  countD++;
	  d[j1]=ch;
	  j1++;	  
  }
  
  //punctuation
    if (ispunct((int)ch)){
	  countP++;
	  p[j2]=ch;
	  j2++;	  
  }
  
  //white space
    if (isspace((int)ch)){
	  countW++;
	  w[j3]=ch;
	  j3++;	  
  }
  
  /*increment s to scan all characters in the string*/
  ch= s[++i];
  }   
    /*print statements to out stream*/
    if (countA>1)
     fprintf (out,"%d alphabetic characters: %s\n",countA,a); 
    else
     fprintf (out,"%d alphabetic character: %s\n",countA,a);
 
    if (countD>1)
     fprintf (out,"%d numeric characters: %s\n",countD,d); 
    else
     fprintf (out,"%d numeric character: %s\n",countD,d);
 
     if (countP>1)
     fprintf (out,"%d punctuation characters: %s\n",countP,p); 
     else
     fprintf (out,"%d punctuation character: %s\n",countP,p);
     
     if (countW>1)
     fprintf (out,"%d whitespace characters: %s\n",countW,w); 
     else
     fprintf (out,"%d whitespace character: %s\n",countW,w);
    
	/*empty array for next line*/
	memset(a,0,256);
	memset(d,0,256);
	memset(p,0,256);
	memset(w,0,256);
  }
  
  free(s);
  s= NULL;
  s=s+1;
  free(a);
  a= NULL;
  a=a+1;
  free(d);
  d= NULL;
  d=d+1;
  free(w);
  w= NULL;
  w=w+1;
  
   /* close input and output files */
   fclose(in);
   fclose(out);

   return(EXIT_SUCCESS);
}

 
