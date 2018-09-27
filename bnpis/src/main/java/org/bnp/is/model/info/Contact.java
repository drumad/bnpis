package org.bnp.is.model.info;

public class Contact {

    private Integer countryCode;

    private Integer areaCode;

    private Integer prefix;

    private Integer lineNumber;

    private Integer extension;

    private Contact() {
        countryCode = null;
        areaCode = null;
        prefix = null;
        lineNumber = null;
        extension = null;
    }

    public Integer getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Integer countryCode) {
        this.countryCode = countryCode;
    }

    public Integer getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }

    public Integer getPrefix() {
        return prefix;
    }

    public void setPrefix(Integer prefix) {
        this.prefix = prefix;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Integer getExtension() {
        return extension;
    }

    public void setExtension(Integer extension) {
        this.extension = extension;
    }
}
