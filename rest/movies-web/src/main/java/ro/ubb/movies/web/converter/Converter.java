package ro.ubb.movies.web.converter;

import ro.ubb.movies.core.model.BaseEntity;
import ro.ubb.movies.web.dto.BaseDto;

/**
 * Created by radu.
 */

public interface Converter<Model extends BaseEntity<Long>, Dto extends BaseDto> {

    Model convertDtoToModel(Dto dto);

    Dto convertModelToDto(Model model);

}

