package com.core.components.list;

import com.core.components.form.field.FieldView;
import com.core.components.form.field.ListType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface isFieldList {
    ListModule isVisible();
    String label();
}
