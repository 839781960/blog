工作中查看日志的方法有很多，具体要根据日志的类型、规模和用途来选择合适的工具和技巧。

* 使用ELK（Elasticsearch+Logstash+Kibana）系统
来收集、管理、分析和可视化Web日志，可以实现实时监控、全文检索、聚合统计、报表生成等功能。
* 使用tail命令配合grep命令来实时查看和过滤日志文件中的关键信息，
可以使用管道符（|）将多个命令组合起来，例如：tail -f /var/log/messages | grep ERROR
* 使用awk或sed命令来对日志文件进行文本处理，
可以提取、替换、格式化或删除日志中的某些字段或内容，例如：awk ‘{print $1,$4,$5}’ /var/log/messages
*使用find或locate命令来快速定位日志文件的位置，
可以使用-name或-iname选项来指定文件名或模式匹配，例如：find / -iname “*.log”