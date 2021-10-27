import java.io.FileWriter;
import java.io.IOException;

class Main{
    public static void main(String[] args) {
        StringPublisher publisher = new StringPublisher();
        StringSubscriber alphabet;
        StringSubscriber number;
        StringSubscriber symbol;
        try {
            alphabet = new AlphabetSubscriber(32,new FileWriter("alphabet.txt"));
            number = new NumberSubscriber(32,new FileWriter("number.txt"));
            symbol = new SymbolSubscriber(32,new FileWriter("symbol.txt"));
            publisher.subscribe(alphabet);
            publisher.subscribe(number);
            publisher.subscribe(symbol);
        } catch (IOException e) {
            
            e.printStackTrace();
        }

    }
}
