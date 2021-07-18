package com.core.backend.controller;

import com.core.backend.entity.Category;
import com.core.backend.service.CategoryService;
import com.core.backend.service.list.EntityList;
import com.core.backend.service.list.EntityListContent;
import com.core.backend.service.list.Row;
import com.core.backend.service.list.View;
import com.core.components.TreeComponent;
import com.core.components.form.field.CheckboxFieldForm;
import com.core.components.form.field.FieldFormType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody Category category) {
        service.save(category);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(category.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Category> get(@PathVariable Integer id)
    {
        if (id != null)
        {
            return service.get(id);
        }
        return null;
        // FIXME deve retornar pagina de erro!
    }

//    @RequestMapping(value = "", method = RequestMethod.GET)
//    public List<Category> getAll()
//    {
//        return service.findAll();
//    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<Category>> findAll(@PageableDefault(page = 0, size = Integer.MAX_VALUE, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Category> categories = service.getAll(pageable);

//        if (customers == null || customers.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }

        return new ResponseEntity<Page<Category>>(categories, HttpStatus.OK);
    }

    @RequestMapping(value = "/list/build", method = RequestMethod.GET)
    public ResponseEntity<EntityList> listBuild(HttpServletRequest req) {
        boolean isReduced = req.getParameter("reduced") != null ? Boolean.parseBoolean(req.getParameter("reduced")) : false;
        EntityList entityList = new EntityList();
        entityList.setContent(new EntityListContent());
        if (isReduced)
        {
            entityList.setView(View.REDUCED);
        }
        boolean hasInput = req.getParameter("input") != null ? Boolean.parseBoolean(req.getParameter("input")) : false;
        if (hasInput)
        {
            if(entityList.getContent() == null)
            {
                entityList.setContent(new EntityListContent());
            }
            entityList.getContent().addCol("");
            entityList.getContent().setInput(FieldFormType.CHECKBOX);
        }
        entityList = service.getList(entityList);
        String formControlName = req.getParameter("formControlName") != null ? req.getParameter("formControlName") : null;
        if(formControlName != null)
        {
            entityList = changeFormControlName(entityList, formControlName);
        }
        return ResponseEntity.ok(entityList);
    }

    private EntityList changeFormControlName(EntityList entityList, String newLabel)
    {
        if(entityList != null)
        {
            EntityListContent content = entityList.getContent();
            if(content != null)
            {
                List<Row> rows = entityList.getContent().getRows();
                for(Row row: rows)
                {
                    List value = row.getValue();
                    if(value != null && !value.isEmpty())
                    {
                        for(Object property: value)
                        {
                            if(property instanceof CheckboxFieldForm)
                            {
                                ((CheckboxFieldForm) property).setLabel(newLabel);
                            }
                        }
                    }
                }
            }

        }
        return entityList;
    }

    @RequestMapping(value = "/tree", method = RequestMethod.GET)
    public ResponseEntity<TreeComponent> getTree(@PageableDefault(page = 0, size = Integer.MAX_VALUE, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        TreeComponent tree = new TreeComponent<Category>();
        tree.setFields(service.getAll());
        tree.setName(Category.class.getSimpleName());
        //TODO implementar!

        return new ResponseEntity<>(tree, HttpStatus.OK);
    }
}
