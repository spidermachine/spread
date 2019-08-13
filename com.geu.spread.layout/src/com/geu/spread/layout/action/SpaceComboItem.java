package com.geu.spread.layout.action;

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

import com.geu.spread.layout.ILayoutParameterUtil;
import com.geu.spread.layout.LayoutMananger;
import com.geu.spread.layout.LayoutPlugin;

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
