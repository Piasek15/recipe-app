package pl.piasecki.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import pl.piasecki.commands.CategoryCommand;
import pl.piasecki.domain.Category;

@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand>{

    @Synchronized
    @Nullable
    @Override
    public CategoryCommand convert(Category source) {

        if (source == null) {
            return null;
        }

        final CategoryCommand categoryCommand = new CategoryCommand();

        categoryCommand.setId(source.getId());
        categoryCommand.setDescription(source.getDescription());

        return categoryCommand;
    }
}
