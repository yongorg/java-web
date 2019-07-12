package node.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private Integer id;
    private String name;
    private Integer age;
    private Date birthday;

    public String getBirStr(){
        if (birthday!=null){
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(birthday);
        }else {
            return "";
        }
    }
}
