package com.core.components.form.field;

import com.core.components.utils.WebComponent;

public class ListFieldForm extends FieldForm{
    private FieldView modeView;
    public ListType listType;
    public Object instance;

    public ListFieldForm(String id, String label, Integer group, FieldView view, Class instance){
        super(id, label, group, FieldFormType.LIST);
        if(instance != null)
        {
            String instanceName = instance.getName();
            if(instanceName != null)
            {
                try {
                    this.instance = Class.forName(instanceName).getDeclaredConstructor().newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (Exception e)
                {

                }
            }
        }
    }

    public ListFieldForm(String id, String label, Integer group, FieldView modeView){
        super(id, label, group, FieldFormType.LIST);
        this.setWebComponentByString(id);
    }

    public ListFieldForm(String id, String label, Integer group, FieldView modeView, ListType listType){
        super(id, label, group, FieldFormType.LIST);
        this.modeView = modeView;
        this.listType = listType;
        this.setWebComponentByString(id);
    }

    public ListFieldForm(String id, String label, Integer group, FieldView modeView, ListType listType, Class instance){
        super(id, label, group, FieldFormType.LIST);
        this.modeView = modeView;
        this.listType = listType;
        this.instance = instance.getSimpleName();
        this.setWebComponentByString(id);
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

    public Object getInstance() {
        return instance;
    }

    public void setInstance(String instance) {
        this.instance = instance;
    }

    public void setWebComponentByString(String component)
    {
        try
        {
            WebComponent webComponent = WebComponent.valueOf(component);
            super.setWebComponent(webComponent);
        }
        catch(Exception e)
        {
            System.out.println("error creating web component");
        }
    }
}
