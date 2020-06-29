### Spring 事务传播属性练习
````
    参考 https://mp.weixin.qq.com/s/Ta5GQYj2KtFIRDYLo4xAFg
````

#### 传播属性

    | 传播性 | 值 | 描述 |
    |--------- |---: | :-------------------:|     
    | REQUIRED | 0 | 支持当前事务,没有就新建事务 |
    | SUPPORTS | 1 | 支持当前事务,如果没有就不以事务的方式运行 |
    | MANDATORY | 2 | 支持当前事务,如果没有事务就抛异常 |
    | REQUIRES_NEW | 3 | 无论当前是否有事务,都会新起一个事务 |
    | NOT_SUPPORTED | 4 | 不支持事务,如果当前存在事务,就将此事务挂起不以事务方式运行 |
    | NEVER | 5 | 不支持事务,如果当前存在事务,就抛出异常 |
    | NESTED | 6 | 如果当前存在事务,在当前事务中再新起一个嵌套事务 |

#### 项目git地址
````
    https://github.com/modouxiansheng/Doraemon
    https://github.com/YunaiV/SpringBoot-Labs
````  

#### h2的安装
````
    参考 https://www.jianshu.com/p/c959666cd8dd
````
