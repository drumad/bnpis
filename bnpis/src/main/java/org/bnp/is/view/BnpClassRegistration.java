package org.bnp.is.view;

import org.bnp.is.model.retreat.ClassInfo;
import org.bnp.is.view.custom.SuggestiveText;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class BnpClassRegistration {

    private Display display;

    private Shell shell;

    private static BnpClassRegistration instance = new BnpClassRegistration();

    private ClassInfo classInfo;

    private SuggestiveText classNoTxt;
    private DateTime beginDate;
    private DateTime endDate;
    private Combo classTypeCombo;

    private BnpClassRegistration() {
        this(null);
    }

    private BnpClassRegistration(ClassInfo classInfo) {
        setClassInfo(classInfo);
        init();
    }

    private void init() {
        display = new Display();

        shell = new Shell(display, SWT.TITLE | SWT.CLOSE | SWT.MIN );

        shell.setSize(500, 400);
        shell.setMinimumSize(400, 400);
        shell.setText("Class Registration");

        RowLayout layout = new RowLayout(SWT.VERTICAL);
        shell.setLayout(layout);

        initClassInfoContent(shell);

        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    private void initClassInfoContent(Shell shell) {
        Label label;
        RowData rd;
        Composite composite;
        RowLayout clayout = new RowLayout(SWT.HORIZONTAL);

        RowData labelrd = new RowData();
        labelrd.width = 100;

        // Class type
        composite = new Composite(shell, SWT.NONE);
        composite.setLayout(clayout);

        label = new Label(composite, SWT.NONE);
        label.setText("Class Type:");
        label.setLayoutData(labelrd);

        rd = new RowData();
        rd.width = 120;
        classTypeCombo = new Combo(composite, SWT.BORDER);
        classTypeCombo.add("Panawagan");
        classTypeCombo.add("Marian");
        classTypeCombo.add("Special");
        classTypeCombo.add("Little Lambs");
        classTypeCombo.add("Mission");
        classTypeCombo.add("Apostolic Mission");
        classTypeCombo.add("Regular");
        classTypeCombo.add("Youth Ministry");
        classTypeCombo.add("Spiritual Workshop");
        classTypeCombo.add("Munting Pagsasanay");
        classTypeCombo.setLayoutData(rd);

        // Class number
        composite = new Composite(shell, SWT.NONE);
        composite.setLayout(clayout);

        label = new Label(composite, SWT.NONE);
        label.setText("Class Number:");
        label.setLayoutData(labelrd);

        rd = new RowData();
        rd.width = 50;
        classNoTxt = new SuggestiveText(composite, SWT.BORDER, "#");
        classNoTxt.setLayoutData(rd);

        // Begin Date
        composite = new Composite(shell, SWT.NONE);
        composite.setLayout(clayout);

        label = new Label(composite, SWT.NONE);
        label.setText("Begin Date:");
        label.setLayoutData(labelrd);

        rd = new RowData();
        rd.width = 100;
        beginDate = new DateTime(composite, SWT.BORDER);
        beginDate.setLayoutData(rd);

        // End Date
        composite = new Composite(shell, SWT.NONE);
        composite.setLayout(clayout);

        label = new Label(composite, SWT.NONE);
        label.setText("Begin Date:");
        label.setLayoutData(labelrd);

        rd = new RowData();
        rd.width = 100;
        endDate = new DateTime(composite, SWT.BORDER);
        endDate.setLayoutData(rd);
    }

    public void setClassInfo(ClassInfo classInfo) {
        this.classInfo = classInfo;
    }

    public ClassInfo getClassInfo() {
        return classInfo;
    }

    public static BnpClassRegistration getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        BnpClassRegistration.getInstance();
    }
}
