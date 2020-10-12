### ZigZag Conversion
#### 方法1
本质方法是将元素按照题目描述放到容器里，再遍历。一开始想直接用二维数组打印，空间复杂度太高。其实每一行可以用ArrayList进行压缩。
2. 构造N个List，N代表rows。按照N字型逐个将元素放入每行的List。放置顺序先从的上到下，再从下到上。注意变换方向的时机，是第一行和最后一行。
3. 最后，遍历每一行，将每行List中的元素按顺序拼接起来。

#### 方法2
找规律，发现这个Z字队形有以下特点：
1. numRows>1的情况下，在竖的每一行，元素数量为N，斜的每一行，元素数量为N-2。也就是竖的每一行，两个元素在原字符串里下标的间隔是2N-2。假如输入数组a，例如第一行，第一个元素时a[0]，第二个元素时a[2n-2],第三个元素时a[4n-4]...依次类推。第二行会发现也是一样的：a[1],a[2n-1],a[4n-3]...。
2. 除了第一行和最后一行，每两个竖的中间又有一个元素，index为[old+2n-2-i*2], old表示前一个元素的索引。


### 7. Reverse Integer
踩坑心得：
1. 算数问题，要重点关注越界问题。
2. 正数做除运算（除以正数）是正数；负数做除运算，是负数。
2. 正数的余数为正数，很直观；负数取余数，余数也是负数。比如-10 mod 3 =-1
3. 表达式：`a = a x 10 + b`；这个表达式有几个越界风险。
	1. 如果`a = a x 10 + b`是正数，很可能比`Integer.MAX_VALUE大`。
	2. 如果`a = a x 10 + b`，则可能比`Integer.MIN_VALUE`小。
	3. 因此采用`a x 10 + b > Integer.MAX_VALUE`或者`a x 10 + b < Integer.MIN_VALUE`都是不可取的，因为左边的很可能已经越界了。但是可以做一个不定式的换算，即可以改判断为`a > (Integer.MAX_VALUE - b)/10, (b>0)`，或者`a < (Integer.MAX_VALUE - b)/10, (b<0)`; 