package com.yun.bisecurity.group.role.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * <p>
 * 
 * </p>
 *
 * @author Sober
 * @since 2022-11-10
 */
@TableName("role")
@Schema(title = "RoleEntity对象", description = "")
public class RoleEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @Schema(description = "角色名称")
    private String name;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public String toString() {
        return "RoleEntity{" +
        "id=" + id +
        ", name=" + name +
        ", createdTime=" + createdTime +
        ", updatedTime=" + updatedTime +
        "}";
    }
}
