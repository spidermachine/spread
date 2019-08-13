package com.geu.spread.layout;

import java.util.ArrayList;
import java.util.List;

import cn.com.bankit.ide.common.diagram.model.CommonNodeModel;

public class LayoutMananger
{
    private List<ILayoutListener> listeners = new ArrayList<ILayoutListener>();
    
    private LayoutMananger(){}
    
    public static final LayoutMananger INSTANCE =new LayoutMananger();

    public void addLayoutListener(ILayoutListener listener)
    {
        if (!listeners.contains(listener))
        {
            listeners.add(listener);
        }
    }

    public void removeLayoutListenerr(ILayoutListener listener)
    {
        if (listeners.contains(listener))
        {
            listeners.remove(listener);
        }
    }
    
    public void fireLayout(CommonNodeModel root){
        
        for(ILayoutListener listener:listeners){
            listener.layout(root);
        }
    }

}
