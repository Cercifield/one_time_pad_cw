public class Pad_Controller {
    private Pad_Model model;
    private Pad_View view;

    public Pad_Controller(Pad_Model model, Pad_View view) {
        this.model = model;
        this.view = view;

    }

    public void encryptMessage() {
        String message = view.getMessageInput();
        String pad = view.isPadLoadedFromFile() ? view.getPad() : model.getFixedPad();

        try {
            String encryptedMessage = model.encrypt(message, pad);
            view.setOutput(encryptedMessage);
        } catch (Exception e) {
            view.showError(e.getMessage());
        }
    }

    public void decryptMessage() {
        String encryptedMessage = view.getMessageInput();
        String pad = view.isPadLoadedFromFile() ? view.getPad() : model.getFixedPad();

        try {
            String decryptedMessage = model.decrypt(encryptedMessage, pad);
            view.setOutput(decryptedMessage);
        } catch (Exception e) {
            view.showError(e.getMessage());
        }
    }


}