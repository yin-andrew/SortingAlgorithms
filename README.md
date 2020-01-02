# SortingAlgorithms
//Andrew Yin, 1/2/2020 Update

The purpose of this project is to analyse the efficiency of various sorting algorithms that we learned in class. For each of the 8 implementations of the algorithms, different input sizes are tested with random inputs. Each test is performed 5 times to yield an average run time, and then a table is printed as output which displays the results of the test. 

Note: Mergesort has both an iterative and recursive implementation, both of which are tested here. My instructor told me that the iterative implementation should be more efficient than the recursive implementation the majority of the time when the size of the array to be sorted, N, is greater than 512. However, that has not proven to be the case as the recursive implementation appears to be faster on average, further tests to be done. 
