# Compound Words Finder

This Java program is designed to identify the longest and second-longest compounded words from a list of alphabetically sorted words stored in a file. A compounded word is defined as a word that can be constructed by concatenating shorter words also found in the same file. The solution uses a straightforward approach without employing a trie data structure, ensuring simplicity and efficiency.

## How to Use

1. **Input File**: The program reads the word list from a file specified by the `inputFile` variable in the code. Set this variable to the desired input file, such as "Input_01.txt" for a small list or "Input_02.txt" for a larger list.

2. **Execution**: Run the Java program, and it will display the longest and second-longest compounded words along with the time taken to process the input file.

3. **Output**: The program outputs the results to the console. The longest compounded word, second-longest compounded word, and the time taken to process the input file are all displayed.

## Approach

The solution utilizes a `Set` to efficiently store the words from the input file. The `isCompoundWord` method recursively checks if a word is compounded by trying different combinations of prefixes and suffixes. The program then identifies the longest and second-longest compounded words and reports the time taken for processing.

Feel free to modify the `inputFile` variable to test the program with different word lists.
