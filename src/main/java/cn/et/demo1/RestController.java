package cn.et.demo1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

/**


 *  资源（有一个唯一标识符）
 *  对资源的操作就是一动作(GET(查) | POST （新增）| PUT(修改) |DELETE(删除)
*
 *  rest是一种设计风格 设计资源的标识符
 *  http://localhsot:8080/s/deleteUser?id=1 (标准http协议 资源定义方式)
 */
@Controller
public class RestController {

    /**
     * 添加
     * @param name
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/user",method=RequestMethod.POST)
    public String addUser(String name,HttpServletResponse response) throws Exception{
        response.getWriter().println(name+" 添加成功！！");
        return null;
    }

    /**
     * 删除
     * @param userId
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/user/{id}",method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable(value="id") String userId,HttpServletResponse response) throws Exception{
        response.getWriter().println(userId+" 删除成功！！");
        return null;
    }

    /**
     * 修改
     * @param userId
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/user/{id}",method=RequestMethod.PUT)
    public String updateUser(@PathVariable(value="id") String userId,HttpServletResponse response) throws Exception{
        response.getWriter().println(userId+" 修改成功！！");
        return null;
    }

    /**
     * 查询
     * @param userId
     * @return
     */
    @RequestMapping(value="/user/{id}",method=RequestMethod.GET)
    public String getUser(@PathVariable(value="id") String userId, HttpServletResponse response)throws Exception{
        response.getWriter().println(userId+" 查询成功！！");
        return null;
    }
}
