package org.bnp.is.view.custom;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.awt.*;

public class SuggestiveText extends Text {

    private String defaultText;

    private Color defaultFg;

    private Color textFg;

    private boolean contactNumbersOnly = false;

    private boolean numbersOnly = false;

    private VerifyListener contactNumberVerify;

    private VerifyListener numberVerify;

    public SuggestiveText(Shell shell, int style, String defaultText) {
        super(shell, style);

        this.defaultText = defaultText;
        defaultFg = new Color(shell.getDisplay().getCurrent(), 220, 220, 220);
        textFg = new Color(shell.getDisplay().getCurrent(), 0, 0, 0);

        this.setForeground(defaultFg);
        this.setText(this.defaultText);

        this.addListener(SWT.FocusIn, (var e) -> {
            if ( this.isEmpty() ) {
                this.setText("");
                this.setForeground(textFg);
                this.redraw();
            }
        });

        this.addListener(SWT.FocusOut, (var e) -> {
           if ( this.getText().isEmpty() ) {
               this.setText(defaultText);
               this.setForeground(defaultFg);
           }
        });
    }

    public SuggestiveText(Composite composite, int style, String defaultText) {
        super(composite, style);

        this.defaultText = defaultText;
        defaultFg = new Color(composite.getDisplay().getCurrent(), 220, 220, 220);
        textFg = new Color(composite.getDisplay().getCurrent(), 0, 0, 0);

        this.setForeground(defaultFg);
        this.setText(this.defaultText);

        this.addListener(SWT.FocusIn, (var e) -> {
            if ( this.isEmpty() ) {
                this.setText("");
                this.setForeground(textFg);
            }

            if ( contactNumbersOnly && contactNumberVerify != null ) {
                this.addVerifyListener(contactNumberVerify);
            }

            if ( numbersOnly && numberVerify != null ) {
                this.addVerifyListener(numberVerify);
            }
        });

        this.addListener(SWT.FocusOut, (var e) -> {
            if ( contactNumbersOnly && contactNumberVerify != null ) {
                this.removeVerifyListener(contactNumberVerify);
            }

            if ( numbersOnly && numberVerify != null ) {
                this.removeVerifyListener(numberVerify);
            }

            if ( this.getText().isEmpty() ) {
                this.setText(defaultText);
                this.setForeground(defaultFg);
            }
        });
    }

    public String getDefaultText() {
        return defaultText;
    }

    public void setDefaultText(String defaultText) {
        this.defaultText = defaultText;
    }

    public boolean isEmpty() {
        return this.getForeground().equals(defaultFg) && this.getText().equals(defaultText);
    }

    public void setContactNumbersOnly(boolean set) {
        contactNumbersOnly = set;

        if ( numbersOnly && set ) {
            numbersOnly = false;
        }

        if (contactNumbersOnly) {
            if ( contactNumberVerify == null ) {
                contactNumberVerify = (var e) -> {
                    if (!Character.isDigit(e.character) && e.character != '-' && e.character != '\b') {
                        e.doit = false;
                        Toolkit.getDefaultToolkit().beep();
                    }
                };
            }
        } else {
            if ( contactNumberVerify != null ) {
                this.removeVerifyListener(contactNumberVerify);
                contactNumberVerify = null;
            }
        }
    }

    public void setNumbersOnly(boolean set) {
        numbersOnly = set;

        if ( contactNumbersOnly && set ) {
            contactNumbersOnly = false;
        }

        if ( numbersOnly ) {
            if ( numberVerify == null ) {
                numberVerify = (var e) -> {
                    if (!Character.isDigit(e.character) && e.character != '\b') {
                        e.doit = false;
                        Toolkit.getDefaultToolkit().beep();
                    }
                };
            }
        } else {
            if ( numberVerify != null ) {
                this.removeVerifyListener(contactNumberVerify);
                numberVerify = null;
            }
        }
    }

    @Override
    protected void checkSubclass() {

    }
}
