package com.evan.homemaking.common.model.dto;

import com.evan.homemaking.common.model.dto.base.OutputConverter;
import com.evan.homemaking.common.model.entity.Evaluation;
import lombok.Data;

import javax.persistence.Column;
import java.util.List;

/**
 * @ClassName EvaluationDTO
 * @Description
 * @Author EvanWang
 * @Version 1.0.0
 * @Date 2020/1/17 16:36
 */
@Data
public class EvaluationDTO implements OutputConverter<EvaluationDTO, Evaluation> {

    private Integer id;

    private String employeeNickName;

    private String content;

    private Integer score;
}
