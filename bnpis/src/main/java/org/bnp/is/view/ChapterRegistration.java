package org.bnp.is.view;

import org.bnp.is.model.info.Chapter;
import org.bnp.is.view.custom.SuggestiveText;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class ChapterRegistration {

    private Chapter chapterInfo;

    private Display display;

    private Shell shell;

    private Button addBtn;

    private Button closeBtn;

    private SuggestiveText chapterAddressTxt;

    private SuggestiveText chapterCityTxt;

    private SuggestiveText chapterStateTxt;

    private SuggestiveText chapterTxt;

    private SuggestiveText chapterZipTxt;

    private DateTime chapterStartDate;

    private static ChapterRegistration instance = new ChapterRegistration();

    private ChapterRegistration() {
        this(null);
    }

    private ChapterRegistration(Chapter chapterInfo) {
        setChapterInfo(chapterInfo);
        init();
    }

    public void setChapterInfo(Chapter chapterInfo) {
        this.chapterInfo = chapterInfo;
    }

    public Chapter getChapterInfo() {
        return chapterInfo;
    }

    public static ChapterRegistration getInstance() {
        return instance;
    }

    public void init() {
        display = new Display();

        shell = new Shell(display, SWT.TITLE | SWT.CLOSE | SWT.MIN );

        shell.setSize(390, 280);
        shell.setText("Chapter Registration");

        initChapterInfoContent(shell);

        RowLayout layout = new RowLayout(SWT.VERTICAL);

        shell.setLayout(layout);

        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    private void initChapterInfoContent(Shell shell) {
        Label label;
        RowData rd;
        Composite composite;
        RowLayout clayout = new RowLayout(SWT.HORIZONTAL);

        RowData labelrd = new RowData();
        labelrd.width = 90;

        composite = new Composite(shell, SWT.NONE);
        composite.setLayout(clayout);

        label = new Label(composite, SWT.NONE);
        label.setText("Chapter:");
        label.setLayoutData(labelrd);

        rd = new RowData();
        rd.width = 250;
        chapterTxt = new SuggestiveText(composite, SWT.BORDER, "Chapter");
        chapterTxt.setLayoutData(rd);

        // Chapter Address
        composite = new Composite(shell, SWT.NONE);
        composite.setLayout(clayout);

        label = new Label(composite, SWT.NONE);
        label.setText("Address:");
        label.setLayoutData(labelrd);

        rd = new RowData();
        rd.width = 250;
        chapterAddressTxt = new SuggestiveText(composite, SWT.BORDER, "Address");
        chapterAddressTxt.setLayoutData(rd);

        // City
        composite = new Composite(shell, SWT.NONE);
        composite.setLayout(clayout);

        label = new Label(composite, SWT.NONE);
        label.setText("City:");
        label.setLayoutData(labelrd);

        rd = new RowData();
        rd.width = 250;
        chapterCityTxt = new SuggestiveText(composite, SWT.BORDER, "City");
        chapterCityTxt.setLayoutData(rd);

        // State / Province
        composite = new Composite(shell, SWT.NONE);
        composite.setLayout(clayout);

        label = new Label(composite, SWT.NONE);
        label.setText("State / Province:");
        label.setLayoutData(labelrd);

        rd = new RowData();
        rd.width = 250;
        chapterStateTxt = new SuggestiveText(composite, SWT.BORDER, "State / Province");
        chapterStateTxt.setLayoutData(rd);

        // Zip
        composite = new Composite(shell, SWT.NONE);
        composite.setLayout(clayout);

        label = new Label(composite, SWT.NONE);
        label.setText("Zip:");
        label.setLayoutData(labelrd);

        rd = new RowData();
        rd.width = 250;
        chapterZipTxt = new SuggestiveText(composite, SWT.BORDER, "Zip");
        chapterZipTxt.setLayoutData(rd);

        // Start Date
        composite = new Composite(shell, SWT.NONE);
        composite.setLayout(clayout);

        label = new Label(composite, SWT.NONE);
        label.setText("Start Date:");
        label.setLayoutData(labelrd);

        rd = new RowData();
        rd.width = 262;
        chapterStartDate = new DateTime(composite, SWT.BORDER);
        chapterStartDate.setLayoutData(rd);

        // Buttons
        clayout = new RowLayout();
        clayout.center = true;
        clayout.marginTop = 20;
        clayout.marginLeft = 201;
        composite = new Composite(shell, SWT.NONE);
        composite.setLayout(clayout);

        rd = new RowData();
        rd.width = 80;
        addBtn = new Button(composite, SWT.PUSH);
        addBtn.setText("&Add Chapter");
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

    public static void main(String[] args) {
        ChapterRegistration.getInstance();
    }
}
