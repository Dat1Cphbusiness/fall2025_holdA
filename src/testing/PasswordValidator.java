package testing;

/**
 * Klasse som bruges til at validere passwords.
 * @author Signe
 *
 */
public class PasswordValidator {

    /** Password skal være minimum 8 karakterer, maximum 15 og
    * indeholde mindst et bogstav
    * @param password der skal tjekkes
    * @return true hvis password opfylder alle krav. Ellers false
     * @throws NullPointerException hvis psw er null
    */
    public static boolean validate(String psw){
        if(psw == null) return false;
        if(psw.length() < 8) return false;
        if(psw.length() > 15) return false;
        if (!psw.matches(".*[a-zA-Z].*")) return false;

        return true;
    }

    @Deprecated
    public static boolean oldValidator(String psw){
        if(psw != null) return true;
        return false;
    }
}
