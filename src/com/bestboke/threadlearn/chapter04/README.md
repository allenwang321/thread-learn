### synchronized关键字

`synchronized`关键字可以实现一个简单的策略来防止线程干扰和内存一致性错误，如果一个对象是对多个线程可见的，那么该对象的所有读或者写都将通过同步的方式来进行。  

- `synchronized`关键字提供了一种锁的机制，能够确保共享变量的互斥访问，从而防止数据不一致问题出现。
- `synchronized`关键字包括monitor enter和monitor exit两个JVM指令，它能够保证在任何时候任何线程执行到monitor enter成功之前都必须从主内存中获取数据，而不是缓存中，在monitor exit运行成功之后，共享变量被更新后的值必须刷入到主内存中。
- `synchronized`的指令严格遵守java happens-before规则，一个monitor exit指令之前必须要有一个monitor enter。
