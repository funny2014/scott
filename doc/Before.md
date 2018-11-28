#### 1.项目基础描述
  - 核心框架：SpringMVC|MyBatis|MySQL|Shiro|Vue|Layer

  - 项目资源配置：
    - doc：数据库及说明文档
    - dp-base: 基础信息：地区、字典
    - dp-common: 公共资源信息
    - dp-orm: 持久层信息：数据库、数据源
    - dp-quartz: 定时任务信息
    - dp-shiro: 权限处理
    - dp-web: web资源核心

  - 结构层次：
    - controller：业务处理核心控制
    - dao：mapper 映射
    - entity：实体对象
    - manager：服务层
      - impl：服务实现层
    - service：服务层
      - impl：服务实现层
    - annotation：注释
    - aspect：监控
    - constant：公用静态标识
    - exception：自定义异常
    - plugin：插件
    - utils：工具类
    - validator：校验
    - xss：过滤器
    - template：模板
    - dialect：数据库方言
    - mybatis：SQL工厂
    - profiles：开发环境配置
      - prd：生产
      - pre：开发
      - sit：测试
    - static：静态资源
    - view：视图

    ## 注：所有账户密码均经过 AESUtil 加密（dp-common）。
