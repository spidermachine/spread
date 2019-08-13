package com.geu.spread.layout;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class LayoutPlugin extends AbstractUIPlugin
{

    private static LayoutPlugin INSTANCE;

    /**
     * @return 返回字段iNSTANCE的值.
     */
    public static LayoutPlugin getINSTANCE()
    {
        return INSTANCE;
    }

    /**
     * @param context
     * @throws Exception
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start(BundleContext context) throws Exception
    {
        // TODO Auto-generated method stub
        super.start(context);
        INSTANCE = this;
    }

}
