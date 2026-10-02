package com.uc.ms_security.dto.permission;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BasePermissionDTO {

    @NotBlank(message = "El nombre del permiso es obligatorio")
    @Size(max = 100, message = "El nombre del permiso no puede superar 100 caracteres")
    private String name;

    @NotBlank(message = "La descripción del permiso es obligatoria")
    @Size(max = 255, message = "La descripción no puede superar 255 caracteres")
    private String description;
}