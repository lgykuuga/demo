package com.lgy.common.config.system;

/**
 * 系统启动时候初始化组件配置
 *
 * @author Gwall-yangkai
 * @date 2016年6月25日
 */
public class SpringToolStateUtil {

    private static String DB_NAME = null;

    public static boolean isSAAS_STATE() {
        if ("on".equals(SystemConfigManage.getProperty("system.SAAS"))) {
            return true;
        }
        return false;
    }
    /**
     * 自定义单号生成规则开关,开启后会在本服务中全局启用自定义的实现类
     * @Title: IDIncrementerPlugs
     * @param: @return
     * @return: boolean
     * @throws
     */
    public static boolean isIDIncrementerPlugs() {
        if ("on".equals(SystemConfigManage.getProperty("system.IDIncrementerPlugs"))) {
            return true;
        }
        return false;
    }

    public static boolean isREDIS_STATE() {
        if ("on".equals(SystemConfigManage.getProperty("system.redis"))) {
            return true;
        }
        return false;
    }

    public static boolean isRabbitMQ_STATE() {
        if ("on".equals(SystemConfigManage.getProperty("system.rabbitMQ"))) {
            return true;
        }
        return false;
    }

    public static boolean getJobs() {
        if ("on".equals(SystemConfigManage.getProperty("system.jobs"))) {
            return true;
        }
        return false;
    }


    public static String getDBName() {
        return DB_NAME;
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://10.10.10.27:18066/G_302_base?123=123";
        if (url != null && url.length() > 0) {
            String vs[] = url.split("/");
            if (vs.length > 0) {
                String v = vs[vs.length - 1];
                System.out.println(v);
                if(v.indexOf("?") !=-1){
                    v = v.split("\\?")[0];
                }
                System.out.println(v);
                String strs[] = v.split("_");
                if (strs.length == 3) {
                    DB_NAME = strs[2];
                } else {
                    DB_NAME = v;
                }
                System.out.println(DB_NAME);
            }
        }
    }
}

