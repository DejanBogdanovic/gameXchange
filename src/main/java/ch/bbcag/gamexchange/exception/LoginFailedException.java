package ch.bbcag.gamexchange.exception;

/**
 * This exception is thrown if user login has failed.
 */
public class LoginFailedException extends Exception {

  private static final long serialVersionUID = -5630015745792204357L;
  private static final String ERROR_MSG = "Benutzer existiert nicht oder falsches Passwort eingegeben";

  /**
   * Creates an instance of {@link LoginFailedException} and initializes it.
   */
  public LoginFailedException() {
    super(ERROR_MSG);
  }
}