# Smart-BI-Data

## 写在前面

项目发布初期，希望大家多多点点`Star`
- [Gitee](https://gitee.com/new_sonw/Smart-BI-Data)
- [GitHub](https://github.com/ShelikeSnow/Smart-BI-Data)
#### 介绍
基于大屏类业务 而产生的 数据中台
1.配置即用 简单配置 运维可上手
目前包含如下功能：
- 实时接口转发
- 数据库查询直接输出接口
- 数据拦截
- 数据落库 表不存在自动匹配类型创建表
- 静态接口 (对应大屏业务的比如标题等)
- 缓存机制(第三方token缓存)
- 支持多角色第三方token模式
- 文档聚合
- 大屏数据模板已完成(集合对象转基本图表类型,对象转集合类型) 具体代码中也有注释


     *  对象转list集合并添加元素,{"fireProbability":"10%","flood":"5%"} ===> "[{"name":"火灾","value":"10%"},{"name":"洪水","value":"5%"}]"      params===> "[{"fireProbability":"value","join":{"name":"火灾"}},{"flood":"value","join":{"name":"洪水"}}]"
     
     *  基本类型图表   {"a":"a","c":"c","b":"b"}===>{"name":"a","value":"b"} 集合类型同理  params===>{"a":"name","b":"value"}

     * 柱状图  不存在非集合情况!!!
     * 将一个集合 转为前端柱状图形式,
     * {"total":123,"list":[{"name":张三,"age":18,"value":1},{"name":李四,"age":23,"value":2},{"name":王五,"age":18,"value":3}]}===>{"total":123,"data":[18,23,18],"name":["张三","李四","王五"]}===>
     * params===>{"ppr":[{"key":"total","jsonPath":"$..total"}],"name":"name","data":"data"} 理论上只能有一个key{"key":"total","jsonPath":"$..total"} 这里面除了jsonPath只会有一个
     * 可同时做字段转换名称
### 待开发
- 直接输出前端大屏模板(即通过后台配置模板类型后 可直接返回图标使用数据 柱状图 折线图 等...) 优先 ✔
- 文件服务(ico,图片,视频等...不做重点开发)
- 数据融合(多个接口数据混合计算后输出结果)
- 其他待定(欢迎各位提出需求)


### 软件架构
软件架构说明(没画 脑补先)

