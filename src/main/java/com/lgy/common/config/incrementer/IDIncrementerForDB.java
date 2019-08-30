package com.lgy.common.config.incrementer;

import com.lgy.common.util.SimpleDateUtils;
import org.apache.shiro.dao.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * ID生成器，在存储bean时生成ID
 */
@Component(value="idIncrementerForDB")
public class IDIncrementerForDB {

    public Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 基于mysql生成ID
     */
    public void initIDMode(Map<String, IDIncrementerBean> idMode) {
        String sql = "select moid,voru,cid,next,updt from gids";

        try {
            List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);

            for (Map<String, Object> map : result) {
                String key = map.get("moid").toString();// 模块ID
                String value = map.get("voru").toString();// 模块格式
                idMode.put(key, new IDIncrementerBean(value));
            }
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            logger.error(ex.toString());
        }
    }

    /**
     * 基于mysql生成ID
     */
    public void initIDbyMysql() {
        // 当前日期
        String dateStr = SimpleDateUtils.convertDateToStirng(SimpleDateUtils.getCurrentTimeToStirng());
        // 验证时间, 如果不相等,就需要更新
        String updateSql = "update gids set next = 1,updt='" + dateStr + "' where updt<>'" + dateStr + "'";
        jdbcTemplate.update(updateSql);
    }

    /**
     * 获取当前ID值。最终的结果是：prefix + ymd + idFormat生成的结果。
     * @param moid 模块编码
     * @param cid 客户编码
     * @return  String PO2017060800001
     */
    public String getNextId(String moid, String cid) {
        String selectSql = "select  next,updt from gids where moid ='"+moid+"'";

        Map<String, Object> map = jdbcTemplate.queryForMap(selectSql);
        if (map != null) {
            String next = map.get("next").toString();

            //2017-04-06
            String dateStr = SimpleDateUtils.convertDateToStirng(SimpleDateUtils.getCurrentTimeToStirng());
            int row = -1;
            //当时间不对时，重置生成规则
            if(!dateStr.equals(map.get("updt"))){
                updateGidsDate(dateStr);
                row = 1;
            }else{
                String updateSql = "update gids set next = next+1 where moid ='"+moid+"' and next="+next;
                //更新单号
                row = jdbcTemplate.update(updateSql);
            }

            if(row ==1){
                IDIncrementerBean idb = IDIncrementerInitializer.IDMODE.get(moid);
                return idb.getNextFormatID(Long.parseLong(next));
            }
        }
        return null;
    }

    /**
     * 更新gids表的 updt和vid 字段
     * @param dateStr  更新时间
     */
    private void updateGidsDate(String dateStr){
        String updateSql = "update gids set next = 1,updt='"+dateStr+"'";
        jdbcTemplate.update(updateSql);
    }
}
