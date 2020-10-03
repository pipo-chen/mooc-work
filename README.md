# mooc-work
## mooc homework for java basic dev

## Java基础：入门编程练习 1
1. 编程题：使用Java输出如下图所示的心形

2. 编程题：今天是周二，1000天以后是周几？

3. 实现对三个整数进行排序，输出时按照从小到大的顺序输出。

4. 编写程序，从键盘接收整数参数。如果该数为1-7，打印对应的星期值，否则打印“非法参数”。

5. 从键盘分别输入年、月、日，判断这一天是当年的第几天

6. 从键盘上读入一个学生成绩，存放在变量score中，根据score的值输出其对应的成绩等级：
    - score>=90           等级：A
    - 70=<score<90        等级：B
    - 60=<score<70        等级：C
    - score<60            等级：D

7. 根据指定月份，打印该月份所属的季节。
    - 3,4,5 春季 6,7,8 夏季  9,10,11 秋季 12, 1, 2 冬季

8. 打印自然数的个数
    - 1）打印1~100之间 6的倍数的个数
    - 2）求出1～100之间，既是3又是7的倍数的自然数出现的次数？

9. 求调和级数中从第多少项开始值大于10
    - 调和级数的第n项形式为：1+1/2+1/3+…+1/n

10. 输出所有的水仙花数
    - 所谓水仙花数是指一个3位数，其各个位上数字立方和等于其本身。
    - 例如： 153 = 1*1*1 + 3*3*3 + 5*5*5 

11. 山上有一口缸可以装50升水，现在有15升水。老和尚叫小和尚下山挑水，每次可以挑5升。问：小和尚要挑几次水才可以把水缸挑满？通过编程解决这个问题。
    提示：
    - (1) 用整型变量water表示水缸里的水“int water = 15;”。
    - (2) 用整型变量l表示小和尚下山挑水的次数“int l = 0;”。
    - ((3) 分析循环条件（水少于50升），循环操作（水增加5升，挑水次数增加1）。
    - ((4) 套用while循环（或do-while循环）写出代码。

12. 生成13位条形码
    (Ean-13码规则：第十三位数字是前十二位数字经过计算得到的校验码。
    例如：690123456789
    计算其校验码的过程为：
    - (① 前十二位的奇数位和6+0+2+4+6+8=26
    - (② 前十二位的偶数位和9+1+3+5+7+9=34
    - (③ 将奇数和与偶数和的三倍相加26+34*3=128
    - (④ 取结果的个位数：128的个位数为8
    - (⑤ 用10减去这个个位数10-8=2
   - ( 所以校验码为2
    （注：如果取结果的个位数为0，那么校验码不是为10（10-0=10），而是0）
    实现上述代码的功能，计算验证码，输入12位条码，返回带验证码的条码。
    例：输入：692223361219输出：6922233612192

13. 开发一款软件，根据公式（身高-108）*2=体重，可以有10斤左右的浮动。来观察测试者体重是否合适。

14. 有3个整数，给出提示信息：能否创建三角形；两边之和大于第三边  三个条件都要写
如果能构建三角形，提示是直角三角形还是等边三角形等腰三角形还是普通三角形；最后输出三角形面积；

15. 一个数如果恰好等于它的因子之和，这个数就称为"完数"(因子：除去这个数本身正的约数）
- 例如6=1＋2＋3.编程 找出1000以内的所有完数


