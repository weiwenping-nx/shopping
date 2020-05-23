package com.awen.shopping.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wwp
 * @since 2020-05-21
 */
@TableName("T_STUDENT_TEST")
public class StudentTest extends Model<StudentTest> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableField("ID")
    private String id;

    /**
     * 姓名
     */
    @TableField("NAME")
    private String name;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "StudentTest{" +
        "id=" + id +
        ", name=" + name +
        "}";
    }
}
