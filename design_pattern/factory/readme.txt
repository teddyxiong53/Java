罗列了3种工厂方法：
1、只有一个produce方法，通过传递参数进去来判断产生哪种Sender。
2、有2个方法：produceMail和produceSms。没有参数。
3、在2的基础上改进，把SendFactory里的方法定义为静态的。这种最常用。

