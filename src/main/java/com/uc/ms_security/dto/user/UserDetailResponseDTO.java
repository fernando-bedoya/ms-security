package com.uc.ms_security.dto.user;

import com.uc.ms_security.dto.profile.ProfileResponseDTO;
import lombok.Value;

@Value
public class UserDetailResponseDTO {
    Long id;
    String name;
    String email;
    ProfileResponseDTO profile;
}

//Aqui se manda a hacer el join con la tabla de profile para que se pueda traer la informacion del profile del usuario, y se hace un mapeo en el mapper para que se pueda traer la informacion del profile del usuario.