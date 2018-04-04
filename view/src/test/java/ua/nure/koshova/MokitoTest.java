package ua.nure.koshova;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import ua.nure.koshova.controller.CategoryController;
import ua.nure.koshova.entity.Category;
import ua.nure.koshova.service.CategoryService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MokitoTest {

    @InjectMocks
    private CategoryController controller = new CategoryController();

    @Mock
    private CategoryService service;

    private Category thisCategory = new Category();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        thisCategory.setId(1L);
        this.thisCategory.setName("Cat");
    }

    @Test
    public void testCreate() {
        when(service.getCategory(1L)).thenReturn(thisCategory);

        assertEquals(controller.getCategory(1L), thisCategory);

        verify(service).getCategory(1L);
    }
}




