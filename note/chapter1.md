#<center> 第一章 线程管理
## 1.1 简介
进程 Process  
线程 Thread  
并发  
并行  
## 1.2 线程的创建和运行
Java提供了两种方式来创建线程：  
1. 继承Thread类，并且覆盖run()方法  
2. 创建一个实现Runnable接口的类。使用带参数的Thread构造器来创建Thread对象。这个参数就是实现Runnable接口的类的一个对象  
Java中有两类线程：User Thread（用户线程）、Daemon Thread（守护线程）
任何一个守护线程都是整个JVM中所有非守护线程的保姆
守护线程：为其他线程的运行提供便利服务，守护线程最典型的应用就是GC（垃圾回收器）  
只要当前JVM实例中尚存在任何一个非守护线程没有结束，守护线程就全部工作；只有当最后一个非守护线程结束时，守护线程随着JVM一同结束工作  
守护线程并非只有虚拟机内部提供，用户在编写程序时也可以设置守护线程  
```Thread daemonThread = new Thread(); daemonThread.setDaemon(true);```  
## 1.3 线程信息的获取和设置
ID、Name、Priority、Status  
Status:  
1. NEW : Thread state for a thread which has not yet started.  
2. RUNNABLE : Thread state for a runnable thread.  A thread in the runnable state is executing in the Java virtual machine but it may be waiting for other resources from the operating system such as processor.  
3. BLOCKED : Thread state for a thread blocked waiting for a monitor lock.A thread in the blocked state is waiting for a monitor lock to enter a synchronized block/method or reenter a synchronized block/method after calling  
4. WAITING : Thread state for a waiting thread with a specified   waiting time.  
5. TIMED_WAITING  
6. TERMINATED : Thread state for a terminated thread.The thread has completed execution.  
## 1.4 线程的中断
## 1.5 线程中断的控制
