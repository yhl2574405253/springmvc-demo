package cn.et.demo05.controller;

import cn.et.demo05.mapper.MoneyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.OutputStream;

@Controller
public class InterController {
    @Autowired
    MoneyMapper moneyMapper;

    /**
     * 演示拦截器的使用方式
     * @param outputStream
     * @return
     * @throws IOException
     */
    @RequestMapping("/demo05/test1")
    public String test1(OutputStream outputStream) throws IOException {
        outputStream.write("hello".getBytes());
        return null;
    }

    /**
     * 演示扣款防止重复提交的例子
     * @param money
     * @param os
     * @return
     * @throws Exception
     */
    @RequestMapping( value="/demo05/test2")
    public String reg(Integer money ,OutputStream os) throws Exception{
        moneyMapper.updateMoney(money);
        os.write(("money is: "+ moneyMapper.selectMoney()).getBytes());
        return null;
    }
}
