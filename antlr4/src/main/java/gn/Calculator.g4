// 带赋值的计算器语法定义文件
grammar Calculator; // 语法的名字

// 程序program是由一系列语句构成的

program: statement+ ; // + 一个或多个statement构成的

// 语句由三种情况:
// - 表达式 换行符
// - 赋值语句 : 标识符 '=' 表达式换行符
// - 换行符
statement: expression NEWLINE
            | ID '=' expression NEWLINE
            | NEWLINE
            ;

expression: expression op = ('*'|'/') expression
            | expression op = ('+'|'-') expression
            | INT
            | ID
            | '(' expression ')'
            ;

// 变量名, 当前设置为只支持一个或多个大消息字母
ID: [a-zA-Z]+ ;
INT: [0-9]+ ;

NEWLINE: '\r'? '\n'; // \r出现一次或出现零次, \n必须出现

WS: [ \t]+ -> skip;






