### HomeWork

#### Week01

- [x] 通过自研 Web MVC 框架实现（可以自己实现）一个用户注册，forward 到一个成功的页面（JSP 用法）/register
- [x] 通过 Controller -> Service -> Repository 实现（数据库实现）
- [ ] （非必须）JNDI 的方式获取数据库源（DataSource），在获取 Connection

#### Week02

- [x] 通过课堂上的简易版依赖注入和依赖查找，实现用户注册功能
- [x] 通过 UserService 实现用户注册注册用户需要校验
  - Id：必须大于 0 的整数
  - 密码：6-32 位 
  - 电话号码: 采用中国大陆方式（11 位校验）

#### Week03

**需求一（必须）**

- [x] 整合 [jolokia](https://jolokia.org/) 实现一个自定义 JMX MBean，通过 Jolokia 做 Servlet 代理

**需求二（选做）** 

- [ ] 继续完成 Microprofile config API 中的实现
  - 扩展 org.eclipse.microprofile.config.spi.ConfigSource 实现，包括 OS 环境变量，以及本地配置文件
  - 扩展 org.eclipse.microprofile.config.spi.Converter 实现，提供 String 类型到简单类型
- [ ] 通过 org.eclipse.microprofile.config.Config 读取当前应用名称,应用名称 property name = “application.name”

##### 需求一验证

（1） `git checkout homework-week03`

（2）访问 URL `http://127.0.0.1:8080/jolokia/read/org.geektimes.projects.user.management:type=User`

（3） 期望结果

```json
{"request":{"mbean":"org.geektimes.projects.user.management:type=User","type":"read"},"value":{"Email":"mercyblitz@gmail.com","User":{"password":"******","phoneNumber":"abcdefg","name":"小马哥","id":null,"email":"mercyblitz@gmail.com"},"PhoneNumber":"abcdefg","Id":null,"Name":"小马哥","Password":"******"},"timestamp":1615992674,"status":200}
```

（4）通过 jconsole 修改 MBean 属性Name为'瞿晓峰'，执行步骤（1）得到期望结果

```json
{"request":{"mbean":"org.geektimes.projects.user.management:type=User","type":"read"},"value":{"Email":"mercyblitz@gmail.com","User":{"password":"******","phoneNumber":"abcdefg","name":"瞿晓峰","id":null,"email":"mercyblitz@gmail.com"},"PhoneNumber":"abcdefg","Id":null,"Name":"瞿晓峰","Password":"******"},"timestamp":1615995343,"status":200}
```

