/**结题报告：
 * a + b + c = sum -> a + b = sum - c, 其中 a, b,c 为变量，sum 在本题中等于0, 所以,先排序 arr, 再遍历数组，每个A[i] 当做 c ,问题转化为2 sum, target = sum - c,  然后用双指针法，往中间夹取，有重复，则继续挪动指针, 或者也可以用hashset 来处理去重问题
 * 
 * 3 Sum是two Sum的变种，可以利用two sum的二分查找法来解决问题。
 本题比two sum增加的问题有：解决duplicate问题，3个数相加返回数值而非index。
 首先，对数组进行排序。
 然后，从0位置开始到倒数第三个位置（num.length - 2)，进行遍历，假定num[i]就是3sum中得第一个加数，然后从i+1的位置开始，进行2sum的运算。
 当找到一个3sum==0的情况时，判断是否在结果hashset中出现过，没有则添加。(利用hashset的value唯一性）
 因为结果不唯一，此时不能停止，继续搜索，low和high指针同时挪动。
 
 * 
 */ 