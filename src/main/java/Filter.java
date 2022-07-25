import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        AtomicInteger countElement = new AtomicInteger();

        source.forEach((element) -> {
            System.out.print(element + ' ');
            if (element >= treshold) {
                logger.log("Элемент " + element + " проходит");
                countElement.getAndIncrement();
                result.add(element);
            }
            else logger.log("Элемент " + element + " не проходит");
        });
        logger.log("Прошло фильтр " + countElement + " элемента из " + source.size());
        return result;
    }
}
