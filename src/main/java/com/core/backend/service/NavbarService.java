package com.core.backend.service;

import com.core.components.nav.DropdownFieldNav;
import com.core.components.nav.FieldNav;
import com.core.components.nav.FieldNavInterface;
import com.core.components.nav.Navbar;
import com.core.components.translations.i18n.I18nUtils;
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
        fields.add(new FieldNav(I18nUtils.getString("start"),"fa fa-home", patternUrl.getHome()));
        fields.add(new FieldNav(I18nUtils.getString("salesportal"),"fa fa-cart-plus", patternUrl.getStoreSpace(), true, true));
        // FIXME arrumar link quando componente existir
        fields.add(new FieldNav(I18nUtils.getString("box"),"fa fa-folder-open-o", ""));
        fields.add(new FieldNav(I18nUtils.getString("payments"),"fa fa-credit-card-alt", ""));

        DropdownFieldNav dropdown = new DropdownFieldNav("Consultas", "fa fa-home");
        dropdown.addField(new FieldNav(I18nUtils.getString("customers"), patternUrl.getListRoute(patternUrl.getCustomer())));
        dropdown.addField(new FieldNav(I18nUtils.getString("products"), patternUrl.getListRoute(patternUrl.getProduct())));
        dropdown.addField(new FieldNav(I18nUtils.getString("providers"), patternUrl.getListRoute(patternUrl.getProvider())));
        dropdown.addField(new FieldNav(I18nUtils.getString("users"), patternUrl.getListRoute(patternUrl.getUser())));
        fields.add(dropdown);

        DropdownFieldNav dropdownMore = new DropdownFieldNav("Mais", "fa fa-plus");
        dropdownMore.addField(new FieldNav(I18nUtils.getString("birthdaypeoples")));
        fields.add(dropdownMore);
        fields.add(new FieldNav(I18nUtils.getString("exit"), "fa fa-sign-out"));
        navbar.setFields(fields);
        return navbar;
    }
}
