# info6205-teamProject

By sorting with pinyin4j, we use a two-dimensional string array to contians names and their pinyin expression.<br>
By sorting with collactor, we use a String array to store names.<br>
<a href= https://github.com/carlruan/info6205-teamProject/blob/master/report/INFO6205-FinalReport.docx> Final report </a><br>
<a href= https://github.com/carlruan/info6205-teamProject/blob/master/report/Paper%20report.docx> Paper report </a><br>
<a href= https://github.com/carlruan/info6205-teamProject/blob/master/report/code%20report.docx> Code modification and implementaion</a><br>
<a href=https://github.com/carlruan/info6205-teamProject/tree/master/report/thousandWords> First 1000 words. </a>!Collator sort won't sort correctly!<br>
<a href=https://github.com/carlruan/info6205-teamProject/blob/master/report/Benchmark%26UnitTest.docx> Bechmark and unit tests </a><br>

# MSD radix sort
By using Collator class, it’s difficult to define a proper charAt() method to return the char of a Chinese word. In order to solve this problem, we designed a map to keep each Chinese word and their order.<br>
At first, we obtained each Chinese word from shuffledChinese.txt and store themselves and their pinyin String transformed from pinyin4j in a key-value pair. Then we sort the pairs and initialize the map. <br>
After that, we can rewrite the charAt() method so that it will return map.get(Chinese char) which is the order of the Chinese word.<br>
    
# LSD radix sort
The major problem of LSD radix sort to sort Chinese names is that the basic LSD radix sort can only sort strings of same length. <br>
I have to add something to solve this problem. Since LSD radix sort is to sort the least significant character first, I can add “ “(space) to the end of the names which are not as long as others. <br>
At the beginning of the algorithm, I iterate the string array to get the length of longest name, and then iterate again to add space to names which length aren’t equal to the longest until they are the same length.<br>

# Three way string quicksort
In three way string quick sort, I just reuse the map obtained from MSD radix sort and modify the code a little. <br>
Modifications are made separately in sorting with Collator and sort with pinyin4j.<br>

# Timsort
In TImsort, I set the minimum merge number as 32, and use insertion sort to sort the Strings. <br>
I use Collator class and pinyin4j library to sort the String array, and make modifications to each algorithms.<br>

# Dual-pivot Quicksort
For sort with collator part, codes are unmodified.<br>
For sort with pinyin4j, we modified the code to sort two-dimensional string arrays.<br>

# Huskysort
In Huskysort, I set a Node class which implements HuskySortable and override compareTo() and huskycode() method. <br>
In order to get the correct order, I set Node with str as a data member which obtained from pinyin4j transforming Chinese names. <br>
And in compareTo() method, I compare attribute str of different Nodes. About huskycode(), I use HuskyCoderFactory.asciiToLong() method to get long of the Node’s str.<br>
