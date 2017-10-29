package in.hocg.web.modules.domain;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.datatables.mapping.DataTablesOutput;

import java.io.Serializable;

/**
 * Created by hocgin on 2017/10/28.
 * email: hocgin@gmail.com
 * 单位
 */
@Data
@Document(collection = "Department")
public class Department implements Serializable {
    @Id
    @JsonView(DataTablesOutput.View.class)
    private String id;
    
    @JsonView(DataTablesOutput.View.class)
    private String name;         // 单位名称
    
    @JsonView(DataTablesOutput.View.class)
    private String parent;       // 父级ID, 若顶级为null
    
    @JsonView(DataTablesOutput.View.class)
    private String description;  // 描述
    
    @JsonView(DataTablesOutput.View.class)
    private String address;      // 地址
    
    @JsonView(DataTablesOutput.View.class)
    private String phone;        // 联系电话
    
    @JsonView(DataTablesOutput.View.class)
    private boolean hasChildren = Boolean.FALSE; // 是否有子节点
}