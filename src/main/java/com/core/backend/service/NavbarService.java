package com.core.backend.service;

import com.core.components.nav.DropdownFieldNav;
import com.core.components.nav.FieldNav;
import com.core.components.nav.FieldNavInterface;
import com.core.components.nav.Navbar;
import com.core.utils.PatternUrl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NavbarService {

    public Navbar getNavbar()
    {
        PatternUrl patternUrl = new PatternUrl();
        Navbar navbar = new Navbar();
        List<FieldNavInterface> fields = new ArrayList<>();
        fields.add(new FieldNav("Ínicio","fa fa-home", patternUrl.getHome()));
        fields.add(new FieldNav("Portal de vendas","fa fa-cart-plus", patternUrl.getStoreSpace(), true, true));
        // FIXME arrumar link quando componente existir
        fields.add(new FieldNav("Caixa","fa fa-folder-open-o", ""));
        fields.add(new FieldNav("Pagamentos","fa fa-credit-card-alt", ""));

        DropdownFieldNav dropdown = new DropdownFieldNav("Consultas", "fa fa-home");
        dropdown.addField(new FieldNav("Clientes", patternUrl.getListRoute(patternUrl.getCustomer())));
        dropdown.addField(new FieldNav("Produtos", patternUrl.getListRoute(patternUrl.getProduct())));
        dropdown.addField(new FieldNav("Fornecedores", patternUrl.getListRoute(patternUrl.getProvider())));
        dropdown.addField(new FieldNav("Usuários", patternUrl.getListRoute(patternUrl.getUser())));
        fields.add(dropdown);

        DropdownFieldNav dropdownMore = new DropdownFieldNav("Mais", "fa fa-plus");
        dropdownMore.addField(new FieldNav("Aniversariantes"));
        fields.add(dropdownMore);
        fields.add(new FieldNav("Sair", "fa fa-sign-out"));
        navbar.setFields(fields);
        return navbar;
    }
}
