package com.core.backend.controller;


import com.core.backend.entity.Provider;
import com.core.backend.service.ProviderService;
import com.core.backend.service.list.EntityList;
import com.core.backend.service.list.EntityListContent;
import com.core.backend.service.list.View;
import com.core.components.form.Eform;
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
import java.util.Optional;

@RestController
@RequestMapping(value = "/provider")
public class ProviderController {

    @Autowired
    private ProviderService service;

    //FIXME: FIND ALL WITH PAGEABLE
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<Provider>> findAll(@PageableDefault(page = 0, size = Integer.MAX_VALUE, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Provider> providers = service.getAll(pageable);

        if (providers == null || providers.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

            return new ResponseEntity<Page<Provider>>(providers, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Provider>> findById(@PathVariable Integer id) {
        Optional<Provider> user = service.get(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody Provider provider) {
        service.save(provider);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(provider.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Provider provider, @PathVariable Integer id) {
        if (service.get(id) == null) {
            return ResponseEntity.notFound().build();
        }
        service.save(provider);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/list/build", method = RequestMethod.GET)
    public ResponseEntity<EntityList> listBuild(HttpServletRequest req) {
        boolean isReduced = req.getParameter("reduced") != null ? Boolean.parseBoolean(req.getParameter("reduced")) : false;
        EntityList entityList = new EntityList();
        if (isReduced)
        {
            entityList.setView(View.REDUCED);
        }
        boolean radio = req.getParameter("radio") != null ? Boolean.parseBoolean(req.getParameter("reduced")) : false;
        if (radio)
        {
            if(entityList.getContent() == null)
            {
                entityList.setContent(new EntityListContent());
            }
            entityList.getContent().addCol("");
            entityList.getContent().setInputRadioInRows(true);
        }
        entityList = service.getList(entityList);
        return ResponseEntity.ok(entityList);
    }

    @RequestMapping(value = "/eform/build", method = RequestMethod.GET)
    public ResponseEntity<Eform> eFormBuild() {
        Eform eform = service.buildEform();
        return ResponseEntity.ok(eform);
    }

}
