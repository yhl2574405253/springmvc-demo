package cn.et.demo06.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Repository
public class FoodMapper {
    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 演示查询
     * @param name
     * @return
     */
    public List<Map<String, Object>> queryAllFood(String name){
        if (StringUtils.isEmpty(name)){
            name ="";
        }
        String sql ="select * from food where name like '%"+name+"%'";
        return jdbcTemplate.queryForList(sql);
    }
}
