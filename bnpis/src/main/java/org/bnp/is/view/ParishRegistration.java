package org.bnp.is.view;

import org.bnp.is.controller.ParishController;
import org.bnp.is.view.custom.SuggestiveText;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import java.util.Map;

public class ParishRegistration {

    private Button addBtn;

    private Button closeBtn;

    private Combo parishCountryCmb;

    private Display display;

    private ParishController controller;

    private Shell shell;

    private SuggestiveText parishAddressTxt;

    private SuggestiveText parishCityTxt;

    private SuggestiveText parishStateTxt;

    private SuggestiveText parishTxt;

    private SuggestiveText parishZipTxt;

    public ParishRegistration() {
        controller = new ParishController();
        init();
    }

    public void init() {
        display = new Display();

        shell = new Shell(display, SWT.TITLE | SWT.CLOSE | SWT.MIN );

        shell.setSize(390, 280);
        shell.setText("Parish Registration");

        initParishInfoContent(shell);

        RowLayout layout = new RowLayout(SWT.VERTICAL);

        shell.setLayout(layout);
    }

    private void initParishInfoContent(Shell shell) {
        Label label;
        RowData rd;
        Composite composite;
        RowLayout clayout = new RowLayout(SWT.HORIZONTAL);

        RowData labelrd = new RowData();
        labelrd.width = 90;

        composite = new Composite(shell, SWT.NONE);
        composite.setLayout(clayout);

        label = new Label(composite, SWT.NONE);
        label.setText("Parish:");
        label.setLayoutData(labelrd);

        rd = new RowData();
        rd.width = 250;
        parishTxt = new SuggestiveText(composite, SWT.BORDER, "Parish");
        parishTxt.setLayoutData(rd);

        // Parish Address
        composite = new Composite(shell, SWT.NONE);
        composite.setLayout(clayout);

        label = new Label(composite, SWT.NONE);
        label.setText("Address:");
        label.setLayoutData(labelrd);

        rd = new RowData();
        rd.width = 250;
        parishAddressTxt = new SuggestiveText(composite, SWT.BORDER, "Address");
        parishAddressTxt.setLayoutData(rd);

        // City
        composite = new Composite(shell, SWT.NONE);
        composite.setLayout(clayout);

        label = new Label(composite, SWT.NONE);
        label.setText("City:");
        label.setLayoutData(labelrd);

        rd = new RowData();
        rd.width = 250;
        parishCityTxt = new SuggestiveText(composite, SWT.BORDER, "City");
        parishCityTxt.setLayoutData(rd);

        // State / Province
        composite = new Composite(shell, SWT.NONE);
        composite.setLayout(clayout);

        label = new Label(composite, SWT.NONE);
        label.setText("State / Province:");
        label.setLayoutData(labelrd);

        rd = new RowData();
        rd.width = 250;
        parishStateTxt = new SuggestiveText(composite, SWT.BORDER, "State / Province");
        parishStateTxt.setLayoutData(rd);

        // Zip
        composite = new Composite(shell, SWT.NONE);
        composite.setLayout(clayout);

        label = new Label(composite, SWT.NONE);
        label.setText("Zip:");
        label.setLayoutData(labelrd);

        rd = new RowData();
        rd.width = 250;
        parishZipTxt = new SuggestiveText(composite, SWT.BORDER, "Zip");
        parishZipTxt.setLayoutData(rd);

        // Country
        composite = new Composite(shell, SWT.NONE);
        composite.setLayout(clayout);

        label = new Label(composite, SWT.NONE);
        label.setText("Country:");
        label.setLayoutData(labelrd);

        Map<Integer, String> map = controller.getCountryMap();

        rd = new RowData();
        rd.width = 235;
        parishCountryCmb = new Combo(composite, SWT.BORDER | SWT.READ_ONLY);
        parishCountryCmb.add("---------", 0);
        if ( map != null ) {
            for ( Map.Entry<Integer, String> entry : map.entrySet() ) {
                parishCountryCmb.add(entry.getValue(), entry.getKey());
            }
        }
        parishCountryCmb.select(0);
        parishCountryCmb.setLayoutData(rd);

        // Buttons
        clayout = new RowLayout();
        clayout.center = true;
        clayout.marginTop = 20;
        clayout.marginLeft = 206;
        composite = new Composite(shell, SWT.NONE);
        composite.setLayout(clayout);

        rd = new RowData();
        rd.width = 75;
        addBtn = new Button(composite, SWT.PUSH);
        addBtn.setText("&Add Parish");
        addBtn.setLayoutData(rd);
        shell.setDefaultButton(addBtn);

        addBtn.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {

            }
        });

        rd = new RowData();
        rd.width = 75;
        closeBtn = new Button(composite, SWT.PUSH);
        closeBtn.setText("&Close");
        closeBtn.setLayoutData(rd);

        closeBtn.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                shell.dispose();
            }
        });
    }

    public void setParishAddressTxt(String parishAddress) {
        this.parishAddressTxt.setText(parishAddress);
    }

    public String getParishAddressTxt() {
        return parishAddressTxt.getText();
    }

    public void setParishCityTxt(String parishCity) {
        this.parishCityTxt.setText(parishCity);
    }

    public String getParishCityTxt() {
        return parishCityTxt.getText();
    }

    public void setParishCountryCmb(Integer index) {
        this.parishCountryCmb.select(index);
    }

    public void setParishCountryCmb(String name) {
        Map<Integer, String> map = controller.getCountryMap();
        int index = 0;

        if ( map != null ) {
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                if ( entry.getValue().equalsIgnoreCase(name.trim()) ) {
                    index = entry.getKey();
                }
            }
        }

        this.parishCountryCmb.select(index);
    }

    public Integer getParishCountryCmb() {
        return parishCountryCmb.getSelectionIndex();
    }

    public void setParishStateTxt(String parishState) {
        this.parishStateTxt.setText(parishState);
    }

    public String getParishStateTxt() {
        return parishStateTxt.getText();
    }

    public void setParishTxt(String parish) {
        this.parishTxt.setText(parish);
    }

    public String getParishTxt() {
        return parishTxt.getText();
    }

    public void setParishZipTxt(String parishZip) {
        this.parishZipTxt.setText(parishZip);
    }

    public String getParishZipTxt() {
        return parishZipTxt.getText();
    }

    public void openView() {
        if ( shell == null )
            return;

        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    public static void main(String[] args) {
        new ParishRegistration();
    }
}
