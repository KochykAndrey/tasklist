package by.kochyk.tasklist.web.mappers;

import by.kochyk.tasklist.domain.task.Task;
import by.kochyk.tasklist.web.dto.task.TaskDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper extends Mappable<Task, TaskDto> {
}
