/**
 * Special Declaration: These technical material reserved as the technical 
 * secrets by Bankit TECHNOLOGY have been protected by the "Copyright Law" 
 * "ordinances on Protection of Computer Software" and other relevant 
 * administrative regulations and international treaties. Without the written 
 * permission of the Company, no person may use (including but not limited to 
 * the illegal copy, distribute, display, image, upload, and download) and 
 * disclose the above technical documents to any third party. Otherwise, any 
 * infringer shall afford the legal liability to the company.
 *
 * 特别声明：本技术材料受《中华人民共和国著作权法》、《计算机软件保护条例》
 * 等法律、法规、行政规章以及有关国际条约的保护，浙江宇信班克信息技术有限公
 * 司享有知识产权、保留一切权利并视其为技术秘密。未经本公司书面许可，任何人
 * 不得擅自（包括但不限于：以非法的方式复制、传播、展示、镜像、上载、下载）使
 * 用，不得向第三方泄露、透露、披露。否则，本公司将依法追究侵权者的法律责任。
 * 特此声明！
 *
 * Copyright(C) 2012 Bankit Tech, All rights reserved.
 */

/*
 * cn.com.bankit.ide.bap.auto.layout.model.TreeNode.java
 * Created by 朱克平 @ 2012-5-14 上午10:28:38
 */

package cn.com.bankit.ide.common.auto.layout.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.geometry.Rectangle;

import cn.com.bankit.ide.common.diagram.model.CommonNodeModel;

/**
* <DL>
* <DT><B> 标题. </B></DT>
* <p>
* <DD>详细介绍</DD>
* </DL>
* <p>
* 
* <DL>
* <DT><B>使用范例</B></DT>
* <p>
* <DD>使用范例说明</DD>
* </DL>
* <p>
* 
* @author 朱克平 $Author$
* @author 浙江宇信班克信息技术有限公司
* @version $Id$
*/
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
