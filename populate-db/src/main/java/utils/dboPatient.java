package utils;

public class dboPatient {

    private String ID_PATIENT;
    private String FIRST_NAME;
    private String LAST_NAME;
    private String AGE;
    private String GENDER;
    private String PHONE_NUMBER;

    public void setID_PATIENT(String ID_PATIENT) {
        this.ID_PATIENT = ID_PATIENT;
    }

    public void setFIRST_NAME(String FIRST_NAME) {
        this.FIRST_NAME = FIRST_NAME;
    }

    public void setLAST_NAME(String LAST_NAME) {
        this.LAST_NAME = LAST_NAME;
    }

    public void setAGE(String AGE) {
        this.AGE = AGE;
    }

    public void setGENDER(String GENDER){
        this.GENDER = GENDER;
    }
    public void  setPHONE_NUMBER(String PHONE_NUMBER){
        this.PHONE_NUMBER = PHONE_NUMBER;
    }

    public String getID_PATIENT() {
        return ID_PATIENT;
    }

    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    public String getLAST_NAME() {
        return LAST_NAME;
    }

    public String getAGE() {
        return AGE;
    }

    public String getGENDER() {
        return GENDER;
    }

    public String getPHONE_NUMBER() {
        return PHONE_NUMBER;
    }
}
