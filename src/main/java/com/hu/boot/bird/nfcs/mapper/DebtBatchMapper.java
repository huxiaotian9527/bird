package com.hu.boot.bird.nfcs.mapper;

import com.hu.boot.bird.nfcs.entity.DebtBatchPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 债权包信息 Mapper 接口
 * </p>
 *
 * @author htt
 * @since 2020-04-20
 */
public interface DebtBatchMapper extends BaseMapper<DebtBatchPO> {

    @Select("SELECT * FROM t_debt_batch where id in (select debt_batch_id from t_debt where debt_no = #{debt})")
    DebtBatchPO selectByDebtNo(@Param("debt") String debt);
}
