---
title: 看看版本
---

# 版本历史

## 1.0.0

- 实时接口转发
- 数据库查询直接输出接口
- 数据拦截
- 数据落库 表不存在自动匹配类型创建表
- 静态接口 (对应大屏业务的比如标题等)
- 缓存机制(第三方token缓存)
- 支持多角色第三方token模式
- 文档聚合
- 限流,熔断策略
- 数据融合(目前支持数据合并 根据主键合并,数组合并(以最小数组为准，多余会舍弃 具体看方法 dataFusion),主键融合)
- 独立服务 独立报错代码
- 大屏数据模板(集合对象转基本图表类型,对象转集合类型，柱状图) 具体代码中也有注释
- 代码生成器(不是最终版,目前可以直接生成对应实体类,控制层到各个分体的包中直接使用)
- 文件入库(支持csv,json,xlsx,根据后缀自动判断,*删除时 会删除表!!!)
- 完善的版本依赖管理
- 大部分代码遵循阿里规范 注释完善
- 目前还不属于正式开放阶段 欢迎各位提出问题 提交pr 加入开发。
