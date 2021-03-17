**Stage0 - Java EE Standard Architecture（Java EE 标准架构）**

------

### 概念

##### JSR

JSR（Java Specification Requests - Java 规范提案）指向 JCP（Java Community Process）提出新增一个标准化技术规范的正式请求。任何人都可以提交 JSR以向Java平台增添新的API和服务。JSR已成为Java界的一个重要标准。简单的说，jsr是java开发者以及授权者指定的标准，而java开发者以及授权者形成一个jcp国际组织，其职能是指定java标准。

##### Servlet

> 官方API文档解释为**Serv**er App**let**（服务端小程序），Servlet通常通过HTTP（超文本传输协议）接收和响应来自Web客户端的请求。

个人觉得官方释义并不准确，应该理解为处理请求的业务逻辑。通过**Web服务器**（将某个主机上的资源映射为一个URL供外界访问）访问资源必须经过三个过程，接收请求、处理请求、响应请求。其中接收请求和响应请求是共性功能，且没有差异性，所以就把这两个步骤抽取成Web服务器；但处理请求的逻辑是不同的，因此抽取出来做成Servlet，交给程序员自己编写。

tomcat = web服务器 + Servlet容器

##### Java SPI

> SPI全称Service Provider Interface，是Java提供的一套用来被第三方实现或者扩展的API，它可以用来启用框架扩展和替换组件

##### [Java JNDI](https://docs.oracle.com/javase/tutorial/jndi/)

> JNDI（Java Naming and Directory InterfaceTM）-- 依赖查找的一种工具
>
> **Naming**：命名服务是一种查找具有给定名称的对象的方法，主要功能是将用户友好的名称映射到对象，例如， Internet域名系统（DNS） 将计算机名称（例如www.sun.com）映射到IP地址（例如192.9.48.5）
>
> **Directory**：目录服务扩展了许多命名服务。目录服务将名称与对象相关联，并且还允许此类对象具有属性。因此，您不仅可以按对象名称查找对象，还可以获取对象的属性或根据其属性搜索对象。
>
> JNDI体系结构的三个主要组件： 命名模型， 目录模型和 服务提供者模型。
>
> ![img](https://github.com/qxf-Carl/Evo/blob/main/resource/jndiarch.jpg)

##### JDBC

> JDBC就是一种持久化机制。文件IO也是一种持久化机制。

##### JPA

> JPA（Java Persistence API的简称，中文名 Java持久层API）
> JPA 是Java EE 5.0平台标准的ORM规范（或持久化规范），使得应用程序以统一的方式访问持久层

**主要特性**

- **标准化**：JPA 是 JCP 组织发布的 Java EE 标准之一，因此任何声称符合 JPA 标准的框架都遵循同样的架构，提供相同的访问API，这保证了基于JPA开发的企业应用能够经过少量的修改就能够在不同的JPA框架下运行
- **容器级特性的支持**：JPA框架中支持大数据集、事务、并发等容器级事务，这使得 JPA 超越了简单持久化框架的局限，在企业应用发挥更大的作用
- **简单方便**：JPA的主要目标之一就是提供更加简单的编程模型：在JPA框架下创建实体和创建Java 类一样简单，没有任何的约束和限制，只需要使用 javax.persistence.Entity进行注释，JPA的框架和接口也都非常简单，没有太多特别的规则和设计模式的要求，开发者可以很容易地掌握。JPA基于非侵入式原则设计，因此可以很容易地和其它框架或者容器集成。
- **查询能力**：JPA的查询语言是面向对象而非面向数据库的，它以面向对象的自然语法构造查询语句，可以看成是Hibernate HQL的等价物。JPA定义了独特的JPQL（Java Persistence Query Language），JPQL是EJB QL的一种扩展，它是针对实体的一种查询语言，操作对象是实体，而不是关系数据库的表，而且能够支持批量更新和修改、JOIN、GROUP BY、HAVING 等通常只有 SQL 才能够提供的高级查询特性，甚至还能够支持子查询。
- JPA 中能够支持面向对象的高级特性，如类之间的继承、多态和类之间的复杂关系，这样的支持能够让开发者最大限度的使用面向对象的模型设计企业应用，而不需要自行处理这些特性在关系数据库的持久化。

##### Spring Data

> Spring Data是Spring 社区的一个子项目，主要用于简化数据（关系型&非关系型）访问，其主要目标是使得数据库的访问变得方便快捷，提供了很多模板操作（如 Spring Data Redis等），其中就包含了Spring Data JPA

##### Spring Data JPA

> Spring Data JPA 是一个JPA数据访问抽象。也就是说Spring Data JPA不是一个实现或JPA提供的程序，它只是一个抽象层，主要用于减少为各种持久层存储实现数据访问层所需的样板代码量。但是它还是需要JPA提供实现程序，其实Spring Data JPA底层依赖 Hibernate实现。
>
> Spring Data JPA是在实现了JPA规范的基础上封装的一套 JPA 应用框架，虽然ORM框架都实现了JPA规范，但是在不同的ORM框架之间切换仍然需要编写不同的代码，而使用Spring Data JPA能够方便在不同的ORM框架之间进行切换而不需要更改代码。Spring Data JPA旨在通过将统一ORM框架的访问持久层的操作，来提高开发人的效率。

##### Hibernate

> Hibernate是JPA的一种实现



### 实用类库

##### java.beans Package 

> 









### Reference

[Java 的 JSR 规范](https://www.cnblogs.com/mintsd/p/14339998.html)

[servlet的本质是什么，它是如何工作的](https://www.zhihu.com/question/21416727/answer/690289895)

[Java Servlet技术概述](https://www.oracle.com/java/technologies/servlet-technology.html)

[Servlet API](https://docs.oracle.com/javaee/7/api/javax/servlet/Servlet.html)

[Overview of JNDI](https://docs.oracle.com/javase/tutorial/jndi/overview/index.html)

[JNDI教程在线版](https://docs.oracle.com/javase/jndi/tutorial/)

[JDK 之 Java Bean 内省机制](https://www.cnblogs.com/binarylei/p/10211667.html)