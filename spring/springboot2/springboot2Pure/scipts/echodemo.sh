#!/usr/bin/env bash

# 单行输出，可以不加引号
echo hello world
# 多行输出
echo "
<HTML>
    <HEAD>
          <TITLE>Page Title</TITLE>
    </HEAD>
    <BODY>
          Page body.
    </BODY>
</HTML>
"
# -n 输出不换行
echo -n a;echo -n b;
# ab

# -e 解释特殊字符，不能解释命令
echo -e "a\nb"
echo "a\nb"
echo "ps -ef | grep java"
echo -e "ps -ef | grep java"

# 拓展命令
echo $(pwd)
echo $(ps -ef | grep java | awk '{print $1}')

