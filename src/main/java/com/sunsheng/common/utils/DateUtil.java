package com.sunsheng.common.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 时间工具类
 */
@Service
public class DateUtil {


    // 格式：年月日 小时分钟秒
    public static final String FORMAT_ONE = "yyyyMMdd";
    public static final String FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";


    Calendar date = Calendar.getInstance();
    Integer year = date.get(Calendar.YEAR);
    Integer month = date.get(Calendar.MONTH) + 1;
    Integer day = date.get(Calendar.DAY_OF_MONTH);

    SanYuanUtil sanYuanUtil = new SanYuanUtil();

    /**
     * 获取当前系统标准时间
     *
     * @return
     */
    public Date getNowDate() {
        return new Date();
    }

    /**
     * 获取当前日期年月
     *
     * @return
     */
    public String getCurrentMonth() {
        String m = "";
        if (month < 10) {
            m = "0" + month;
        }
        return year + m;
    }

    /**
     * 获取当前日期字符串信息 格式为yyyyMMdd
     *
     * @return
     */
    public String getNowDateDay() {
        return dateToString(getNowDate(), FORMAT_ONE);
    }

    /**
     * 把日期转换为字符串
     *
     * @param date
     * @return
     */
    public static String dateToString(Date date, String format) {
        String result = "";
        SimpleDateFormat formater = new SimpleDateFormat(format);
        try {
            result = formater.format(date);
        } catch (Exception e) {
            // log.error(e);
        }
        return result;
    }

    /**
     * 获取当前系统标准时间的毫秒值
     *
     * @return
     */
    @Bean
    public Long getNowDateForLong() {
        return new Date().getTime();
    }

    public Date milToTime(Long time) {
        Date date = new Date();
        date.setTime(time);
        return date;
    }


    /**
     * 生成公司编号
     *
     * @param no
     * @return
     */
    /*public String getNo(Long no, NoTypeCode type) {
        String months = "";
        String days = "";
        //如果月份和天小于10的时候，就给前面拼接0
        if (month < 10) {
            months = "0" + month;
        } else {
            months = "" + month;
        }
        if (day < 10) {
            days = "0" + day;
        } else {
            days = "" + day;
        }
        //获取当前系统时间的年份并转字符
        String nowtime = year + months + days;
        //如果获取到的公司编号中的时间和当前时间相同，就是认为今天添加公司了
        String rno = "";
        if (no == null || !nowtime.equals(no.toString().substring(0, 8))) {
            //如果一个公司都没有或者今天没有添加公司，编号从1开始
            rno = type + nowtime + "0001";
        } else if (nowtime.equals(no.toString().substring(0, 8))) {
            //再截取已有公司编号的后四位，转int再自增赋给新公司的编号
            Integer tmpgsid = Integer.parseInt(no.toString().substring(8, 12)) + 1;//截取后四位的编号，再根据编号增肌
            if (tmpgsid < 10) {
                rno = type + nowtime + "000" + tmpgsid;
            } else if (tmpgsid == 10 || (tmpgsid > 10 && tmpgsid < 100)) {
                rno = type + nowtime + "00" + tmpgsid;
            } else if (tmpgsid == 100 || (tmpgsid > 100 && tmpgsid < 1000)) {
                rno = type + nowtime + "0" + tmpgsid;
            } else if (tmpgsid == 1000 || (tmpgsid > 1000 && tmpgsid < 10000)) {
                rno = type + nowtime + tmpgsid;
            } else if (tmpgsid == 9999) {
                new Error("今天添加达到最大值，请明天再添加");
            }
        }
        return rno;
    }*/


    /**
     * 前/后?天
     *
     * @param d
     * @param day
     * @return
     */
    public Date rollDay(Date d, int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.DAY_OF_MONTH, day);
        return cal.getTime();
    }

    /**
     * 比较两个日期
     *
     * @param date1
     * @param date2
     * @return
     */
    public boolean compileTwoDate(Date date1, Date date2) {
        if (date1.before(date2)) {
            return true;
        }
        return false;
    }

    /**
     * 生成公司编号
     *
     * @param no
     * @return
     */
    public String getCompaniesNo(Long no) {
        String months = "";
        String days = "";
        //如果月份和天小于10的时候，就给前面拼接0
        if (month < 10) {
            months = "0" + month;
        } else {
            months = "" + month;
        }
        if (day < 10) {
            days = "0" + day;
        } else {
            days = "" + day;
        }
        //获取当前系统时间的年份并转字符
        String nowtime = year + months + days;
        //如果获取到的公司编号中的时间和当前时间相同，就是认为今天添加公司了
        String gsid = "";
        if (no == null || !nowtime.equals(no.toString().substring(0, 8))) {
            //如果一个公司都没有或者今天没有添加公司，编号从1开始
            gsid = "GS" + nowtime + "0001";
        } else if (nowtime.equals(no.toString().substring(0, 8))) {
            //再截取已有公司编号的后四位，转int再自增赋给新公司的编号
            Integer tmpgsid = Integer.parseInt(no.toString().substring(8, 12)) + 1;//截取后四位的编号，再根据编号增肌
            if (tmpgsid < 10) {
                gsid = "GS" + nowtime + "000" + tmpgsid;
            } else if (tmpgsid == 10 || (tmpgsid > 10 && tmpgsid < 100)) {
                gsid = "GS" + nowtime + "00" + tmpgsid;
            } else if (tmpgsid == 100 || (tmpgsid > 100 && tmpgsid < 1000)) {
                gsid = "GS" + nowtime + "0" + tmpgsid;
            } else if (tmpgsid == 1000 || (tmpgsid > 1000 && tmpgsid < 10000)) {
                gsid = "GS" + nowtime + tmpgsid;
            } else if (tmpgsid == 9999) {
                new Error("今天公司添加达到最大值，请明天再添加");
            }
        }
        return gsid;
    }


    /**
     * 生成角色编号
     *
     * @param no
     * @return
     */
    public String getRoleNo(Long no) {
        String date = getNowDateDay();

        //如果获取到的编号中的时间和当前时间相同，就是认为今天添加公司了
        String rno = "";
        if (EmptyUtils.isEmpty(no) || !date.equals(no.toString().substring(0, 8))) {
            //如果一个公司都没有或者今天没有添加公司，编号从1开始
            rno = "R" + date + "0001";
        } else if (date.equals(no.toString().substring(0, 8))) {
            //再截取已有公司编号的后四位，转int再自增赋给新公司的编号
            Integer tmpgsid = Integer.parseInt(no.toString().substring(8, 12)) + 1;//截取后四位的编号，再根据编号增肌
            if (tmpgsid < 10) {
                rno = "R" + date + "000" + tmpgsid;
            } else if (tmpgsid == 10 || (tmpgsid > 10 && tmpgsid < 100)) {
                rno = "R" + date + "00" + tmpgsid;
            } else if (tmpgsid == 100 || (tmpgsid > 100 && tmpgsid < 1000)) {
                rno = "R" + date + "0" + tmpgsid;
            } else if (tmpgsid == 1000 || (tmpgsid > 1000 && tmpgsid < 10000)) {
                rno = "R" + date + tmpgsid;
            } else if (tmpgsid == 9999) {
                new Error("今天添加达到最大值，请明天再添加");
            }
        }
        return rno;
    }


//    public static void main(String[] args) {
//        DateUtil dateUtil = new DateUtil();
//        long a = 20200214003L;
//        Long l = new Long(a);
//        String userid =  dateUtil.getUsersId(l);
//        System.out.println(userid);
//    }

    /**
     * 生成用户编号
     *
     * @param userid
     * @return
     */
    public String getUsersId(Long userid) {
        String months = "";
        String days = "";
        //如果月份和天小于10的时候，就给前面拼接0
        if (month < 10) {
            months = "0" + month;
        } else {
            months = "" + month;
        }
        if (day < 10) {
            days = "0" + day;
        } else {
            days = "" + day;
        }
        String nowtime = year + months + days;//获取当前系统时间的年份并转字符
        //如果获取到的公司编号中的时间和当前时间相同，就是认为今天添加公司了
        String ygid = "";
        if (userid == null || !nowtime.equals(userid.toString().substring(0, 8))) {
            ygid = "U" + nowtime + "0001";
        } else if (nowtime.equals(userid.toString().substring(0, 8))) {
            //再截取员工编号的后四位，转int再自增赋给新员工的编号
            Integer tmpgsid = Integer.parseInt(userid.toString().substring(8, 12)) + 1;//截取后四位的编号，再根据编号自增
            if (tmpgsid < 10) {
                ygid = "U" + nowtime + "000" + tmpgsid;
            } else if (tmpgsid == 10 || (tmpgsid > 10 && tmpgsid < 100)) {
                ygid = "U" + nowtime + "00" + tmpgsid;
            } else if (tmpgsid == 100 || (tmpgsid > 100 && tmpgsid < 1000)) {
                ygid = "U" + nowtime + "0" + tmpgsid;
            } else if (tmpgsid == 1000 || (tmpgsid > 1000 && tmpgsid < 10000)) {
                ygid = "U" + nowtime + tmpgsid;
            } else if (tmpgsid == 9999) {
                new Error("今天用户添加达到最大值，请明天再添加");
            }
        }
        return ygid;
    }

    /**
     * 生成专柜编号
     *
     * @return
     */
    public String getCounterId(Long zgid) {
        String months = "";
        String days = "";
        //如果月份和天小于10的时候，就给前面拼接0
        if (month < 10) {
            months = "0" + month;
        } else {
            months = "" + month;
        }
        if (day < 10) {
            days = "0" + day;
        } else {
            days = "" + day;
        }
        String nowtime = year + months + days;//获取当前系统时间的年份并转字符
        //如果获取到的公司编号中的时间和当前时间相同，就是认为今天添加公司了
        String zgids = "";
        if (zgid == null || !nowtime.equals(zgid.toString().substring(0, 8))) {
            zgids = "ZG" + nowtime + "0001";
        } else if (zgid != null && nowtime.equals(zgid.toString().substring(0, 8))) {
            //再截取员工编号的后四位，转int再自增赋给新员工的编号
            Integer tmpgsid = Integer.parseInt(zgid.toString().substring(8, 12)) + 1;//截取后四位的编号，再根据编号自增
            if (tmpgsid < 10) {
                zgids = "ZG" + nowtime + "000" + tmpgsid;
            } else if (tmpgsid == 10 || (tmpgsid > 10 && tmpgsid < 100)) {
                zgids = "ZG" + nowtime + "00" + tmpgsid;
            } else if (tmpgsid == 100 || (tmpgsid > 100 && tmpgsid < 1000)) {
                zgids = "ZG" + nowtime + "0" + tmpgsid;
            } else if (tmpgsid == 1000 || (tmpgsid > 1000 && tmpgsid < 10000)) {
                zgids = "ZG" + nowtime + tmpgsid;
            } else if (tmpgsid == 9999) {
                new Error("今天专柜添加达到最大值，请明天再添加");
            }
        }
        return zgids;
    }

    /**
     * 供应商编号，传入查询的最大供应商编号，如果是空的，就从1开始，否则在最大编号的基础上+1
     *
     * @param maxno
     * @return
     */
    public String getSuppliersNo(String maxno) {
        String SuppliersNo = "";
        if (null == maxno) {
            //如果没有编号，就是从1开始
            SuppliersNo = "GYS0001";
        } else if (maxno != null) {
            //如果编号不为空，将编号转为数字并加1
            Integer no = Integer.parseInt(maxno) + 1;
            if (no < 10) {
                //1-9
                SuppliersNo = "GYS000" + no;
            } else if (no == 10 || (no > 10 && no < 100)) {
                //10-99
                SuppliersNo = "GYS00" + no;
            } else if (no == 100 || (no > 100 && no < 1000)) {
                //100-999
                SuppliersNo = "GYS0" + no;
            } else if (no == 1000 || (no > 1000 && no < 10000)) {
                //1000-9999
                SuppliersNo = "GYS" + no;
            } else if (no == 9999 || no > 9999) {
                new Error("供应商编号达到最大值，不能再报错请联系管理员");
            }
        }
        return SuppliersNo;
    }

    /**
     * 品牌编号的生产
     *
     * @param maxno
     * @return
     */
    public String getBrandsNo(String maxno) {
        String brandsNo = "";
        if (maxno == null) {
            //如果没有编号，就是从1开始
            brandsNo = "Br0001";
        } else if (maxno != null) {
            //如果编号不为空，将编号转为数字并加1
            Integer no = Integer.parseInt(maxno) + 1;
            if (no < 10) {
                //1-9
                brandsNo = "Br000" + no;
            } else if (no == 10 || (no > 10 && no < 100)) {
                //10-99
                brandsNo = "Br00" + no;
            } else if (no == 100 || (no > 100 && no < 1000)) {
                //100-999
                brandsNo = "Br0" + no;
            } else if (no == 1000 || (no > 1000 && no < 10000)) {
                //1000-9999
                brandsNo = "Br" + no;
            } else if (no == 9999 || no > 9999) {
                new Error("品牌编号达到最大值，不能再报错请联系管理员");
            }
        }
        return brandsNo;
    }

    /**
     * 规格编号生成
     *
     * @param maxno
     * @return
     */
    public String getSpecsNo(String maxno) {
        String Gno = "";
        if (maxno == null) {
            //如果没有编号，就是从1开始
            Gno = "G0001";
        } else if (maxno != null) {
            //如果编号不为空，将编号转为数字并加1
            Integer no = Integer.parseInt(maxno) + 1;
            if (no < 10) {
                //1-9
                Gno = "G000" + no;
            } else if (no == 10 || (no > 10 && no < 100)) {
                //10-99
                Gno = "G00" + no;
            } else if (no == 100 || (no > 100 && no < 1000)) {
                //100-999
                Gno = "G0" + no;
            } else if (no == 1000 || (no > 1000 && no < 10000)) {
                //1000-9999
                Gno = "G" + no;
            } else if (no == 9999 || no > 9999) {
                new Error("规格编号达到最大值，不能再报错请联系管理员");
            }
        }
        return Gno;
    }

    /**
     * draftusers表的编号和nenbers表会员编号的生成
     *
     * @param num
     * @return
     */
    public String getNumber(Long num) {
//        Calendar date = Calendar.getInstance();
//        Integer year = date.get(Calendar.YEAR);
//        Integer month = date.get(Calendar.MONTH) + 1;
//        Integer day = date.get(Calendar.DAY_OF_MONTH);

        String months = "";
        String days = "";
        //如果月份和天小于10的时候，就给前面拼接0
        if (month < 10) {
            months = "0" + month;
        } else {
            months = "" + month;
        }
        if (day < 10) {
            days = "0" + day;
        } else {
            days = "" + day;
        }
        String nowtime = year + months + days;//获取当前系统时间的年份并转字符
        String number = "";
        if (num == null || !nowtime.equals(num.toString().substring(0, 8))) {
            number = "U" + nowtime + "0001";
        } else if (num != null && nowtime.equals(num.toString().substring(0, 8))) {
            //再截取员工编号的后四位，转int再自增赋给新员工的编号
            Integer tmpgsid = Integer.parseInt(num.toString().substring(8, 12)) + 1;//截取后四位的编号，再根据编号自增
            if (tmpgsid < 10) {
                number = "U" + nowtime + "000" + tmpgsid;
            } else if (tmpgsid == 10 || (tmpgsid > 10 && tmpgsid < 100)) {
                number = "U" + nowtime + "00" + tmpgsid;
            } else if (tmpgsid == 100 || (tmpgsid > 100 && tmpgsid < 1000)) {
                number = "U" + nowtime + "0" + tmpgsid;
            } else if (tmpgsid == 1000 || (tmpgsid > 1000 && tmpgsid < 10000)) {
                number = "U" + nowtime + tmpgsid;
            } else if (tmpgsid == 9999) {
                new Error("今天添加达到最大值，请明天再添加");
            }
        }
        return number;
    }

    /**
     * 获取今天的开始时间，结束时间
     *
     * @return
     */
    public Map<String, String> getTodayStratAndEndTime() {
        Date start = new Date();
        start.setHours(0);
        start.setMinutes(0);
        start.setSeconds(0);
        Date end = new Date();
        end.setHours(23);
        end.setMinutes(59);
        end.setSeconds(59);
        Map<String, String> map = new HashMap<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        map.put("start", simpleDateFormat.format(start));
        map.put("end", simpleDateFormat.format(end));
        return map;
    }

    /**
     * 获取昨天的开始时间，结束时间
     *
     * @return
     */
    public Map<String, String> getYesterdayStratAndEndTime() {
        Date start = new Date();
        start.setDate(start.getDate() - 1);
        start.setHours(0);
        start.setMinutes(0);
        start.setSeconds(0);
        Date end = new Date();
        end.setDate(end.getDate() - 1);
        end.setHours(23);
        end.setMinutes(59);
        end.setSeconds(59);
        Map<String, String> map = new HashMap<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        map.put("start", simpleDateFormat.format(start));
        map.put("end", simpleDateFormat.format(end));
        return map;
    }

    /**
     * 获取当月的开始时间，结束时间
     *
     * @return
     */
    public Map<String, String> getCurrentMonthStratAndEndTime() {
        Map<String, String> map = new HashMap<>();
        Calendar s = Calendar.getInstance();
        s.setTime(new Date());
        //设置为1号,当前日期既为本月第一天
        s.set(Calendar.DAY_OF_MONTH, 1);
        //将小时至0
        s.set(Calendar.HOUR_OF_DAY, 0);
        //将分钟至0
        s.set(Calendar.MINUTE, 0);
        //将秒至0
        s.set(Calendar.SECOND, 0);
        //将毫秒至0
        s.set(Calendar.MILLISECOND, 0);

        Calendar e = Calendar.getInstance();
        e.setTime(new Date());
        //设置为当月最后一天
        e.set(Calendar.DAY_OF_MONTH, e.getActualMaximum(Calendar.DAY_OF_MONTH));
        //将小时至23
        e.set(Calendar.HOUR_OF_DAY, 23);
        //将分钟至59
        e.set(Calendar.MINUTE, 59);
        //将秒至59
        e.set(Calendar.SECOND, 59);
        //将毫秒至999
        e.set(Calendar.MILLISECOND, 999);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        map.put("start", simpleDateFormat.format(s.getTime()));
        map.put("end", simpleDateFormat.format(e.getTime()));
        return map;
    }

    /**
     * 获取上月的开始时间，结束时间
     *
     * @return
     */
    public Map<String, String> getLastMonthStratAndEndTime() {
        Map<String, String> map = new HashMap<>();
        Calendar s = Calendar.getInstance();
        Date startdate = new Date();
        startdate.setMonth(startdate.getMonth() - 1);
        s.setTime(startdate);
        s.set(Calendar.DAY_OF_MONTH, 1);
        s.set(Calendar.HOUR_OF_DAY, 0);
        s.set(Calendar.MINUTE, 0);
        s.set(Calendar.SECOND, 0);
        s.set(Calendar.MILLISECOND, 0);
//        map.put("start",s.getTime());
        Calendar e = Calendar.getInstance();
        Date enddate = new Date();
        enddate.setMonth(enddate.getMonth() - 1);
        e.setTime(enddate);
        e.set(Calendar.DAY_OF_MONTH, e.getActualMaximum(Calendar.DAY_OF_MONTH));
        e.set(Calendar.HOUR_OF_DAY, 23);
        e.set(Calendar.MINUTE, 59);
        e.set(Calendar.SECOND, 59);
        e.set(Calendar.MILLISECOND, 999);
//        map.put("end",e.getTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        map.put("start", simpleDateFormat.format(s.getTime()));
        map.put("end", simpleDateFormat.format(e.getTime()));
        return map;
    }

    //    public static void main(String[] args) {
//        Map<String, Object> lsit = getOldYearTime();
//    }
    //获取当前时间的前20年，20-30,30-40,40-50,50以上的时间
    Calendar calendar = Calendar.getInstance();

    public Date getOld20Year() {
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, -20);
        return calendar.getTime();
    }

    public Date getOld30Year() {
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, -30);
        return calendar.getTime();
    }

    public Date getOld40Year() {
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, -40);
        return calendar.getTime();
    }

    public Date getOld50Year() {
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, -50);
        return calendar.getTime();
    }
}
