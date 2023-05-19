package com.example.petadmin.converters;

import com.example.petadmin.models.dto.UserRegistrationDto;
import com.example.petadmin.models.entity.user.Users;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserRegistrationMapper {
    Users toEntity(UserRegistrationDto userRegistrationDto);

    UserRegistrationDto toDto(Users users);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Users partialUpdate(UserRegistrationDto userRegistrationDto, @MappingTarget Users users);
}