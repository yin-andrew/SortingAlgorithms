# SortingAlgorithms
//Andrew Yin, 1/2/2020 Update

Objective: 
The purpose of this project is to analyze the efficiency of various sorting algorithms. This program compares the run times (in milliseconds) of the following sorting algorithms: bubble sort, insertion sort, selection sort, recursive and nonrecursive mergesort, quicksort, and an optimized quicksort where if the number of elements in the array are less than 10 (N < 10), the implementation will use insertion sort instead. 

Implementation: 
The program generates random arrays of sizes (N) 2 <sup>1</sup>, 2<sup>2</sup>, 2<sup>3</sup>... 2<sup>14</sup>. At each size, the program generates 5 random arrays to be sorted by the sorting algorithm. The average time is then taken and reported in a table that is displayed as the output after all of the trials and all of the algorithms have been sorted. 

*The program also implements a mergesort function for linked lists but is not included in the comparison of sorting algorithms.

To run the program, remote lab machines were used for the final measurements instead of personal devices for consistency. Emory University's lab machines were accessed via an SSH session in MobaXTerm and the java files were transferred and run there. The results were graphed. 

Ex Output: 
```
Running Bubble Sort ...done.
Running Selection Sort ...done.
Running Insertion Sort ...done.
Running Quicksort...done.
Running Optimized Quicksort...done.
Running MergeSort Recursive ...done.
Running MergeSort Non Recursive ...done.
Running MergeSort for Linked List ...done.

Average running time(ms):
N	 Bubble Sort	    Selection Sort	Insertion Sort	QuickSort	QuickSortOpt	MergeSortRec	MergeSortNon	MergeSortList
2	   0.0014	          0.0012	      0.0019	     0.0033	      0.0054	      0.0034	      0.0023	     0.0120	  
4	   0.0003	          0.0004	      0.0002	     0.0006	      0.0001	      0.0006	      0.0004	     0.0015	  
8	   0.0005	          0.0008	      0.0002	     0.0013	      0.0001	      0.0014	      0.0005	     0.0112	  
16	  0.0003	            0.0025	      0.0003	     0.0065	      0.1200	      0.0153	      0.0008	     0.0223	  
32	  0.0008	            0.0137	      0.0007	     0.0379	      0.0552	      0.0191	      0.0015	     0.0322	  
64	  0.0013	            0.0580	      0.0013	     0.0591	      0.0549	      0.0226	      0.0031	     0.0517	  
128	  0.0034	            0.1141	      0.0031	     0.0562	      0.0635	      0.0291	      0.0143	     0.0351	  
256	  0.0076	            0.1763	      0.0048	     0.1344	      0.0948	      0.0296	      0.0184	     0.0270	  
512	  0.0092	            0.3179	      0.0091	     0.1851	      0.0624	      0.0480	      0.0233	     0.0381	  
1024	  0.0183	          0.2299	      0.0180	     0.1546	      0.1098	      0.0512	      0.0473	     0.0505	  
2048	  0.0291	          0.3910	      0.0360	     0.7162	      0.1943	      0.0568	      0.1049	     0.0667	  
4096	  0.0571	          1.6011	      0.0772	     2.5274	      0.4365	      0.1143	      0.2030	     0.1416	  
8192	  0.1126	          9.1142	      0.1313	    13.9597	      0.9435	      0.2301	      0.4244	     0.3142	  
16384	  0.0550	         37.8278	      0.0611	    59.3241	      1.3550	      0.4898	      0.5233	     0.7884
```

Note: Mergesort has both an iterative and recursive implementation, both of which are tested here. My instructor indicated that the iterative implementation should be more efficient than the recursive implementation the majority of the time when the size of the array to be sorted, N, is greater than 512. However, that has not proven to be the case as the recursive implementation appears to be faster on average, further tests to be done. 
