package by.kochyk.tasklist.web.mappers;

import by.kochyk.tasklist.domain.task.TaskImage;
import by.kochyk.tasklist.web.dto.task.TaskImageDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskImageMapper extends Mappable<TaskImage, TaskImageDto> {
}