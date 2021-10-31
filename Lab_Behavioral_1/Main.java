import java.io.FileWriter;
import java.io.IOException;

class Main{
    public static void main(String[] args) {
        StringPublisher publisher = new StringPublisher();
        StringSubscriber alphabet;
        StringSubscriber number;
        StringSubscriber symbol;
        try {
            alphabet = new AlphabetSubscriber(64,new FileWriter("alphabet.txt",true));
            number = new NumberSubscriber(64,new FileWriter("number.txt",true));
            symbol = new SymbolSubscriber(64,new FileWriter("symbol.txt",true));
            publisher.subscribe(alphabet);
            publisher.subscribe(number);
            publisher.subscribe(symbol);

            publisher.publish("Il0v3S0ft@rch");
            
        } catch (IOException e) {
            
            e.printStackTrace();
        }

    }
}
