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
 * 角色信息表
 * </p>
 *
 * @author heima
 * @since 2021-07-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ad_role")
@ApiModel(value="AdRole", description="角色信息表")
public class AdRole implements Serializable {


    @TableId("id")
    private Integer id;

    @ApiModelProperty(value = "角色名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "角色描述")
    @TableField("description")
    private String description;

    @ApiModelProperty(value = "是否有效")
    @TableField("is_enable")
    private Integer isEnable;

    @ApiModelProperty(value = "登录时间")
    @TableField("created_time")
    private Date createdTime;


}
