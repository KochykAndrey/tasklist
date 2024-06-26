package by.kochyk.tasklist.web.dto.user;

import by.kochyk.tasklist.web.dto.validation.OnCreate;
import by.kochyk.tasklist.web.dto.validation.OnUpdate;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Schema(description = "User DTO")
public class UserDto {

    @Schema(description = "User id", example = "1")
    @NotNull(message = "Id must be not null.", groups = OnUpdate.class)
    private Long id;

    @Schema(description = "User name", example = "John Doe")
    @NotNull(
            message = "Name must be not null.",
            groups = {OnUpdate.class, OnCreate.class})
    @Length(
            max = 255,
            message = "Name length must be smaller than 255 symbols.",
            groups = {OnUpdate.class, OnCreate.class})
    private String name;

    @Schema(
            description = "User username",
            example = "johndoe@gmail.com")
    @NotNull(
            message = "Username must be not null.",
            groups = {OnUpdate.class, OnCreate.class})
    @Length(
            max = 255,
            message = "Username length must be smaller than 255 symbols.",
            groups = {OnUpdate.class, OnCreate.class})
    private String username;

    @Schema(
            description = "User crypted password",
            example = "$2a$10$clmo6T3ORVKgHBOcnpCqn."
                    + "atzThqxt4JZJcpti5CPHch20gECCpXu")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(
            message = "Password must be not null.",
            groups = {OnUpdate.class, OnCreate.class})
    private String password;

    @Schema(
            description = "User crypted password Confirmation",
            example = "$2a$10$clmo6T3ORVKgHBOcnpCqn."
                    + "atzThqxt4JZJcpti5CPHch20gECCpXu")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(
            message = "Password confirmation must be not null.",
            groups = OnCreate.class)
    private String passwordConfirmation;

}
