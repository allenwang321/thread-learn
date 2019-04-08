##### TryConcurrency
尝试同时运行两个方法，一个代表听音乐一个代表看新闻，但是并没有实现最初的想法

![](https://ws4.sinaimg.cn/large/006tKfTcgy1g14m0o1kqzj316g0aowfk.jpg)

##### TryConcurrencyUpdate
借助Thread实现以上的想法，一边听音乐一般看新闻

![](https://ws1.sinaimg.cn/large/006tKfTcgy1g14m1tnmzij321i0bqjt0.jpg)

> TryConcurrencyUpdate类中线程启动必须要在其中一个任务之前，否则线程将永远不会启动，因为前一个任务永远不会结束

1. 创建一个新的线程，并且重写了它的run方法，将看新闻交给它执行。
2. 启动新的线程只有调用了Thread的start方法，才代表派生了一个新的线程否则Thread和其他的没有区别，start方法是立即返回方法，并不会让程序陷入阻塞

#### 模板模式

> 通过方法覆盖实现