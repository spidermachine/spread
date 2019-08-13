package com.geu.spread.layout;

class LayoutParameter implements ILayoutParameterUtil
{

    @Override
    public int getYStep()
    {
        int y = LayoutPlugin.getINSTANCE().getPreferenceStore().getInt(YSTEP);
        if (y == 0)
            return 30;
        return y;
    }

    @Override
    public int getXStep()
    {
        int x = LayoutPlugin.getINSTANCE().getPreferenceStore().getInt(XSTEP);
        if (x == 0)
            return 30;
        return x;
    }

}
