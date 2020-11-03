### reproduce steps  
1. Run `main` method of `Provider` in `dubbo-provider` module.    
2. Run `main` method of `Consumer` in `dubbo-consumer` module.  
3. View memory cost by memory analyzed tool.    
The command I used
1. find pid, `jps|grep "Consumer"` 
result:`16238 Consumer`
pid is 16238  
2. run GC manually.  `jcmd 16238 GC.run`  
3. view class histogram  `jcmd 16238 GC.class_histogram`  
```
 num     #instances         #bytes  class name
----------------------------------------------
   1:          1616     1510006176  [I
   2:         17732        1398664  [C
   3:          1642         944136  [B
   4:          4543         526712  [Ljava.lang.Object;
   5:          4462         500616  java.lang.Class
   6:         17696         424704  java.lang.String

```
the `int[]` occupy much memory.  
4. uncomment 25th line in `Consumer.java`, `InternalThreadLocal.removeAll()`, memory cost will be normal.  
