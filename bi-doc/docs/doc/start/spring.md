---
title: 怎么样启动项目
---
# 怎么让项目跑起来???

## 默认账户
 - 账号：sober1050@qq.com
 - 密码：sober1050

首先先下载Nacos 2.1.1 
这里浅浅放上一个下载地址 - [nacos](https://github.com/alibaba/nacos/releases)
```  
     *  解压后   
     *  Linux/Unix/Mac
     *  启动命令(standalone代表着单机模式运行，非集群模式):
     *  sh startup.sh -m standalone
     *  如果您使用的是ubuntu系统，或者运行脚本报错提示[[符号找不到，可尝试如下运行：
     *  bash startup.sh -m standalone
     *  Windows
     *  启动命令(standalone代表着单机模式运行，非集群模式):
     *  startup.cmd -m standalone
```
运行成功后看到以下
<img src="/img/nacos.png" alt="img" />
接下来将 doc/yaml/下所有yaml复制到 nacos 或者打成压缩包导入
<img src="/img/nacosp.png" alt="img" />
```
然后就是在MySQL下执行 /doc/db/init.sql
接下来就是修改各个服务的
namespace===>nacos的
```
<img src="/img/namespace.png" alt="img" />

```
右侧这一段长的像UUID的东西
server-addr====>服务器地址 默认端口8848
接下来就启动所有服务
访问网关文档聚合地址 http://127.0.0.1:8607/doc.html 即可愉快的玩耍了
```
## 限流配置

可以通过nacos  网关配置  默认不写配置的情况 即 每秒100次qps
```yaml
smart:
 sentinel:
  限流数量
  count: 100
  间隔时间
  intervalSec: 1
```
详细配置可在GatewayConfiguration 配置

熔断默认就一种 直接看yaml配置超时时间即可  timeoutInMilliseconds

hystrix 信号量隔离，3秒后自动超时
```yaml
hystrix:
  enabled: true
  shareSecurityContext: true
  command:
    default:
      execution:
        isolation:
          strategy: SEMAPHORE
          thread:
            timeoutInMilliseconds: 3000
```