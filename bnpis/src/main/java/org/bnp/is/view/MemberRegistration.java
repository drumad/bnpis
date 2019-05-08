package org.bnp.is.view;

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


public class MemberRegistration {

    private Display display;

    private Shell shell;

    private static MemberRegistration instance = new MemberRegistration();

    private SuggestiveText classNoTxt;

    private SuggestiveText lastNameTxt;

    private SuggestiveText firstNameTxt;

    private SuggestiveText middleNameTxt;

    private SuggestiveText addressTxt;

    private SuggestiveText cityTxt;

    private SuggestiveText stateTxt;

    private SuggestiveText zipTxt;

    private SuggestiveText homePhoneTxt;

    private SuggestiveText workPhoneTxt;

    private SuggestiveText cellularTxt;

    private SuggestiveText emailTxt;

    private DateTime bdayTxt;

    private SuggestiveText ageTxt;

    private Combo genderTxt;

    private Combo maritalStatusTxt;

    private Combo educationTxt;

    private SuggestiveText religionTxt;

    private SuggestiveText parishTxt;

    private SuggestiveText parishAddressTxt;

    private SuggestiveText parishCityTxt;

    private SuggestiveText parishStateTxt;

    private SuggestiveText parishZipTxt;

    private MemberRegistration() {
        init();
    }

    public static MemberRegistration getInstance() {
        return instance;
    }

    private void init() {
        display = new Display();

        shell = new Shell(display, SWT.TITLE | SWT.CLOSE | SWT.MIN );

        shell.setSize(625, 600);
        shell.setMinimumSize(625, 500);
        shell.setText("Member Registration");

        initMemberInfoContent(shell);

        RowLayout layout = new RowLayout(SWT.VERTICAL);

        shell.setLayout(layout);

        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    private void initMemberInfoContent(Shell shell) {
        Label label;
        RowData rd;
        Composite parent;
        Composite composite;
        RowLayout clayout = new RowLayout(SWT.HORIZONTAL);

        RowData labelrd = new RowData();
        labelrd.width = 100;

        RowData plabelrd = new RowData();
        plabelrd.width = 95;

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

        // Name
        composite = new Composite(shell, SWT.NONE);
        composite.setLayout(clayout);

        label = new Label(composite, SWT.NONE);
        label.setText("Name:");
        label.setLayoutData(labelrd);

        rd = new RowData();
        rd.width = 150;
        lastNameTxt = new SuggestiveText(composite, SWT.BORDER, "Last");
        lastNameTxt.setLayoutData(rd);

        rd = new RowData();
        rd.width = 200;
        firstNameTxt = new SuggestiveText(composite, SWT.BORDER, "First");
        firstNameTxt.setLayoutData(rd);

        rd = new RowData();
        rd.width = 100;
        middleNameTxt = new SuggestiveText(composite, SWT.BORDER, "Middle");
        middleNameTxt.setLayoutData(rd);

        // Address
        composite = new Composite(shell, SWT.NONE);
        composite.setLayout(clayout);

        label = new Label(composite, SWT.NONE);
        label.setText("Address:");
        label.setLayoutData(labelrd);

        rd = new RowData();
        rd.width = 480;
        addressTxt = new SuggestiveText(composite, SWT.BORDER, "Address");
        addressTxt.setLayoutData(rd);

        // Address 2nd line
        composite = new Composite(shell, SWT.NONE);
        composite.setLayout(clayout);

        label = new Label(composite, SWT.NONE);
        label.setLayoutData(labelrd);

        rd = new RowData();
        rd.width = 250;
        cityTxt = new SuggestiveText(composite, SWT.BORDER, "City");
        cityTxt.setLayoutData(rd);

        rd = new RowData();
        rd.width = 100;
        stateTxt = new SuggestiveText(composite, SWT.BORDER, "State / Province");
        stateTxt.setLayoutData(rd);

        rd = new RowData();
        rd.width = 100;
        zipTxt = new SuggestiveText(composite, SWT.BORDER, "Zip");
        zipTxt.setLayoutData(rd);

        // Contact Numbers
        composite = new Composite(shell, SWT.NONE);
        composite.setLayout(clayout);

        label = new Label(composite, SWT.NONE);
        label.setText("Contact Numbers:");
        label.setLayoutData(labelrd);

        rd = new RowData();
        rd.width = 100;
        homePhoneTxt = new SuggestiveText(composite, SWT.BORDER, "Home");
        homePhoneTxt.setContactNumbersOnly(true);
        homePhoneTxt.setLayoutData(rd);

        rd = new RowData();
        rd.width = 100;
        workPhoneTxt = new SuggestiveText(composite, SWT.BORDER, "Work");
        workPhoneTxt.setContactNumbersOnly(true);
        workPhoneTxt.setLayoutData(rd);

        rd = new RowData();
        rd.width = 100;
        cellularTxt = new SuggestiveText(composite, SWT.BORDER, "Cellular");
        cellularTxt.setContactNumbersOnly(true);
        cellularTxt.setLayoutData(rd);

        // Email
        composite = new Composite(shell, SWT.NONE);
        composite.setLayout(clayout);

        label = new Label(composite, SWT.NONE);
        label.setText("Email:");
        label.setLayoutData(labelrd);

        rd = new RowData( );
        rd.width = 250;
        emailTxt = new SuggestiveText(composite, SWT.BORDER, "E-mail");
        emailTxt.setLayoutData(rd);

        // Gender
        composite = new Composite(shell, SWT.NONE);
        composite.setLayout(clayout);

        label = new Label(composite, SWT.NONE);
        label.setText("Gender:");
        label.setLayoutData(labelrd);

        rd = new RowData();
        rd.width = 50;
        genderTxt = new Combo(composite, SWT.BORDER | SWT.READ_ONLY);
        genderTxt.add("Male");
        genderTxt.add("Female");
        genderTxt.setLayoutData(rd);

        // Birthday
        composite = new Composite(shell, SWT.NONE);
        composite.setLayout(clayout);

        label = new Label(composite, SWT.NONE);
        label.setText("Date of Birth:");
        label.setLayoutData(labelrd);

        rd = new RowData();
        rd.width = 150;
        bdayTxt = new DateTime(composite, SWT.BORDER);
        bdayTxt.setLayoutData(rd);

        rd = new RowData();
        rd.width = 100;
        rd.height = 18;
        ageTxt = new SuggestiveText(composite, SWT.BORDER, "Age");
        ageTxt.setNumbersOnly(true);
        ageTxt.setLayoutData(rd);

        // Marital Status
        composite = new Composite(shell, SWT.NONE);
        composite.setLayout(clayout);

        label = new Label(composite, SWT.NONE);
        label.setText("Marital Status:");
        label.setLayoutData(labelrd);

        rd = new RowData();
        rd.width = 100;
        maritalStatusTxt = new Combo(composite, SWT.BORDER | SWT.READ_ONLY);
        maritalStatusTxt.add("Single");
        maritalStatusTxt.add("Married");
        maritalStatusTxt.add("Widowed");
        maritalStatusTxt.add("Separated");
        maritalStatusTxt.add("Divorced");
        maritalStatusTxt.setLayoutData(rd);

        // Education
        composite = new Composite(shell, SWT.NONE);
        composite.setLayout(clayout);

        label = new Label(composite, SWT.NONE);
        label.setText("Education:");
        label.setLayoutData(labelrd);

        rd = new RowData();
        rd.width = 100;
        educationTxt = new Combo(composite, SWT.BORDER | SWT.READ_ONLY);
        educationTxt.add("N/A");
        educationTxt.add("Elementary");
        educationTxt.add("Middle School");
        educationTxt.add("High School");
        educationTxt.add("Bachelor's");
        educationTxt.add("Master's");
        educationTxt.add("Doctorate");
        educationTxt.add("Professional");
        educationTxt.setLayoutData(rd);

        // Parish
        parent = new Composite(shell, SWT.BORDER);
        parent.setLayout(new RowLayout(SWT.VERTICAL));
        rd = new RowData();
        rd.width = 598;
        parent.setLayoutData(rd);

        composite = new Composite(parent, SWT.NONE);
        composite.setLayout(clayout);

        label = new Label(composite, SWT.NONE);
        label.setText("Religion:");
        label.setLayoutData(plabelrd);

        rd = new RowData();
        rd.width = 300;
        religionTxt = new SuggestiveText(composite, SWT.BORDER, "Religion");
        religionTxt.setLayoutData(rd);

        composite = new Composite(parent, SWT.NONE);
        composite.setLayout(clayout);

        label = new Label(composite, SWT.NONE);
        label.setText("Parish:");
        label.setLayoutData(plabelrd);

        rd = new RowData();
        rd.width = 475;
        parishTxt = new SuggestiveText(composite, SWT.BORDER, "Parish");
        parishTxt.setLayoutData(rd);

        // Parish Address
        composite = new Composite(parent, SWT.NONE);
        composite.setLayout(clayout);

        label = new Label(composite, SWT.NONE);
        label.setText("Address:");
        label.setLayoutData(plabelrd);

        rd = new RowData();
        rd.width = 475;
        parishAddressTxt = new SuggestiveText(composite, SWT.BORDER, "Address");
        parishAddressTxt.setLayoutData(rd);

        // Parish Address 2nd line
        composite = new Composite(parent, SWT.NONE);
        composite.setLayout(clayout);

        label = new Label(composite, SWT.NONE);
        label.setLayoutData(plabelrd);

        rd = new RowData();
        rd.width = 250;
        parishCityTxt = new SuggestiveText(composite, SWT.BORDER, "City");
        parishCityTxt.setLayoutData(rd);

        rd = new RowData();
        rd.width = 95;
        parishStateTxt = new SuggestiveText(composite, SWT.BORDER, "State / Province");
        parishStateTxt.setLayoutData(rd);

        rd = new RowData();
        rd.width = 100;
        parishZipTxt = new SuggestiveText(composite, SWT.BORDER, "Zip");
        parishZipTxt.setLayoutData(rd);
    }


    public static void main(String[] args) {
        MemberRegistration.getInstance();
    }
}
