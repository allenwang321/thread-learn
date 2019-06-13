#### wait

- wait方法的三个重载方法都将调用wait(long timeout)这个方法。
- Object的wait()方法会导致当前线程进入阻塞，直到有其他线程调用了Object的notify或者notifyAll方法才会将其唤醒，或者阻塞时间到了timeout时间而自动唤醒。
- wait方法必须拥有该对象的monitor，也就是wait方法必须在同步方法中使用。
- 当前线程执行了该对象的wait方法之后，将会放弃对该对象monitor的所有权并且进入与该对象关联的wait set中，也就是说一旦线程执行了某个object的wait方法之后，他就会释放该对象的monitor的所有权，其他线程也会有机会继续争抢该monitor的所有权。

#### notify

- 唤醒单个正在执行该对象的wait方法的线程。
- 如果有某个线程由于执行该对象的wait方法而进入阻塞则会唤醒，如果没有则会忽略。
- 被唤醒的线程需要重新获取对该对象所关联的monitor的lock才能继续执行。

#### wait与notify

- wait方法是可中断的，这也就意味着，当前线程一旦调用了wait方法进入阻塞状态，其他线程是可以使用interrupt方法将其打断；可中断方法被打断之后会收到中断异常InterruptedException，同时interrupt标识也会被擦除。
- 线程执行了某个对象的wait方法之后，会加入与之对应的wait set中，每一个对象的monitor都有一个与之关联的wait set。
- 当线程进入wait set之后，notify方法可以将其唤醒，也就是从wait set中弹出，同时中断wait中的线程也会将其唤醒。
- 必须在同步方法中使用wait和notify方法，因为执行wait和notify的前提条件是必须持有同步方法的monitor的所有权。
- 同步代码的monitor必须与执行wait notify方法的对象一致，简单的说就是用哪个对象的monitor进行同步，就只能用哪个对象进行wait和notify操作。