package com.core.components.form.field;

public class ListFieldForm extends FieldForm{
    private FieldView modeView;
    public ListType listType;

    public ListFieldForm(String id, String label, String group){
        super(id, label, group, FieldFormType.LIST);
    }

    public ListFieldForm(String id, String label, String group, FieldView modeView){
        super(id, label, group, FieldFormType.LIST);
    }

    public ListFieldForm(String id, String label, String group, FieldView modeView, ListType listType){
        super(id, label, group, FieldFormType.LIST);
        this.modeView = modeView;
        this.listType = listType;
    }

    public FieldView getModeView() {
        return modeView;
    }

    public void setModeView(FieldView modeView) {
        this.modeView = modeView;
    }

    public ListType getListType() {
        return listType;
    }

    public void setListType(ListType listType) {
        this.listType = listType;
    }
}
