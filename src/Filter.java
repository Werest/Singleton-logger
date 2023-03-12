import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        source.forEach(x -> {
            if(x < treshold){
                logger.log("Элемент \"" + x + "\" не проходит");
            }else {
                result.add(x);
                logger.log("Элемент \"" + x + "\" проходит");
            }
        });
        return result;
    }
}
