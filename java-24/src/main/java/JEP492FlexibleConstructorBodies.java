public class JEP492FlexibleConstructorBodies {
    public static void main(String[] args) {
        // JEP 492: Flexible Constructor Bodies (Third Preview)
        // https://openjdk.org/jeps/492


    }
}
record OuterRecord(int outerValue) {
    class Inner {
        int innerValue;

        Inner(OuterRecord OuterRecord.this, int innerValue) {
            this.innerValue = innerValue;
            System.out.println("OuterRecord Value: " + this);
        }
    }
}

class EventHandler {
    interface Listener {
        void onEvent();
    }

    class ButtonClickListener implements Listener {
        ButtonClickListener(EventHandler EventHandler.this) {  // Flexible Constructor
            System.out.println("Event handler created!");
        }

        @Override
        public void onEvent() {
            System.out.println("Button clicked!");
        }
    }
}