package com.yun.bifilemanage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 文件管理
 *
 * @author Yun
 * @email 2289128964@qq.com
 * @date 2022-10-10 17:26:29
 */
@Data
@TableName("file_storage")
public class FileStorageEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 创建时间
     */
    private Date createdTime = new Date();
    /**
     * 更新时间
     */
    private Date updatedTime = new Date();
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 文件大小
     */
    private Long size;
    /**
     * minio Id
     */
    private Long minioId;
    /**
     * 文件类型 0.csv 1.xlsx 2.json
     */
    private Integer fileType;
    /**
     * 存储数据源
     */
    private Integer sourceId;
    /**
     * 保存表名
     */
    private String saveName;
    /**
     * 是否删除
     */
    private Boolean status = false;

}
