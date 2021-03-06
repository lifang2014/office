/**
 * Created by Administrator on 2014/11/25.
 */
package com.common.design.decorator;

/*
    设计原则:
        1、多用组合,少用继承。(利用继承设计子类的行为，是在编译时静态决定的,而所有子类都会继承相同的行为属性,
        而如果使用组合,就可以扩展对象的行为,就可以在运行时动态的进行扩展.)
        2、类应该对扩展开放,对修改关闭.
    装饰模式：
        1、动态给对象添加一些额外的职责.

    重点:
        1、装饰者和被装饰者都必须有相同的基类
        2、

    用例说明:
        1.有存储在数据库中的新闻
        2.有存储在XML文件中的新闻(一般都是推荐新闻,内容比较少)
        在没有接触设计模式时,都是针对具体实现编程,读取数据库新闻时直接写一个基于数据库的方法,
    读取推荐新闻时再写一个基于XML的方法,两种方法之间没有任何的关系.当时觉的这样实现也没什么不好。
    可是你总会发现这两种方法在实现上有很多相同的地方,都是读取出一个新闻标题集合来绑定数据源,只是取数据源的方法不同而已。
    为了方便管理,我们可以定义一个统一的接口来约束这两种方法。这种做法也足够满足读取不同载体的新闻要求。
    可是如果在读取新闻时要做其它的操作呢?例如:给读取出来的新闻的人气加一。
    这个时候我们就要修改原程序,这样有背于"对扩展开放,对修改关闭"的编程原则。
    如何解决呢?这就是装饰者模式出场的时候了。

 */