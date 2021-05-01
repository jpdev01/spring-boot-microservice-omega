package com.core.backend.service;

import com.core.backend.entity.User;
import com.core.backend.repository.UserRepository;
import com.core.components.form.Eform;
import com.core.components.form.EventBinding;
import com.core.components.form.field.SelectFieldForm;
import com.core.utils.PatternUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements ServiceInterface<User> {

    @Autowired
    private UserRepository repository;

    @Autowired
    private EFormService eFormService;

    @Override
    public void save(User user) {
        try {
            if (isValidUser(user)) {
                Integer id = user.getId();
                if (id != null) {
                    if (repository.existsById(id)) {
                        // FIXME Fazer validação de usuário já existe
                    }
                }
                repository.save(user);
            }
        } catch (Exception e) {
            System.out.println("erro ao salvar usuário " + e);
        }
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public Page<User> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<User> get(Integer id) {
        return repository.findById(id);
    }

    private boolean isValidUser(User user) {
        return user != null && user.getLogin() != null && user.getPassword() != null;
    }

    public Integer validateLogin(String login, String password) {
        return repository.validate(login, password);
    }

    public User getUserByLogin(String login) {
        return repository.findByLogin(login);
    }

    public Eform buildEform()
    {
        Eform eform = eFormService.build(User.class);
        ArrayList<String> options = new ArrayList<>();
        options.add("Administrador");
        options.add("Gestor");
        options.add("Básico");
        options.add("Master"); // programador
        SelectFieldForm permissionsField = new SelectFieldForm("permission", "Permissão", options);

        // actions
        PatternUrl patternUrl = new PatternUrl();
        eform.setOnSave(new EventBinding("Usuário salvo com sucesso!", patternUrl.getHomeRoute(patternUrl.getUser())));
        eform.setOnSaveError(new EventBinding("Erro ao salvar usuário!"));
        return eform;
    }

}
