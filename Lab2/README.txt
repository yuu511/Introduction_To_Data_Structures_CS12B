The make file compiles all three files with FileReverse as the main class and makes one jar file.

For FileReverse, I used most of FileTokens.java, but added some extra code. The code from FileTokens would parse the text, 
but instead of outputting words and amount of tokens, it would output the word reversed. I used a for loop and the .charAt() method
 to store a reversed word in a temp string, which would eventually print out to the file.