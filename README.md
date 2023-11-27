# one_time_pad_cw
1. Einleitung
Diese Anwendung ermöglicht das Verschlüsseln und Entschlüsseln von Nachrichten mit dem One-Time-Pad-Verfahren. Sie bietet eine benutzerfreundliche grafische Oberfläche, um Nachrichten und Pads zu laden, zu verschlüsseln, zu entschlüsseln und die Eingaben zurückzusetzen.

2. Struktur der Anwendung
Die Anwendung besteht aus drei Hauptkomponenten:

Main: Der Einstiegspunkt der Anwendung, der die JavaFX-Applikation startet.
Pad_View: Die grafische Benutzeroberfläche der Anwendung.
Pad_Controller: Der Controller, der die Logik für Verschlüsselung und Entschlüsselung steuert.
Pad_Model: Das Model, das die eigentliche Logik für die Verschlüsselung und Entschlüsselung bereitstellt.
3. Main-Klasse
Die Main-Klasse ist der Einstiegspunkt der Anwendung, sie dient lediglich zum Aufrufen der Application.launch.

4. Pad_View-Klasse
Die Pad_View-Klasse ist für die Darstellung der grafischen Benutzeroberfläche verantwortlich. Sie definiert das Layout und das Verhalten der verschiedenen UI-Elemente.

Hauptelemente:

Textfelder: Zur Eingabe der Nachricht.
Labels: Zur Beschriftung der UI-Elemente.
Buttons: Zum Laden von Nachrichten und Pads, zum Verschlüsseln/Entschlüsseln und zum Zurücksetzen.
TextArea: Zur Anzeige des verschlüsselten oder entschlüsselten Textes.
Die Klasse ermöglicht auch das Laden von Dateien für die Nachricht und das Pad mithilfe eines FileChooser-Dialogs. Zwei zusätzliche Buttons dienen dem Zurücksetzen der Nachricht und des One-Time-Pads.

5. Pad_Controller-Klasse
Die Pad_Controller-Klasse dient als Vermittler zwischen der Pad_View und dem Pad_Model. Sie reagiert auf Benutzeraktionen in der Pad_View und ruft entsprechende Methoden im Pad_Model auf.

6. Pad_Model-Klasse
Das Pad_Model stellt die Funktionalität für die Verschlüsselung und Entschlüsselung von Nachrichten bereit. Es verwendet das One-Time-Pad-Verfahren, um die Sicherheit zu gewährleisten.

7. Style-Sheet
Die Anwendung verwendet ein CSS-Stylesheet (style.css), um das Erscheinungsbild der Benutzeroberfläche anzupassen.

8. Verwendung der Anwendung
Nach dem Start der Anwendung kann der Benutzer:

Eine Nachricht und/oder ein One-Time-Pad aus einer Textdatei laden.
Die Nachricht verschlüsseln oder entschlüsseln.
Das Ergebnis in der TextArea anzeigen.
Eingaben oder Ergebnisse zurücksetzen.
9. Fehlerbehandlung
Die Anwendung zeigt Fehlermeldungen an, falls Probleme beim Lesen der Dateien oder bei der Verschlüsselung/Entschlüsselung auftreten.

10. Zusammenfassung
Diese Anwendung demonstriert eine Implementierung einer Verschlüsselungsanwendung unter Verwendung des One-Time-Pad-Verfahrens.
