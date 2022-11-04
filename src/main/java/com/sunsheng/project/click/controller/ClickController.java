package com.sunsheng.project.click.controller;

//import com.sunsheng.config.ClickHouseConfig;
import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

/**
 * @author PC
 */
@RestController
@RequestMapping("/click")
public class ClickController {
//    @Resource
//    public ClickService clickService;
//
//    @RequestMapping(value = "/addTest")
//    public void getFrsDataTest() {
//        System.out.println("******************");
//        String sql = "select * from default.t_order01";
//        List<JSONObject> result = ClickHouseUtil.exeSql(sql);
//        System.out.println(result);
//        System.out.println("******************");
//    }
//
//    @RequestMapping(value = "/addAll")
//    public R exeSql() {
//        String sql = "select * from user";
//        List<JSONObject> result = ClickHouseUtil.exeSql(sql);
//        System.out.println(result);
//        return R.ok().putData("result", result);
//    }

    /*@Value("${spring.datasource.clickhouse.address}")
    public static String url;*/

    /*@RequestMapping(value = "/addTest")
    public R exeSql2() throws Exception {
        Class.forName("com.github.housepower.jdbc.ClickHouseDriver");
        System.out.println("-------------------" + url);
        Connection connection = DriverManager.getConnection(url);
//        Connection connection = DriverManager.getConnection("jdbc:clickhouse://192.168.10.130:8123");

        PreparedStatement pstmt = connection.prepareStatement("insert into default.jdbc_example values(?, ?, ?)");

        for (int i = 0; i < 10; i++) {
            pstmt.setDate(1, new Date(System.currentTimeMillis()));
            pstmt.setString(2, "panda_" + (i + 1));
            pstmt.setInt(3, 18);
            pstmt.addBatch();
        }
        pstmt.executeBatch();
        return R.ok().putData("result");
    }*/

}
