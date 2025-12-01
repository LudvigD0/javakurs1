import java.awt.event.KeyEvent;
import java.util.ArrayList;

class TypingLogic {

    private String[] listOfWords = {
        "velocity", "rapid", "keyboard", "sprint", "pulse",
        "momentum", "flash", "swift", "typing", "challenge",
        "focus", "precision", "battle", "energy", "rhythm",
        "flow", "spark", "cascade", "motion", "glide",
        "fusion", "zenith", "matrix", "quantum", "neon",
        "vector", "pixel", "orbit", "nova", "turbo",
        "logic", "stellar", "flux", "tempo", "shift",
        "ignite", "alpha", "cipher", "echo", "phase",
        "vortex", "drift", "rapidly", "syntax", "stream",
        "horizon", "tunnel", "boost", "enok but performance wise"
    };

    private final ArrayList<Character> typedCharacters = new ArrayList<>();
    public final ArrayList<Boolean> progress = new ArrayList<>();
    public final ArrayList<Character> toBeTypedList = initializeWords();


    public void handleKeyPressed(KeyEvent e) {
        char c = e.getKeyChar();
        int typedCode = e.getKeyCode();
        
        if (typedCode == KeyEvent.VK_BACK_SPACE && e.isControlDown()) {
            if (typedCharacters.isEmpty() == false) {
                if (typedCharacters.getLast() == ' ') {
                    typedCharacters.removeLast();
                    progress.removeLast();
                } else {
                    for (int i = typedCharacters.size()-1; i >= 0; i--) {
                        if (typedCharacters.get(i) == ' ') {
                            break;
                        } else {
                            typedCharacters.removeLast();
                            progress.removeLast();

                        }
                    }
                }
            }
        } else if (typedCode == KeyEvent.VK_BACK_SPACE || c == '\b') {
            if (typedCharacters.isEmpty() == false) {
                typedCharacters.removeLast();
                progress.removeLast();
            }
        } else {
            if (c != KeyEvent.CHAR_UNDEFINED &&
                c != '\b' &&
                c != '\n' &&
                c != '\t' &&
                c != 127 &&
                c >= 32) {

                typedCharacters.add(e.getKeyChar());
                progress.add(checkCharacter(typedCharacters.getLast(), toBeTypedList.get(typedCharacters.size()-1)));
            }

        }
        
        System.out.println(typedCharacters.toString());
        System.out.println(progress.toString());
    }

    private Boolean checkCharacter(char f, char s) {
        return f == s;
    }



    private ArrayList<Character> initializeWords() {
        int expectedSize = listOfWords.length;
        ArrayList <Character> list = new ArrayList<>(expectedSize);
    
        for (int i = 0; i < expectedSize; i++) {
            char[] chars = listOfWords[i].toCharArray();
            
            for (int j = 0; j < chars.length; j++) {
                list.add(chars[j]);
            }
            if (i != expectedSize-1) {
                list.add(' ');
            }
        }

        System.out.println(list.toString());
        return list;
    }
}