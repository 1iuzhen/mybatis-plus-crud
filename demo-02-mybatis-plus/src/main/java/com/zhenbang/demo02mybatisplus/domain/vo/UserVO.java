package com.zhenbang.demo02mybatisplus.domain.vo;




import com.zhenbang.demo02mybatisplus.domain.po.UserInfo;
import com.zhenbang.demo02mybatisplus.enums.UserStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "用户表单实体")
public class UserVO {

    @Schema(description = "id")
    private Long id;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "详细信息")
    private Object info;

    @Schema(description = "使用状态（1正常，2冻结）")
    private Integer status;

    @Schema(description = "账户余额（单位：分）")
    private Integer balance;

    @Schema(description = "用户的收货地址列表")
    private List<AddressVO> addresses;

    // Lombok 可选保留
    // 如果你希望继续自动生成 getter/setter 等方法，可以保留
    // 否则请手写 Getter/Setter（如你想规范类结构）

    // 示例：保留 Lombok
    // @Data
}
