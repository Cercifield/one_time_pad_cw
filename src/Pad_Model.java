public class Pad_Model {

    private String fixedPad = "FesterPadStringDerDenRichtlinienEntsprichtUndAusreichendLangIst";

        public String encrypt(String message, String pad) {
            if (!isValidInput(message) || !isValidInput(pad)) {
                throw new IllegalArgumentException("Text und Pad dürfen nur ASCII-Zeichen zwischen 0x20 und 0x7E enthalten.");
            }

            char[] messageChars = message.toCharArray();
            char[] padChars = pad.toCharArray();

            if (padChars.length < messageChars.length) {
                throw new IllegalArgumentException("Das Pad muss mindestens so lang sein wie die Nachricht.");
            }

            char[] encryptedChars = new char[messageChars.length];
            for (int i = 0; i < messageChars.length; i++) {
                int messageVal = messageChars[i] - 0x20;
                int padVal = padChars[i] - 0x20;
                int encryptedVal = (messageVal + padVal) % 95; // Falls Summe > 94, subtrahieren wir 95
                encryptedChars[i] = (char) (encryptedVal + 0x20);
            }

            return new String(encryptedChars);
        }

        public String decrypt(String encryptedMessage, String pad) {
            if (!isValidInput(encryptedMessage) || !isValidInput(pad)) {
                throw new IllegalArgumentException("Verschlüsselter Text und Pad dürfen nur ASCII-Zeichen zwischen 0x20 und 0x7E enthalten.");
            }

            char[] encryptedChars = encryptedMessage.toCharArray();
            char[] padChars = pad.toCharArray();

            if (padChars.length < encryptedChars.length) {
                throw new IllegalArgumentException("Das Pad muss mindestens so lang sein wie die verschlüsselte Nachricht.");
            }

            char[] decryptedChars = new char[encryptedChars.length];
            for (int i = 0; i < encryptedChars.length; i++) {
                int encryptedVal = encryptedChars[i] - 0x20;
                int padVal = padChars[i] - 0x20;
                int decryptedVal = (encryptedVal - padVal + 95) % 95; // Falls Differenz negativ, addieren wir 95
                decryptedChars[i] = (char) (decryptedVal + 0x20);
            }

            return new String(decryptedChars);
        }
    public String getFixedPad() {
        return fixedPad;
    }
        private boolean isValidInput(String input) {
            return input.chars().allMatch(c -> c >= 0x20 && c <= 0x7E);
        }
    }
