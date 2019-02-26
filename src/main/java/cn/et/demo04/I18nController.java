package cn.et.demo04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Locale;

@Controller
public class I18nController {
    @Autowired
    private MessageSource ms;

    /**
     * 切换语言
     * @return
     * @throws Exception
     */
    @RequestMapping( value="demo04/mid",method=RequestMethod.GET)
    public String test1() throws Exception{
        return "/demo04/reg.jsp";
    }

    /**
     * 校验数据
     * @param userInfo
     * @param error
     * @param locale
     * @return
     * @throws Exception
     */
    @RequestMapping( value="/demo04/reg",method=RequestMethod.POST)
    public String mdi(@Valid UserInfo userInfo,BindingResult  error , Locale locale) throws Exception{
        if(error.hasErrors()){
            return "/demo04/reg.jsp";
        }
        return null;
    }
}
