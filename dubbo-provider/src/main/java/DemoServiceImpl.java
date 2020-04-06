public class DemoServiceImpl implements IDemoService {

  @Override
  public int[] sayHello() {
    return new int[9 * 1024*1024];
  }
}
