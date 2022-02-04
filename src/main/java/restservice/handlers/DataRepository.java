package restservice.handlers;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class DataRepository {

  private final BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();

  private DataRepository() {
      blockingQueue.addAll(FileReader.readNamesFromFile("/data.txt"));
  }

  public String getData() {
      try {
          return blockingQueue.take();
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
      return null;
  }

  public void returnData(String text) {
      try {
          if (!blockingQueue.contains(text)) {
              blockingQueue.put(text);
          }
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
  }

  @Override
  public String toString() {
      return "Data{" +
              "blockingQueue=" + blockingQueue +
              '}';
  }

}
