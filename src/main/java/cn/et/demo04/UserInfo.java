package cn.et.demo04;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserInfo {
    /**
     * NotNull 属性名 !=null
     * NotEmpty 属性名!=null &&  !属性名.equals("")
     */
    @NotEmpty(message="用户名不能为空")
    private String userName;

    @NotEmpty(message="密码不能为空")
    private String password;

    @NotEmpty(message="再次输入不能为空")
    private String repassword;

    // lixin@126.com
    @Pattern(message="邮箱格式错误",regexp=".+@.+\\..+")
    private String email;

    @NotEmpty(message="年龄不能为空")
    @Min(value=1,message="年龄必须大于1")
    @Max(value=100,message="年龄必须小于100")
    private String age;

    @Size(min=11, max=11,message="手机号码必须是11位")
    private String phone;

    @Pattern(message="时间格式错误",regexp="(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)")
    private String date;

    @Pattern(message="网址格式错误",regexp="^([hH][tT]{2}[pP]:/*|[hH][tT]{2}[pP][sS]:/*|[fF][tT][pP]:/*)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/])+(\\?{0,1}(([A-Za-z0-9-~]+\\={0,1})([A-Za-z0-9-~]*)\\&{0,1})*)$")
    private String url;

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRepassword() {
        return repassword;
    }
    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
