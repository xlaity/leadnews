package com.heima.model.behavior.pojos;

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
 * APP阅读行为表
 * </p>
 *
 * @author heima
 * @since 2021-08-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ap_read_behavior")
@ApiModel(value="ApReadBehavior", description="APP阅读行为表")
public class ApReadBehavior implements Serializable {


    @TableId("id")
    private Long id;

    @ApiModelProperty(value = "用户ID")
    @TableField("entry_id")
    private Integer entryId;

    @ApiModelProperty(value = "文章ID")
    @TableField("article_id")
    private Long articleId;

    @TableField("count")
    private Integer count;

    @ApiModelProperty(value = "阅读时间单位秒")
    @TableField("read_duration")
    private Integer readDuration;

    @ApiModelProperty(value = "阅读百分比")
    @TableField("percentage")
    private Integer percentage;

    @ApiModelProperty(value = "文章加载时间")
    @TableField("load_duration")
    private Integer loadDuration;

    @ApiModelProperty(value = "登录时间")
    @TableField("created_time")
    private Date createdTime;

    @TableField("updated_time")
    private Date updatedTime;


}
