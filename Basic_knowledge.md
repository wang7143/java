Java是一个完整的平台，有一个庞大的库，其中包含了很多可重用的代码和一个提供诸如安全性、跨操作系统的可移植性以及自动垃圾收集等服务的执行环境。

1）简单性
2）面向对象
3）分布式
Java有一个丰富的例程库，用于处理像HTTP和FTP之类的TCP/IP协议。Java应用程序能够通过URL打开和访问网络上的对象，其便捷程度就好像访问本地文件一样。
4）健壮性
Java投入了大量的精力进行早期的问题检测、后期动态的（运行时）检测，并消除了容易出错的情况……Java和C++最大的不同在于Java采用的指针模型可以消除重写内存和损坏数据的可能性。
5）安全性
运行时堆栈溢出。如蠕虫和病毒常用的攻击手段。
·破坏自己的进程空间之外的内存。
·未经授权读写文件。

6）体系结构中立
编译器生成一个体系结构中立的目标文件格式，这是一种编译过的代码，只要有Java运行时系统，这些编译后的代码可以在许多处理器上运行。Java编译器通过生成与特定的计算机体系结构无关的字节码指令来实现这一特性。精心设计的字节码不仅可以很容易地在任何机器上解释执行，而且还可以动态地翻译成本地机器代码。
7）可移植性
8）解释型
Java解释器可以在任何移植了解释器的机器上执行Java字节码。由于链接是一个增量式且轻量级的过程，所以，开发过程也变得更加快捷，更加具有探索性。

9）高性能
10）多线程
11）动态性

3.4.2 常量
在Java中，利用关键字final指示常量，
可以使用关键字staticfina丨设置一个类常量
需要注意，类常量的定义位于maiii方法的外部。因此，在同一个类的其他方法中也可以使用这个常量。而且，如果一个常量被声明为public，那么其他类的方法也可以使用这个量。
如果将一个类标记为strictfp,这个类中的所有方法都要使用严格的浮点计算。

3.5.3 强制类型转换
    需要通过强制类型转换（cast)实现这个操作。强制类型转换的语法格式是在圆括号中给出想要转换的目标类型，后面紧跟待转换的变量名


3.6 字符串 
    Java没有内置的字符串类型，而是在标准Java类库中提供了一个预定义类，很自然地叫做String。每个用双引号括起来的字符串都是String类的一个实例

3 . 6.1子串
    Stringgreeting="Hello";
    Strings=greeting.substring®,3);
    创建了一个由字符“Hel”组成的字符串。

3.6.2拼接
    Java语言允许使用+号连接（拼接）两个字符串，
    当将一个字符串与一个非字符串的值进行拼接时，后者被转换成字符串。
    如果需要把多个字符串放在一起，用一个定界符分隔，可以使用静态join方法：
    Stringall=String.join("/","S","M","L","XL");
    如何修改这个字符串呢？在Java中实现这项操作非常容易。首先提取需要的字符，然后再拼接上替换的字符串：
    greeting=greeting.substring(0,3)+"p!";
    上面这条语句将greeting当前值修改为“Help!”

3.6.3不可变字符串
    以想象将各种字符串存放在公共的存储池中。字符串变量指向存储池中相应的位置。如果复制一个字符串变量，原始字符串与复制的字符串共享相同的字符。
    总而言之，Java的设计者认为共享带来的高效率远远胜过于提取、拼接字符串所带来的低效率。查看一下程序会发现：很少需要修改字符串，而是往往需要对字符串进行比较（有一种例外情况，将来自于文件或键盘的单个字符或较短的字符串汇集成字符串。为此，Java提供了一个独立的类

3.6.4 检测字符串是否相等
    可以使用equals方法检测两个字符串是否相等。对于表达式：
    s.equals(t)；如果字符串s与字符串t相等，则返回true;否则，返回false。
    也可以是字符串字面量。例如，下列表达式是合法的："Hello".equals(greeting)要想检测两个字符串是否相等，而不区分大小写，可以使用equalsIgnoreCase方法。"Hello".equalsIgnoreCase("hel1o")

    如果虚拟机始终将相同的字符串共享，就可以使用=运算符检测是否相等。但实际上只有字符串常量是共享的，而+或substring等操作产生的结果并不是共享的。因此，千万不要使甩==运算符测试字符串的相等性，以免在程序中出现糟糕的bug。从表面上看，这种bug很像随机产生的间歇性错误。

3 . 6.5空 串 与Null串
    空串""是长度为0的字符串 
    if(str.lengthQ=0) 或 if(str.equals(""))；
    String变量还可以存放一个特殊的值，名为null,这表示目前没有任何对象与该变量关联

如果想要遍历一个字符串，并且依次査看每一个码点，可以使用下列语句：
    intcp=sentence.codePointAt(i);
    if(Character.isSupplementaryCodePoint(cp))i+=2;elsei++;
可以使用下列语句实现回退操作：i；
    if(CharacterssSurrogate(sentence.charAt(i)))i;
    intcp=sentence.codePointAt(i);
显然，这很麻烦。更容易的办法是使用codePoints方法，它会生成一个int值的“流”，每个int值对应一个码点。（流将在卷II的第2章中讨论〉可以将它转换为一个数组（见3.10节)，再完成遍历。
    intDcodePoints=str.codePointsO.toArrayO；

反之，要把一个码点数组转换为一个字符串，可以使用构造函数（我们将在第4章详细讨论构造函数和new操作符)。
    Stringstr=newString(codePoints,0,codePoints.length)

charcharAt(intindex)
返回给定位置的代码单元。除非对底层的代码单元感兴趣，否则不需要调用这个方法。•intcodePointAt(intIndex)
5.0返回从给定位置开始的码点。
•intoffsetByCodePoints(intstartlndex,intcpCount)5.0
返回从startlndex代码点开始，位移cpCount后的码点索引。
•i n tcompareTo(Stringother)按照字典顺序，如果字符串位于other之前，返回一个负数；如果字符串位于other之后，返回一个正数；如果两个字符串相等，返回0。•IntStreamcodePoints()8
将这个字符串的码点作为一个流返回。调用toArray将它们放在一个数组中。•newString(int[]codePoints,intoffset,intcount)5.0
用数组中从offset开始的count个码点构造一个字符串。
•booleanequals(0bjectother)
如果字符串与other相等，返回true。
$3tJava的 基 本 程 序 ? ? ? 构5 1•
booleanequalsIgnoreCase(Stringother)
如果字符串与other相等（忽略大小写)，返回tme。•booleanstartsWith(Stringprefix)•booleanendsWith(Stringsuffix)如果字符串以suffix开头或结尾，则返回true。

•intindexOf(Stringstr)•intindexOf(Stringstr,intfromlndex)•intindexOf(intcp)•intindexOf(intcp,intfromlndex)返回与字符串str或代码点cp匹配的第一个子串的开始位置。这个位置从索引0或fromlndex开始计算。如果在原始串中不存在str，返回-1。

•int1astIndexOf(Stringstr)•Int1astIndexOf(Stringstr,intfromlndex)•intlastindexOf(intcp)•int1astindexOf(intcp,intfromlndex)返回与字符串str或代码点cp匹配的最后一个子串的开始位置。这个位置从原始串尾端或fromlndex开始计算。

•int1ength()返回字符串的长度。•intcodePointCount(intstartlndex,intendlndex)5.0返回startlndex和endludex-l之间的代码点数量。没有配成对的代用字符将计入代码点。參Stringreplace(CharSequenceoldString,CharSequencenewString)返回一个新字符串。这个字符串用newString代替原始字符串中所有的oldString。可以用String或StringBuilder对象作为CharSequence参数。•Stringsubstring(intbeginlndex)參Stringsubstring(intbeginlndex,intendlndex)返回一个新字符串。这个字符串包含原始字符串中从beginlndex到串尾或endlndex-l的所有代码单元。•StringtoLowerCase()參StringtoUpperCase()返回一个新字符串。这个字符串将原始字符串中的大写字母改为小写，或者将原始字符串中的所有小写字母改成了大写字母。•Stringt r i m()返回一个新字符串。这个字符串将删除了原始字符串头部和尾部的空格。•Stringjoin(CharSequencedelimiter,CharSequence...elements)8返回一个新字符串，用给定的定界符连接所有元素。

3 . 6.9构建字符串
    如果需要用许多小段的字符串构建一个字符串，那么应该按照下列步骤进行。首先，构建一个空的字符串构建器：StringBuilderbuilder=newStringBuilderO;当每次需要添加一部分内容时，就调用append方法。builder.append(ch);//appendsasinglecharacterbui1der.append(str);//appendsastring在需要构建字符串时就凋用toString方法，将可以得到一个String对象，其中包含了构建器中的字符序列。StringcompletedString=builder.toString()


3.7.3 文件输入与输出
    要想对文件进行读取，就需要一个用File对象构造一个Scanner对象，如下所示：Scannerin=newScanner(Paths.get("niyflle.txt"),"UTF-8");
    如果文件名中包含反斜杠符号，就要记住在每个反斜杠之前再加一个额外的反斜杠：“c:\\mydirectory\\myfile.txt”

    要想写入文件，就需要构造一个PrintWriter对象。在构造器中，只需要提供文件名：PrintWriterout=newPrintlulriterC'myfile.txt","UTF-8");
    如果文件不存在，创建该文件。可以像输出到System.out—样使用print、println以及printf命令。


    当采用命令行方式启动一个程序时，可以利用Shell的重定向语法将任意文件关联到System.in和System.out:
    javaMyProg<rayfile.txt>output.txt
    这样，就不必担心处理IOException异常了


for 循环
    尽管Java允许在for循环的各个部分放置任何表达式，但有一条不成文的规则：for语句的3个部分应该对同一个计数器变量进行初始化、检测和更新。若不遵守这一规则，编写的循环常常晦涩难懂

与C++不同，Java还提供了一种带标签的break语句，用于跳出多重嵌套的循环语句。
请注意，标签必须放在希望跳出的最外层循环之前，并且必须紧跟一个冒号。

3.9 大数值
    如果基本的整数和浮点数精度不能够满足需求，那么可以使用jaVa.math包中的两个很有用的类：Biglnteger和BigDecimaL这两个类可以处理包含任意长度数字序列的数值。Biglnteger类实现了任意精度的整数运算，BigDecimal实现了任意精度的浮点数运算。
    使用静态的valueOf方法可以将普通的数值转换为大数值：
    Biglntegera=Biglnteger.valueOf(100);
    遗憾的是，不能使用人们熟悉的算术运算符（如：+和*)处理大数值。而需要使用大数值类中的add和multiply方法。
    Biglntegerc=a.add(b);
    //c=a+b
    Biglntegerd=c.nultipiy(b.add(Biglnteger.valueOf(2)));
    //d=c*(b+2)

3.10 数组
    创建一个数字数组时，所有元素都初始化为0。boolean数组的元素会初始化为fals%对象数组的元素则初始化为一个特殊值null,这表示这些元素（还）未存放任何对象。初学者对此可能有些不解。例如，String[]names=newString[10];会创建一个包含10个字符串的数组，所有字符串都为null。

3.10.1 for each循环
    for(intelement:a)System.out.println(element):打印数组a的每一个元素，一个元素占一行。这个循环应该读作“循环a中的每一个元素”（foreachelementina)。


3.10.2  数组初始化以及匿名数组
    在Java中，提供了一种创建数组对象并同时赋予初始值的简化书写形式。下面是一例子：int[]smallPrimes={2,3,5,7,11,13};请注意，在使用这种语句时，不需要调用new。甚至还可以初始化一个匿名的数组：newintD{17,19,23,29,31,37}这种表示法将创建一个新数组并利用括号中提供的值进行初始化，数组的大小就是初始值的个数。使用这种语法形式可以在不创建新变量的情况下重新初始化一个数组。例如：smallPrimes=newint[]{17,19,23,29,31,37};


3.10.3  数组拷贝
    两个变量将引用同一个数组：intQluckyNumbers=smallPrimes;1uckyNumbers[S]=12;//nowsmallPrimes[5]isalso12图3-14显示了拷贝的结果。如果希望将一个数组的所有值拷贝到一个新的数组中去，就要使用Arrays类的copyOf方法：l u c k y N u m b e r f e=|{"1 1图3-1 4拷贝一个数组变量int[]copiedLuckyNumbers=Arrays.copyOf(luckyNumbers,luckyNumbers.length);第2个参数是新数组的长度。这个方法通常用来增加数组的大小：luckyNumbers=Arrays.copyOf(luckyNumbers,2*luckyNumbers.length);如果数组元素是数值型，那么多余的元素将被赋值为0;如果数组元素是布尔型，则将赋值为false。相反，如果长度小于原始数组的长度，则只拷贝最前面的数据元素。

    Java中的[]运算符被预定义为检查数组边界，而且没有指针运算，即不能通过a加1得到数组的下一个元素。

3.10.5 数组排序
    要想对数值型数组进行排序，可以使用Arrays类中的sort方法.
    Math.rand0m方法将返回一个0到1之间（包含0、不包含1)的随机浮点数。用乘以这个浮点数，就可以得到从0到n-l之间的一个随机数。intr=(int)(Math.random0*n)


第四章   对象与类
    实现封装的关键在于绝对不能让类中的方法直接地访问其他类的实例域。程序仅通过对象的方法与对象数据进行交互。封装给对象赋予了“黑盒”特征，这是提高重用性和可靠性的关键。这意味着一个类可以全面地改变存储数据的方式，只要仍旧使用同样的方法操作数据，其他对象就不会知道或介意所发生的变化。

4.2.1 对象与对象变量
    在Java程序设计语言中，使用构造器（constructor)构造新实例。
    一定要认识到：一个对象变量并没有实际包含一个对象，而仅仅引用一个对象。
    在Java中，任何对象变量的值都是对存储在另外一个地方的一个对象的引用。new操作符的返回值也是一个引用。

    在Java语言中，这些问题都不复存在。如果使用一个没有初始化的指针，运行系统将会产生一个运行时错误，而不是生成一个随机的结果，同时，不必担心内存管理问题，垃圾收集器将会处理相关的事宜。

    在Java中，必须使用clone方法获得对象的完整拷贝

    只 访 问 对 象 而 不 修 改 对 象 的 方 法 有 时 称 为 访 问 器 方 法


    •构造器与类同名
    •每个类可以有一个以上的构造器
    •构造器可以有0个、1个或多个参数
    •构造器没有返回值
    •构造器总是伴随着new操作一起调用

    在Java中，为了实现一个私有的方法，只需将关键字public改为private即可。

4.3.9   final实例域
    可以将实例域定义为final。构建对象时必须初始化这样的域。也就是说，必须确保在每一个构造器执行之后，这个域的值被设置，并且在后面的操作中，不能够再对它进行修改。
    final修饰符大都应用于基本（primitive)类型域，或不可变（immutable)类的域（如果类中的每个方法都不会改变其对象，这种类就是不可变的类。

4.4 静态域与静态方法
    如果将域定义为static,每个类中只有一个这样的域。而每一个对象对于所有的实例域却都有自己的一份拷贝。


    在下面?种情?下使用??方法：
    •一方法不需要访问对象状态，其所需参数都是通过显式参数提供（例如：Math.pow)0
    •一个方法只需要访问类的静态域（例如：Employee.getNextldh

4.4.4 工厂方法
    NumberFormatcurrencyFormatter=NumberFormat.getCurrencylnstanceO;NumberFormatpercentFormatter=NumberFormat.getPercentlnstance()；doublex=0.1;System.out.println(currencyFormatter.format(x));//printsSO.10System.out.println(percentFomatter.format(x));//prints10%

4.4.5
    main方法不对任何对象进行操作。事实上，在启动程序时还没有任何一个对象。静态的main方法将执行并创建程序所需要的对象。

4.5  方法参数
    按值调用（callbyvalue)表示方法接收的是调用者提供的值。而按引用调用（callbyreference)表示方法接收的是调用者提供的变量地址。一个方法可以修改传递引用所对应的变量值，而不能修改传递值调用所对应的变量值。
    方法得到的是对象引用的拷贝，对象引用及其他的拷贝同时引用同一个对象。
    Java程序设计语言对对象采用的不是引用调用，实际上，对象引用是按值传递的。
    下面总结一下Java中方法参数的使用情况：
    •一个方法不能修改一个基本数据类型的参数（即数值型或布尔型）。
    •一个方法可以改变一个对象参数的状态。
    •一个方法不能让对象参数引用一个新的对象。


4.6  对象构造
    前面已经学习了编写简单的构造器，可以定义对象的初始状态。但是，由于对象构造非常重要，所以Java提供了多种编写构造器的机制。

4.6.1 重载
    如果多个方法有相同的名字、不同的参数，便产生了重载。

4.6.2   默认域初始化
    如果在构造器中没有显式地给域赋予初值，那么就会被自动地赋为默认值：数值为0、布尔值为false、对象引用为null。

4.6.3   无参数的构造器
    如果在编写一个类时没有编写构造器，那么系统就会提供一个无参数构造器。这个构造器将所有的实例域设置为默认值。于是，实例域中的数值型数据设置为0、布尔型数据设置为false、所有对象变量将设置为null。

4.6.4   显式域初始化
    在执行构造器之前，先执行赋值操作。当一个类的所有构造器都希望把相同的值赋予某个特定的实例域时，这种方式特别有用。

4.6.6  调用另一个构造器
    采用这种方式使用this关键字非常有用，这样对公共的构造器代码部分只编写一次即可。

4.6.8   对象析构与finalize方法
    可以为任何一个类添加finalize方法。finalize方法将在垃圾回收器清除对象之前调用。在实际应用中，不要依赖于使用finalize方法回收任何短缺的资源，这是因为很难知道这个方法什么时候才能够调用。

4.7     包
    使用包的主要原因是确保类名的唯一性。假如两个程序员不约而同地建立了Employee类。只要将这些类放置在不同的包中，就不会产生冲突。事实上，为了保证包名的绝对唯一性，Sun公司建议将公司的因特网域名（这显然是独一无二的）以逆序的形式作为包名，并且对于不同的项目使用不同的子包。

4.7.1   类的导入
    一个类可以使用所属包中的所有类，以及其他包中的公有类（publicclass)。
    我们可以采用两种方式访问另一个包中的公有类。

4.7.2   静态导入
    mportstaticjava.lang.System.*;就可以使用System类的静态方法和静态域，而不必加类名前缀：

4.7.3   将类放入包中
    如果没有在源文件中放置package语句，这个源文件中的类就被放置在一个默认包(defaulfpackage)中。默认包是一个没有名字的包。在此之前，我们定义的所有类都在默认包中。

4.7.4   包作用域

4.8   类路径
    类存储在文件系统的子目录中。类的路径必须与包名匹配。类文件也可以存储在JAR(Java归档）文件中。在一个JAR文件中，可以包含多个压缩形式的类文件和子目录，这样既可以节省又可以改善性能。
    JAR文件使用ZIP格式组织文件和子目录。可以使用所有ZIP实用程序查看内部的rt.jar以及其他的JAR文件。

4.8.1  设置类路径
    java -classpath/home/user/dassdir:.:/home/user/archives/archive.jarHyProg
    利用-dasspath选项设置类路径是首选的方法，也可以通过设置CLASSPATH环境变量完成这个操作。其详细情况依赖于所使用的shell。在BourneAgainshell(bash)中，命令格式如下：
    exportCLASSPATH=/home/user/classdir:.:/home/user/archives/archive.jar
    在Windowsshell,命令格式如下：
    setCLASSPATH=c:\classdir;.;c:\archives\archive.jar
    直到退出shell为止，类路径设置均有效。

4.9     文档注释
    由于文档注释与源代码在同一个文件中，在修改源代码的同时，重新运行javadoc就可以轻而易举地保持两者的一致性。

4.9.1   注释的插入
    javadoc实用程序（utility)从下面几个特性中抽取信息：
    •包
    •公有类与接口
    •公有的和受保护的构造器及方法
    •公有的和受保护的域

4.9.6   包与概述注释
    想产生包注释，就需要在每一个包目录中添加一个单独的文件。
    1)提供一个以package.html命名的HTML文件。在标记<body>—</body>之间的所有文本都会被抽取出来。
    2)提供一个以package-info.java命名的Java文件。这个文件必须包含一个初始的以/**和*/界定的Javadoc注释，跟随在一个包语句之后。它不应该包含更多的代码或注释。

4.9.7   注释的抽取
    2)如果是一个包，应该运行命令:
    javadoc-ddocDirectorynameOfPackage
    或对于多个包生成文档，运:
    javadoc-ddocDirectorynameOfPackage\nameOfPackage...
    如果文件在默认包中，就应该运行：
    javadoc-ddocDirectory*.java

4.10    类设计技巧
    1.一定要保证数据私有
    2.一定要对数据初始化
    3.不要在类中使用过多的基本类型
    4.不是所有的域都需要独立的域访问器和域更改器
    5.将职责过多的类进行分解
    6.类名和方法名要能够体现它们的职责
    习惯是访问器方法用小写get开头(getSalary),更改器方法用小写的set开头（setSalary)
    7.优先使用不可变的类


    第  五  章          继承

▲类、超类和子类          ▲Object：所有类的超类
▲泛型数组列表            ▲对象包装器与自动装箱
▲参数数量可变的方法      ▲枚举类
▲反射                   ▲继承的设计技巧

反射是指在程序运行期间发现更多的类及其属性的能力。

5.1 类、超类和子类
关键字extends表明正在构造的新类派生于一个已存在的类。已存在的类称为超类(superclass)、基类（baseclass)或父类（parentclass);新类称为子类（subclass)、派生类(derivedclass)或孩子类（childclass)。超类和子类是Java程序员最常用的两个术语，而了解其他语言的程序员可能更加偏爱使用父类和孩子类，这些都是继承时使用的术语。

5.1.2  覆盖方法
    在Java中使用关键字super调用超类的方法，而在C++中则采用超类名加上：：操作符的形式。

5.1.3   子类构造器
    关键字this有两个用途：一是引用隐式参数，二是调用该类其他的构造器，同样，super关键字也有两个用途：一是调用超类的方法，二是调用超类的构造器。在调用构造器的时候，这两个关键字的使用方式很相似。调用构造器的语句只能作为另一个构造器的第一条语句出现。构造参数既可以传递给本类（this)的其他构造器，也可以传递给超类（super)的构造器。
    一个对象变量（例如，变量e)可以指示多种实际类型的现象被称为多态
    在运行时能够自动地选择调用哪个方法的现象称为动态绑定

5.1.5   多态
    在Java中，子类数组的引用可以转换成超类数组的引用，而不需要采用强制类型转换。

4.1.6  理解方法调用
<<<<<<< HEAD
    每次调用方法都要进行搜索，时间开销相当大。因此，虚拟机预先为每个类创建了一个方法表（methodtable),其中列出了所有方法的签名和实际调用的方法。这样一来，在真正调用方法的时候，虚拟机仅查找这个表就行了。

    动态绑定有一个非常重要的特性：无需对现存的代码进行修改，就可以对程序进行扩展。假设增加一个新类Executive,并且变量e有可能引用这个类的对象，我们不需要对包含调用e.getSalary()的代码进行重新编译。如果e恰好引用一个Executive类的对象，就会自动地调用Executive.getSalaryO方法

    在覆盖一个方法的时候，子类方法不能低于超类方法的可见性。特别是，如果超类方法是public,子类方法一定要声明为public。经常会发生这类错误：在声明子类方法的时候，遗漏了public修饰符。此时，编译器将会把它解释为试图提供更严格的访问权限。

5.1.7   阻止继承： final类和方法
    不允许扩展的类被称为final类。如果在定义类的时候使用了final修饰符就表明这个类是final类。
    `
    public final class Executive extends Manager
    {
        ...
    }
    `
    类中的特定方法也可以被声明为final。如果这样做，子类就不能覆盖这个方法

    前面曾经说过，域也可以被声明为final。对于final域来说，构造对象之后就不允许改变它们的值了。不过，如果将一个类声明为final，只有其中的方法自动地成为final,而不包括域。


5.1.8    强制类型转换
    对象引用的转换语法与数值表达式的类型转换类似，仅需要用一对圆括号将目标类名括起来，并放置在需要转换的对象引用之前就可以了。
    进行类型转换的唯一原因是：在暂时忽视对象的实际类型之后，使用对象的全部功能。

    将一个值存人变量时，编译器将检查是否允许该操作。将一个了-类的引用赋给一个超类变量，编译器是允许的。但将一个超类的引用赋给一个子类变量，必须进行类型转换，这样才能够通过运行时的检査。

    在进行类型转换之前，先查看一下是否能够成功地转换。这个过程简单地使用instanceof操作符就可以实现。
    `
    if (staff[1] instanceof Manager)
    {
        do something ...
    }
    `
    在一般情况下，应该尽量少用类型转换和instanceof运算符。


5.1.9   抽象类
    抽象方法充当着占位的角色，它们的具体实现在子类中。扩展抽象类可以有两种选择。一种是在抽象类中定义部分抽象类方法或不定义抽象类方法，这样就必须将子类也标记为抽象类；另一种是定义全部的抽象方法，这样一来，子类就不是抽象的了。
    抽象类不能被实例化。也就是说，如果将一个类声明为abstract,就不能创建这个类的对象。

    在Java程序设计语言中，抽象方法是一个重要的概念。在接口（interface)中将会看到更多的抽象方法。

5.1.10  受保护访问
    在有些时候，人们希望超类中的某些方法允许被子类访问，或允许子类的方法访问超类的某个域。为此，需要将这些方法或域声明为protected。

    受保护的方法更具有实际意义。如果需要限制某个方法的使用，就可以将它声明为protected。这表明子类（可能很熟悉祖先类）得到信任，可以正确地使用这个方法，而其他类则不行。

    归纳一下Java用于控制可见性的4个访问修饰符：
    1)仅对本类可见private。
    2)对所有类可见public。
    3)对本包和所有子类可见protected。
    4)对本包可见——默认（很遗憾)，不需要修饰符。

5.2     Object: 所有类的超类
    
5.2.2   相等测试与继承
    Java语言规范要求equals方法具有下面的特性：
    1)自反性：对于任何非空引用x,x.equals(x)应该返回true。
    2)对称性:对于任何引用x和y,当且仅当y.equals(x)返回true,x.equals(y)也应该返回true。
    3)传递性：对于任何引用x、y和z,如果x.equals(y)返回true，y.equals(z)返回true,x.equals(z)也应该返回true。
    4)一致性：如果x和y引用的对象没有发生变化，反复调用x.equals(y)应该返回同样的结果。
    5)对于任意非空引用x,x.equals(null)应该返回false。
    在雇员和经理的例子中，只要对应的域相等，就认为两个对象相等。如果两个Manager对象所对应的姓名、薪水和雇佣日期均相等，而奖金不相等，就认为它们是不相同的，因此，可以使用getClass检测。但是，假设使用雇员的ID作为相等的检测标准，并且这个相等的概念适用于所有的子类，就可以使用instanceof进行检测，并应该将Employee.equals声明为final。

    1)显式参数命名为otherObject,稍后需要将它转换成另一个叫做other的变量。
    2)检测this与otherObject是否引用同一个对象：if(this=otherObject)returntrue;这条语句只是一个优化。实际上，这是一种经常采用的形式。因为计算这个等式要比一个一个地比较类中的域所付出的代价小得多。
    3)检测otherObject是否为null,如果为null,返回false。这项检测是很必要的。if(otherObject=null)returnfalse;
    4)比较this与otherObject是否属于同一个类。如果equals的语义在每个子类中有所改变，就使用getClass检测：if(getClass()!=otherObject.getCIassO)returnfalse;如果所有的子类都拥有统一的语义，就使用instanceof检测：if(!(otherObjectinstanceofClassName))returnfalse;
    5)将otherObject转换为相应的类类型变量：ClassNameother=(ClassName)otherObject
    6)现在开始对所有需要比较的域进行比较了。使用=比较基本类型域，使用equals比较对象域。如果所有的域都匹配，就返回true;否则返回false。returnfieldl==other.field&&Objects.equa1s(fie1d2,other.field2)如果在子类中重新定义equals,就要在其中包含调用super.equals(other)。
<<<<<<< HEAD

5.2.3   hashCode 方法
    散列码（hashcode)是由对象导出的一个整型值。

5.2.4   toString方法
    用于返回表示对象值的字符串
    在调用x.toString()的地方可以用""+x替代。这条语句将一个空串与x的字符串表示相连接。这里的x就是x.toString()。与toString不同的是，如果x是基本类型，这条语句照样能够执行。
    System.out.println(x);
    println方法就会直接地调用x.toString()，井打印输出得到的字符串。
    修正的方式是调用静态方法Arrays.toString。
    代码：Strings=Arrays.toString(luckyNumbers);
    将生成字符串“[2,3,5,7，11，13]”。
    要想打印多维数组（即，数组的数组）则需要调用Arrays.deepToString方法。
    强烈建议为自定义的每一个类增加toString方法。这样做不仅自己受益，而且所有使用这个类的程序员也会从这个日志记录支持中受益匪浅。
    [详细解释== 和 equal 的区别连接](https://www.cnblogs.com/pop822/p/6215040.html) 详细解释== 和 equal 的区别
     
    == 比较地址  equal 比价内容

5.3    泛型数组列表
    ArrayList<Employee> staff = new ArrayListoQ；
    这被称为“菱形”语法，因为空尖括号o就像是一个菱形。

    数组列表的容量与数组的大小有一个非常重要的区别。如果为数组分配100个元素的存储空间，数组就有100个空位置可以使用。而容量为100个元素的数组列表只是拥有保存100个元素的潜力（实际上，重新分配空间的话，将会超过丨00),但是在最初，甚至完成初始化构造之后，数组列表根本就不含有任何元素。

    staff,size() 将返回staff数组列表的当前元素数量.

    一旦能够确认数组列表的大小不再发生变化，就可以调用trimToSize方法。这个方法将存储区域的大小调整为当前元素数量所需要的存储空间数目。垃圾回收器将回收多余的存储空间。

5.3.1   访问数组列表元素
    使用add方法为数组添加新元素，而不要使用set方法，它只能替换数组中已经存在的元素内容。
    Employeee=staff.get(i);


5.3.2   类型化与原始数组列表的兼容性
    一旦能确保不会造成严重的后果，可以用@SuppressWamings("unchecked")标注来标记这个变量能够接受类型转换，如下所示：@SuppressWarnings("unchecked")

```java
ArrayList<Employee>result = (ArrayList<Employee>)employeeDB.find(query);//yieldsanotherwarning
```

5.4     对象包装器与自动装箱
    常，这些类称为包装器（wrapper）。这些对象包装器类拥有很明显的名字：Integer、Long、Float、Double、Short、Byte、Character、Void和Boolean（前6个类派生于公共的超类Number）。对象包装器类是不可变的，即一旦构造了包装器，就不允许更改包装在其中的值。同时，对象包装器类还是final，因此不能定义它们的子类
    由于每个值分别包装在对象中，所以ArrayList<lnteger>的效率远远低于int[]数组。因此，应该用它构造小型集合，其原因是此时程序员操作的方便性要比执行效率更加重要。
    添加int类型的元素到ArrayList<lnteger>中。下面这个调用list.add(3);
    将自动地变换成
    list.add(Integer.value0f(3));
    这种变换被称为自动装箱（autoboxing)。
    最后强调一下，装箱和拆箱是编译器认可的，而不是虚拟机。编译器在生成类的字节码时，插人必要的方法调用。虚拟机只是执行这些字节码。

5.5    参数数量可变的方法
    publicclassPrintStream
    {
        publicPrintStreamprintf(Stringfmt,Object...args){returnformat(fmt,args);}
    }这里的省略号...是Java代码的一部分，它表明这个方法可以接收任意数量的对象（除fmt参数之外)。

5.6     枚举类
        [枚举类详解地址](https://blog.csdn.net/javazejian/article/details/71333103)
5.7     反射
    反射库（reflectionlibrary)提供了一个非常丰富且精心设计的工具集，以便编写能够动态操纵Java代码的程序。特别是在设计或运行中添加新类时，能够快速地应用开发工具动态地查询新添加类的能力。
    能够分析类能力的程序称为反射（reflective)。
        *在运行时分析类的能力。
        •在运行时查看对象，例如，编写一个toString方法供所有类使用。
        •实现通用的数组操作代码。
        •利用Method对象，这个对象很像中的函数指针。

5.7.1   class类
    在程序运行期间，Java运行时系统始终为所有的对象维护一个被称为运行时的类型标识。这个信息跟踪着每个对象所属的类。虚拟机利用运行时类型信息选择相应的方法执行。
    Class类实际上是一个泛型类。例如，Employee.class的类型是Class<Employee>。没有说明这个问题的原因是：它将已经抽象的概念更加复杂化了。在大多数实际问题中，可以忽略类型参数，而使用原始的Class类。
<<<<<<< HEAD
    虚拟机为每个类型管理一个Class对象。因此，可以利用=运算符实现两个类对象比较的操作
    将forName与newlnstance配合起来使用，可以根据存储在字符串中的类名创建一个对象

```java
Strings="java.util.Random";
Objectm=Class.forName(s).newlnstance();
```

### 5.7.2    捕获异常

抛出异常比终止程序要灵活得多，这是因为可以提供一个“捕获”异常的处理器（handler)对异常情况进行处理。
异常有两种类型：未检查异常和已检查异常。

### 5.7.3   利用反射分析类能力

在java.lang.reflect包中有三个类Field、Method和Constructor分别用于描述类的域、方法和构造器。
Class类中的getFields、getMethods和getConstructors方 法 将 分 别 返 回 类 提 供 的public域、方法和构造器数组，其中包括超类的公有成员。Class类的getDeclareFields、getDeclareMethods和getDeclaredConstructors方法将分别返回类中声明的全部域、方法和构造器，其中包括私有和受保护成员，但不包括超类的成员。

### 5.7.4   在运行时使用反射分析对象

    反射机制的默认行为受限于Java的访问控制。反射可以查看修改该对象的内部参数，详情查看
[实例文件](./objectAnalyzer/objectAnalyzerTest.java)

### 5.7.5   使用反射编写泛型数组代码

    java.lang.reflect包中的Array类允许动态地创建数组。
[实例](arrays/CopyofTest.java)


### 5.7.6   调用任意方法

    JAVA提供接口来解决，反射机制允许用任意方法。
[实例](methods/MethodTableTest.java)

### 5.8     继承的设计技巧

    1.将公共操作和域放在超类
    2.不要使用受保护的域 
    第一，子类集合是无限制的，任何一个人都能够由某个类派生一个子类，并编写代码以直接访问protected的实例域，从而破坏了封装性。第二，在Java程序设计语言中，在同一个包中的所有类都可以访问proteced域，而不管它是否为这个类的子类。不过，protected方法对于指示那些不提供一般用途而应在子类中重新定义的方法很有用。
    3.使用继承实现“is-a”关系
    4.除非所有继承的方法都有意义，否则不要使用继承
    5.在覆盖方法时，不要改变预期的行为
    6.使用多态，而非类型信息
    7.不要过多地使用反射
    多态的三个特点：继承
    重写
    父类引用指向子类对象

## 第六章  接口、lambda表达式与内部类

### 6.1.1 接口概念

    类实现接口的两个步骤
    1.将类声明为实现给定的接口。
     使用关键子implements(工具、器具、用具)   

```java
class Employee implements Comparable
```

    2.对接口中的所有方法进行定义。

    ✨在实现接口时，必须把方法声明为public；
    否则，编译器将认为这个方法的访问属性是包可见性，即类的默认访问属性，
    之后编译器就会给出试图提供更严格的访问权限的警告信息。

### 6.1.2接口的特性

    不能构造接口的对象，却能声明接口的变量
    接口变量必须引用实现了接口的类对象
```java
Comoarable x; //声明接口的变量
x = new Employee(...);  //口变量必须引用实现了接口的类对象
if (anObject instanceof Comparable) {...}
//可以使用instance检查一个对象是否实现了某个特定的接口

//接口也可以被扩展。这里允许存在多条从具有较高通用性的接口到较高专用性的接口的链.
public interface Moveable
{
    void move(double x, double y);
}
//扩展为Powered的接口
public interface Powered extends Moveable
{
    double milesPerGallon(); 
    //在接口中不能包含实例域或静态方法，但却可以包含常量
    //接口中的域将被自动设为public static final
}
```

### 6.1.3 接口与抽象类

    使用抽象类表示通用属性存在这样一个问题：每个类只能扩展于一个类，有些程序设计语言允许一个类有多个超类，例如C++。我们将此特性称为多重继承，va的设计者选择了不支持多继承，其主要原因是多继承会让语言本身变得非常复杂（如同C++），效率也会降低

### 6.1.4 静态方法

    在Java SE 8中，允许在接口中增加静态方法。

### 6.1.5 默认方法

    必须用default修饰符标记这样一个方法。这些默认方法什么也不做。个接口的程序员只需要为他们真正关心的事件覆盖相应的监听器。

### 6.1.6 解决默认方法冲突

    1）超类优先。如果超类提供了一个具体方法，同名而且有相同参数类型的默认方法会被忽略
    2）接口冲突。如果一个超接口提供了一个默认方法，另一个接口提供了一个同名而且参数类型（不论是否是默认参数）相同的方法，必须覆盖这个方法来解决冲突。

[extends和implements区别](https://blog.csdn.net/qq_15037231/article/details/82813140)

### 6.2.1 接口与回调

    回调（callback）是一种常见的程序设计模式。在这种模式中，可以指出某个特定事件发生时应该采取的动作.
[实例](timer/TimerTest.java)

### 6.2.2 Comparator接口

### 6.2.3 对象克隆
    
    clone方法是Object的一个protected方法，这说明你的代码不能直接调用这个方法.只有Employee类可以克隆Employee对象.
    对于每一个类，需要确定：
        1）默认的clone方法是否满足要求；
        2）是否可以在可变的子对象上调用clone来修补默认的clone方法；
        3）是否不该使用clone。
    实际上第3个选项是默认选项。如果选择第1项或第2项，类必须：
        1）实现Cloneable接口；
        2）重新定义clone方法，并指定public访问修饰符。

<font color=red>
Object类中clone方法声明为protected，所以你的代码不能直接调用anObject.clone（）

子类只能调用受保护的clone方法来克隆它自己的对象。必须重新定义clone为public才能允许所有方法克隆对象。

Cloneable接口的出现与接口的正常使用并没有关系。具体来说，它没有指定clone方法，这个方法是从Object类继承的。这个接口只是作为一个标记，指示类设计者了解克隆过程。对象对于克隆很“偏执”，如果一个对象请求克隆，但没有实现这个接口，就会生成一个受查异常。

所有数组类型都有一个public的clone方法，而不是protected。可以用这个方法建立一个新数组，包含原数组所有元素的副本。
</font>
[实例](clone/CloneTest.java)


### 6.3 lambda表达式

    lambda表达式是一个可传递的代码块，可以在以后执行一次或多次。
    
### 6.3.2 lambda表达式的语法

    无需指定lambda表达式的返回类型。lambda表达式的返回类型总是会由上下文推导得出。

### 6.3.3 函数式接口

    对于只有一个抽象方法的接口，需要这种接口的对象时，就可以提供一个lambda表达式。这种接口称为函数式接口（functional interface）。

    不能把lambda表达式赋给类型为Object的变量，Object不是一个函数式接口
[函数式接口](https://blog.csdn.net/fdlhei/article/details/100007966)。

### 6.3.4 方法引用

```java
    Time t = new Timer(1000, event -> System.out.printIn(event));
    //等价于 🔽
    Time t = new Timer(1000, System.out::printIn);
    //System.out::printIn == x->System.out.println（x）
    //要用：：操作符分隔方法名与对象或类名
    
    //第二种情况，方法引用等价于提供方法参数的lambda表达式
    //Math：：pow等价于（x，y）->Math.pow（x，y）。

    //第3种情况，第1个参数会成为方法的目标
    //String：：compareToIgnoreCase等同于（x，y）->x.compareToIgnoreCase（y）

    //可以在方法引用中使用this参数。例如，this：：equals等同于x->this.equals（x）。使用super也是合法的。下面的方法表达式
```

### 6.3.5 构造器引用

    构造器引用与方法引用很类似，只不过方法名为new。例如，Person：：new是Person构造器的一个引用。

    可以用数组类型建立构造器引用。例如，int[]：：new是一个构造器引用，它有一个参数：即数组的长度。这等价于lambda表达式x->new int[x]。

    Java有一个限制，无法构造泛型类型T的数组。

### 6.3.6 变量作用域

    固我们对lambda表达式的理解。lambda表达式有3个部分：
    1）一个代码块；
    2）参数；
    3）自由变量的值，这是指非参数而且不在代码中定义的变量。
    关于代码块以及自由变量值有一个术语：闭包（closure）。在Java中，lambda表达式就是闭包。

    lambda表达式可以捕获外围作用域中变量的值。在Java中，要确保所捕获的值是明确定义的，这里有一个重要的限制。

    这里有一条规则：lambda表达式中捕获的变量必须实际上是最终变量，上的最终变量是指，这个变量初始化之后就不会再为它赋新值。
    
    在lambda表达式中声明与一个局部变量同名的参数或局部变量是不合法的。
    lambda表达式的作用域嵌套在init方法中

### 6.3.7 处理lambda表达式

    使用lambda表达式的重点是延迟执行（deferred execution）
    如果设计你自己的接口，其中只有一个抽象方法，可以用@FunctionalInterface注解来标记这个接口。这样做有两个优点。如果你无意中增加了另一个非抽象方法，编译器会产生一个错误消息。另外javadoc页里会指出你的接口是一个函数式接口。

    根据定义，任何有一个抽象方法的接口都是函数式接口

### 在谈Comparator

    Comparator接口包含很多方便的静态方法来创建比较器。这些方法可以用于lambda表达式或方法引用。

     