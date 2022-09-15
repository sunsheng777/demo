package com.sunsheng.modules.sunsheng;

import cn.hutool.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Pretty")
public class HtmlController {

    @RequestMapping("/erciyuan")
    public ModelAndView indexaaa() {
        return new ModelAndView("redirect:http://www.dmoe.cc/random.php");
    }

    @RequestMapping("/erciyuan2")
    public ModelAndView indexbbb() {
        return new ModelAndView("redirect:https://acg.yanwz.cn/api.php");
    }

    @RequestMapping("/menhera")
    public ModelAndView menhera() {
        return new ModelAndView("redirect:https://acg.yanwz.cn/menhera/api.php");
    }

    @RequestMapping("/hdwallpaper")
    public ModelAndView hdwallpaper() {
        return new ModelAndView("redirect:https://api.ixiaowai.cn/gqapi/gqapi.php");
    }

    @RequestMapping("/dailybingwallpaper")
    public ModelAndView dailybingwallpaper() {
        return new ModelAndView("redirect:https://api.66mz8.com/api/bing.php?idx=0&format=jpg");
    }

    @RequestMapping("/randomTaobaoSellerShow")
    public ModelAndView randomTaobaoSellerShow() {
        return new ModelAndView("redirect:https://api.66mz8.com/api/rand.tbimg.php?format=png");
    }

    @RequestMapping("/随机头像")
    public ModelAndView 随机头像() {
        return new ModelAndView("redirect:https://api.66mz8.com/api/rand.portrait.php?type=%E7%94%B7&format=jpg");
    }

    @RequestMapping("/一言语录")
    public ModelAndView 一言语录() {
        return new ModelAndView("redirect:https://api.ixiaowai.cn/api/ylapi.php");
    }

    @RequestMapping("/舔狗日记")
    public ModelAndView 舔狗日记() {
        return new ModelAndView("redirect:https://api.ixiaowai.cn/tgrj/index.php");
    }

    @RequestMapping("/随机情话&污话")
    public ModelAndView 随机情话污话() {
        return new ModelAndView("redirect:https://api.66mz8.com/api/sweet.php?format=jsonp");
    }

    @RequestMapping("/随机毒鸡汤")
    public ModelAndView 随机毒鸡汤(){
        return new ModelAndView("redirect:http://api.lkblog.net/ws/api.php");
    }


    @RequestMapping("/3D城市")
    public String index1() {
        return "modules/sunsheng/Pretty/3D城市.html";
    }

    @RequestMapping("/3D旅行")
    public String index2() {
        return "modules/sunsheng/Pretty/3D旅行.html";
    }

    @RequestMapping("/404滚动框")
    public String index3() {
        return "modules/sunsheng/Pretty/404滚动框.html";
    }
    @RequestMapping("/404demo")
    public String index3demo() {
        return "modules/sunsheng/Pretty/demo.html";
    }

    @RequestMapping("/打砖块")
    public String indexdzk() {
        return "modules/sunsheng/Pretty/打砖块/打砖块.html";
    }

    @RequestMapping("/ddg")
    public String indexddg() {
        return "modules/sunsheng/Pretty/叠叠高/叠叠高.html";
    }

    @RequestMapping("/canvas六角型")
    public String canvas六角型() {
        return "modules/sunsheng/Pretty/canvas六角型.html";
    }

    @RequestMapping("/Canvas加载动画")
    public String Canvas加载动画() {
        return "modules/sunsheng/Pretty/Canvas加载动画.html";
    }

    @RequestMapping("/canvas喷泉")
    public String canvas喷泉() {
        return "modules/sunsheng/Pretty/canvas喷泉.html";
    }

    @RequestMapping("/canvas树")
    public String canvas树() {
        return "modules/sunsheng/Pretty/canvas树.html";
    }

    @RequestMapping("/CSS涡旋")
    public String CSS涡旋() {
        return "modules/sunsheng/Pretty/CSS 涡旋.html";
    }

    @RequestMapping("/CSS3loadding加载等待效果")
    public String CSS3loadding加载等待效果() {
        return "modules/sunsheng/Pretty/CSS3 loadding加载等待效果.html";
    }

    @RequestMapping("/canvas酷炫圆弧时钟动画特效")
    public String canvas酷炫圆弧时钟动画特效() {
        return "modules/sunsheng/Pretty/canvas酷炫圆弧时钟动画特效.html";
    }

    @RequestMapping("/三角形花圈")
    public String 三角形花圈() {
        return "modules/sunsheng/Pretty/三角形花圈.html";
    }

    @RequestMapping("/下雨")
    public String 下雨() {
        return "modules/sunsheng/Pretty/下雨.html";
    }

    @RequestMapping("/倒计时")
    public String 倒计时() {
        return "modules/sunsheng/Pretty/倒计时.html";
    }

    @RequestMapping("/全屏不规则的棱形背景动画")
    public String 全屏不规则的棱形背景动画() {
        return "modules/sunsheng/Pretty/全屏不规则的棱形背景动画.html";
    }

    @RequestMapping("/创意心形动画")
    public String 创意心形动画() {
        return "modules/sunsheng/Pretty/创意心形动画.html";
    }

    @RequestMapping("/加载动画")
    public String 加载动画() {
        return "modules/sunsheng/Pretty/加载动画.html";
    }

    @RequestMapping("/原点动画")
    public String 原点动画() {
        return "modules/sunsheng/Pretty/原点动画.html";
    }

    @RequestMapping("/大白")
    public String 大白() {
        return "modules/sunsheng/Pretty/大白.html";
    }

    @RequestMapping("/山林里太阳日出日落动画")
    public String 山林里太阳日出日落动画() {
        return "modules/sunsheng/Pretty/山林里太阳日出日落动画.html";
    }

    @RequestMapping("/弹性波浪特效")
    public String 弹性波浪特效() {
        return "modules/sunsheng/Pretty/弹性波浪特效.html";
    }

    @RequestMapping("/彩虹蜘蛛")
    public String 彩虹蜘蛛() {
        return "modules/sunsheng/Pretty/彩虹蜘蛛.html";
    }

    @RequestMapping("/彩虹雨")
    public String 彩虹雨() {
        return "modules/sunsheng/Pretty/彩虹雨.html";
    }

    @RequestMapping("/心")
    public String 心() {
        return "modules/sunsheng/Pretty/心.html";
    }

    @RequestMapping("/心1")
    public String 心1() {
        return "modules/sunsheng/Pretty/心1.html";
    }

    @RequestMapping("/情人节快乐")
    public String 情人节快乐() {
        return "modules/sunsheng/Pretty/情人节快乐.html";
    }

    @RequestMapping("/抽象的画布花纹动画")
    public String 抽象的画布花纹动画() {
        return "modules/sunsheng/Pretty/抽象的画布花纹动画.html";
    }

    @RequestMapping("/散景效果CSS")
    public String 散景效果CSS() {
        return "modules/sunsheng/Pretty/散景效果（CSS）.html";
    }

    @RequestMapping("/机器猫")
    public String 机器猫() {
        return "modules/sunsheng/Pretty/机器猫.html";
    }

    @RequestMapping("/机械手表")
    public String 机械手表() {
        return "modules/sunsheng/Pretty/机械手表.html";
    }

    @RequestMapping("/格子")
    public String 格子() {
        return "modules/sunsheng/Pretty/格子.html";
    }

    @RequestMapping("/模拟声波扩散线性传播")
    public String 模拟声波扩散线性传播() {
        return "modules/sunsheng/Pretty/模拟声波扩散线性传播.html";
    }

    @RequestMapping("/珠子迷宫")
    public String 珠子迷宫() {
        return "modules/sunsheng/Pretty/珠子迷宫.html";
    }

    @RequestMapping("/粒子动画")
    public String 粒子动画() {
        return "modules/sunsheng/Pretty/粒子动画.html";
    }

    @RequestMapping("/粒子波浪")
    public String 粒子波浪() {
        return "modules/sunsheng/Pretty/粒子波浪.html";
    }

    @RequestMapping("/粒子秘密")
    public String 粒子秘密() {
        return "modules/sunsheng/Pretty/粒子秘密.html";
    }

    @RequestMapping("/纯css抽屉")
    public String 纯css抽屉() {
        return "modules/sunsheng/Pretty/纯css抽屉.html";
    }

    @RequestMapping("/网页特效")
    public String 网页特效() {
        return "modules/sunsheng/Pretty/网页特效.html";
    }

    @RequestMapping("/花卉")
    public String 花卉() {
        return "modules/sunsheng/Pretty/花卉.html";
    }

    @RequestMapping("/计算器")
    public String 计算器() {
        return "modules/sunsheng/Pretty/计算器.html";
    }

    @RequestMapping("/跳动的爱心")
    public String 跳动的爱心() {
        return "modules/sunsheng/Pretty/跳动的爱心.html";
    }

    @RequestMapping("/闪电风暴雨")
    public String 闪电风暴雨() {
        return "modules/sunsheng/Pretty/闪电风暴雨.html";
    }

    @RequestMapping("/黑客帝国")
    public String 黑客帝国() {
        return "modules/sunsheng/Pretty/黑客帝国.html";
    }

    @RequestMapping("/黑客帝国界面")
    public String 黑客帝国界面() {
        return "modules/sunsheng/Pretty/黑客帝国界面.html";
    }

    @RequestMapping("/鼠标跟随")
    public String 鼠标跟随() {
        return "modules/sunsheng/Pretty/鼠标跟随.html";
    }

//    @RequestMapping("/音频可视化")
//    public String 音频可视化() {
//        return "modules/sunsheng/Pretty/音频可视化/音频可视化.html";
//    }

    @RequestMapping("/weather")
    public String weather() {
        return "modules/sunsheng/Import/weather.html";
    }

    @RequestMapping("/gis")
    public String gis() {
        return "modules/sunsheng/Import/gis.html";
    }
}
