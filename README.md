# HearthStoneKillCalculator-Android

上次炉石传说斩杀计算器博客发布后，感觉还有很多功能还没有实现，现在推出2.0，较1.0在思路上有了较大改进。

##核心思路如图：
![](https://raw.githubusercontent.com/hfrommane/HearthStoneKillCalculator-Android/master/images/%E9%B1%BC%E4%BA%BA.jpg)
##卡组介绍：
![](https://raw.githubusercontent.com/hfrommane/HearthStoneKillCalculator-Android/master/images/QS.jpg)
###核心卡牌：
![](https://raw.githubusercontent.com/hfrommane/HearthStoneKillCalculator-Android/master/images/AnyfinCanHappen.png)

![](https://raw.githubusercontent.com/hfrommane/HearthStoneKillCalculator-Android/master/images/%E7%BB%84%E5%90%88.jpg)
###卡组思路：
前期保命，后期依靠两张“亡者归来”，让鱼人返场，完成斩杀。

##软件思路
但是由于，鱼人组合实在是太多，我们很难在短时间内计算我们使用“亡者归来”召唤出来的鱼人所具有的斩杀值，所以特意花时间写了一个计算斩杀值的计算器，软件的思路如本文的第一张图片。当坟场鱼人少于等于7时，可以计算出精确的斩杀值。但是当坟场鱼人大于7的时候就会很复杂，软件采用了组合算法，给出了斩杀的最小值和对应的概率，在点击了查看所有斩杀值后，软件列出了所有的斩杀值。

##软件截图：
![](https://raw.githubusercontent.com/hfrommane/HearthStoneKillCalculator-Android/master/images/%E9%A6%96%E9%A1%B5.jpg)
![](https://raw.githubusercontent.com/hfrommane/HearthStoneKillCalculator-Android/master/images/%E5%9D%9F%E5%9C%BA%E9%B1%BC%E4%BA%BA.jpg)
![](https://raw.githubusercontent.com/hfrommane/HearthStoneKillCalculator-Android/master/images/%E5%B0%8F%E4%BA%8E7.jpg)
![](https://raw.githubusercontent.com/hfrommane/HearthStoneKillCalculator-Android/master/images/%E5%A4%A7%E4%BA%8E7.jpg)
![](https://raw.githubusercontent.com/hfrommane/HearthStoneKillCalculator-Android/master/images/%E8%AF%A6%E7%BB%86.jpg)