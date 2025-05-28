package ru.osiptsoff.npaws.dto;

import java.util.Set;
import java.util.UUID;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecurityUserDto {
    @Nullable
    private UUID uuid;
    @NotBlank
    private String login;
    @NotBlank
    private String password;
    @Nullable
    private String oldPassword;
    @Nullable
    private Set<String> roles;
}
