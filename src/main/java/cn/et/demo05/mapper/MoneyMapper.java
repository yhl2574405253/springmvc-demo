package cn.et.demo05.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MoneyMapper {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void updateMoney(Integer money){
        String sql ="update mymoney set money = money-"+money+" where id=1";
        jdbcTemplate.execute(sql);
    }
    public Integer selectMoney(){
        String sql ="select money from mymoney where id=1";
        Integer num = jdbcTemplate.queryForObject(sql, Integer.class);
        return num;
    }
}
