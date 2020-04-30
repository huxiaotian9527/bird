package com.hu.boot.bird.nfcs.mapper;

import com.hu.boot.bird.nfcs.entity.DebtOriginalPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 原始债权表（通过接口请求获取的原始债权数据） Mapper 接口
 * </p>
 *
 * @author htt
 * @since 2020-04-30
 */
public interface DebtOriginalMapper extends BaseMapper<DebtOriginalPO> {

    @Select("SELECT * FROM t_debt_batch where id in (select debt_batch_id from t_debt where debt_no = #{debt})")
    DebtOriginalPO selectByDebtNo(@Param("debt") String debt);

}
