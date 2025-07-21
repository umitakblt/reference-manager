package com.umitakbulut.reference_manager.dto.response;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -365653788362456280L;

    private Long id;
    private Long userId;
    private Long username;
    private Long email;
    private Long role;
}
