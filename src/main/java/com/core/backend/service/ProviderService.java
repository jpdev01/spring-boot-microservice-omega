package com.core.backend.service;

import com.core.backend.entity.Provider;
import com.core.backend.entity.User;
import com.core.backend.repository.ProviderRepository;
import com.core.backend.service.list.EntityList;
import com.core.backend.service.list.ListBuilder;
import com.core.components.form.Eform;
import com.core.components.form.EventBinding;
import com.core.components.form.field.SelectFieldForm;
import com.core.custom.Permission;
import com.core.utils.PatternUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProviderService implements ServiceInterface<Provider> {
    @Autowired
    private ProviderRepository repository;

    @Autowired
    private ListBuilder listBuilder;

    @Autowired
    private EFormService eFormService;

    @Override
    public void save(Provider provider) {
        if (provider != null) {
            try {
                repository.save(provider);
            } catch (Exception e) {
                System.err.println("erro ao salvar novo produto!");
            }
        }
    }

    @Override
    public List<Provider> getAll() {
        return repository.findAll();
    }

    @Override
    public Page<Provider> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<Provider> get(Integer id) {
        return repository.findById(id);
    }

    public EntityList getList() {
        return listBuilder.build(Provider.class);
    }

    public EntityList getList(EntityList entityList) {
        return listBuilder.build(Provider.class, entityList);
    }

    public Eform buildEform() {
        Eform eform = eFormService.build(Provider.class);
        ArrayList<Permission> options = new ArrayList<>();
        options.add(Permission.ADM);
        options.add(Permission.MANAGER);
        options.add(Permission.LESS);
        options.add(Permission.MASTER); // programador
        SelectFieldForm permissionsField = new SelectFieldForm("permission", "Permissão", options, 0);
        eform.addField(permissionsField);

        // actions
        PatternUrl patternUrl = new PatternUrl();
        eform.setOnSave(new EventBinding("Usuário salvo com sucesso!", patternUrl.getListRoute(patternUrl.getUser())));
        eform.setOnSaveError(new EventBinding("Erro ao salvar usuário!"));
        return eform;
    }

}
