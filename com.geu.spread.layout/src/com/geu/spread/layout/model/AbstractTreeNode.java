
package com.geu.spread.layout.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.geometry.Rectangle;

public abstract class AbstractTreeNode
{
    protected CommonNodeModel model;
    
    protected AbstractTreeNode parent;

    protected List<AbstractTreeNode> children = new ArrayList<AbstractTreeNode>();

    protected Rectangle region = new Rectangle();


    /**
     * @return 返回字段parent的值.
     */
    public AbstractTreeNode getParent()
    {
        return parent;
    }

    /**
     * @param parent 用以设置字段parent的值.
     */
    public void setParent(AbstractTreeNode parent)
    {
        this.parent = parent;
    }

    /**
     * @return 返回字段model的值.
     */
    public CommonNodeModel getModel()
    {
        return model;
    }

    /**
     * @param model 用以设置字段model的值.
     */
    public void setModel(CommonNodeModel model)
    {
        this.model = model;
    }

    /**
     * @return 返回字段children的值.
     */
    public List<AbstractTreeNode> getChildren()
    {
        return children;
    }

    /**
     * @param children 用以设置字段children的值.
     */
    public void setChildren(List<AbstractTreeNode> children)
    {
        this.children = children;
    }

    public void addChild(AbstractTreeNode child)
    {
        if (!this.children.contains(child))
        {
            child.setParent(this);
            this.children.add(child);
        }
    }

    public void removeChild(AbstractTreeNode child)
    {
        if (this.children.contains(child))
        {
            child.setParent(null);
            this.children.remove(child);
        }
    }

    public abstract Rectangle getRegion();
  

    //采用分制策略去设计算法
    public abstract void setRegion(Rectangle region,
            Map<CommonNodeModel, Rectangle> result);

    //设置区域之后的值
    public Rectangle getBounds()
    {
        return region;
    }

}
