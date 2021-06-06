package com.core.backend.service.list;

import com.core.components.TreeComponent;

import java.util.List;

public class EntityList {
    private EntityListContent content;
    private TreeComponent treeComponent;
    private View view;

    public EntityList(){}

    public EntityList(EntityListContent content, View view) {
        this.content = content;
        this.view = view;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public EntityListContent getContent() {
        return content;
    }

    public void setContent(EntityListContent content) {
        this.content = content;
    }

    public TreeComponent getTreeComponent() {
        return treeComponent;
    }

    public void setTreeComponent(TreeComponent treeComponent) {
        this.treeComponent = treeComponent;
    }
}
