package pl.piasecki.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.piasecki.domain.Category;
import pl.piasecki.domain.UnitOfMeasure;
import pl.piasecki.repositories.CategoryRepository;
import pl.piasecki.repositories.UnitOfMeasureRepository;

@Slf4j
@Component
@Profile({"dev", "prod"})
public class BootstrapMySQL implements ApplicationListener<ContextRefreshedEvent>{

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public BootstrapMySQL(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (categoryRepository.count() == 0L){
            log.debug("Loading Categories");
            loadCategories();
        }

        if (unitOfMeasureRepository.count() == 0L){
            log.debug("Loading UOMs");
            loadUom();
        }
    }

    private void loadCategories(){
        Category cat1 = new Category();
        Category cat2 = new Category();
        Category cat3 = new Category();
        Category cat4 = new Category();

        cat1.setDescription("American");
        cat2.setDescription("Italian");
        cat3.setDescription("Mexican");
        cat4.setDescription("Fast Food");

        categoryRepository.save(cat1);
        categoryRepository.save(cat2);
        categoryRepository.save(cat3);
        categoryRepository.save(cat4);
    }

    private void loadUom(){
        UnitOfMeasure uom1 = new UnitOfMeasure();
        UnitOfMeasure uom2 = new UnitOfMeasure();
        UnitOfMeasure uom3 = new UnitOfMeasure();
        UnitOfMeasure uom4 = new UnitOfMeasure();
        UnitOfMeasure uom5 = new UnitOfMeasure();
        UnitOfMeasure uom6 = new UnitOfMeasure();
        UnitOfMeasure uom7 = new UnitOfMeasure();
        UnitOfMeasure uom8 = new UnitOfMeasure();

        uom1.setDescription("Teaspoon");
        uom2.setDescription("Tablespoon");
        uom3.setDescription("Cup");
        uom4.setDescription("Pinch");
        uom5.setDescription("Ounce");
        uom6.setDescription("Each");
        uom7.setDescription("Pint");
        uom8.setDescription("Dash");

        unitOfMeasureRepository.save(uom1);
        unitOfMeasureRepository.save(uom2);
        unitOfMeasureRepository.save(uom3);
        unitOfMeasureRepository.save(uom4);
        unitOfMeasureRepository.save(uom5);
        unitOfMeasureRepository.save(uom6);
        unitOfMeasureRepository.save(uom7);
        unitOfMeasureRepository.save(uom8);
    }
}
