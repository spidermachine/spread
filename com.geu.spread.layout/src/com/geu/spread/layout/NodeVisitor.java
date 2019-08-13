package com.geu.spread.layout;

import java.util.ArrayList;
import java.util.List;

import cn.com.bankit.ide.common.auto.layout.model.AbstractTreeNode;
import cn.com.bankit.ide.common.diagram.model.CommonLinkModel;
import cn.com.bankit.ide.common.diagram.model.CommonNodeModel;

public abstract class NodeVisitor
{

    /**
     * 
     * 
     * @param parent
     * @param comparator
     * @param visitedType
     *                           true 深度优先，false广度优先
     * @return
     */
    public AbstractTreeNode visitor(CommonNodeModel parent, boolean visitedType)
    {
        AbstractTreeNode root =getRoot(parent);
        List<CommonNodeModel> visited = new ArrayList<CommonNodeModel>();
        visited.add(root.getModel());
        if (visitedType)
            buildTreeDeep(visited, root);
        else
            buildTreeWide(visited, root);
        return root;

    }
    
    protected abstract AbstractTreeNode getRoot(CommonNodeModel parent);

    protected abstract void sortLink(List<CommonLinkModel> links,
            CommonNodeModel model);

    protected abstract AbstractTreeNode getNewNode();

    protected void buildTreeDeep(List<CommonNodeModel> visited,
    /* List<TreeNode> path */AbstractTreeNode parent)
    {

        //对连线排序
        List<CommonLinkModel> links = parent.getModel().getSources();

        if (links.size() > 1)
        {

            sortLink(links, parent.getModel());
        }

        //深度优先
        for (CommonLinkModel link : links)
        {
            CommonNodeModel subModel = link.getTarget();
            //没有遍历过
            if (!visited.contains(subModel))
            {
                visited.add(subModel);
                AbstractTreeNode tn = getNewNode();

                tn.setModel(subModel);
                parent.addChild(tn);
                buildTreeDeep(visited, tn);
            }
        }

      

    }

    //广度优先
    protected void buildTreeWide(List<CommonNodeModel> visited,
    AbstractTreeNode parent)
    {

        //对连线排序
        List<CommonLinkModel> links = parent.getModel().getSources();

        if (links.size() > 1)
        {

            sortLink(links, parent.getModel());
        }

        for (CommonLinkModel link : links)
        {
            CommonNodeModel subModel = link.getTarget();
            //没有遍历过
            if (!visited.contains(subModel))
            {
                visited.add(subModel);
                AbstractTreeNode tn = getNewNode();
                tn.setModel(subModel);
                parent.addChild(tn);
            }
        }

        for (AbstractTreeNode tn : parent.getChildren())
        {
            buildTreeWide(visited, tn);
        }

    }

}
