package by.kochyk.tasklist.web.conroller;

import by.kochyk.tasklist.domain.task.Task;
import by.kochyk.tasklist.domain.user.User;
import by.kochyk.tasklist.service.TaskService;
import by.kochyk.tasklist.service.UserService;
import by.kochyk.tasklist.web.dto.task.TaskDto;
import by.kochyk.tasklist.web.dto.user.UserDto;
import by.kochyk.tasklist.web.dto.validation.OnCreate;
import by.kochyk.tasklist.web.dto.validation.OnUpdate;
import by.kochyk.tasklist.web.mappers.TaskMapper;
import by.kochyk.tasklist.web.mappers.UserMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Validated
@Tag(name = "User Controller", description = "User API")
public class UserController {

    private final UserService userService;
    private final TaskService taskService;

    private final UserMapper userMapper;
    private final TaskMapper taskMapper;

    @GetMapping("/{id}")
    @QueryMapping(name = "userById")
    @Operation(summary = "Get UserDto by id")
    @PreAuthorize("@customSecurityExpression.canAccessUser(#id)")
    public UserDto getById(@PathVariable @Argument final Long id) {
        User user = userService.getById(id);
        return userMapper.toDto(user);
    }

    @PutMapping
    @MutationMapping(name = "updateUser")
    @Operation(summary = "Update User")
    @PreAuthorize("@customSecurityExpression.canAccessUser(#dto.id)")
    public UserDto update(
            @Validated(OnUpdate.class)
            @RequestBody @Argument
            final UserDto dto) {
        User user = userMapper.toEntity(dto);
        User updatedUser = userService.update(user);
        return userMapper.toDto(updatedUser);
    }

    @DeleteMapping("/{id}")
    @MutationMapping(name = "deleteUserById")
    @Operation(summary = "Delete User by id")
    @PreAuthorize("@customSecurityExpression.canAccessUser(#id)")
    public void deleteById(@PathVariable @Argument final Long id) {
        userService.delete(id);
    }

    @GetMapping("/{id}/tasks")
    @QueryMapping(name = "tasksByUserId")
    @Operation(summary = "Get all user tasks")
    @PreAuthorize("@customSecurityExpression.canAccessUser(#id)")
    public List<TaskDto> getTasksByUserId(@PathVariable
                                          @Argument final Long id) {
        List<Task> tasks = taskService.getAllByUserId(id);
        return taskMapper.toDto(tasks);
    }

    @PostMapping("/{id}/tasks")
    @MutationMapping(name = "createTask")
    @Operation(summary = "Add task to user")
    @PreAuthorize("@customSecurityExpression.canAccessUser(#id)")
    public TaskDto createTask(@PathVariable @Argument final Long id,
                              @Validated(OnCreate.class)
                              @RequestBody @Argument final TaskDto dto) {
        Task task = taskMapper.toEntity(dto);
        Task createdTask = taskService.create(task, id);
        return taskMapper.toDto(createdTask);
    }


}
