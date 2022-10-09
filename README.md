# 介绍

#### dubbo-service 完全rpc了，调用dubbo-interface都是通过rpc来实现的

#### dubbo-service2 未完成rpc，有可能依赖dubbo-service的service服务，所以可能会有service里面带了dubbo-service2的rpc服务，比如UserServiceImpl依赖了TestServiceImpl，TestServiceImpl有依赖本项目的rpc的UserFacade

# https://github.com/apache/dubbo/issues/6776 复现

## 复现版本

#### 1. dubbo版本高于等于2.7.8即可，目前2.7.15（这个bug是由于在2.7.8以后版本“org.apache.dubbo.config.spring.beans.factory.annotation.ReferenceAnnotationBeanPostProcessor.doGetInjectedBean”方法中添加了“prepareReferenceBean(referencedBeanName, referenceBean, localServiceBean);”导致的循环引用问题）

#### 2. 已经测试 2.7.15 以及3.1.1版本

## 启动顺序

#### 1. 分支使用 名称为"循环引用复现" 的commit点

#### 2. 启动dubbo-service2即可报错

## 解决办法

#### 就是只能有循环依赖的rpc消费者添加 @Reference(injvm = false) 可以解决(比如这个里面的TestServiceImpl的UserFacade上面)，但是会带来第二个bug。。https://github.com/apache/dubbo/issues/10570

# https://github.com/apache/dubbo/issues/10570 复现

## 复现版本

#### 1. dubbo版本使用 2.7.4.1 3.1.1 出现问题，今天测试2.7.15 好像没问题。。之前测试肯定是有问题的，可能之前的项目复杂点，今天项目简单点

#### 2. naocs版本 2.1.1

## 启动顺序

#### 1. 启动 dubbo-service （生产者 TestFacade）

#### 2. 启动 dubbo-service2 （消费者 UserController里面消费了 TestFacade 2种写法）

#### 3. 关闭 dubbo-service （生产者 TestFacade）

#### 4. 这个时候观察 dubbo-service2 有ReconnectTimerTask的错误，1分钟一次