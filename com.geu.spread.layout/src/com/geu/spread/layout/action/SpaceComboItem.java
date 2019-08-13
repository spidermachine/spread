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
 * cn.com.bankit.ide.common.auto.layout.action.SpaceComboItem.java
 * Created by 朱克平 @ 2012-5-18 下午3:17:13
 */

package cn.com.bankit.ide.common.auto.layout.action;

import java.io.IOException;

import org.eclipse.jface.action.ControlContribution;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

import cn.com.bankit.ide.common.auto.layout.ILayoutParameterUtil;
import cn.com.bankit.ide.common.auto.layout.LayoutMananger;
import cn.com.bankit.ide.common.auto.layout.LayoutPlugin;

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
public class SpaceComboItem extends ControlContribution
{

    protected Combo combo;

    public SpaceComboItem(String id)
    {
        super(id);
    }

    /**
     * @param parent
     * @return
     * @see org.eclipse.jface.action.ControlContribution#createControl(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected Control createControl(Composite parent)
    {
        combo = new Combo(parent, SWT.BORDER | SWT.READ_ONLY);
        parent.setLayout(new FillLayout());
        combo.setItems(new String[] { "10", "20", "30", "50", "100" });
        combo.addSelectionListener(new SelectionListener()
        {

            @Override
            public void widgetSelected(SelectionEvent e)
            {
                String value = combo.getText();
                int size = Integer.parseInt(value);
                ScopedPreferenceStore ps = (ScopedPreferenceStore) LayoutPlugin
                        .getINSTANCE().getPreferenceStore();
                ps.setValue(getId(), size);
                try
                {
                    ps.save();
                } catch (IOException e1)
                {
                    e1.printStackTrace();
                }

                LayoutMananger.INSTANCE.fireLayout(null);

            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e)
            {

            }
        });
        if (getId() == ILayoutParameterUtil.XSTEP)
        {
            combo.setText(ILayoutParameterUtil.INSTANCE.getXStep() + "");
            combo.setToolTipText("流程水平间距");
        } else
        {
            combo.setText(ILayoutParameterUtil.INSTANCE.getYStep() + "");
            combo.setToolTipText("流程竖直间距");
        }
        return combo;
    }

}
