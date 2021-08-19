package com.heima.model.admin.pojos;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 菜单资源信息表
 * </p>
 *
 * @author heima
 * @since 2021-07-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ad_menu")
@ApiModel(value="AdMenu", description="菜单资源信息表")
public class AdMenu implements Serializable {


    @TableId("id")
    private Integer id;

    @ApiModelProperty(value = "菜单名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "菜单代码")
    @TableField("code")
    private String code;

    @ApiModelProperty(value = "父菜单")
    @TableField("parent_id")
    private Integer parentId;

    @ApiModelProperty(value = "登录时间")
    @TableField("created_time")
    private Date createdTime;


}
