import java.util.Random;

public class DemoServiceImpl implements IDemoService {

  @Override
  public int[] getData() {
    Random random = new Random();
    int i = random.nextInt(8);
    return new int[i * 1024 * 1024];
  }
}
