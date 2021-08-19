package com.heima.model.article.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * 搜索热词表
 * </p>
 *
 * @author heima
 * @since 2021-07-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ap_hot_words")
@ApiModel(value="ApHotWords", description="搜索热词表")
public class ApHotWords implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "热词")
    @TableField("hot_words")
    private String hotWords;

    @ApiModelProperty(value = "0:热,1:荐,2:新,3:火,4:精,5:亮")
    @TableField("type")
    private Integer type;

    @ApiModelProperty(value = "热词日期")
    @TableField("hot_date")
    private String hotDate;

    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    private Date createdTime;


}
