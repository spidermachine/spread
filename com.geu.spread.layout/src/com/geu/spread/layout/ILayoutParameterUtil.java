
package com.geu.spread.layout;

public interface ILayoutParameterUtil
{

    final ILayoutParameterUtil INSTANCE = new LayoutParameter();

    String XSTEP = "x step";

    String YSTEP = "y step";


    int getYStep();

    int getXStep();

}
