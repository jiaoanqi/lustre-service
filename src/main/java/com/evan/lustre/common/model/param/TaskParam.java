package com.evan.lustre.common.model.param;

import com.evan.lustre.common.model.dto.base.InputConverter;
import com.evan.lustre.common.model.entity.Task;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @ClassName TaskParam
 * @Description
 * @Author EvanWang
 * @Version 1.0.0
 * @Date 2019/12/5 19:56
 */
@Data
public class TaskParam implements InputConverter<Task> {

    @NotBlank(message = "任务内容不能为空")
    @Size(max = 255, message = "任务内容长度不能超过 {max}")
    private String content;

    @NotBlank(message = "任务标题不能为空")
    @Size(max = 50, message = "任务内容长度不能超过 {max}")
    private String title;

    @Max(value = 3, message = "状态标识字符不能大于 {value}")
    @Min(value = 0, message = "状态标识字符不能小于 {value}")
    private Integer status;
}
